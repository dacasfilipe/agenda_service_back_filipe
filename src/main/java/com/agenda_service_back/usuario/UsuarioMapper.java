package com.agenda_service_back.usuario;

import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.endereco.EnderecoDTO;
import com.agenda_service_back.endereco.EnderecoMapper;
import com.agenda_service_back.telefone.Telefone;
import com.agenda_service_back.telefone.TelefoneDTO;
import com.agenda_service_back.telefone.TelefoneMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(imports = {EnderecoMapper.class, TelefoneMapper.class})
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mappings({
            @Mapping(source = "usuarioDTO.usuarioEndereco", target = "usuario.usuario_endereco_id", qualifiedByName = "enderecoToEnderecoEntity"),
            @Mapping(source = "usuarioDTO.telefones", target = "usuario.telefone_usuario_id", qualifiedByName = "telefonesDTOToTelefonesEntity")
    })
    Usuario toEntity(UsuarioDTO usuarioDTO);

    @Mappings({
            @Mapping(source = "usuario.usuario_endereco_id", target = "usuarioDTO.usuarioEndereco", qualifiedByName = "enderecoEntityToEnderecoDTO"),
            @Mapping(source = "usuario.telefone_usuario_id", target = "usuarioDTO.telefones", qualifiedByName = "telefonesEntityToTelefonesDTO")
    })
    UsuarioDTO toDTO(Usuario usuario);

    @Mapping(source = "endereco", target = "enderecoDTO")
    EnderecoDTO enderecoToEnderecoDTO(Endereco endereco);

    @Mapping(source = "enderecoDTO", target = "endereco")
    Endereco enderecoDTOToEnderecoEntity(EnderecoDTO enderecoDTO);

    @Mapping(source = "telefone", target = "telefoneDTO")
    TelefoneDTO telefoneEntityToTelefoneDTO(Telefone telefone);

    @Mapping(source = "telefoneDTO", target = "telefone")
    Telefone telefoneDTOToTelefoneEntity(TelefoneDTO telefoneDTO);

    List<UsuarioDTO> toDTOList(List<Usuario> usuarios);
}
