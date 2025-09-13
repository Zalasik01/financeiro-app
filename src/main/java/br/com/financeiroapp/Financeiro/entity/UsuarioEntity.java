// src/main/java/br/com/financeiroapp/Financeiro/entity/UsuarioEntity.java
package br.com.financeiroapp.Financeiro.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_sequence")
    @SequenceGenerator(name = "usuarios_sequence", sequenceName = "usuarios_sequence", allocationSize = 1)
    private Long idUsuario;

    @Column(nullable = false)
    private UUID tenant;

    private String nome;
    private String email;
    private String senha;
    private Boolean ativo;
    private Boolean deletado;
    private String situacaoConta;
    private Long idUsuarioUltimaAlteracao;
    private LocalDateTime dataUltimaAlteracao;

    @Column(name = "guid", unique = true, nullable = false)
    private UUID guid;

    public UsuarioEntity() {}
}
