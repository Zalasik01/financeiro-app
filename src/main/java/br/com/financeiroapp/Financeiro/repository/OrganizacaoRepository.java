package br.com.financeiroapp.Financeiro.repository;

import br.com.financeiroapp.Financeiro.entity.OrganizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizacaoRepository extends JpaRepository<OrganizacaoEntity, Long> {
}
