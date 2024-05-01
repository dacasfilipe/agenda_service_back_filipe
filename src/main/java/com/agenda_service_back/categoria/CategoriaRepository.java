package com.agenda_service_back.categoria;

import com.agenda_service_back.servico.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // No additional custom queries are defined by default for Categoria

}

