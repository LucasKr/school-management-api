package br.fameg.edu.views;

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.model.Coordenador;
import br.fameg.edu.domain.model.DadosPessoais;
import br.fameg.edu.domain.model.Professor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CoordenadorViewTest extends BaseViewTest {

    private String coordenadorURL;

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
        payload.setDisciplinas(new ArrayList<>());
        ResponseEntity<Aluno> response = restTemplate.postForEntity(path, payload, Aluno.class);
        assertEquals(200, response.getStatusCodeValue());

        Aluno responseBody = response.getBody();
        assertEquals(responseBody.getNumeroDeMatricula(), payload.getNumeroDeMatricula());
        assertNotNull(responseBody.getDisciplinas());

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

    public void respondToAddDisciplina() {
        //TODO: Implement
    }

    public void respondToAddTurma() {
        //TODO: Implement
    }
}
