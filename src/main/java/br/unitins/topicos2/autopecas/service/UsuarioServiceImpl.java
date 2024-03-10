package br.unitins.topicos2.autopecas.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.autopecas.dto.UsuarioDTO;
import br.unitins.topicos2.autopecas.dto.UsuarioResponseDTO;
//import br.unitins.topicos2.autopecas.dto.UsuarioResponseDTO2;
import br.unitins.topicos2.autopecas.model.Usuario;
import br.unitins.topicos2.autopecas.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;

    @Override
    public List<UsuarioResponseDTO> getAll() {

        List<Usuario> list = usuarioRepository.findAll().list();
        return list.stream().map(e -> UsuarioResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id);
        if (usuario == null)
            throw new NotFoundException("Usuario não encontrado.");
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO create(@Valid UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        // validar(usuarioDTO);

        Usuario entity = new Usuario();
        entity.setNome(usuarioDTO.nome());
        entity.setEmail(usuarioDTO.email());
        //entity.setIdade(usuarioDTO.idade());
        entity.setSenha(usuarioDTO.senha());

        usuarioRepository.persist(entity);

        return UsuarioResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(Long id, UsuarioDTO usuarioDTO) throws ConstraintViolationException {
        validar(usuarioDTO);

        Usuario entity = usuarioRepository.findById(id);

        entity.setNome(usuarioDTO.nome());
        entity.setEmail(usuarioDTO.email());
        //entity.setIdade(usuarioDTO.idade());
        entity.setSenha(usuarioDTO.senha());

        return UsuarioResponseDTO.valueOf(entity);
    }

    private void validar(UsuarioDTO estadoDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(estadoDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        List<Usuario> list = usuarioRepository.findByNome(nome).list();
        return list.stream().map(e -> UsuarioResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return usuarioRepository.count();
    }

    @Override
    public long countByNome(String nome) {
        return usuarioRepository.findByNome(nome).count();
    }
}
