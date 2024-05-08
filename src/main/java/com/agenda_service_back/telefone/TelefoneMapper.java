package com.agenda_service_back.telefone;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface TelefoneMapper {

    TelefoneMapper INSTANCE = Mappers.getMapper(TelefoneMapper.class);

    @Mappings({
            @Mapping(source = "telefone.telefone_usuario_id", target = "telefoneDTO.usuarioId"),
            @Mapping(source = "telefone.telefone_prestador_id", target = "telefoneDTO.prestadorId")
    })
    TelefoneDTO toDTO(Telefone telefone);

    @Mappings({
            @Mapping(source = "telefoneDTO.usuarioId", target = "telefone.telefone_usuario_id"),
            @Mapping(source = "telefoneDTO.prestadorId", target = "telefone.telefone_prestador_id")
    })
    Telefone toEntity(TelefoneDTO telefoneDTO);

    List<TelefoneDTO> toDTOList(List<Telefone> telefones);

    // New methods for mapping based on user and prestador IDs

    @Mappings({
            @Mapping(source = "telefones", target = "telefoneDTOList", qualifiedByName = "telefoneToTelefoneDTO")
    })
    List<TelefoneDTO> toDTOListFromUsuario(List<Telefone> telefones);

    @Mappings({
            @Mapping(source = "telefones", target = "telefoneDTOList", qualifiedByName = "telefoneToTelefoneDTO")
    })
    List<TelefoneDTO> toDTOListFromPrestador(List<Telefone> telefones);

    @Mapping(source = "telefone", target = "telefoneDTO")
    TelefoneDTO telefoneToTelefoneDTO(Telefone telefone);
}

