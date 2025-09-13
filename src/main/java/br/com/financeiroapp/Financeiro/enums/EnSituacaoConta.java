package br.com.financeiroapp.Financeiro.enums;

public enum EnSituacaoConta {
    ATIVO("ATIVO"),
    INATIVA("INATIVA"),
    SUSPENSA("SUSPENSA"),
    CANCELADA("CANCELADA");

    private final String valor;

    EnSituacaoConta(String valor) {
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
