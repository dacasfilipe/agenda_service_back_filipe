package com.agenda_service_back.prestador;

import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.endereco.EnderecoDTO;
import com.agenda_service_back.endereco.EnderecoMapper;
import com.agenda_service_back.endereco.EnderecoService;
import com.agenda_service_back.servico.Servico;
import com.agenda_service_back.servico.ServicoDTO;
import com.agenda_service_back.servico.ServicoService;
import com.agenda_service_back.telefone.Telefone;
import com.agenda_service_back.telefone.TelefoneDTO;
import com.agenda_service_back.telefone.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.agenda_service_back.prestador.exceptions.PrestadorNotFoundException;

import java.util.List;

@Service
public class PrestadorService {

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private PrestadorMapper prestadorMapper;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Transactional
    public Prestador salvarPrestador(PrestadorDTO prestadorDTO) {
        Prestador prestador = prestadorMapper.toEntity(prestadorDTO);

//        // Salvar endereço (se existir)
//        EnderecoDTO enderecoDTO = prestadorDTO.getPrestadorEndereco();
//        if (enderecoDTO != null) {
//            Endereco endereco = enderecoMapper.toEntity(enderecoDTO); // Convert enderecoDTO to entity
//            endereco = enderecoService.salvarEnderecoEntity(endereco); // Save the endereco entity
//            prestador.setEndereco(endereco); // Set the relationship
//        }

//        // Salvar telefones (se existirem)
//        List<TelefoneDTO> telefoneDTOs = prestadorDTO.getTelefones();
//        if (telefoneDTOs != null && !telefoneDTOs.isEmpty()) {
//            List<Telefone> telefones = telefoneService.salvarTelefones(telefoneDTOs, prestador);
//            prestador.setTelefones(telefones);
//        }

        // Salvar serviços (se existirem)
//        List<ServicoDTO> servicoDTOs = prestadorDTO.getServicos();
//        if (servicoDTOs != null && !servicoDTOs.isEmpty()) {
//            List<Servico> servicos = servicoService.salvarServicos(servicoDTOs, prestador);
//            prestador.setServicos(servicos);
//        }

        return prestadorRepository.save(prestador);
    }

    public Prestador buscarPrestadorPorId(Long prestadorId) {
        Prestador prestador = prestadorRepository.findById(prestadorId).orElseThrow(() -> new PrestadorNotFoundException(prestadorId));
        return prestador;
    }

    public List<PrestadorDTO> buscarTodosPrestadores() {
        List<Prestador> prestadores = prestadorRepository.findAll();
        return prestadorMapper.toDTOList(prestadores);
    }

    @Transactional
    public Prestador atualizarPrestador(Long prestadorId, PrestadorDTO prestadorDTO) {
        Prestador prestador = buscarPrestadorPorId(prestadorId);

        // Update properties from DTO (excluding ID, servicos, telefones)
        prestador.setPrestador_nome(prestadorDTO.getPrestadorNome());
        prestador.setPrestador_cpf(prestadorDTO.getPrestadorCpf());
        prestador.setPrestador_cnpj(prestadorDTO.getPrestadorCnpj());
        prestador.setPrestador_email(prestadorDTO.getPrestadorEmail());
        prestador.setPrestador_senha(prestadorDTO.getPrestadorSenha()); // Consider security implications
        prestador.setPrestador_razao_social(prestadorDTO.getPrestadorRazaoSocial());

//        // Update Endereco (if provided)
//        Endereco endereco = prestadorDTO.getPrestadorEndereco();
//        if (endereco != null) {
//            enderecoService.atualizarEndereco(prestador.getPrestador_endereco_id().getEndereco_id(), endereco);
//        }

//        // Update Telefones (if provided)
//        List<TelefoneDTO> telefoneDTOs = prestadorDTO.getTelefones();
//        if (telefoneDTOs != null && !telefoneDTOs.isEmpty()) {
//            telefoneService.excluirTelefonesPorPrestadorId(prestador.getPrestador_id());
//            List<Telefone> telefones = telefoneService.salvarTelefones(telefoneDTOs, prestador);
//            prestador.setTelefones(telefones);
//        }

        // Update Servicos (if provided)
        List<ServicoDTO> servicoDTOs = prestadorDTO.getServicos();
        if (servicoDTOs != null && !servicoDTOs.isEmpty()) {
            servicoService.excluirServicosPorPrestadorId(prestador.getPrestador_id());
            List<Servico> servicos = servicoService.salvarServicos(servicoDTOs, prestador);
            prestador.setServicos(servicos);
        }

        return prestadorRepository.save(prestador);
    }

    public void excluirPrestadorPorId(Long prestadorId) {
        Prestador prestador = buscarPrestadorPorId(prestadorId);
        prestadorRepository.delete(prestador);
    }

    // Add additional methods for searching by specific criteria (e.g., by name, CPF, CNPJ)
}

