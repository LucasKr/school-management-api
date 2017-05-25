package br.fameg.edu.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Semestre {

    @Id @GeneratedValue
    private long id;
    private int sequencia;
    private int ano;
    private Date dataInicial;
    private Date dataFinal;
    
    public Semestre(long id, int sequencia, int ano, Date dataInicial, Date dataFinal) {
        super();
        this.id = id;
        this.sequencia = sequencia;
        this.ano = ano;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }
    
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
