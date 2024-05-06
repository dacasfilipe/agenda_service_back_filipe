package com.agenda_service_back.servico;

import com.agenda_service_back.categoria.CategoriaDTO;
import com.agenda_service_back.prestador.PrestadorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data // -Getters -Setters Hash Equals toString
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long servicoId;
    private String servicoNome;
    private String servicoDescricao;
    private String servicoInformacoesExtras;
    @JsonIgnore
    private CategoriaDTO servicoCategoria;
    @JsonIgnore
    private PrestadorDTO servicoPrestador;

    // No need to include the 'agendamentos' list here as it's likely for internal use
    // within the service layer. Consider DTOs for 'Agendamento' if needed for data transfer.
}

