package com.agenda_service_back.endereco;

import com.agenda_service_back.prestador.Prestador;
import com.agenda_service_back.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long endereco_id;

    @Column(name = "endereco_rua")
    private String endereco_rua;

    @Column(name = "endereco_cep")
    private String endereco_cep;

    @Column(name = "endereco_numero")
    private int endereco_numero;

    @Column(name = "endereco_complemento")
    private String endereco_complemento;

    @Column(name = "endereco_cidade")
    private String endereco_cidade;

    @Column(name = "endereco_estado")
    private String endereco_estado;

    @Column(name = "endereco_bairro")
    private String endereco_bairro;

    @OneToMany(mappedBy = "usuario_endereco_id", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "prestador_endereco_id", fetch = FetchType.LAZY)
    private List<Prestador> prestadores;

}
