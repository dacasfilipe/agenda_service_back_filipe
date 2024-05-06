package com.agenda_service_back.telefone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    List<Telefone> findByTelefoneUsuarioId(Long usuarioId);

    List<Telefone> findByTelefonePrestadorId(Long prestadorId);
}

