package br.com.financeiroapp.Financeiro.service;

import br.com.financeiroapp.Financeiro.entity.LojaEntity;
import br.com.financeiroapp.Financeiro.dto.LojaDTO;
import br.com.financeiroapp.Financeiro.exception.ObjetoOperacaoInvalidaException;
import br.com.financeiroapp.Financeiro.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    public LojaEntity cadastrarLoja(LojaDTO dto) {
        if (dto.getTenant() == null || dto.getTenant().isEmpty()) {
            throw new ObjetoOperacaoInvalidaException("Tenant (guid da organização) não informado.");
        }
        // Aqui você pode validar se o guid existe na base, se necessário
        // Exemplo: if (!organizacaoRepository.existsByGuid(dto.getTenant())) { ... }


        LojaEntity loja = new LojaEntity();
        loja.setGuid(java.util.UUID.randomUUID());
        loja.setNome(dto.getNome());
        loja.setTenant(UUID.fromString(dto.getTenant()));
        loja.setAtivo(true);
        loja.setDeletado(false);
        return repository.save(loja);
    }


    public List<LojaEntity> listarTodas() {
        return repository.findAllLoja();
    }

    public LojaEntity buscarPorId(Long id) {
        return repository.findByIdLoja(id);
    }

    public LojaEntity atualizar(Long id, LojaDTO dto) {
        Optional<LojaEntity> lojaOpt = repository.findById(id);
        if (lojaOpt.isPresent()) {
            LojaEntity loja = lojaOpt.get();
            loja.setNome(dto.getNome());
            return repository.save(loja);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
