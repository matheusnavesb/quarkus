package br.unitins.topicos2.autopecas.model;

import jakarta.persistence.Entity;

@Entity
public class Endereco extends DefaultEntity {
    
    private String logradouro;
    private String numero;
    private String cep;
    
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }


}
