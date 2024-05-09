package com.agenda_service_back.prestador;

import com.agenda_service_back.prestador.Prestador;
import com.agenda_service_back.prestador.PrestadorDTO;

public class PrestadorConverter {
    public static PrestadorDTO toDTO(Prestador prestador) {
        PrestadorDTO dto = new PrestadorDTO();
        dto.setPrestadorId(prestador.getPrestador_id());
        dto.setPrestadorNome(prestador.getPrestador_nome());
        dto.setPrestadorCpf(prestador.getPrestador_cpf());
        dto.setPrestadorCnpj(prestador.getPrestador_cnpj());
        dto.setPrestadorEmail(prestador.getPrestador_email());
        dto.setPrestadorSenha(prestador.getPrestador_senha());
        dto.setPrestadorRazaoSocial(prestador.getPrestador_razao_social());
        dto.setPrestadorEndereco(prestador.getEndereco());

        return dto;
    }

    public static Prestador toEntity(PrestadorDTO prestadorDTO) {
        Prestador prestador = new Prestador();
        prestador.setId(PrestadorDTO.getId());
        prestador.setNome(PrestadorDTO.getNome());
        // Add logic to convert related DTOs (e.g., ServicoDTO) to entities if needed
        return prestador;
    }
}
