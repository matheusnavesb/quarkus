package br.unitins.topicos2.autopecas.service;

import java.util.List;

import br.unitins.topicos2.autopecas.dto.FornecedorDTO;
import br.unitins.topicos2.autopecas.dto.FornecedorResponseDTO;

public interface FornecedorService {
    
    // recursos basicos
    List<FornecedorResponseDTO> getAll();

    FornecedorResponseDTO findById(Long id);

    FornecedorResponseDTO create(FornecedorDTO dto);

    FornecedorResponseDTO update(Long id, FornecedorDTO dto);

    void delete(Long id);

    // recursos extras

    List<FornecedorResponseDTO> findByNome(String nome);

    long count();
}
