package br.fameg.edu.domain.repositories;

import br.fameg.edu.domain.model.Matricula;
import org.springframework.data.repository.CrudRepository;

public interface MatriculaRepository extends CrudRepository<Matricula, Long> {

    public Iterable<Matricula> findByAluno(Long alunoId);
}
