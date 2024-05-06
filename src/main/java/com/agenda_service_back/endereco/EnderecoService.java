package com.agenda_service_back.endereco;

import com.agenda_service_back.categoria.Categoria;
import com.agenda_service_back.categoria.CategoriaDTO;
import com.agenda_service_back.endereco.EnderecoDTO;
import com.agenda_service_back.endereco.EnderecoMapper;
import com.agenda_service_back.endereco.exceptions.CepNaoEncontradoException;
import com.agenda_service_back.endereco.exceptions.EnderecoNotFoundException;
import com.agenda_service_back.endereco.exceptions.RuaNaoEncontradoException;
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
        if (enderecos.isEmpty()) {
            throw new RuaNaoEncontradoException("Rua não encontrada: " + rua);
        }
        return enderecoMapper.toDTOList(enderecos);
    }

    public List<EnderecoDTO> buscarEnderecosPorCep(String cep) {
        List<Endereco> enderecos = enderecoRepository.findByCep(cep);
        if (enderecos.isEmpty()) {
            throw new CepNaoEncontradoException("CEP não encontrado: " + cep);
        }
        return enderecoMapper.toDTOList(enderecos);
    }

    public EnderecoDTO update(Long id,EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Endereco não encontrado"));
        if (endereco == null) {
            throw new EnderecoNotFoundException(id);
        }
        enderecoDTO.setEndereco_id(endereco.getEndereco_id());
        endereco = enderecoMapper.updateEntity(enderecoDTO, endereco);
        enderecoRepository.save(endereco);

        return enderecoMapper.toDTO(endereco);
        }

}
