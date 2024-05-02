package com.agenda_service_back.agendamento;

import com.agenda_service_back.servico.Servico;
import com.agenda_service_back.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private long agendamento_id;


    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "agendamento_data")
    private LocalDate agendamento_data;

    @Temporal(TemporalType.TIME)
    @Column(name = "agendamento_hora")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime agendamento_hora;

    @Enumerated(EnumType.STRING)
    @Column(name = "agendamento_status")
    private AgendamentoStatus agendamento_status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_usuario_id", nullable = false)
    private Usuario agendamento_usuario_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_servico_id", nullable = false)
    private Servico agendamento_servico_id;
}

