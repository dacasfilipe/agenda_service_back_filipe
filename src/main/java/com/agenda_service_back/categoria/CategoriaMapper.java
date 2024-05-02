package com.agenda_service_back.categoria;

import com.agenda_service_back.categoria.CategoriaDTO;
import com.agenda_service_back.categoria.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(source = "categoria_id", target = "categoria_id")
    CategoriaDTO toDTO(Categoria categoria);

    List<CategoriaDTO> toDTO(List<Categoria> categorias);

    @Mapping(source = "categoriaDTO.categoria_id", target = "categoria_id")
    Categoria toEntity(CategoriaDTO categoriaDTO);

    @Mappings({
            @Mapping(source = "categoriaDTO.categoria_id", target = "categoria_id"),
            @Mapping(source = "categoriaDTO.categoria_nome", target = "categoria_nome"),
            @Mapping(source = "categoriaDTO.categoria_descricao", target = "categoria_descricao")
    })
    Categoria updateEntity(CategoriaDTO categoriaDTO, Categoria categoria);
}

