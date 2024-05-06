package com.agenda_service_back.prestador.exceptions;

public class PrestadorNotFoundException extends RuntimeException {

    public PrestadorNotFoundException(Long id) {
        super("Prestador com ID " + id + " não encontrado.");
    }
}

