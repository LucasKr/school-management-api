package br.fameg.edu.domain.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

@Entity
public class Trabalho {

    @Id 
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @OneToOne
    private Professor professor;
    @Column(nullable = true)
    private BigDecimal nota;
    @Column(nullable = true)
    private Date dataEntrega;    
    @Column
    private boolean isObrigatorio;
    
    public Trabalho() {}

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

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    } 
    
}
