package com.agenda_service_back.agendamento;

public enum AgendamentoStatus {
    PENDENTE("Pendente"),
    CONCLUIDO("Concluído"),
    EM_ESPERA("Em Espera");

    private final String descricao;

    AgendamentoStatus(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}

