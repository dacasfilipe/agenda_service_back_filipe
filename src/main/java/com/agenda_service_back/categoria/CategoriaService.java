package com.agenda_service_back.categoria;

import com.agenda_service_back.categoria.CategoriaDTO;
import com.agenda_service_back.categoria.Categoria;
import com.agenda_service_back.categoria.CategoriaMapper;
import com.agenda_service_back.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

//    Buscando todas as Categorias.
    public List<CategoriaDTO> findAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toList());
    }
    // Buscando uma categoria por id
    public CategoriaDTO findById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        return categoriaMapper.toDTO(categoria);
    }
    //Criando uma nova Categoria
    public CategoriaDTO create(CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(categoria);
    }
    //atualizando uma categoria
    public CategoriaDTO update(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        categoriaMapper.updateEntity(categoriaDTO, categoria);
        categoria = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(categoria);
    }
    //deletando uma categoria por id
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}

