package com.agenda_service_back.categoria;

//import com.agenda_service_back.servico.ServicoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long categoria_id;
    private String categoria_nome;
    private String categoria_descricao;
   // private List<ServicoDTO> servicos;

}

