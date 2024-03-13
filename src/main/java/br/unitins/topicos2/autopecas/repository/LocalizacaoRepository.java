package br.unitins.topicos2.autopecas.repository;

import java.util.List;

import br.unitins.topicos2.autopecas.model.Localizacao;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LocalizacaoRepository implements PanacheRepository<Localizacao> {
    
    public PanacheQuery<Localizacao> findByNome(String localizacao) {
        if (localizacao == null)
            return null;
        return find("UPPER(nome) LIKE ?1 ", "%" + localizacao.toUpperCase() + "%");
    }

    public List<Localizacao> findAll2() {
        return find("SELECT l FROM Localizacao l ORDER BY l.cidade ").list();
    }
}
