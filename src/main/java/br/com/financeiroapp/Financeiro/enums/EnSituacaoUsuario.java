package br.com.financeiroapp.Financeiro.enums;

public enum EnSituacaoUsuario {
    ATIVA("ATIVA"),
    INATIVA("INATIVA"),
    PENDENTE("PENDENTE");

    private final String valor;

    EnSituacaoUsuario(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
