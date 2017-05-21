package br.fameg.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coordenador {

    @Id @GeneratedValue
    public long id;
    public String nome;
    public String endereco;
}