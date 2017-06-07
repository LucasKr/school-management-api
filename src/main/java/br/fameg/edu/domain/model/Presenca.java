package br.fameg.edu.domain.model;

import br.fameg.edu.utils.DateDeserializer;
import br.fameg.edu.utils.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Presenca {

    @Id @GeneratedValue
    private long id;
    @OneToOne(optional = false)
    private Aluno aluno;
    @OneToOne(optional = false)
    private Disciplina disciplina;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
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
