package br.fameg.edu.services;

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.model.Matricula;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    public Matricula validarMatricula(Aluno aluno, Matricula matricula) {
        throw new UnsupportedOperationException("Ainda não validamos matrícula.");
    }
}
