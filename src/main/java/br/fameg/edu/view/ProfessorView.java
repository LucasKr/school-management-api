package br.fameg.edu.view;

import br.fameg.edu.domain.model.Professor;
import br.fameg.edu.domain.model.Trabalho;
import br.fameg.edu.domain.repositories.DadosPessoaisRepository;
import br.fameg.edu.domain.repositories.ProfessorRepository;
import br.fameg.edu.domain.repositories.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/professor/{id}", produces = "application/json")
public class ProfessorView {
    
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private TrabalhoRepository trabalhoRepository;
    @Autowired
    private DadosPessoaisRepository dadosPessoaisRepository;

    @PutMapping
    public @ResponseBody Professor atualizarProfessor(@RequestBody Professor payload) {
        dadosPessoaisRepository.save(payload.getDadosPessoais());
        return professorRepository.save(payload);
    }

    @PostMapping(value = "/trabalho", consumes = "application/json")
    public @ResponseBody Trabalho agendarTrabalho(@RequestBody Trabalho payload) {
        return trabalhoRepository.save(payload);
    }

    @GetMapping("/trabalho")
    public @ResponseBody Iterable<Trabalho> obterTrabalhos(@PathVariable("id") long id) {
        return trabalhoRepository.findByProfessor(id);
    }
}
