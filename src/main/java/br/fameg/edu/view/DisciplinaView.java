package br.fameg.edu.view;

import br.fameg.edu.domain.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaView {

    @Autowired private DisciplinaRepository disciplinaRepository;
    
}
