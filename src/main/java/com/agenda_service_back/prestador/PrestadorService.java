package com.agenda_service_back.prestador;

import com.agenda_service_back.endereco.Endereco;
import com.agenda_service_back.endereco.EnderecoService;
import com.agenda_service_back.servico.Servico;
import com.agenda_service_back.servico.ServicoService;
import com.agenda_service_back.telefone.Telefone;
import com.agenda_service_back.telefone.TelefoneDTO;
import com.agenda_service_back.telefone.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Prestador salvarPrestador(PrestadorDTO prestadorDTO) {
        Prestador prestador = prestadorMapper.toEntity(prestadorDTO);

        // Salvar endereço (se existir)
        Endereco endereco = prestadorDTO.getEndereco();
        if (endereco != null) {
            endereco = enderecoService.salvarEndereco(endereco);
            prestador.setPrestadorEnderecoId(endereco);
        }

        // Salvar telefones (se existirem)
        List<TelefoneDTO> telefoneDTOs = prestadorDTO.getTelefones();
        if (telefoneDTOs != null && !telefoneDTOs.isEmpty()) {
            List<Telefone> telefones = telefoneService.salvarTelefones(telefoneDTOs, prestador);
            prestador.setTelefones(telefones);
        }

        // Salvar serviços (se existirem)
        List<ServicoDTO> servicoDTOs = prestadorDTO.getServicos();
        if (servicoDTOs != null && !servicoDTOs.isEmpty()) {
            List<Servico> servicos = servicoService.salvarServicos(servicoDTOs, prestador);
            prestador.setServicos(servicos);
        }

        return prestadorRepository.save(prestador);
    }

    public PrestadorDTO buscarPrestadorPorId(Long prestadorId) {
        Prestador prestador = prestadorRepository.findById(prestadorId).orElseThrow(() -> new PrestadorNotFoundException(prestadorId));
        return prestadorMapper.toDTO(prestador);
    }

    public List<PrestadorDTO> buscarTodosPrestadores() {
        List<Prestador> prestadores = prestadorRepository.findAll();
        return prestadorMapper.toDTOList(prestadores);
    }

    @Transactional
    public Prestador atualizarPrestador(Long prestadorId, PrestadorDTO prestadorDTO) {
        Prestador prestador = buscarPrestadorPorId(prestadorId);

        // Update properties from DTO (excluding ID, servicos, telefones)
        prestador.setPrestadorNome(prestadorDTO.getPrestadorNome());
        prestador.setPrestadorCpf(prestadorDTO.getPrestadorCpf());
        prestador.setPrestadorCnpj(prestadorDTO.getPrestadorCnpj());
        prestador.setPrestadorEmail(prestadorDTO.getPrestadorEmail());
        prestador.setPrestadorSenha(prestadorDTO.getPrestadorSenha()); // Consider security implications
        prestador.setPrestadorRazaoSocial(prestadorDTO.getPrestadorRazaoSocial());

        // Update Endereco (if provided)
        Endereco endereco = prestadorDTO.getEndereco();
        if (endereco != null) {
            enderecoService.atualizarEndereco(prestador.getPrestadorEnderecoId().getEnderecoId(), endereco);
        }

        // Update Telefones (if provided)
        List<TelefoneDTO> telefoneDTOs = prestadorDTO.getTelefones();
        if (telefoneDTOs != null && !telefoneDTOs.isEmpty()) {
            telefoneService.excluirTelefonesPorPrestadorId(prestador.getPrestadorId());
            List<Telefone> telefones = telefoneService.salvarTelefones(telefoneDTOs, prestador);
            prestador.setTelefones(telefones);
        }

        // Update Servicos (if provided)
        List<ServicoDTO> servicoDTOs = prestadorDTO.getServicos();
        if (servicoDTOs != null && !servicoDTOs.isEmpty()) {
            servicoService.excluirServicosPorPrestadorId(prestador.getPrestadorId());
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

