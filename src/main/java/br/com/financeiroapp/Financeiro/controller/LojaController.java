package br.com.financeiroapp.Financeiro.controller;

import br.com.financeiroapp.Financeiro.dto.LojaDTO;
import br.com.financeiroapp.Financeiro.entity.LojaEntity;
import br.com.financeiroapp.Financeiro.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaService service;

    @PostMapping("/novo-registro")
    public LojaEntity criar(@RequestBody LojaDTO dto) {
        return service.cadastrarLoja(dto);
    }

    @GetMapping("/{id}")
    public LojaEntity buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<LojaEntity> listarTodas() {
        return service.listarTodas();
    }

    @PutMapping("/{id}")
    public LojaEntity atualizar(@PathVariable Long id, @RequestBody LojaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
