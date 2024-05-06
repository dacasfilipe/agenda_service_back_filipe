package com.agenda_service_back.telefone;

import com.agenda_service_back.telefone.TelefoneDTO;
import com.agenda_service_back.telefone.TelefoneMapper;
import com.agenda_service_back.telefone.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private TelefoneMapper telefoneMapper;

    @PostMapping
    public ResponseEntity<TelefoneDTO> salvarTelefone(@Valid @RequestBody TelefoneDTO telefoneDTO) {
        TelefoneDTO salvoTelefoneDTO = telefoneMapper.toDTO(telefoneService.salvarTelefone(telefoneMapper.toEntity(telefoneDTO)));
        return new ResponseEntity<>(salvoTelefoneDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> buscarTelefonePorId(@PathVariable Long id) {
        TelefoneDTO telefoneDTO = telefoneMapper.toDTO(telefoneService.buscarTelefonePorId(id));
        return new ResponseEntity<>(telefoneDTO, HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<TelefoneDTO>> buscarTelefonesPorUsuarioId(@PathVariable Long usuarioId) {
        List<TelefoneDTO> telefonesDTO = telefoneMapper.toDTOList(telefoneService.buscarTelefonesPorUsuarioId(usuarioId));
        return new ResponseEntity<>(telefonesDTO, HttpStatus.OK);
    }

    @GetMapping("/prestador/{prestadorId}")
    public ResponseEntity<List<TelefoneDTO>> buscarTelefonesPorPrestadorId(@PathVariable Long prestadorId) {
        List<TelefoneDTO> telefonesDTO = telefoneMapper.toDTOList(telefoneService.buscarTelefonesPorPrestadorId(prestadorId));
        return new ResponseEntity<>(telefonesDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDTO> atualizarTelefone(@PathVariable Long id, @Valid @RequestBody TelefoneDTO telefoneDTO) {
        TelefoneDTO atualizadoTelefoneDTO = telefoneMapper.toDTO(telefoneService.atualizarTelefone(id, telefoneMapper.toEntity(telefoneDTO)));
        return new ResponseEntity<>(atualizadoTelefoneDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirTelefonePorId(@PathVariable Long id) {
        telefoneService.excluirTelefonePorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

