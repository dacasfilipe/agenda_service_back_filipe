package com.agenda_service_back.agendamento;

import com.agenda_service_back.servico.Servico;
import com.agenda_service_back.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

//    findByDataHoraUsuario: Esta consulta toma como parâmetros data, hora e usuário
//    e retorna um Opcional contendo o objeto Agendamento correspondente, caso
//    encontrado.
    @Query("SELECT a FROM Agendamento a WHERE a.agendamento_data = :data AND a.agendamento_hora = :hora AND a.usuario = :usuario")
    Optional<Agendamento> findByDataHoraUsuario(LocalDate data, LocalTime hora, Usuario usuario);

//    findByServicoData: Esta consulta toma como parâmetros o objeto serviço,
//    data de início e data de término e retorna um Iterable de objetos Agendamento
//    que estão associados ao serviço fornecido e programados entre a data de início
//    e término.
    @Query("SELECT a FROM Agendamento a WHERE a.servico = :servico AND a.agendamento_data >= :dataInicial AND a.agendamento_data <= :dataFinal")
    Iterable<Agendamento> findByServicoData(Servico servico, LocalDate dataInicial, LocalDate dataFinal);

}

