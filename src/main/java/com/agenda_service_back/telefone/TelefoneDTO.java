package com.agenda_service_back.telefone;

import com.agenda_service_back.usuario.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long telefoneId;

    private String numero;

    @JsonIgnore
    private Long usuarioId;

    @JsonIgnore
    private Long prestadorId;

    @JsonProperty("usuario")
    private UsuarioDTO usuario;

    @JsonProperty("prestador")
    private PrestadorDTO prestador;


}

