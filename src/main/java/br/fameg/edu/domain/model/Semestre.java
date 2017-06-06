package br.fameg.edu.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Semestre {

    @Id @GeneratedValue
    private long id;
    @Column(nullable = false)
    private int sequencia;
    @Column(nullable = false)
    private int ano;
    @Column(nullable = false)
    private Date dataInicial;
    @Column(nullable = false)
    private Date dataFinal;
    
    public Semestre(){}
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public int getSequencia() {
        return sequencia;
    }
    
    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }
    
    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public Date getDataInicial() {
        return dataInicial;
    }
    
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }
    
    public Date getDataFinal() {
        return dataFinal;
    }
    
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}
