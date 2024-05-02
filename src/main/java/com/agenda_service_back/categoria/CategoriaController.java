package com.agenda_service_back.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias() {
        List<CategoriaDTO> categoriasDTO = categoriaService.findAll();
        return ResponseEntity.ok(categoriasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Long id) {
        CategoriaDTO categoriaDTO = categoriaService.findById(id);
        return ResponseEntity.ok(categoriaDTO);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO createdCategoriaDTO = categoriaService.create(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoriaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Long id, @Valid @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO updatedCategoriaDTO = categoriaService.update(id, categoriaDTO);
        return ResponseEntity.ok(updatedCategoriaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

