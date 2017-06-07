package br.fameg.edu.views;

import br.fameg.edu.domain.model.*;
import br.fameg.edu.domain.repositories.DisciplinaRepository;
import br.fameg.edu.domain.repositories.MatriculaRepository;
import br.fameg.edu.domain.repositories.TurmaRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;


public class AlunoViewTest extends BaseViewTest {

    private String ALUNO_URL;

    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    @Autowired
    private MatriculaRepository matriculaRepository;

    private Turma turmaDoBairro;
    private Aluno alunoTester;
    private List<Disciplina> disciplinasDisponiveis = new ArrayList<>();
    private List<Semestre> semestres = new ArrayList<>();

    @Before
    public void setup() {
        semestres = loadSemestres();

        DadosPessoais dadosDoAlunoTester = new DadosPessoais();
        dadosDoAlunoTester.setCpf("88899520364");
        dadosDoAlunoTester.setNome("Aluno Tester");
        dadosDoAlunoTester.setEndereco("Rua Joãozinho");
        dadosDoAlunoTester.setTelefone("(47) 9994-2536");
        dadosPessoaisRepository.save(dadosDoAlunoTester);

        Aluno aluno = new Aluno();
        aluno.setNumeroDeMatricula(789452);
        aluno.setDadosPessoais(dadosDoAlunoTester);
        alunoTester = alunoRepository.save(aluno);

        Turma turma = new Turma();
        turma.setDescricao("3º ano 02");
        turma.setAlunos(Arrays.asList(alunoTester));
        turmaDoBairro = turmaRepository.save(turma);

        loadDisciplinas();

        ALUNO_URL = BASE_URL + localPort + "/aluno/" + alunoTester.getId();
    }

    @After
    public void tearDown() {
        matriculaRepository.deleteAll();
        disciplinaRepository.deleteAll();
        semestreRepository.deleteAll();
        turmaRepository.deleteAll();
        professorRepository.deleteAll();
        alunoRepository.deleteAll();
        dadosPessoaisRepository.deleteAll();
    }

    private DadosPessoais loadDadosPessoais(String cpf, String nome, String endereco, String telefone) {
        DadosPessoais result = new DadosPessoais();
        result.setCpf(cpf);
        result.setNome(nome);
        result.setEndereco(endereco);
        result.setTelefone(telefone);
        return dadosPessoaisRepository.save(result);
    }

    private void loadDisciplinas() {
        Professor prof = new Professor();
        prof.setDadosPessoais(loadDadosPessoais("123456", "Professor da Turma", "Não sei", "33717171"));
        prof.setUsuario("Ximira");
        prof.setSenha("ichbinteacher");
        professorTester = professorRepository.save(prof);

        Disciplina ciencias = new Disciplina();
        ciencias.setNome("Ciências");
        ciencias.setProfessor(professorTester);
        ciencias.setSemestres(semestres);
        disciplinasDisponiveis.add(disciplinaRepository.save(ciencias));
    }

    private List<Semestre> loadSemestres() {
        List<Semestre> result = new ArrayList<>();
        Semestre primeiroSemestre = new Semestre();
        primeiroSemestre.setSequencia(1);
        primeiroSemestre.setAno(2017);
        primeiroSemestre.setDataInicial(new Date(System.currentTimeMillis()));
        primeiroSemestre.setDataFinal(new Date(System.currentTimeMillis() + 2000));

        Semestre segundoSemestre = new Semestre();
        segundoSemestre.setSequencia(2);
        segundoSemestre.setAno(2017);
        segundoSemestre.setDataInicial(new Date(System.currentTimeMillis() + 5000));
        segundoSemestre.setDataFinal(new Date(System.currentTimeMillis() + 10000));

        result.add(semestreRepository.save(primeiroSemestre));
        result.add(semestreRepository.save(segundoSemestre));
        return result;
    }

    private Matricula loadMatricula() {
        Matricula aulaDeCiencias = new Matricula();
        aulaDeCiencias.setAluno(alunoTester);
        aulaDeCiencias.setTrancada(false);
        aulaDeCiencias.setTurma(turmaDoBairro);
        aulaDeCiencias.setDataMatricula(new Date(System.currentTimeMillis()));
        aulaDeCiencias.setDisciplina(disciplinasDisponiveis.get(0));
        aulaDeCiencias.setSemestre(semestres.get(0));
        return matriculaRepository.save(aulaDeCiencias);
    }

    @Test
    public void respondToObterAluno() {
        Aluno response = restTemplate.getForObject(ALUNO_URL, Aluno.class);
        assertEquals(alunoTester.getNumeroDeMatricula(), response.getNumeroDeMatricula());

        DadosPessoais dadosDoAlunoTester = alunoTester.getDadosPessoais();
        DadosPessoais dadosPessoaisResponse = response.getDadosPessoais();
        assertEquals(dadosDoAlunoTester.getNome(), dadosPessoaisResponse.getNome());
        assertEquals(dadosDoAlunoTester.getCpf(), dadosPessoaisResponse.getCpf());
        assertEquals(dadosDoAlunoTester.getEndereco(), dadosPessoaisResponse.getEndereco());
        assertEquals(dadosDoAlunoTester.getTelefone(), dadosPessoaisResponse.getTelefone());
    }

    @Test
    public void respondToFazerMatricula() {
        Matricula aulaDeCiencias = loadMatricula();

        ResponseEntity<Matricula> response = restTemplate.postForEntity(ALUNO_URL+"/matricula", aulaDeCiencias, Matricula.class);
        assertEquals(200, response.getStatusCodeValue());

        Matricula body = response.getBody();
        assertEquals(aulaDeCiencias.isTrancada(), body.isTrancada());
        assertEquals(aulaDeCiencias.getSemestre().getAno(), body.getSemestre().getAno());
    }

    @Test
    public void respondToTrancarDisciplina() {
        Matricula matricula = loadMatricula();
        matricula.setTrancada(true);
        RequestEntity<Matricula> payload = RequestEntity
                .put(URI.create(ALUNO_URL+"/matricula/"+matricula.getId()))
                .body(matricula);

        ResponseEntity<Matricula> response = restTemplate.exchange(payload, Matricula.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(matricula.isTrancada(), response.getBody().isTrancada());
    }
}