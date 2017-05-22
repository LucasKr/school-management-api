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

import br.fameg.edu.domain.model.Coordenador;
import br.fameg.edu.domain.repositories.CoordenadorRepository;

@RestController
@RequestMapping("/coordenadores")
public class CoordenadorView {
    
    @Autowired private CoordenadorRepository coordenadorRepository;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody Coordenador addCoordenador(@RequestBody Coordenador payload) {
        return coordenadorRepository.save(payload);
    }

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Coordenador> getAll() {
        return coordenadorRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody Coordenador getOne(@PathVariable("id") Long id) {
        return coordenadorRepository.findOne(id);
    }
    
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody Coordenador updateCoordenador(@PathVariable("id") Long id, @RequestBody Coordenador payload) {
        return coordenadorRepository.save(payload);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCoordenador(@PathVariable("id") Long id) {
        coordenadorRepository.delete(id);
    }
}
