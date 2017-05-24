package br.fameg.edu.view;

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

import br.fameg.edu.domain.model.Turma;
import br.fameg.edu.domain.repositories.TurmaRepository;

@RestController
@RequestMapping("/turma")
public class TurmaView {

    @Autowired private TurmaRepository turmaRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody Turma addTurma(@RequestBody Turma payload) {
        return turmaRepository.save(payload);
    }

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Turma> getAll() {
        return turmaRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody Turma getOne(@PathVariable("id") Long id) {
        return turmaRepository.findOne(id);
    }
    
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody Turma updateTurma(@PathVariable("id") Long id, @RequestBody Turma payload) {
        return turmaRepository.save(payload);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTurma(@PathVariable("id") Long id) {
        turmaRepository.delete(id);
    }
    
}
