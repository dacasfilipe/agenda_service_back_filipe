package com.agenda_service_back.servico.exceptions;

public class ServicoNaoEncontradoException extends RuntimeException {

    public ServicoNaoEncontradoException(String message) {
        super(message);
    }
}

