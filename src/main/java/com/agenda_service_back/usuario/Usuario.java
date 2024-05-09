package com.agenda_service_back.usuario;

import com.agenda_service_back.agendamento.Agendamento;
import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "usuario_nome")
    private String usuario_nome;

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

    @ManyToOne(fetch = FetchType.EAGER)
    private Endereco endereco;

    @OneToMany(mappedBy = "telefone_usuario_id", fetch = FetchType.EAGER)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "agendamento_usuario_id", fetch = FetchType.EAGER)
    private List<Agendamento> agendamentos;


}
