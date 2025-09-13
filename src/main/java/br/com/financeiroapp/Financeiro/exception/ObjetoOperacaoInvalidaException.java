package br.com.financeiroapp.Financeiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ObjetoOperacaoInvalidaException extends RuntimeException {
    public ObjetoOperacaoInvalidaException(String message) {
        super(message);
    }
}
