package com.esp.modalidad.repository;

import com.esp.jornada.entity.Jornada;
import com.esp.modalidad.entity.Modalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("modalidad_modalidadRepositorio")
public interface ModalidadRepository extends JpaRepository<Modalidad, Integer> {
    Optional<Modalidad> findByNombreModalidadIgnoreCase(String nombre);
    boolean existsByNombreModalidadIgnoreCase(String nombre);
}
