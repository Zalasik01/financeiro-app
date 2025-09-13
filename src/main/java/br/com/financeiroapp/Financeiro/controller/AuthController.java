package br.com.financeiroapp.Financeiro.controller;

import br.com.financeiroapp.Financeiro.dto.LoginRequestDTO;
import br.com.financeiroapp.Financeiro.dto.LoginResponseDTO;
import br.com.financeiroapp.Financeiro.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        String accessToken = authService.autenticar(loginRequest.getEmail(), loginRequest.getSenha());
        return ResponseEntity.ok(new LoginResponseDTO(accessToken));
    }
}