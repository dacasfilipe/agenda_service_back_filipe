package com.agenda_service_back.prestador;

import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.endereco.EnderecoMapper;
import com.agenda_service_back.servico.ServicoDTO;
import com.agenda_service_back.servico.ServicoMapper;
import com.agenda_service_back.telefone.TelefoneDTO;
import com.agenda_service_back.telefone.TelefoneMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PrestadorMapper {

    PrestadorMapper INSTANCE = Mappers.getMapper(PrestadorMapper.class);

    @Mappings({
            @Mapping(source = "prestadorDTO.prestadorEndereco", target = "prestador.endereco"),  // Map EnderecoDTO to Endereco
            @Mapping(source = "prestadorDTO.servicos", target = "prestador.servicos"),
            @Mapping(source = "prestadorDTO.telefones", target = "prestador.telefones")
    })
    Prestador toEntity(PrestadorDTO prestadorDTO);

    @Mappings({
            @Mapping(source = "prestador.endereco", target = "prestadorDTO.prestadorEndereco", using = EnderecoMapper.class),  // Use EnderecoMapper for conversion
            @Mapping(source = "prestador.servicos", target = "prestadorDTO.servicos"),
            @Mapping(source = "prestador.telefones", target = "prestadorDTO.telefones")
    })
    PrestadorDTO toDTO(Prestador prestador);

    List<PrestadorDTO> toDTOList(List<Prestador> prestadores);
}
