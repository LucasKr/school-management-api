package br.fameg.edu.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma {

    @Id @GeneratedValue
    private long id;
    private String descricao;
    private @OneToMany List<Aluno> alunos;
    
    public Turma(long id, String descricao, List<Aluno> alunos, List<Semestre> semestres) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.alunos = alunos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
