package br.fameg.edu.controllers;

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

import br.fameg.edu.model.Semestre;
import br.fameg.edu.repositories.SemestreRepository;

@RestController
@RequestMapping("/semestres")
public class SemestreController {

    @Autowired private SemestreRepository semestreRepository;
    

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody Semestre addSemestre(@RequestBody Semestre payload) {
        return semestreRepository.save(payload);
    }

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Semestre> getAll() {
        return semestreRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody Semestre getOne(@PathVariable("id") Long id) {
        return semestreRepository.findOne(id);
    }
    
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody Semestre updateSemestre(@PathVariable("id") Long id, @RequestBody Semestre payload) {
        return semestreRepository.save(payload);
    }
    
    @DeleteMapping("/{id}")
    public void deleteSemestre(@PathVariable("id") Long id) {
        semestreRepository.delete(id);
    }
}
