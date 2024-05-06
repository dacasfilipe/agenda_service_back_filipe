package com.agenda_service_back.usuario;

import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.endereco.EnderecoDTO;
import com.agenda_service_back.endereco.EnderecoService;
import com.agenda_service_back.servico.ServicoService;
import com.agenda_service_back.telefone.Telefone;
import com.agenda_service_back.telefone.TelefoneDTO;
import com.agenda_service_back.telefone.TelefoneService;
import com.agenda_service_back.usuario.Usuario;
import com.agenda_service_back.usuario.UsuarioDTO;
import com.agenda_service_back.usuario.UsuarioMapper;
import com.agenda_service_back.usuario.UsuarioRepository;
import com.agenda_service_back.usuario.exceptions.UsuarioNotFoundException;
import com.agenda_service_back.usuario.exceptions.UsuarioNaoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Autowired
    private PasswordEncoder passwordEncoder;  // Inject PasswordEncoder bean

    @Transactional
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        EnderecoDTO enderecoDTO = enderecoService.salvarEndereco(usuarioDTO.getUsuarioEndereco());
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setUsuario_endereco_id(enderecoDTO.getEndereco_id());
        usuario = usuarioRepository.save(usuario);

        for (TelefoneDTO telefoneDTO : usuarioDTO.getTelefones()) {
            Telefone telefone = new Telefone();
            telefone.setNumero(telefoneDTO.getNumero());
            telefone.setTelefone_usuario_id(usuario);
            telefoneService.salvarTelefone(telefone);
        }

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
        // Implement logic for deleting related entities (e.g., telefones, servicos)
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public UsuarioDTO updateUsuario(Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuarioToUpdate = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário com ID " + id + " não encontrado."));

        // Update user fields from DTO (excluding sensitive fields like password)
        usuarioToUpdate.setUsuario_email(usuarioDTO.getUsuarioEmail());
        // ... Update other non-sensitive fields

        // Handle password update if provided (implement secure hashing)
        if (usuarioDTO.getUsuarioSenha() != null && !usuarioDTO.getUsuarioSenha().isEmpty()) {
            String hashedPassword = passwordEncoder.encode(usuarioDTO.getUsuarioSenha());
            usuarioToUpdate.setUsuario_senha(hashedPassword);
        }

        Usuario savedUsuario = usuarioRepository.save(usuarioToUpdate);
        return usuarioMapper.toDTO(savedUsuario);
    }
}
