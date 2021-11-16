package com.example.SpringRestDto.configuration.ExceptionsHandlers;

import com.example.SpringRestDto.configuration.Exceptions.Cliente.ClienteExistenteException;
import com.example.SpringRestDto.configuration.Exceptions.Cliente.ClienteNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ClienteExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ClienteNotFoundException.class })
    protected ResponseEntity<Object> ClienteInexistente(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Cliente no encontrado",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({ClienteExistenteException.class})
    protected ResponseEntity<Object> clienteExistente(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex,"El Cliente ya existe",
                new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }


}
