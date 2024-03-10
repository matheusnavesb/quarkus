package br.unitins.topicos2.autopecas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FornecedorDTO(
    @NotBlank(message = "O campo nome deve ser informado.")
    @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.")
    String nome,

    @NotBlank(message = "O campo cnpj deve ser informado.")
    @Size(min = 18, max = 18, message = "O campo cnpj deve possuir 18 caracteres.")
    String cnpj,

    @NotBlank(message = "O campo email deve ser informado.")
    @Size(max = 60, message = "O campo email deve possuir no máximo 60 caracteres.")
    String email
) {
    
}
