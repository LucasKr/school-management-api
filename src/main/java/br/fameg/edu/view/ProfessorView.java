package br.fameg.edu.view;

import br.fameg.edu.domain.model.Professor;
import br.fameg.edu.domain.repositories.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorView {
    
    @Autowired private ProfessorRepository disciplinaRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody Professor addProfessor(@RequestBody Professor payload) {
        return disciplinaRepository.save(payload);
    }

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Professor> getAll() {
        return disciplinaRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody Professor getOne(@PathVariable("id") Long id) {
        return disciplinaRepository.findOne(id);
    }
    
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody Professor updateProfessor(@PathVariable("id") Long id, @RequestBody Professor payload) {
        return disciplinaRepository.save(payload);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable("id") Long id) {
        disciplinaRepository.delete(id);
    }
}
