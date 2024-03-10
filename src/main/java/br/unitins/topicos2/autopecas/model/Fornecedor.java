package br.unitins.topicos2.autopecas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Fornecedor extends DefaultEntity {

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false)
    private String cnpj;

    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
