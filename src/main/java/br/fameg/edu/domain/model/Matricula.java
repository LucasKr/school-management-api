package br.fameg.edu.domain.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"disciplina_id", "aluno_id", "semestre_id", "turma_id"}))
public class Matricula {

    @Id @GeneratedValue
    private Long id;
    @OneToOne(optional = false)
    private Disciplina disciplina;
    @OneToOne(optional = false)
    private Aluno aluno;
    @OneToOne(optional = false)
    private Semestre semestre;
    @OneToOne(optional = false)
    private Turma turma;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataMatricula;
    private boolean trancada;
       
    public Matricula() {}
    
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

    public boolean isTrancada() {
        return trancada;
    }

    public void setTrancada(boolean trancada) {
        this.trancada = trancada;
    }
}
