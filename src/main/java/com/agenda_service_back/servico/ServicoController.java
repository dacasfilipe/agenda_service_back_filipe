package com.agenda_service_back.servico;

import com.agenda_service_back.categoria.CategoriaService;
import com.agenda_service_back.prestador.PrestadorService;
import com.agenda_service_back.usuario.UsuarioService; // Import if needed for authorization
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private PrestadorService prestadorService;

    @Autowired
    private UsuarioService usuarioService; // Inject if needed for authorization

    @PostMapping
    public ResponseEntity<ServicoDTO> salvarServico(@Valid @RequestBody ServicoDTO servicoDTO) {
        Servico salvoServico = servicoService.salvarServico(servicoDTO);
        ServicoDTO salvoServicoDTO = ServicoMapper.INSTANCE.toDTO(salvoServico);
        return new ResponseEntity<>(salvoServicoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{servicoId}")
    public ResponseEntity<ServicoDTO> buscarServicoPorId(@PathVariable Long servicoId) {
        Servico servico = servicoService.buscarServicoPorId(servicoId);
        ServicoDTO servicoDTO = ServicoMapper.INSTANCE.toDTO(servico);
        return new ResponseEntity<>(servicoDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ServicoDTO>> buscarTodosServicos() {
        List<Servico> servicos = servicoService.buscarTodosServicos();
        List<ServicoDTO> servicosDTO = ServicoMapper.INSTANCE.toDTOList(servicos);
        return new ResponseEntity<>(servicosDTO, HttpStatus.OK);
    }

    @PutMapping("/{servicoId}")
    public ResponseEntity<ServicoDTO> atualizarServico(@PathVariable Long servicoId,
                                                       @Valid @RequestBody ServicoDTO servicoDTO) {
        Servico atualizadoServico = servicoService.atualizarServico(servicoId, servicoDTO);
        ServicoDTO atualizadoServicoDTO = ServicoMapper.INSTANCE.toDTO(atualizadoServico);
        return new ResponseEntity<>(atualizadoServicoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{servicoId}")
    public ResponseEntity<?> excluirServicoPorId(@PathVariable Long servicoId) {
        servicoService.excluirServicoPorId(servicoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Add additional methods for searching by specific criteria (e.g., by categoria, by prestador)
    // ...
}
