package com.agenda_service_back.prestador;

import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.endereco.EnderecoDTO;
import com.agenda_service_back.servico.ServicoDTO;
import com.agenda_service_back.telefone.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long prestadorId;

    private String prestadorNome;

    private String prestadorCpf;

    private String prestadorCnpj;

    private String prestadorEmail;

    private String prestadorSenha; // Consider security implications of including password in DTO

    private String prestadorRazaoSocial;

    private EnderecoDTO prestadorEndereco;
    @JsonIgnore
    private List<ServicoDTO> servicos;
    @JsonIgnore
    private List<TelefoneDTO> telefones;



}

