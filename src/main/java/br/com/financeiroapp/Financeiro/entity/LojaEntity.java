package br.com.financeiroapp.Financeiro.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "loja")
public class LojaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loja_seq")
    @SequenceGenerator(name = "loja_seq", sequenceName = "loja_sequence", allocationSize = 1)
    @Column(name = "id_loja")
    private Long idLoja;

    @Column(name = "guid", unique = true, nullable = false)
    private UUID guid;

    @Column(name = "ativo")
    private Boolean ativo;

    @Column(name = "deletado")
    private Boolean deletado;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tenant")
    private UUID tenant;

    // Getters e Setters

    public Long getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getDeletado() {
        return deletado;
    }

    public void setDeletado(Boolean deletado) {
        this.deletado = deletado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getTenant() {
        return tenant;
    }

    public void setTenant(UUID tenant) {
        this.tenant = tenant;
    }
}
