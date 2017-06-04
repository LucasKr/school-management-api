package br.fameg.edu.services;

import br.fameg.edu.domain.repositories.AlunoRepository;
import br.fameg.edu.domain.repositories.CoordenadorRepository;

public class CoordenadorService {

    private CoordenadorRepository coordenadorRepo;
    private AlunoRepository alunoRepo;

    public CoordenadorService(CoordenadorRepository coordenadorRepo, AlunoRepository alunoRepo) {
        this.coordenadorRepo = coordenadorRepo;
        this.alunoRepo = alunoRepo;
    }
}
