package com.agenda_service_back.prestador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

    @Query("SELECT p FROM Prestador p WHERE p.prestadorCpf = ?1")
    Prestador findByPrestadorCpf(String cpf);

    @Query("SELECT p FROM Prestador p WHERE p.prestadorCnpj = ?1")
    Prestador findByPrestadorCnpj(String cnpj);

    @Query("SELECT p FROM Prestador p WHERE p.prestadorEmail = ?1")
    Prestador findByPrestadorEmail(String email);

    @Query("SELECT p FROM Prestador p WHERE p.prestadorNome LIKE ?1%")
    List<Prestador> findByPrestadorNomeContaining(String nome);
}

