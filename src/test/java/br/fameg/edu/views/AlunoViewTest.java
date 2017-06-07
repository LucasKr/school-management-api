package br.fameg.edu.views;

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.model.DadosPessoais;
import br.fameg.edu.domain.repositories.AlunoRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;


public class AlunoViewTest extends BaseViewTest {

    private String ALUNO_URL;

    @Autowired
    protected AlunoRepository alunoRepository;

    private Aluno alunoTester;

    @Before
    public void setup() {
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

        ALUNO_URL = BASE_URL + localPort + "/aluno/" + alunoTester.getId();
    }

    @After
    public void tearDown() {
        alunoRepository.deleteAll();
        dadosPessoaisRepository.deleteAll();
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
    
    public void deveEncontrarAsMatriculas() {

    }

    public void deveValidarMatricula() {

    }
}
