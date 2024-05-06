package com.agenda_service_back.prestador;

import com.agenda_service_back.usuario.UsuarioService; // Import if needed for authorization
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestadores")
public class PrestadorController {

    @Autowired
    private PrestadorService prestadorService;

    @Autowired
    private UsuarioService usuarioService; // Inject if needed for authorization

    @PostMapping
    public ResponseEntity<PrestadorDTO> salvarPrestador(@Valid @RequestBody PrestadorDTO prestadorDTO) {
        PrestadorDTO salvoPrestadorDTO = prestadorService.salvarPrestador(prestadorDTO);
        return new ResponseEntity<>(salvoPrestadorDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{prestadorId}")
    public ResponseEntity<PrestadorDTO> buscarPrestadorPorId(@PathVariable Long prestadorId) {
        PrestadorDTO prestadorDTO = prestadorService.buscarPrestadorPorId(prestadorId);
        return new ResponseEntity<>(prestadorDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PrestadorDTO>> buscarTodosPrestadores() {
        List<PrestadorDTO> prestadoresDTO = prestadorService.buscarTodosPrestadores();
        return new ResponseEntity<>(prestadoresDTO, HttpStatus.OK);
    }

    @PutMapping("/{prestadorId}")
    public ResponseEntity<PrestadorDTO> atualizarPrestador(@PathVariable Long prestadorId,
                                                           @Valid @RequestBody PrestadorDTO prestadorDTO) {
        PrestadorDTO atualizadoPrestadorDTO = prestadorService.atualizarPrestador(prestadorId, prestadorDTO);
        return new ResponseEntity<>(atualizadoPrestadorDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{prestadorId}")
    public ResponseEntity<?> excluirPrestadorPorId(@PathVariable Long prestadorId) {
        prestadorService.excluirPrestadorPorId(prestadorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Add additional methods for searching by specific criteria (e.g., by name, CPF, CNPJ)
    // ...
}

