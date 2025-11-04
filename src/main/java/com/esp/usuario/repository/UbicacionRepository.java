package com.esp.usuario.repository;

import com.esp.usuario.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("usuario_UbicacionRepository")
public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {
}
