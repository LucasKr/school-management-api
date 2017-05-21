package br.fameg.edu.controllers;

import br.fameg.edu.model.Disciplina;
import br.fameg.edu.repositories.DisciplinaRepository;
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
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired private DisciplinaRepository disciplinaRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody Disciplina addDisciplina(@RequestBody Disciplina payload) {
        return disciplinaRepository.save(payload);
    }

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Disciplina> getAll() {
        return disciplinaRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody Disciplina getOne(@PathVariable("id") Long id) {
        return disciplinaRepository.findOne(id);
    }
    
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody Disciplina updateDisciplina(@PathVariable("id") Long id, @RequestBody Disciplina payload) {
        return disciplinaRepository.save(payload);
    }
    
    @DeleteMapping("/{id}")
    public void deleteDisciplina(@PathVariable("id") Long id) {
        disciplinaRepository.delete(id);
    }
    
}
