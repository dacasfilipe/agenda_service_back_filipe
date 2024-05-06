package com.agenda_service_back.telefone.exceptions;

public class TelefoneNotFoundException extends RuntimeException {

    public TelefoneNotFoundException(Long id) {
        super("Telefone não encontrado com o ID: " + id);
    }
}

