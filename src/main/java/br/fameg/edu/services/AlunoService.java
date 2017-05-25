package br.fameg.edu.services;

import br.fameg.edu.domain.model.Aluno;
import br.fameg.edu.domain.repositories.AlunoRepository;

public class AlunoService {
    
    private AlunoRepository alunoRepository;
    
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    
    public void validarAluno(Aluno aluno) {
        
    }
    
}
