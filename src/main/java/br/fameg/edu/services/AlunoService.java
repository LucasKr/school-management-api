package br.fameg.edu.services;

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.model.Matricula;
import br.fameg.edu.domain.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private MatriculaRepository matriculaRepository;

    public AlunoService(MatriculaRepository repo) {
        this.matriculaRepository = repo;
    }

    public Matricula matricular(Matricula matricula) {
        if(!validarSituacaoDoAluno(matricula.getAluno()))
            throw new RuntimeException("O Nº de matrícula do aluno é inválido.");
        return matriculaRepository.save(matricula);
    }
    private boolean validarSituacaoDoAluno(Aluno aluno) {
        return aluno.getNumeroDeMatricula() > 0;
    }
}
