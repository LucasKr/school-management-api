package br.fameg.edu.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Disciplina {
    
    @Id @GeneratedValue
    public long id;
    public String descricao;
    public @OneToOne Professor professor;
    public @OneToMany List<Semestre> semestres;
    
}