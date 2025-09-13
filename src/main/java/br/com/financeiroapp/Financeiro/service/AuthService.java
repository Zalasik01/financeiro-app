package br.com.financeiroapp.Financeiro.service;

import br.com.financeiroapp.Financeiro.entity.UsuarioEntity;
import br.com.financeiroapp.Financeiro.exception.ObjetoOperacaoInvalidaException;
import br.com.financeiroapp.Financeiro.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthService {

    @Value("${auth.chave-secreta}")
    private String CHAVE_SECRETA;

    @Value("${auth.horas-expiracao}")
    private int HORAS_EXPIRACAO;

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String autenticar(String email, String senha) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findByEmail(email);

        if (usuarioOptional.isEmpty()) {
            throw new ObjetoOperacaoInvalidaException("Credenciais inválidas");
        }

        UsuarioEntity usuario = usuarioOptional.get();

        if (!passwordEncoder.matches(senha, usuario.getSenha())) {
            throw new ObjetoOperacaoInvalidaException("Credenciais inválidas");
        }

        return gerarToken(usuario.getEmail(), usuario.getGuid().toString());
    }

    private String gerarToken(String email, String guid) {
        Date expiracao = new Date(System.currentTimeMillis() + HORAS_EXPIRACAO * 3600000L);
        Key key = Keys.hmacShaKeyFor(CHAVE_SECRETA.getBytes());

        return Jwts.builder()
                .setSubject(email)
                .claim("guid", guid)
                .setIssuedAt(new Date())
                .setExpiration(expiracao)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validarToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(CHAVE_SECRETA.getBytes());

            Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String obterEmailDoToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(CHAVE_SECRETA.getBytes());

            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }
}