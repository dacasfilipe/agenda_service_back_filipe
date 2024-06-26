package com.agenda_service_back.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long endereco_id;
    private String endereco_rua;
    private String endereco_cep;
    private int endereco_numero;
    private String endereco_complemento;
    private String endereco_cidade;
    private String endereco_estado;
    private String endereco_bairro;

    private EnderecoDTO prestadorEndereco;

    private EnderecoDTO usuarioEndereco;

    // Getters and setters are automatically generated by Lombok
}
