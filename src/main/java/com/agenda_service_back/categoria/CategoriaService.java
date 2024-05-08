package com.agenda_service_back.categoria;

import com.agenda_service_back.categoria.CategoriaDTO;
import com.agenda_service_back.categoria.Categoria;
import com.agenda_service_back.categoria.CategoriaMapper;
import com.agenda_service_back.categoria.CategoriaRepository;
import com.agenda_service_back.categoria.exceptions.CategoriaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Categoria buscarCategoriaPorId(Long categoriaId) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoriaId);
        if (categoriaOptional.isPresent()) {
            return categoriaOptional.get();
        } else {
            throw new CategoriaNaoEncontradaException("Categoria com ID " + categoriaId + " não encontrada.");
        }
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
        categoriaDTO.setCategoria_id(categoria.getCategoria_id());
        categoria = categoriaMapper.updateEntity(categoriaDTO, categoria);
        categoriaRepository.save(categoria);

        return categoriaMapper.toDTO(categoria);
    }
    //deletando uma categoria por id
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}

