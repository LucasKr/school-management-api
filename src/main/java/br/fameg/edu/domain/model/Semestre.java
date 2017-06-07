package br.fameg.edu.domain.model;

import br.fameg.edu.utils.DateDeserializer;
import br.fameg.edu.utils.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Semestre {

    @Id @GeneratedValue
    private long id;
    @Column(nullable = false)
    private int sequencia;
    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date dataInicial;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
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
