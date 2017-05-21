package br.fameg.edu.repositories;


import br.fameg.edu.model.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    
}
