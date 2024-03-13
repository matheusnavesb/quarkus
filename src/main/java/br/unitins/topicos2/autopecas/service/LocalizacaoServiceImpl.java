package br.unitins.topicos2.autopecas.service;



import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.autopecas.dto.LocalizacaoDTO;
import br.unitins.topicos2.autopecas.dto.LocalizacaoResponseDTO;
import br.unitins.topicos2.autopecas.model.Localizacao;
import br.unitins.topicos2.autopecas.repository.FornecedorRepository;
import br.unitins.topicos2.autopecas.repository.LocalizacaoRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class LocalizacaoServiceImpl implements LocalizacaoService{
    
    @Inject
    LocalizacaoRepository localizacaoRepository;

    @Inject
    FornecedorRepository fornecedorRepository;
    
    @Inject
    Validator validator;

    @Override
    public List<LocalizacaoResponseDTO> getAll() {
        List<Localizacao> list = localizacaoRepository.findAll2();
        return list.stream().map(e -> LocalizacaoResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public LocalizacaoResponseDTO findById(Long id) {
        Localizacao localizacao = localizacaoRepository.findById(id);
        if (localizacao == null)
            throw new NotFoundException("Localizacao não encontrada.");
        return LocalizacaoResponseDTO.valueOf(localizacao);
    }

    @Override
    @Transactional
    public LocalizacaoResponseDTO create(LocalizacaoDTO localizacaoDTO) throws ConstraintViolationException {
        validar(localizacaoDTO);

        Localizacao entity = new Localizacao();
        entity.setCidade(localizacaoDTO.cidade());
        entity.setEstado(localizacaoDTO.estado());
        entity.setFornecedor(fornecedorRepository.findById(localizacaoDTO.idFornecedor()));

        localizacaoRepository.persist(entity);

        return LocalizacaoResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public LocalizacaoResponseDTO update(Long id, LocalizacaoDTO localizacaoDTO) throws ConstraintViolationException {
        validar(localizacaoDTO);

        Localizacao entity = localizacaoRepository.findById(id);

        entity.setCidade(localizacaoDTO.cidade());
        entity.setFornecedor(fornecedorRepository.findById(localizacaoDTO.idFornecedor()));

        return LocalizacaoResponseDTO.valueOf(entity);
    }

    private void validar(LocalizacaoDTO localizacaoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<LocalizacaoDTO>> violations = validator.validate(localizacaoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        localizacaoRepository.deleteById(id);
    }

    @Override
    public List<LocalizacaoResponseDTO> findByNome(String nome) {
        PanacheQuery<Localizacao> list = localizacaoRepository.findByNome(nome);
        return list.stream().map(e -> LocalizacaoResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return localizacaoRepository.count();
    }
}
