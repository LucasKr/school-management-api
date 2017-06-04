package br.fameg.edu.view;

import br.fameg.edu.domain.model.*;
import br.fameg.edu.domain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/coordenadores", consumes = "application/json", produces = "application/json")
public class CoordenadorView {

    private @Autowired DadosPessoaisRepository dadosPessoaisRepository;
    private @Autowired CoordenadorRepository coordenadorRepository;
    private @Autowired DisciplinaRepository disciplinaRepository;
    private @Autowired ProfessorRepository professorRepository;
    private @Autowired AlunoRepository alunoRepository;
    private @Autowired TurmaRepository turmaRepository;
    
    @PostMapping
    public @ResponseBody Coordenador addCoordenador(@RequestBody Coordenador payload) {
        return coordenadorRepository.save(payload);
    }
    
    @GetMapping
    public @ResponseBody Iterable<Coordenador> getAll() {
        return coordenadorRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Coordenador getOne(@PathVariable("id") Long id) {
        return coordenadorRepository.findOne(id);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody Coordenador updateCoordenador(@PathVariable("id") Long id, @RequestBody Coordenador payload) {
        return coordenadorRepository.save(payload);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCoordenador(@PathVariable("id") Long id) {
        coordenadorRepository.delete(id);
    }
    
    @PostMapping("/{id}/aluno")
    public @ResponseBody Aluno criarAluno(@RequestBody Aluno aluno) {
        if(dadosPessoaisRepository.findByCpf(aluno.getDadosPessoais().getCpf()) == null)
            dadosPessoaisRepository.save(aluno.getDadosPessoais());
        return alunoRepository.save(aluno);
    }
    
    @PutMapping("/{id}/aluno/{alunoId}")
    public @ResponseBody Aluno alterarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    @DeleteMapping("/{id}/aluno/{alunoId}")
    public void removerAluno(@PathVariable("alunoId") Long alunoId) {
        alunoRepository.delete(alunoId);
    }
    
    @PostMapping("/{id}/professor")
    public @ResponseBody Professor addProfessor(@RequestBody Professor payload) {
        return professorRepository.save(payload);
    }

    @GetMapping("/{id}/professor")
    public @ResponseBody Iterable<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}/professor/{professorId}")
    public @ResponseBody Professor getProfessor(@PathVariable("professorId") Long professorId) {
        return professorRepository.findOne(professorId);
    }
    
    @PutMapping("/{id}/professor/{professorId}")
    public @ResponseBody Professor updateProfessor(@RequestBody Professor payload) {
        return professorRepository.save(payload);
    }
    
    @DeleteMapping("/{id}/professor/{professorId}")
    public void deleteProfessor(@PathVariable("professorId") Long professorId) {
        professorRepository.delete(professorId);
    }
    
    @PostMapping("/{id}/turma")
    public @ResponseBody Turma criarTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }
    
    @GetMapping("/{id}/turma")
    public @ResponseBody Iterable<Turma> getTurmas() {
        return turmaRepository.findAll();
    }
    
    @GetMapping("/{id}/turma/{turmaId}")
    public @ResponseBody Turma getTurma(@PathVariable("turmaId") Long turmaId) {
        return turmaRepository.findOne(turmaId);
    }
    
    @PutMapping("/{id}/turma/{turmaId}")
    public @ResponseBody Turma updateTurma(@RequestBody Turma payload) {
        return turmaRepository.save(payload);
    }
    
    @DeleteMapping("/{id}/turma/{turmaId}")
    public void deleteTurma(@PathVariable("id") Long id) {
        turmaRepository.delete(id);
    }

    @PostMapping("/{id}/disciplina")
    public @ResponseBody Disciplina addDisciplina(@RequestBody Disciplina payload) {
        return disciplinaRepository.save(payload);
    }

    @GetMapping("/{id}/disciplina")
    public @ResponseBody Iterable<Disciplina> getDisciplinas() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/{id}/disciplina/{disciplinaId}")
    public @ResponseBody Disciplina getDisciplina(@PathVariable("disciplinaId") Long disciplinaId) {
        return disciplinaRepository.findOne(disciplinaId);
    }

    @PutMapping("/{id}/disciplina/{disciplinaId}")
    public @ResponseBody Disciplina updateDisciplina(@RequestBody Disciplina payload) {
        return disciplinaRepository.save(payload);
    }

    @DeleteMapping("/{id}/disciplina/{disciplinaId}")
    public void deleteDisciplina(@PathVariable("disciplinaId") Long disciplinaId) {
        disciplinaRepository.delete(disciplinaId);
    }
}
