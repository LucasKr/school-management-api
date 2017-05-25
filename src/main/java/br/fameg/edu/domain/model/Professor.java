package br.fameg.edu.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor extends Funcionario {
    
    @Id @GeneratedValue
    public long id;
    
}
