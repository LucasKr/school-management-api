package br.fameg.edu.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.fameg.edu.domain.model.Presenca;
import br.fameg.edu.domain.model.Trabalho;
import br.fameg.edu.domain.repositories.PresencaRepository;
import br.fameg.edu.domain.repositories.TrabalhoRepository;

@RestController
@RequestMapping(value = "/professor/{id}", produces = "application/json")
public class ProfessorView {

    @Autowired private TrabalhoRepository trabalhoRepository;
    @Autowired private PresencaRepository presencaRepository;

    @PostMapping("/{id}/trabalho")
    public @ResponseBody Trabalho criarTrabalho(@RequestBody Trabalho payload) {
        return trabalhoRepository.save(payload);
    }
    
    @PostMapping("/{id}/nota")
    public @ResponseBody Trabalho registrarNota(@RequestBody Trabalho payload) {
        return trabalhoRepository.save(payload);
    }
    
    @PostMapping("/{id}/presenca")
    public @ResponseBody Presenca registrarPresenca(@RequestBody Presenca presenca) {
        return presencaRepository.save(presenca);
    }

    @GetMapping("/trabalho")
    public @ResponseBody Iterable<Trabalho> obterTrabalhos(@PathVariable("id") long id) {
        return trabalhoRepository.findByProfessor(id);
    }
}
