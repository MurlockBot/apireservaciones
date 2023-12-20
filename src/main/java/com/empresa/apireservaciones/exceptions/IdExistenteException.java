package com.empresa.apireservaciones.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdExistenteException extends RuntimeException {

    public IdExistenteException() {
        super(String.format("El recurso que intenta añadir ya existe"));
    }
}
