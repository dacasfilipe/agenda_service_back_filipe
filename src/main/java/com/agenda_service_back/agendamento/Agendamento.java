package com.agenda_service_back.agendamento;

import com.agenda_service_back.categoria.Categoria;
import com.agenda_service_back.prestador.Prestador;
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

@Data //-Getters -Setters Hash Equals toString
//@Getter
//@Setter
@AllArgsConstructor //usar com cuidado em tabelas com chave estrangeira
@NoArgsConstructor
@Entity
@Table(name = "agendamento")
public class Agendamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private Long agendamento_id;

    @Column(name = "agendamento_data", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate agendamento_data;

    @Column(name = "agendamento_hora", nullable = false)
    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime agendamento_hora;

    @Column(name = "observacao", length = 255)
    private String observacao;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AgendamentoStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agendamento_servico_id", nullable = false)
    private Servico servico;

}


