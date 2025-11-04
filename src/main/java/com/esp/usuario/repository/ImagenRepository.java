package com.esp.usuario.repository;

import com.esp.usuario.entity.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usuario_ImagenRepository")
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
}
