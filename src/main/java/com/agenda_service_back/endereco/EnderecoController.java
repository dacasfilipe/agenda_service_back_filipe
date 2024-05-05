package com.agenda_service_back.endereco;

import com.agenda_service_back.endereco.EnderecoDTO;
import com.agenda_service_back.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoDTO> salvarEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO salvoEnderecoDTO = enderecoService.salvarEndereco(enderecoDTO);
        return new ResponseEntity<>(salvoEnderecoDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> buscarTodosEnderecos() {
        List<EnderecoDTO> enderecosDTO = enderecoService.buscarTodosEnderecos();
        return new ResponseEntity<>(enderecosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable Long id) {
        EnderecoDTO enderecoDTO = enderecoService.buscarEnderecoPorId(id);
        return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirEnderecoPorId(@PathVariable Long id) {
        enderecoService.excluirEnderecoPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/rua/{rua}")
    public ResponseEntity<List<EnderecoDTO>> buscarEnderecosPorRua(@PathVariable String rua) {
        List<EnderecoDTO> enderecosDTO = enderecoService.buscarEnderecosPorRua(rua);
        return new ResponseEntity<>(enderecosDTO, HttpStatus.OK);
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<List<EnderecoDTO>> buscarEnderecosPorCep(@PathVariable String cep) {
        List<EnderecoDTO> enderecosDTO = enderecoService.buscarEnderecosPorCep(cep);
        return new ResponseEntity<>(enderecosDTO, HttpStatus.OK);
    }
}
