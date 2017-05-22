package br.fameg.edu.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma {

    @Id @GeneratedValue
    public long id;
    public String descricao;
    public @OneToMany List<Aluno> alunos;
    public @OneToMany List<Semestre> semestres;
}
