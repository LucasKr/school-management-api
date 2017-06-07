package br.fameg.edu.view;

import br.fameg.edu.domain.model.*;
import br.fameg.edu.domain.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/coordenadores", produces = "application/json")
public class CoordenadorView {

    private @Autowired DadosPessoaisRepository dadosPessoaisRepository;
    private @Autowired CoordenadorRepository coordenadorRepository;
    private @Autowired DisciplinaRepository disciplinaRepository;
    private @Autowired ProfessorRepository professorRepository;
    private @Autowired SemestreRepository semestreRepository;
    private @Autowired AlunoRepository alunoRepository;
    private @Autowired TurmaRepository turmaRepository;
    
    @PostMapping(consumes = "application/json")
    public @ResponseBody Coordenador criarCoordenador(@RequestBody Coordenador payload) {
        DadosPessoais d = dadosPessoaisRepository.findByCpf(payload.getDadosPessoais().getCpf());
        if(d == null)
            dadosPessoaisRepository.save(payload.getDadosPessoais());
        return coordenadorRepository.save(payload);
    }
    
    @GetMapping
    public @ResponseBody Iterable<Coordenador> obterCoordenadores() {
        return coordenadorRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody Coordenador obterCoordenador(@PathVariable("id") Long id) {
        return coordenadorRepository.findOne(id);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public @ResponseBody Coordenador atualizarCoordenador(@RequestBody Coordenador payload) {
        dadosPessoaisRepository.save(payload.getDadosPessoais());
        return coordenadorRepository.save(payload);
    }
    
    @DeleteMapping("/{id}")
    public void removerCoordenador(@PathVariable("id") Long id) {
        coordenadorRepository.delete(id);
    }
    
    @PostMapping(value = "/{id}/aluno", consumes = "application/json")
    public @ResponseBody Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        DadosPessoais d = dadosPessoaisRepository.findByCpf(aluno.getDadosPessoais().getCpf());
        if(d == null)
            dadosPessoaisRepository.save(aluno.getDadosPessoais());
        return alunoRepository.save(aluno);
    }

    @GetMapping("/{id}/aluno")
    public @ResponseBody Iterable<Aluno> obterAlunos() {
        return alunoRepository.findAll();
    }

    @DeleteMapping("/{id}/aluno/{alunoId}")
    public void removerAluno(@PathVariable("alunoId") Long alunoId) {
        alunoRepository.delete(alunoId);
    }
    
    @PostMapping(value = "/{id}/professor", consumes = "application/json")
    public @ResponseBody Professor cadastrarProfessor(@RequestBody Professor payload) {
        DadosPessoais d = dadosPessoaisRepository.findByCpf(payload.getDadosPessoais().getCpf());
        if(d == null)
            dadosPessoaisRepository.save(payload.getDadosPessoais());
        return professorRepository.save(payload);
    }

    @GetMapping("/{id}/professor")
    public @ResponseBody Iterable<Professor> obterProfessores() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}/professor/{professorId}")
    public @ResponseBody Professor obterProfessor(@PathVariable("professorId") Long professorId) {
        return professorRepository.findOne(professorId);
    }

    @DeleteMapping("/{id}/professor/{professorId}")
    public void removerProfessor(@PathVariable("professorId") Long professorId) {
        professorRepository.delete(professorId);
    }
    
    @PostMapping(value = "/{id}/turma", consumes = "application/json")
    public @ResponseBody Turma cadastrarTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }
    
    @GetMapping("/{id}/turma")
    public @ResponseBody Iterable<Turma> obterTurmas() {
        return turmaRepository.findAll();
    }
    
    @GetMapping("/{id}/turma/{turmaId}")
    public @ResponseBody Turma obterTurma(@PathVariable("turmaId") Long turmaId) {
        return turmaRepository.findOne(turmaId);
    }
    
    @PutMapping(value = "/{id}/turma/{turmaId}", consumes = "application/json")
    public @ResponseBody Turma alterarTurma(@RequestBody Turma payload) {
        return turmaRepository.save(payload);
    }
    
    @DeleteMapping("/{id}/turma/{turmaId}")
    public void removerTurma(@PathVariable("id") Long id) {
        turmaRepository.delete(id);
    }

    @PostMapping(value = "/{id}/disciplina", consumes = "application/json")
    public @ResponseBody Disciplina cadastrarDisciplina(@RequestBody Disciplina payload) {
        return disciplinaRepository.save(payload);
    }

    @GetMapping("/{id}/disciplina")
    public @ResponseBody Iterable<Disciplina> obterDisciplinas() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/{id}/disciplina/{disciplinaId}")
    public @ResponseBody Disciplina obterDisciplina(@PathVariable("disciplinaId") Long disciplinaId) {
        return disciplinaRepository.findOne(disciplinaId);
    }

    @PutMapping(value = "/{id}/disciplina/{disciplinaId}", consumes = "application/json")
    public @ResponseBody Disciplina atualizarDisciplina(@RequestBody Disciplina payload) {
        return disciplinaRepository.save(payload);
    }

    @DeleteMapping("/{id}/disciplina/{disciplinaId}")
    public void removerDisciplina(@PathVariable("disciplinaId") Long disciplinaId) {
        disciplinaRepository.delete(disciplinaId);
    }

    @PostMapping(value = "/{id}/semestre", consumes = "application/json")
    public @ResponseBody Semestre cadastrarSemestre(@RequestBody Semestre payload) {
        return semestreRepository.save(payload);
    }

    @GetMapping("/{id}/semestre")
    public @ResponseBody Iterable<Semestre> obterSemestres() {
        return semestreRepository.findAll();
    }

    @GetMapping("/{id}/semestre/{semestreId}")
    public @ResponseBody Semestre obterSemestre(@PathVariable("semestreId") Long semestreId) {
        return semestreRepository.findOne(semestreId);
    }

    @PutMapping(value = "/{id}/semestre/{semestreId}", consumes = "application/json")
    public @ResponseBody Semestre atualizarSemestre(@RequestBody Semestre payload) {
        return semestreRepository.save(payload);
    }

    @DeleteMapping("/{id}/semestre/{semestreId}")
    public void removerSemestre(@PathVariable("semestreId") Long semestreId) {
        semestreRepository.delete(semestreId);
    }
}
