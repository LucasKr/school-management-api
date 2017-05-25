package br.fameg.edu.view;

import br.fameg.edu.domain.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorView {
    
    @Autowired private ProfessorRepository disciplinaRepository;

}
