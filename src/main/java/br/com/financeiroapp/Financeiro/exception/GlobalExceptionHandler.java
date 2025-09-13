// src/main/java/br/com/financeiroapp/Financeiro/exception/GlobalExceptionHandler.java
package br.com.financeiroapp.Financeiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjetoOperacaoInvalidaException.class)
    public ResponseEntity<?> handleObjetoOperacaoInvalida(ObjetoOperacaoInvalidaException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Erro: Não foi encontrado organização para esse guid."));
    }

    // Classe auxiliar para resposta de erro
    static class ErrorResponse {
        public String error;
        public ErrorResponse(String error) { this.error = error; }
        public String getError() { return error; }
    }
}
