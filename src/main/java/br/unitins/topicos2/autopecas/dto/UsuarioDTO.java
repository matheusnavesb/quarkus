package br.unitins.topicos2.autopecas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
                @NotBlank(message = "O nome deve ser informado.") 
                @Size(max = 60, message = "O campo nome deve possuir no máximo 60 caracteres.") 
                String nome,

                @NotBlank(message = "O email deve ser informado.") 
                @Size(min = 2, max = 60, message = "O campo email deve possuir no máximo 60 caracteres.") 
                String email,

                //Integer idade,

                @NotBlank(message = "O campo senha deve ser informado.") 
                @Size(min = 8, max = 8, message = "O campo senha deve possuir 8 caracteres.") 
                String senha) {

}
