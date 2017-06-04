package br.fameg.edu.views;

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.model.DadosPessoais;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class AlunoViewTest extends BaseViewTest {

    @Mock
    private Aluno aluno;

    @Before
    @Override
    public void setup() {
        super.setup();
        aluno.setNumeroDeMatricula(123456);
        aluno.setDisciplinas(new ArrayList<>());
        aluno.setId(1l);
        aluno.setDadosPessoais(new DadosPessoais(1l, 0765, "Matheus", "Rua jurisbindo", "33707604"));
    }

    @Test
    public void shouldRespondToGetById() {
        Aluno response = client.getForObject(BASE_URL+localPort+"/alunos/"+aluno.getId(), Aluno.class);
        assertThat(response).isNotNull();
    }
}
