package com.esp.usuario.repository;

import com.esp.usuario.entity.Imagen;
import com.esp.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("usuario_ImagenRepository")
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {


    Optional<Imagen> getImagenByIdUsuario(Usuario u);
}
