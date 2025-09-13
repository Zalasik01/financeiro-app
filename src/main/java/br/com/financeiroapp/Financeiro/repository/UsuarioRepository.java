package br.com.financeiroapp.Financeiro.repository;

import br.com.financeiroapp.Financeiro.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByGuid(UUID guid);

    Optional<UsuarioEntity> findByEmail(String email);
}