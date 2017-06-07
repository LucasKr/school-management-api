package br.fameg.edu.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import br.fameg.edu.domain.model.Trabalho;
import br.fameg.edu.domain.model.Turma;

public interface TrabalhoRepository extends CrudRepository<Trabalho, Long> {
    
}
