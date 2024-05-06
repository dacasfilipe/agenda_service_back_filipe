package com.agenda_service_back.endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
    @Query("SELECT e FROM Endereco e WHERE e.endereco_rua LIKE CONCAT('%', :rua, '%')")
    List<Endereco> findByRua(@Param("rua") String rua);

    @Query("SELECT e FROM Endereco e WHERE e.endereco_cep = :cep")
    List<Endereco> findByCep(@Param("cep") String cep);
}
