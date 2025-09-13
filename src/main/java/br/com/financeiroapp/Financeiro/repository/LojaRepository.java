package br.com.financeiroapp.Financeiro.repository;

import br.com.financeiroapp.Financeiro.entity.LojaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LojaRepository extends JpaRepository<LojaEntity, Long> {

    @Query(value = "SELECT * FROM loja WHERE id_loja = ?1", nativeQuery = true)
    LojaEntity findByIdLoja(Long idLoja);

    @Query(value = "SELECT * FROM loja", nativeQuery = true)
    List<LojaEntity> findAllLoja();
}
