package br.unitins.topicos2.autopecas.dto;

import br.unitins.topicos2.autopecas.model.Estado;

public record EstadoResponseDTO(
        Long id,
        String nome,
        String sigla) {
    public static EstadoResponseDTO valueOf(Estado estado) {
        return new EstadoResponseDTO(
                estado.getId(),
                estado.getNome(),
                estado.getSigla());
    }
}
