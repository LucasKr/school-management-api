package br.fameg.edu.views;

import br.fameg.edu.domain.model.Coordenador;
import br.fameg.edu.domain.model.DadosPessoais;
import br.fameg.edu.domain.repositories.AlunoRepository;
import br.fameg.edu.domain.repositories.CoordenadorRepository;
import br.fameg.edu.domain.repositories.DadosPessoaisRepository;
import br.fameg.edu.domain.repositories.ProfessorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseViewTest {

    protected final String BASE_URL = "http://localhost:";

    @LocalServerPort
    protected int localPort;
    @Autowired
    protected TestRestTemplate restTemplate;
    @Autowired
    protected DadosPessoaisRepository dadosPessoaisRepository;

}
