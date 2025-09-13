package br.com.financeiroapp.Financeiro.entity;

import br.com.financeiroapp.Financeiro.enums.EnSituacaoConta;
import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "organizacao")
public class OrganizacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organizacao")
    private Long id;

    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_contratacao;
    private Double qtd_usuarios;
    @Enumerated(EnumType.STRING)
    private EnSituacaoConta situacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_cancelamento;
    @Column(columnDefinition = "BINARY(16)")
    private UUID guid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_ultima_alteracao;

    // Getters e setters (removendo getTenant/setTenant)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
