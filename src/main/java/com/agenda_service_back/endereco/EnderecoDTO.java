package com.agenda_service_back.endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    private Long enderecoId;
    private String enderecoRua;
    private String enderecoCep;
    private int enderecoNumero;
    private String enderecoComplemento;
    private String enderecoCidade;
    private String enderecoEstado;
    private String enderecoBairro;

    // Excluding related entities (usuarios and prestadores) from DTO for security and performance reasons
    // You can include them if necessary, but consider privacy implications and lazy loading for large collections
}

