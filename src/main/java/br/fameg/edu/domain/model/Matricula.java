package br.fameg.edu.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Matricula {

    private Long id;
    private @OneToOne Disciplina disciplina;
    private @OneToOne Aluno aluno;
    private @OneToOne Semestre semestre;
    private @OneToOne Turma turma;
    private Date dataMatricula;
       
    public Matricula(Long id, Disciplina disciplina, Aluno aluno, Semestre semestre, Turma turma, Date dataMatricula) {
        super();
        this.id = id;
        this.disciplina = disciplina;
        this.aluno = aluno;
        this.semestre = semestre;
        this.turma = turma;
        this.dataMatricula = dataMatricula;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public Aluno getAluno() {
        return aluno;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public Semestre getSemestre() {
        return semestre;
    }
    
    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }
    
    public Turma getTurma() {
        return turma;
    }
    
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public Date getDataMatricula() {
        return dataMatricula;
    }
    
    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
       
}
