package br.fameg.edu.domain.repositories;


import org.springframework.data.repository.CrudRepository;

import br.fameg.edu.domain.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    
}
