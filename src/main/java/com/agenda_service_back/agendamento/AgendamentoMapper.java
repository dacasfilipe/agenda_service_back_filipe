package com.agenda_service_back.agendamento;

import lombok.Data;
import org.mapstruct.Mapper;

@Mapper
public interface AgendamentoMapper {

    AgendamentoDTO toAgendamentoDTO(Agendamento agendamento);

    Agendamento toAgendamento(AgendamentoDTO agendamentoDTO);
}

