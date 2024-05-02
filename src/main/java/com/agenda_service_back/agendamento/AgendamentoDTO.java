package com.agenda_service_back.agendamento;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long agendamento_id;
    private LocalDate agendamento_data;
    private LocalTime agendamento_hora;
    private String agendamento_status; // Use String for enum representation
    private String usuario_id; // Assuming you have a way to get user name
    private String servico_id; // Assuming you have a way to get service name

    // Getters and setters (lombok can be used for these)
}

