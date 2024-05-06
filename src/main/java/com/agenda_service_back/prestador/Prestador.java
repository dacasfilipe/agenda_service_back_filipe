package com.agenda_service_back.prestador;

import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.servico.Servico;
import com.agenda_service_back.telefone.Telefone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prestador")
@Entity
public class Prestador implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestador_id")
    private long prestador_id;

    @Column(name = "prestador_nome")
    private String prestador_nome;

    @CPF
    @Column(name = "prestador_cpf",unique = true)
    private String prestador_cpf;

    @CNPJ
    @Column(name = "prestador_cnpj",unique = true)
    private String prestador_cnpj;

    @Column(name = "prestador_email",unique = true)
    private String prestador_email;

    @Column(name = "prestador_senha")
    private String prestador_senha;

    @Column(name = "prestador_razao_social")
    private String prestador_razao_social;

    @ManyToOne
    @JoinColumn(name = "prestador_endereco_id")
    private Endereco prestador_endereco_id;

    @OneToMany(mappedBy = "servico_prestador_id", fetch = FetchType.EAGER)
    private List<Servico> servicos;

    @OneToMany(mappedBy = "telefone_prestador_id", fetch = FetchType.EAGER)
    private List<Telefone> telefones;
}

