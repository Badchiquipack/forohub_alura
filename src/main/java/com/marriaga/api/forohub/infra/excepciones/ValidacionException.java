package com.marriaga.api.forohub.infra.excepciones;

public class ValidacionException extends RuntimeException{
    public ValidacionException(String mensaje){
        super(mensaje);
    }
}
