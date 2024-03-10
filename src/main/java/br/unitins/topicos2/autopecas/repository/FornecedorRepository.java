package br.unitins.topicos2.autopecas.repository;

import java.util.List;

import br.unitins.topicos2.autopecas.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {

    @SuppressWarnings("unchecked")
    public PanacheRepository<Fornecedor> findByNome(String nome) {
        if (nome == null)
            return null;
        return (PanacheRepository<Fornecedor>) find("UPPER(nome) LIKE ?1 ", "%" + nome.toUpperCase() + "%");
    }

    public List<Fornecedor> findAll2() {
        return (List<Fornecedor>) find("SELECT f FROM Fornecedor f ORDER BY f.nome ").list();
    }
}
