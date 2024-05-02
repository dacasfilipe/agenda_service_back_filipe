package com.agenda_service_back.agendamento;

import com.agenda_service_back.servico.Servico;
import com.agenda_service_back.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired // Spring will inject the mapper instance
    private AgendamentoMapper agendamentoMapper;

    @PostMapping
    public ResponseEntity<Agendamento> createAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento createdAgendamento = agendamentoService.createAgendamento(agendamento);
        return new ResponseEntity<>(createdAgendamento, HttpStatus.CREATED);
    }

    @GetMapping("/{agendamentoId}")
    public ResponseEntity<AgendamentoDTO> findById(@PathVariable Long agendamentoId) {
        Optional<Agendamento> optionalAgendamento = agendamentoService.findById(agendamentoId);
        if (optionalAgendamento.isPresent()) {
            // Convert to DTO for response (assuming you have a DTO class)
            AgendamentoDTO agendamentoDTO = agendamentoMapper.toAgendamentoDTO(optionalAgendamento.get());
            return new ResponseEntity<>(agendamentoDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<AgendamentoDTO>> findAll() {
        Iterable<Agendamento> agendamentos = agendamentoService.findAll();

        // Convert all Agendamento entities to DTOs before returning
        Iterable<AgendamentoDTO> agendamentoDTOs =  // Create an empty list to hold DTOs
                StreamSupport.stream(agendamentos.spliterator(), false)
                        .map(agendamentoMapper::toAgendamentoDTO)
                        .toList();

        return new ResponseEntity<>(agendamentoDTOs, HttpStatus.OK);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Iterable<AgendamentoDTO>> findByUsuarioId(@PathVariable Long usuarioId) {
        // Corrected line
        Iterable<Agendamento> agendamentos = agendamentoService.findByUsuarioId(usuarioId);
        if (agendamentos == null) {  // Optional error handling
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Convert all Agendamento entities to DTOs before returning
        Iterable<AgendamentoDTO> agendamentoDTOs =  // Create an empty list to hold DTOs
                StreamSupport.stream(agendamentos.spliterator(), false)
                        .map(agendamentoMapper::toAgendamentoDTO)
                        .toList();

        return new ResponseEntity<>(agendamentoDTOs, HttpStatus.OK);
    }

}

