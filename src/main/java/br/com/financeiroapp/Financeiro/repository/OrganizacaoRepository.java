package br.com.financeiroapp.Financeiro.repository;

import br.com.financeiroapp.Financeiro.entity.OrganizacaoEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizacaoRepository extends JpaRepository<OrganizacaoEntity, Long> {

    @Query(value = "SELECT * FROM organizacao WHERE id_organizacao = :id", nativeQuery = true)
    OrganizacaoEntity findByIdNative(@Param("id") Long id);

    // Listar todas as organizações
    @Query(value = "SELECT * FROM organizacao", nativeQuery = true)
    List<OrganizacaoEntity> findAll();
}
