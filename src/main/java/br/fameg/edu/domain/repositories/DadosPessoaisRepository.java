package br.fameg.edu.domain.repositories;

import br.fameg.edu.domain.model.DadosPessoais;
import org.springframework.data.repository.CrudRepository;

public interface DadosPessoaisRepository extends CrudRepository<DadosPessoais, Long> {

    public DadosPessoais findByCpf(String cpf);
}
