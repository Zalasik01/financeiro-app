package br.com.financeiroapp.Financeiro.service;

import br.com.financeiroapp.Financeiro.enums.EnSituacaoConta;
import br.com.financeiroapp.Financeiro.repository.OrganizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.financeiroapp.Financeiro.dto.OrganizacaoDTO;
import br.com.financeiroapp.Financeiro.entity.OrganizacaoEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizacaoService {
    @Autowired
    private OrganizacaoRepository repository;

    public OrganizacaoEntity criar(OrganizacaoDTO dto) {
        OrganizacaoEntity entity = new OrganizacaoEntity();
        entity.setNome(dto.getNome());
        entity.setQtd_usuarios(dto.getQtd_usuarios());
        entity.setSituacao(EnSituacaoConta.ATIVA);
        entity.setGuid(UUID.randomUUID());
        entity.setData_contratacao(new Date());
        entity.setData_ultima_alteracao(new Date());
        entity.setData_cancelamento(null);
        return repository.save(entity);
    }

    public OrganizacaoEntity buscarPorId(Long id) {
        Optional<OrganizacaoEntity> entity = repository.findById(id);
        return entity.orElse(null);
    }

    public List<OrganizacaoEntity> listarTodas() {
        return repository.findAll();
    }

    public OrganizacaoEntity atualizar(Long id, OrganizacaoDTO dto) {
        Optional<OrganizacaoEntity> entityOpt = repository.findById(id);
        if (entityOpt.isPresent()) {
            OrganizacaoEntity entity = entityOpt.get();
            entity.setNome(dto.getNome());
            entity.setData_contratacao(dto.getData_contratacao());
            entity.setQtd_usuarios(dto.getQtd_usuarios());
            entity.setSituacao(dto.getSituacao());
            entity.setData_cancelamento(dto.getData_cancelamento());
            entity.setGuid(dto.getGuid());
            entity.setData_ultima_alteracao(dto.getData_ultima_alteracao());
            return repository.save(entity);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
