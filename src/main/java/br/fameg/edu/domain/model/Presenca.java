package br.fameg.edu.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Presenca {

    @Id @GeneratedValue
    private long id;
    @OneToOne(optional = false)
    private Aluno aluno;
    @OneToOne(optional = false)
    private Disciplina disciplina;
    @Column(nullable = false)
    private Date data;
    @Column(nullable = false)
    private boolean presente;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
