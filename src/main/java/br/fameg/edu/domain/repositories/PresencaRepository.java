package br.fameg.edu.domain.repositories;

import org.springframework.data.repository.CrudRepository;

import br.fameg.edu.domain.model.Presenca;

public interface PresencaRepository extends CrudRepository<Presenca, Long> {
    
}
