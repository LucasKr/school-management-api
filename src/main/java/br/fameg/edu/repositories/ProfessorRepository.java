package br.fameg.edu.repositories;

import br.fameg.edu.model.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long>{
    
}
