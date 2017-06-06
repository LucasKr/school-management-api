package br.fameg.edu.view;

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.model.Matricula;
import br.fameg.edu.domain.repositories.AlunoRepository;
import br.fameg.edu.domain.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/aluno/{alunoId}", produces = "application/json")
public class AlunoView {

    private @Autowired AlunoRepository alunoRepository;
    private @Autowired MatriculaRepository matriculaRepository;

    @GetMapping
    public @ResponseBody Aluno obterAluno(@PathVariable("alunoId") Long alunoId) {
        return alunoRepository.findOne(alunoId);
    }

    @PutMapping(consumes = "application/json")
    public @ResponseBody Aluno atualizarAluno(@RequestBody Aluno payload) {
        return alunoRepository.save(payload);
    }

    @GetMapping("/matricula")
    public @ResponseBody Iterable<Matricula> obterMatriculas(@PathVariable("alunoId") Long alunoId) {
        return matriculaRepository.findByAluno(alunoId);
    }

    @PostMapping(value = "/matricula", consumes = "application/json")
    public @ResponseBody Matricula fazerMatricula(@RequestBody Matricula payload) {
        return matriculaRepository.save(payload);
    }

    @GetMapping("/matricula/{matriculaId}")
    public @ResponseBody Matricula obterMatricula(@PathVariable("matriculaId") Long matriculaId) {
        return matriculaRepository.findOne(matriculaId);
    }

}