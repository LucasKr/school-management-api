package br.fameg.edu.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import br.fameg.edu.domain.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long>{
    
}
