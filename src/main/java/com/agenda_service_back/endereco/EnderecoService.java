package com.agenda_service_back.endereco;

import com.agenda_service_back.endereco.EnderecoDTO;
import com.agenda_service_back.endereco.EnderecoMapper;
import com.agenda_service_back.endereco.exceptions.EnderecoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Transactional
    public EnderecoDTO salvarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }

    public List<EnderecoDTO> buscarTodosEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecoMapper.toDTOList(enderecos);
    }

    public EnderecoDTO buscarEnderecoPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new EnderecoNotFoundException(id));
        return enderecoMapper.toDTO(endereco);
    }

    @Transactional
    public void excluirEnderecoPorId(Long id) {
        enderecoRepository.deleteById(id);
    }

    public List<EnderecoDTO> buscarEnderecosPorRua(String rua) {
        List<Endereco> enderecos = enderecoRepository.findByRua(rua);
        return enderecoMapper.toDTOList(enderecos);
    }

    public List<EnderecoDTO> buscarEnderecosPorCep(String cep) {
        List<Endereco> enderecos = enderecoRepository.findByCep(cep);
        return enderecoMapper.toDTOList(enderecos);
    }
}
