package br.unitins.topicos2.autopecas.dto;

import br.unitins.topicos2.autopecas.model.Localizacao;

public record LocalizacaoResponseDTO(
        Long id,
        String cidade,
        String estado,
        FornecedorResponseDTO fornecedor) {

    public static LocalizacaoResponseDTO valueOf(Localizacao localizacao) {
        return new LocalizacaoResponseDTO(
                localizacao.getId(),
                localizacao.getCidade(),
                localizacao.getEstado(),
                FornecedorResponseDTO.valueOf(localizacao.getFornecedor()));
    }
}
