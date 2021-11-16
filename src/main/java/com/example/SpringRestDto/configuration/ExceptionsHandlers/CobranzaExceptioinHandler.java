package com.example.SpringRestDto.configuration.ExceptionsHandlers;

import com.example.SpringRestDto.configuration.Exceptions.Cobranza.CobranzaExistente;
import com.example.SpringRestDto.configuration.Exceptions.Cobranza.CrearCobranzaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CobranzaExceptioinHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({CrearCobranzaException.class })
    protected ResponseEntity<Object> noSePudoCrearCobranza(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "No se pudo Crear la Cobranza",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({CobranzaExistente.class })
    protected ResponseEntity<Object> CobranzaExistente(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "la Cobranza ya existe",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
