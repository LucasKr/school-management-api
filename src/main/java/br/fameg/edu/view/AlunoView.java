package br.fameg.edu.view;

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.model.Matricula;
import br.fameg.edu.domain.repositories.AlunoRepository;
import br.fameg.edu.domain.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/alunos/{alunoId}", consumes = "application/json", produces = "application/json")
public class AlunoView {

    private @Autowired AlunoRepository alunoRepository;
    private @Autowired MatriculaRepository matriculaRepository;

    @GetMapping
    public @ResponseBody Aluno getOne(@PathVariable("id") Long id) {
        return alunoRepository.findOne(id);
    }
    
    @PutMapping
    public @ResponseBody Aluno updateAluno(@PathVariable("id") Long id, @RequestBody Aluno payload) {
        return alunoRepository.save(payload);
    }

    @GetMapping("/matriculas")
    public @ResponseBody Iterable<Matricula> getMatriculas(@PathVariable("alunoId") Long alunoId) {
        return matriculaRepository.findByAluno(alunoId);
    }
}