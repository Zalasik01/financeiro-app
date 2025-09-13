package br.com.financeiroapp.Financeiro.controller;

import br.com.financeiroapp.Financeiro.config.TenantContext;
import br.com.financeiroapp.Financeiro.exception.ObjetoOperacaoInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import br.com.financeiroapp.Financeiro.service.ProdutoService;
import br.com.financeiroapp.Financeiro.dto.ProdutoDTO;

import java.util.List;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        String tenant = attributes.getRequest().getHeader("X-Tenant");
        if (tenant == null) {
            throw new ObjetoOperacaoInvalidaException("Erro: Tenant Obrigatório!");
        }
        TenantContext.setCurrentTenant(tenant);

        ProdutoDTO produtoCriado = produtoService.criarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> buscarTodosProdutos() {
        ServletRequestAttributes atributosDaRequisicao = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        String tenant = atributosDaRequisicao.getRequest().getHeader("X-tenant");
        if (tenant == null) {
            throw new ObjetoOperacaoInvalidaException("Erro: Tenant Obrigatório!");
        }
        TenantContext.setCurrentTenant(tenant);

        List<ProdutoDTO> produtos = produtoService.buscarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }
}
