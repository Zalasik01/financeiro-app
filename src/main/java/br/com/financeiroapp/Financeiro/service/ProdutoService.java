package br.com.financeiroapp.Financeiro.service;

import br.com.financeiroapp.Financeiro.config.TenantContext;
import br.com.financeiroapp.Financeiro.dto.ProdutoDTO;
import br.com.financeiroapp.Financeiro.entity.ProdutoEntity;
import br.com.financeiroapp.Financeiro.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produtoDTO.getNome());
        produtoEntity.setDescricao(produtoDTO.getDescricao());
        produtoEntity.setPreco(produtoDTO.getPreco());
        produtoEntity.setCurrentTenant(TenantContext.getCurrentTenant());

        // Atribui o GUID antes de salvar
        produtoEntity.setGuid(UUID.randomUUID());

        ProdutoEntity salvo = produtoRepository.save(produtoEntity);

        // Retorna o DTO com o ID e o GUID gerados
        return new ProdutoDTO(salvo.getId(), salvo.getNome(), salvo.getDescricao(), salvo.getPreco(), salvo.getGuid());
    }

    public List<ProdutoDTO> buscarTodosProdutos() {
        String tenant = TenantContext.getCurrentTenant();
        List<ProdutoEntity> produtos = produtoRepository.findByTenant(tenant);

        // Mapeia as entidades para DTOs
        return produtos.stream()
                .map(p -> new ProdutoDTO(p.getId(), p.getNome(), p.getDescricao(), p.getPreco(), p.getGuid()))
                .collect(Collectors.toList());
    }
}
