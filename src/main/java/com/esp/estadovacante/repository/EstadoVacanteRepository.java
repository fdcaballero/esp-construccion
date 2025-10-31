package com.esp.estadovacante.repository;

import com.esp.estadovacante.entity.EstadoVacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("estadovcante_EstadoVacanteRepositorio")
public interface EstadoVacanteRepository extends JpaRepository<EstadoVacante, Integer> {
    Optional<EstadoVacante> findByNombreEstadoVacanteIgnoreCase(String nombre);
}
