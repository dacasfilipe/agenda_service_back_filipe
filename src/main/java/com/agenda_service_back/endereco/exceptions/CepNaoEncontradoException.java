package com.agenda_service_back.endereco.exceptions;

public class CepNaoEncontradoException extends RuntimeException {

    public CepNaoEncontradoException(String message) {
        super(message);
    }
}

