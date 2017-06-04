package br.fameg.edu.views;

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.model.Coordenador;
import br.fameg.edu.domain.model.DadosPessoais;
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

        DadosPessoais dados = dadosPessoaisRepository.save(new DadosPessoais("123456789",
                "Test Admin", "localhost", "no-one"));
        Coordenador coordenador = new Coordenador();
        coordenador.setDadosPessoais(dados);
        coordenador.setUsuario("test-admin");
        coordenador.setSenha("123");
        coordenadorTester = coordenadorRepository.save(coordenador);
    }

    @Test
    public void respondToAddCoordenador() throws Exception {
        Coordenador payload = new Coordenador();
        payload.setUsuario("joãozinho");
        payload.setSenha("23145r1");

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
        payload.setDadosPessoais(new DadosPessoais("123456789", "Matheus", "Avenida Brasil", "33707171"));
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

    public void respondToAddProfessor() {
        //TODO: Implement
    }

    public void respondToAddDisciplina() {
        //TODO: Implement
    }

    public void respondToAddTurma() {
        //TODO: Implement
    }
}
