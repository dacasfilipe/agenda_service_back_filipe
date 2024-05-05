package com.agenda_service_back.endereco.exceptions;

public class EnderecoNotFoundException extends RuntimeException {

    public EnderecoNotFoundException(Long id) {
        super("Endereco not found with id: " + id);
    }
}

