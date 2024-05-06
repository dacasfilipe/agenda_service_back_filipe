package com.agenda_service_back.usuario;

import com.agenda_service_back.endereco.EnderecoService;
import com.agenda_service_back.servico.ServicoService;
import com.agenda_service_back.telefone.TelefoneService;
import com.agenda_service_back.usuario.UsuarioDTO;
import com.agenda_service_back.usuario.UsuarioMapper;
import com.agenda_service_back.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO salvoUsuarioDTO = usuarioService.salvarUsuario(usuarioDTO);
        return new ResponseEntity<>(salvoUsuarioDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> buscarTodosUsuarios() {
        List<UsuarioDTO> usuariosDTO = usuarioMapper.toDTOList(usuarioService.buscarTodosUsuarios());
        return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuarioService.buscarUsuarioPorId(id));
        return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuarioPorId(@PathVariable Long id) {
        usuarioService.excluirUsuarioPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO atualizadoUsuarioDTO = usuarioService.updateUsuario(id, usuarioDTO);
        return new ResponseEntity<>(atualizadoUsuarioDTO, HttpStatus.OK);
    }
}

