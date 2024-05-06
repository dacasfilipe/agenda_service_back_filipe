package com.agenda_service_back.usuario;

import com.agenda_service_back.endereco.EnderecoDTO;
import com.agenda_service_back.telefone.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long usuarioId;

    @org.hibernate.validator.constraints.br.CPF
    private String usuarioCpf;

    private String usuarioEmail;

    @JsonFormat(pattern = "dd/MM/YYYY")
    private LocalDate usuarioDataNascimento;

    private String usuarioSenha;

    // No password field in DTO for security reasons

    private EnderecoDTO usuarioEndereco;

    private List<TelefoneDTO> telefones;


}
