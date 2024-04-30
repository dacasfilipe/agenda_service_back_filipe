package com.agenda_service_back.telefone;

import com.agenda_service_back.prestador.Prestador;
import com.agenda_service_back.usuarios.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telefone_id")
    private long telefone_id;

    @Column(name = "telefone_numero",nullable = false,length = 45)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(XX) XXXX-XXXX")
    private String telefone_numero; // 48999895555 --> (48) 99989-5555

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_prestador_id")
    private Prestador prestador;

}
