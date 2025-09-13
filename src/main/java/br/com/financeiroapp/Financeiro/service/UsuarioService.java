package br.com.financeiroapp.Financeiro.service;

import br.com.financeiroapp.Financeiro.dto.UsuarioDTO;
import br.com.financeiroapp.Financeiro.entity.UsuarioEntity;
import br.com.financeiroapp.Financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean emailExiste(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }

    public UsuarioEntity registrarUsuario(UsuarioDTO dto) {
        if (dto.getTenant() == null || dto.getTenant().isEmpty()) {
            throw new IllegalArgumentException("Tenant obrigatório");
        }

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setTenant(UUID.fromString(dto.getTenant()));
        usuario.setAtivo(true);
        usuario.setDeletado(false);
        usuario.setGuid(UUID.randomUUID());
        usuario.setSituacaoConta("ATIVA");
        usuario.setDataUltimaAlteracao(java.time.LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }
}
