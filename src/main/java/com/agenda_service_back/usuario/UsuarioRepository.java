package com.agenda_service_back.usuario;

import com.agenda_service_back.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsuarioCpf(String cpf);

    Usuario findByUsuarioEmail(String email);

    List<Usuario> findByUsuarioEnderecoId(Endereco endereco);
}

