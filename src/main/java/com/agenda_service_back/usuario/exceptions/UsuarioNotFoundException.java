package com.agenda_service_back.usuario.exceptions;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(Long id) {
        super("Usuário não encontrado com o ID: " + id);
    }
}

