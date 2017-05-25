package br.fameg.edu.domain.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Funcionario {

    private Long id;
    private String usuario;
    private String senha; 
    private @OneToOne DadosPessoais dadosPessoais;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getUsuario() {
        return usuario;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }
    
    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }
}
