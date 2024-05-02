package com.agenda_service_back.telefone;

import com.agenda_service_back.prestador.Prestador;
import com.agenda_service_back.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data //-Getters -Setters Hash Equals toString
//@Getter
//@Setter
@AllArgsConstructor //usar com cuidado em tabelas com chave estrangeira
@NoArgsConstructor
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "telefone_id")
    private Long telefone_id;

    @Column(name = "numero", nullable = false, length = 45)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(XX) XXXX-XXXX")
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_usuario_id", nullable = false)
    private Usuario telefone_usuario_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_prestador_id", nullable = false)
    private Prestador telefone_prestador_id;

}
