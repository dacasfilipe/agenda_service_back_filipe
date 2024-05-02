package com.agenda_service_back.agendamento;

import com.agenda_service_back.servico.Servico;
import com.agenda_service_back.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento createAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    public Optional<Agendamento> findById(Long agendamentoId) {
        return agendamentoRepository.findById(agendamentoId);
    }

    public Iterable<Agendamento> findAll() {
        return agendamentoRepository.findAll();
    }

    public Iterable<Agendamento> findByUsuarioId(Long usuarioId) {
        return agendamentoRepository.findByUsuarioId(usuarioId);
    }

    public Iterable<Agendamento> findByServicoId(Long servicoId) {
        return agendamentoRepository.findByServicoId(servicoId);
    }

//    public Iterable<Agendamento> findByDataHoraUsuario(LocalDate data, LocalTime hora, Usuario usuario) {
//        // Since findByDataHoraUsuario is already defined in AgendamentoRepository,
//        // we can directly call it here.
//        return agendamentoRepository.findByDataHoraUsuario(data, hora, usuario);
//    }
//
//    public Iterable<Agendamento> findByServicoData(Servico servico, LocalDate dataInicial, LocalDate dataFinal) {
//        // Similar to findByDataHoraUsuario
//        return agendamentoRepository.findByServicoData(servico, dataInicial, dataFinal);
//    }

    public void deleteAgendamento(Long agendamentoId) {
        agendamentoRepository.deleteById(agendamentoId);
    }
}
