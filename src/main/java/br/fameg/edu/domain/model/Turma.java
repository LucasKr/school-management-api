package br.fameg.edu.domain.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Turma {

    @Id @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String descricao;
    @OneToMany
    private List<Aluno> alunos;
    
    public Turma() {}

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
