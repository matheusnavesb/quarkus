package br.unitins.topicos2.autopecas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Usuario extends DefaultEntity {

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 60)
    private String email;

    //@Column(nullable = false, length = 60)
    //private int idade;

    @Column(nullable = false, length = 60)
    private String senha;

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
    public int getIdade() {
      return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }*/

}
