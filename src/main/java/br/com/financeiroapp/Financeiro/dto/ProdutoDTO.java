package br.com.financeiroapp.Financeiro.dto;

import java.util.UUID;

public class ProdutoDTO {
    private String nome;
    private String descricao;
    private Double preco;
    private UUID guid;

    public ProdutoDTO(Long id, String nome, String descricao, Double preco, UUID guid) {
    }

    public ProdutoDTO(String nome, String descricao, Double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }
}
