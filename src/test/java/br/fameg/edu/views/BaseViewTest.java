package br.fameg.edu.views;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseViewTest {

    @LocalServerPort
    protected int localPort;

    @Autowired
    protected TestRestTemplate client;

    protected final String BASE_URL = "http://localhost:";


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

}
