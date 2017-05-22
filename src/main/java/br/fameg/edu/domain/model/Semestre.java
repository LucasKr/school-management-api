package br.fameg.edu.domain.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Semestre {

    @Id @GeneratedValue
    public long id;
    public String descricao;
    public Date dataInicial;
    public Date dataFinal;
}
