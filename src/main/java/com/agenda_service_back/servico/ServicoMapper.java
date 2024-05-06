package com.agenda_service_back.servico;

import com.agenda_service_back.categoria.CategoriaMapper;
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
            @Mapping(source = "servicoDTO.servicoCategoria", target = "servico.servicoCategoriaId"),
            @Mapping(source = "servicoDTO.servicoPrestador", target = "servico.servicoPrestadorId")
    })
    Servico toEntity(ServicoDTO servicoDTO);

    @Mappings({
            @Mapping(source = "servico.servicoCategoriaId.categoriaId", target = "servicoDTO.servicoCategoria.categoriaId"),
            @Mapping(source = "servico.servicoCategoriaId.categoriaNome", target = "servicoDTO.servicoCategoria.categoriaNome"),
            @Mapping(source = "servico.servicoPrestadorId.prestadorId", target = "servicoDTO.servicoPrestador.prestadorId"),
            @Mapping(source = "servico.servicoPrestadorId.prestadorNome", target = "servicoDTO.servicoPrestador.prestadorNome")
    })
    ServicoDTO toDTO(Servico servico);

    List<ServicoDTO> toDTOList(List<Servico> servicos);

    // Add mappings for specific use cases if needed (e.g., by category ID, by prestador ID)
}

