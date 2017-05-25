package br.fameg.edu.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Trabalho {

    @Id 
    @GeneratedValue
    private Long id;
    private String descricao;
    private @OneToOne Professor professor;
    private Date dataEntrega;    
    
    public Trabalho(Long id, String descricao, Professor professor, Date dataEntrega) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.professor = professor;
        this.dataEntrega = dataEntrega;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Date getDataEntrega() {
        return dataEntrega;
    }
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    } 
    
}
