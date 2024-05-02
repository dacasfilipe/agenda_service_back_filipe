package com.agenda_service_back.agendamento;

import com.agenda_service_back.servico.Servico;
import com.agenda_service_back.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Existing methods from your previous response (assuming they work correctly):

//    @Query("SELECT a FROM Agendamento a WHERE a.agendamento_data = :data AND a.agendamento_hora = :hora AND a.usuario = :usuario")
//    Optional<Agendamento> findByDataHoraUsuario(LocalDate data, LocalTime hora, Usuario usuario);

//    @Query("SELECT a FROM Agendamento a WHERE a.servico = :servico AND a.agendamento_data >= :dataInicial AND a.agendamento_data <= :dataFinal")
//    Iterable<Agendamento> findByServicoData(Servico servico, LocalDate dataInicial, LocalDate dataFinal);

    // Additional methods (optional):

    @Query("SELECT a FROM Agendamento a WHERE a.agendamento_usuario_id = :usuarioId")
    Iterable<Agendamento> findByUsuarioId(Long usuarioId);

    @Query("SELECT a FROM Agendamento a WHERE a.agendamento_servico_id = :servicoId")
    Iterable<Agendamento> findByServicoId(Long servicoId);
}


