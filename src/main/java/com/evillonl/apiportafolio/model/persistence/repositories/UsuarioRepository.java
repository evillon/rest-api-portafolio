package com.evillonl.apiportafolio.model.persistence.repositories;

import com.evillonl.apiportafolio.model.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuario(String usuario);

    List<Usuario> findAllByEstado(Integer estado);

}
