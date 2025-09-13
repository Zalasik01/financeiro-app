package br.com.financeiroapp.Financeiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.financeiroapp.Financeiro.dto.OrganizacaoDTO;
import br.com.financeiroapp.Financeiro.entity.OrganizacaoEntity;
import br.com.financeiroapp.Financeiro.service.OrganizacaoService;

import java.util.List;

@RestController
@RequestMapping("/organizacao")
public class OrganizacaoController {
    @Autowired
    private OrganizacaoService service;

    @PostMapping
    public OrganizacaoEntity criar(@RequestBody OrganizacaoDTO dto) {
        return service.criar(dto);
    }

    @GetMapping("/{id}")
    public OrganizacaoEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<OrganizacaoEntity> listarTodas() {
        return service.listarTodas();
    }

    @PutMapping("/{id}")
    public OrganizacaoEntity atualizar(@PathVariable Long id, @RequestBody OrganizacaoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
