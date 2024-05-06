package com.agenda_service_back.telefone;

import com.agenda_service_back.telefone.Telefone;
import com.agenda_service_back.telefone.TelefoneDTO;
import com.agenda_service_back.telefone.TelefoneMapper;
import com.agenda_service_back.telefone.TelefoneRepository;
import com.agenda_service_back.telefone.exceptions.TelefoneNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private TelefoneMapper telefoneMapper;

    @Transactional
    public Telefone salvarTelefone(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    public Telefone buscarTelefonePorId(Long id) {
        return telefoneRepository.findById(id)
                .orElseThrow(() -> new TelefoneNotFoundException(id));
    }

    public List<Telefone> buscarTelefonesPorUsuarioId(Long usuarioId) {
        return telefoneRepository.findByTelefoneUsuarioId(usuarioId);
    }

    public List<Telefone> buscarTelefonesPorPrestadorId(Long prestadorId) {
        return telefoneRepository.findByTelefonePrestadorId(prestadorId);
    }

    @Transactional
    public Telefone atualizarTelefone(Long id, Telefone telefone) {
        telefone.setTelefone_id(id);
        return telefoneRepository.save(telefone);
    }

    @Transactional
    public void excluirTelefonePorId(Long id) {
        telefoneRepository.deleteById(id);
    }
}

