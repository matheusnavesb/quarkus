package br.unitins.topicos2.autopecas.service;

import java.util.List;

import br.unitins.topicos2.autopecas.dto.LocalizacaoDTO;
import br.unitins.topicos2.autopecas.dto.LocalizacaoResponseDTO;

public interface LocalizacaoService {
    
    // recursos basicos
    List<LocalizacaoResponseDTO> getAll();

    LocalizacaoResponseDTO findById(Long id);

    LocalizacaoResponseDTO create(LocalizacaoDTO dto);

    LocalizacaoResponseDTO update(Long id, LocalizacaoDTO dto);

    void delete(Long id);

    // recursos extras

    List<LocalizacaoResponseDTO> findByNome(String nome);

    long count();
}
