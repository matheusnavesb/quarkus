package br.unitins.topicos2.autopecas.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.autopecas.dto.FornecedorDTO;
import br.unitins.topicos2.autopecas.dto.FornecedorResponseDTO;
import br.unitins.topicos2.autopecas.model.Fornecedor;
import br.unitins.topicos2.autopecas.repository.FornecedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FornecedorServiceImpl implements FornecedorService{
    
    @Inject
    FornecedorRepository fornecedorRepository;

    @Inject
    Validator validator;

    @Override
    public List<FornecedorResponseDTO> getAll() {
        List<Fornecedor> list = fornecedorRepository.findAll2();
        return list.stream().map(e -> FornecedorResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public FornecedorResponseDTO findById(Long id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id);
        if (fornecedor == null)
            throw new NotFoundException("Fornecedor não encontrada.");
        return FornecedorResponseDTO.valueOf(fornecedor);
    }

    @Override
    @Transactional
    public FornecedorResponseDTO create(FornecedorDTO fornecedorDTO) throws ConstraintViolationException {
        validar(fornecedorDTO);

        Fornecedor entity = new Fornecedor();
        entity.setNome(fornecedorDTO.nome());
        entity.setCnpj(fornecedorDTO.cnpj());
        entity.setEmail(fornecedorDTO.email());

        fornecedorRepository.persist(entity);

        return FornecedorResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public FornecedorResponseDTO update(Long id, FornecedorDTO fornecedorDTO) throws ConstraintViolationException {
        validar(fornecedorDTO);

        Fornecedor entity = fornecedorRepository.findById(id);

        entity.setNome(fornecedorDTO.nome());
        entity.setEmail(fornecedorDTO.email());

        return FornecedorResponseDTO.valueOf(entity);
    }

    private void validar(FornecedorDTO fornecedorDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<FornecedorDTO>> violations = validator.validate(fornecedorDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        fornecedorRepository.deleteById(id);
    }

    @Override
    public List<FornecedorResponseDTO> findByNome(String nome) {
        List<Fornecedor> list = fornecedorRepository.findByNome(nome).listAll();
        return list.stream().map(e -> FornecedorResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return fornecedorRepository.count();
    }
}
