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

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.model.Coordenador;
import br.fameg.edu.domain.model.Disciplina;
import br.fameg.edu.domain.model.Professor;
import br.fameg.edu.domain.model.Turma;
import br.fameg.edu.domain.repositories.AlunoRepository;
import br.fameg.edu.domain.repositories.CoordenadorRepository;
import br.fameg.edu.domain.repositories.DisciplinaRepository;
import br.fameg.edu.domain.repositories.ProfessorRepository;
import br.fameg.edu.domain.repositories.TurmaRepository;

@RestController
@RequestMapping("/coordenadores")
public class CoordenadorView {
    
    private @Autowired CoordenadorRepository coordenadorRepository;
    private @Autowired DisciplinaRepository disciplinaRepository;
    private @Autowired ProfessorRepository professorRepository;
    private @Autowired AlunoRepository alunoRepository;
    private @Autowired TurmaRepository turmaRepository;
    
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
    
    @PostMapping("/{id}/criarDisciplina")
    public @ResponseBody Disciplina criarDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }
    
    @PostMapping("/{id}/criarProfessor")
    public @ResponseBody Professor criarProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }
    
    @PostMapping("/{id}/criarAluno")
    public @ResponseBody Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    @PostMapping("/{id}/criarTurma")
    public @ResponseBody Turma criarTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
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
