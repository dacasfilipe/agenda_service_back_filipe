package com.agenda_service_back.servico;

import com.agenda_service_back.categoria.Categoria;
import com.agenda_service_back.categoria.CategoriaDTO;
import com.agenda_service_back.categoria.CategoriaMapper;
import com.agenda_service_back.prestador.Prestador;
import com.agenda_service_back.prestador.PrestadorDTO;
import com.agenda_service_back.prestador.PrestadorMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ServicoMapper {

    ServicoMapper INSTANCE = Mappers.getMapper(ServicoMapper.class);

    @Mappings({
            @Mapping(source = "servicoDTO.servicoCategoria", target = "servico.servico_categoria_id" ),  // Use CategoriaMapper for conversion
            @Mapping(source = "servicoDTO.servicoPrestador", target = "servico.servico_prestador_id")  // Use PrestadorMapper for conversion
    })
    Servico toEntity(ServicoDTO servicoDTO);

    @Mappings({
            @Mapping(source = "servico.servico_categoria_id", target = "servicoDTO.servicoCategoria"),  // Use CategoriaMapper for conversion
            @Mapping(source = "servico.servico_prestador_id", target = "servicoDTO.servicoPrestador")  // Use PrestadorMapper for conversion
    })
    ServicoDTO toDTO(Servico servico);

    List<ServicoDTO> toDTOList(List<Servico> servicos);

    // Add mappings for specific use cases if needed (e.g., by category ID, by prestador ID)
}
