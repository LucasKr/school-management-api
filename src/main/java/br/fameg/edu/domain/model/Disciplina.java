package br.fameg.edu.domain.model;

import java.util.List;

import javax.persistence.*;


@Entity
public class Disciplina {
    
    @Id @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String nome;
    @OneToOne(optional = false)
    private Professor professor;
    @OneToMany
    private List<Semestre> semestres;
    
    
    public Disciplina(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

}