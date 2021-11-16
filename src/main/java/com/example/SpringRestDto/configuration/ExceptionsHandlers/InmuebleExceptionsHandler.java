package com.example.SpringRestDto.configuration.ExceptionsHandlers;


import com.example.SpringRestDto.configuration.Exceptions.Inmueble.InmuebleExistenteException;
import com.example.SpringRestDto.configuration.Exceptions.Inmueble.InmuebleNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InmuebleExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({InmuebleNotFoundException.class })
    protected ResponseEntity<Object> InmuebleInexistente(
            Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Inmueble no encontrado",
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({InmuebleExistenteException.class})
    protected ResponseEntity<Object> InmuebleExistente(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex,"El inmueble ya existe",
                new HttpHeaders(), HttpStatus.BAD_REQUEST,request);
    }
}
