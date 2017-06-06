package br.fameg.edu.domain.model;

import javax.persistence.*;

@Entity
public class Funcionario {

    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false)
    private String senha;
    @OneToOne(optional = false)
    private DadosPessoais dadosPessoais;

    public Funcionario() {

    }
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
