package br.fameg.edu.views;

import br.fameg.edu.domain.model.*;
import br.fameg.edu.domain.repositories.AlunoRepository;
import br.fameg.edu.domain.repositories.CoordenadorRepository;
import br.fameg.edu.domain.repositories.DisciplinaRepository;
import br.fameg.edu.domain.repositories.ProfessorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;


public class CoordenadorViewTest extends BaseViewTest {

    @Autowired
    protected CoordenadorRepository coordenadorRepository;
    @Autowired
    protected ProfessorRepository professorRepository;
    @Autowired
    protected AlunoRepository alunoRepository;
    @Autowired
    protected DisciplinaRepository disciplinaRepository;

    private String coordenadorURL;
    private Coordenador coordenadorTester;

    @Before
    public void setup() {
        coordenadorURL = BASE_URL+localPort+"/coordenadores";
        DadosPessoais payload = new DadosPessoais();
        payload.setCpf("884984");
        payload.setNome("Tester");
        payload.setEndereco("Rua 1");
        payload.setTelefone("123456");
        DadosPessoais dados = dadosPessoaisRepository.save(payload);

        Coordenador coordenador = new Coordenador();
        coordenador.setDadosPessoais(dados);
        coordenador.setUsuario("test-admin");
        coordenador.setSenha("123");
        coordenadorTester = coordenadorRepository.save(coordenador);

        DadosPessoais payloadProfessor = new DadosPessoais();
        payloadProfessor.setCpf("12312315");
        payloadProfessor.setNome("Teacher Tester");
        payloadProfessor.setEndereco("Rua 1");
        payloadProfessor.setTelefone("123456");
        DadosPessoais dadosDoProfessor = dadosPessoaisRepository.save(payloadProfessor);

        Professor professor = new Professor();
        professor.setDadosPessoais(dadosDoProfessor);
        professor.setUsuario("thiago");
        professor.setSenha("11");
        professorTester = professorRepository.save(professor);
        
        Semestre semestre = new Semestre();
        semestre.setAno(2017);
        semestre.setSequencia(1);
        semestre.setDataInicial(new Date(System.currentTimeMillis()));
        semestre.setDataFinal(new Date(System.currentTimeMillis()+1000l));
        semestreTester = semestreRepository.save(semestre);
    }

    @After
    public void tearDown() {
        disciplinaRepository.deleteAll();
        alunoRepository.deleteAll();
        coordenadorRepository.deleteAll();
        professorRepository.deleteAll();
        dadosPessoaisRepository.deleteAll();
    }

    @Test
    public void respondToAddCoordenador() throws Exception {
        DadosPessoais dados = new DadosPessoais();
        dados.setCpf("14250658");
        dados.setNome("Tester");
        dados.setEndereco("Rua 1");
        dados.setTelefone("123456");

        Coordenador payload = new Coordenador();
        payload.setUsuario("joãozinho");
        payload.setSenha("23145r1");
        payload.setDadosPessoais(dados);

        ResponseEntity<Coordenador> response = restTemplate.postForEntity(coordenadorURL, payload, Coordenador.class);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        Coordenador responseBody = response.getBody();
        assertEquals(payload.getUsuario(), responseBody.getUsuario());
        assertEquals(payload.getSenha(), responseBody.getSenha());

    }

    @Test
    public void respondToObterCoordenador() {
        ResponseEntity<Coordenador> response = restTemplate.getForEntity(coordenadorURL + "/" + coordenadorTester.getId(), Coordenador.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(coordenadorTester.getId(), response.getBody().getId());
    }

    @Test
    public void respondToAtualizarCoordenador() {
        coordenadorTester.setUsuario("usuarioTestador");
        coordenadorTester.setSenha("joaozinho123");

        RequestEntity<Coordenador> payload = RequestEntity
                .put(URI.create(coordenadorURL + "/" + coordenadorTester.getId()))
                .body(coordenadorTester);

        ResponseEntity<Coordenador> response = restTemplate.exchange(payload, Coordenador.class);

        assertEquals(200, response.getStatusCodeValue());
        Coordenador responseBody = response.getBody();
        DadosPessoais dadosDoCoordenador = responseBody.getDadosPessoais();
        assertEquals(coordenadorTester.getId(), responseBody.getId());
        assertEquals(coordenadorTester.getUsuario(), responseBody.getUsuario());
        assertEquals(coordenadorTester.getSenha(), responseBody.getSenha());
    }

    @Test
    public void shouldPutDadosPessoais() {
        coordenadorTester.getDadosPessoais().setNome("Enéias");
        coordenadorTester.getDadosPessoais().setTelefone("4002 8922");
        coordenadorTester.getDadosPessoais().setCpf("ninguemsabe");

        RequestEntity<Coordenador> payload = RequestEntity
                .put(URI.create(coordenadorURL + "/" + coordenadorTester.getId()))
                .body(coordenadorTester);

        ResponseEntity<Coordenador> response = restTemplate.exchange(payload, Coordenador.class);
        assertEquals(200, response.getStatusCodeValue());

        DadosPessoais dadosDoCoordenador = response.getBody().getDadosPessoais();
        assertEquals(coordenadorTester.getDadosPessoais().getCpf(), dadosDoCoordenador.getCpf());
        assertEquals(coordenadorTester.getDadosPessoais().getNome(), dadosDoCoordenador.getNome());
        assertEquals(coordenadorTester.getDadosPessoais().getTelefone(), dadosDoCoordenador.getTelefone());
    }

    @Test
    public void respondToAddAluno() {
        String path = String.format("%s/%s/aluno", coordenadorURL, coordenadorTester.getId());
        Aluno payload = new Aluno();
        payload.setNumeroDeMatricula(123);

        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setCpf("07650210100");
        dadosPessoais.setNome("New Tester");
        dadosPessoais.setEndereco("Rua 2");
        dadosPessoais.setTelefone("4567894");

        payload.setDadosPessoais(dadosPessoais);
        ResponseEntity<Aluno> response = restTemplate.postForEntity(path, payload, Aluno.class);
        assertEquals(200, response.getStatusCodeValue());

        Aluno responseBody = response.getBody();
        assertEquals(responseBody.getNumeroDeMatricula(), payload.getNumeroDeMatricula());
        assertNull(responseBody.getDisciplinas());

        DadosPessoais dadosDoAluno = responseBody.getDadosPessoais();
        assertEquals(dadosDoAluno.getCpf(), payload.getDadosPessoais().getCpf());
        assertEquals(dadosDoAluno.getEndereco(), payload.getDadosPessoais().getEndereco());
        assertEquals(dadosDoAluno.getNome(), payload.getDadosPessoais().getNome());
        assertEquals(dadosDoAluno.getTelefone(), payload.getDadosPessoais().getTelefone());
    }

    @Test
    public void respondToAddProfessor() {
        String path = String.format("%s/%s/professor", coordenadorURL, coordenadorTester.getId());
        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setCpf("44455566678");
        dadosPessoais.setNome("New Teacher Tester");
        dadosPessoais.setEndereco("Rua 2");
        dadosPessoais.setTelefone("69694242");

        Professor payload = new Professor();
        payload.setDadosPessoais(dadosPessoais);
        payload.setUsuario("teachertester");
        payload.setSenha("asdjasiodj");
        ResponseEntity<Professor> response = restTemplate.postForEntity(path, payload, Professor.class);
        assertEquals(200, response.getStatusCodeValue());

        Professor responseBody = response.getBody();
        assertEquals(payload.getUsuario(), responseBody.getUsuario());
        assertNotNull(payload.getSenha(), responseBody.getSenha());

        DadosPessoais dadosDoProfessor = responseBody.getDadosPessoais();
        assertEquals(dadosDoProfessor.getCpf(), payload.getDadosPessoais().getCpf());
        assertEquals(dadosDoProfessor.getEndereco(), payload.getDadosPessoais().getEndereco());
        assertEquals(dadosDoProfessor.getNome(), payload.getDadosPessoais().getNome());
        assertEquals(dadosDoProfessor.getTelefone(), payload.getDadosPessoais().getTelefone());
    }

    @Test
    public void respondToAddDisciplina() {
        String path = String.format("%s/%s/disciplina", coordenadorURL, coordenadorTester.getId());

        List<Semestre> semestres = new ArrayList<>();
        semestres.add(semestreTester);
        
        Disciplina disciplina = new Disciplina();
        disciplina.setNome("Projeto orientado a objetos");
        disciplina.setSemestres(semestres);
        disciplina.setProfessor(professorTester);
        
        ResponseEntity<Disciplina> response = restTemplate.postForEntity(path, disciplina, Disciplina.class);
        assertEquals(200, response.getStatusCodeValue());
    }
}
