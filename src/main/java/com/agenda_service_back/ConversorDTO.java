//package com.agenda_service_back;
//
//import com.agenda_service_back.categoria.Categoria;
//import com.agenda_service_back.categoria.CategoriaDTO;
//
//public class ConversorDTO {
//
//    public static CategoriaDTO toDTO(Categoria categoria) {
//        CategoriaDTO dto = new CategoriaDTO();
//        dto.setId(categoria.getId());
//        dto.setNome(categoria.getNome());
//        // Add logic to convert related entities (e.g., Servico) to DTOs if needed
//        return dto;
//    }
//
//    public static Categoria toEntity(CategoriaDTO categoriaDTO) {
//        Categoria categoria = new Categoria();
//        categoria.setId(categoriaDTO.getId());
//        categoria.setNome(categoriaDTO.getNome());
//        // Add logic to convert related DTOs (e.g., ServicoDTO) to entities if needed
//        return categoria;
//    }
//}
