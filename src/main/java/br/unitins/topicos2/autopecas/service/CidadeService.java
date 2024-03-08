package br.unitins.topicos2.autopecas.service;

import java.util.List;

import br.unitins.topicos2.autopecas.dto.CidadeDTO;
import br.unitins.topicos2.autopecas.dto.CidadeResponseDTO;

public interface CidadeService {

    // recursos basicos
    List<CidadeResponseDTO> getAll();

    CidadeResponseDTO findById(Long id);

    CidadeResponseDTO create(CidadeDTO dto);

    CidadeResponseDTO update(Long id, CidadeDTO dto);

    void delete(Long id);

    // recursos extras

    List<CidadeResponseDTO> findByNome(String nome);

    long count();
}
