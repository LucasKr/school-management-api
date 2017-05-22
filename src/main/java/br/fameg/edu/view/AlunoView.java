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
import br.fameg.edu.domain.repositories.AlunoRepository;
import br.fameg.edu.domain.repositories.DisciplinaRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoView {

    @Autowired private AlunoRepository alunoRepository;
    @Autowired private DisciplinaRepository disciplinaRepository;
    

    @PostMapping(consumes = "application/json", produces = "application/json")
    public @ResponseBody Aluno addAluno(@RequestBody Aluno payload) {
        return alunoRepository.save(payload);
    }

    @GetMapping(produces = "application/json")
    public @ResponseBody Iterable<Aluno> getAll() {
        return alunoRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody Aluno getOne(@PathVariable("id") Long id) {
        return alunoRepository.findOne(id);
    }
    
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody Aluno updateAluno(@PathVariable("id") Long id, @RequestBody Aluno payload) {
        
        if(payload.getDisciplinas() != null && !payload.getDisciplinas().isEmpty()) {
            payload.getDisciplinas().forEach(disciplina -> {
                if(disciplinaRepository.exists(disciplina.id))
                    disciplinaRepository.save(disciplina);
            });
        }
        return alunoRepository.save(payload);
    }
    
    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable("id") Long id) {
        alunoRepository.delete(id);
    }
}