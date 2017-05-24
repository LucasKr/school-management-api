package br.fameg.edu.view;

import br.fameg.edu.domain.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turmas")
public class TurmaView {

    @Autowired private TurmaRepository turmaRepository;

}
