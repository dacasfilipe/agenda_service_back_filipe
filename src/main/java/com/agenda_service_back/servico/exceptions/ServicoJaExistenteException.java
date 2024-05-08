package com.agenda_service_back.servico.exceptions;


public class ServicoJaExistenteException extends RuntimeException {

    public ServicoJaExistenteException(String message) {
        super(message);
    }
}
