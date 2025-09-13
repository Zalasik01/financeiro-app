package br.com.financeiroapp.Financeiro.repository;

import br.com.financeiroapp.Financeiro.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

    @Query(value = "SELECT * FROM produtos p WHERE p.tenant = ?1 AND p.ativo = true AND p.deletado = false", nativeQuery = true)
    List<ProdutoEntity> findByTenant(String tenant);
}
