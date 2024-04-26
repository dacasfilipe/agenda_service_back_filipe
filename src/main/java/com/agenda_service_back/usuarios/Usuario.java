package com.agenda_service_back.usuarios;

import com.agenda_service_back.endereco.Endereco;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
@Entity
public class Usuario {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private long usuario_id;

    @CPF
    @Column(name = "usuario_cpf",unique = true)
    private String usuario_cpf;

    @Column(name = "usuario_email",unique = true)
    private String usuario_email;

    @JsonFormat(pattern = "dd/MM/YY")
    @Column(name = "usuario_data_nascimento")
    private LocalDate usuario_data_nascimento;

    @Column(name = "usuario_senha")
    private String usuario_senha;

    @OneToOne
    @JoinColumn(name = "usuario_endereco_id")
    private Endereco endereco;
}
