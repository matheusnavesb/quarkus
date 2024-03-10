package br.unitins.topicos2.autopecas.dto;

import br.unitins.topicos2.autopecas.model.Fornecedor;

public record FornecedorResponseDTO(
        Long id,
        String nome,
        String cnpj,
        String email) {
    public static FornecedorResponseDTO valueOf(Fornecedor fornecedor) {
        return new FornecedorResponseDTO(
                fornecedor.getId(),
                fornecedor.getNome(),
                fornecedor.getCnpj(),
                fornecedor.getEmail());
    }
}
