package br.com.financeiroapp.Financeiro.dto;

import br.com.financeiroapp.Financeiro.enums.EnSituacaoConta;

import java.util.Date;
import java.util.UUID;

public class OrganizacaoDTO {
    private String nome;
    private Date data_contratacao;
    private Double qtd_usuarios;
    private EnSituacaoConta situacao;
    private Date data_cancelamento;
    private UUID guid;
    private Date data_ultima_alteracao;

    // Getters e setters (removendo getTenant/setTenant)

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    public Double getQtd_usuarios() {
        return qtd_usuarios;
    }

    public void setQtd_usuarios(Double qtd_usuarios) {
        this.qtd_usuarios = qtd_usuarios;
    }

    public EnSituacaoConta getSituacao() {
        return situacao;
    }

    public void setSituacao(EnSituacaoConta situacao) {
        this.situacao = situacao;
    }

    public Date getData_cancelamento() {
        return data_cancelamento;
    }

    public void setData_cancelamento(Date data_cancelamento) {
        this.data_cancelamento = data_cancelamento;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public Date getData_ultima_alteracao() {
        return data_ultima_alteracao;
    }

    public void setData_ultima_alteracao(Date data_ultima_alteracao) {
        this.data_ultima_alteracao = data_ultima_alteracao;
    }
}
