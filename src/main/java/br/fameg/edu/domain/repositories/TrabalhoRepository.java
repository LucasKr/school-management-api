package br.fameg.edu.domain.repositories;

import br.fameg.edu.domain.model.Trabalho;
import org.springframework.data.repository.CrudRepository;

public interface TrabalhoRepository extends CrudRepository<Trabalho, Long> {

    public Iterable<Trabalho> findByProfessor(long id);

}
