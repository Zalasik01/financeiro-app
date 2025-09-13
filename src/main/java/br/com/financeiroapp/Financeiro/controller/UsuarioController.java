package br.com.financeiroapp.Financeiro.controller;

import br.com.financeiroapp.Financeiro.dto.UsuarioDTO;
import br.com.financeiroapp.Financeiro.entity.UsuarioEntity;
import br.com.financeiroapp.Financeiro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registrar-usuario")
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioDTO dto) {

        if (usuarioService.emailExiste(dto.getEmail())) {
            return ResponseEntity.badRequest().body("Erro: E-mail já cadastrado.");
        }

        if (dto.getEmail() == null || dto.getSenha() == null) {
            return ResponseEntity.badRequest().body("Erro: E-mail e senha são obrigatórios.");
        }

        usuarioService.registrarUsuario(dto);
        return ResponseEntity.ok("Usuário registrado com sucesso.");
    }
}
