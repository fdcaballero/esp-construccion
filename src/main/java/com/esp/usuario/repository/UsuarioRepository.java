package com.esp.usuario.repository;

import com.esp.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("usuario_UsuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByDocumentoUsuario(String documento);
}
