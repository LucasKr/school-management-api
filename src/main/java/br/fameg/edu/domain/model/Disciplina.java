package br.fameg.edu.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Disciplina {
    
    @Id @GeneratedValue
    private long id;
    private String nome;
    private @OneToOne Professor professor;
    private @OneToMany List<Semestre> semestres;
    
    
    public Disciplina(long id, String nome, Professor professor, List<Semestre> semestres) {
        super();
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.semestres = semestres;
    }

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