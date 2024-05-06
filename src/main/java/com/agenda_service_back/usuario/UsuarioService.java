package com.agenda_service_back.usuario;

import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.endereco.EnderecoService;
import com.agenda_service_back.servico.ServicoService;
import com.agenda_service_back.telefone.TelefoneService;
import com.agenda_service_back.usuario.Usuario;
import com.agenda_service_back.usuario.UsuarioDTO;
import com.agenda_service_back.usuario.UsuarioMapper;
import com.agenda_service_back.usuario.UsuarioRepository;
import com.agenda_service_back.usuario.exceptions.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Transactional
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Endereco endereco = enderecoService.salvarEndereco(usuarioDTO.getUsuarioEndereco());
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setUsuarioEndereco(endereco);
        usuario = usuarioRepository.save(usuario);

        telefoneService.salvarTelefones(usuarioDTO.getTelefones(), usuario);

        return usuarioMapper.toDTO(usuario);
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @Transactional
    public void excluirUsuarioPorId(Long id) {
        Usuario usuario = buscarUsuarioPorId(id);

    }
}