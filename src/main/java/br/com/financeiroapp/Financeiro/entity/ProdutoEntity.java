package br.com.financeiroapp.Financeiro.entity;

import br.com.financeiroapp.Financeiro.config.TenantContext;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "produtos")
public class ProdutoEntity extends TenantContext {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_sequence")
    @SequenceGenerator(name = "produto_sequence", sequenceName = "produto_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "guid", unique = true, nullable = false)
    private UUID guid;

    private String nome;
    private String descricao;
    private Double preco;

    // Construtor padrão necessário pelo JPA
    public ProdutoEntity() {}
}
