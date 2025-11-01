package com.esp.vacante.repository;

import com.esp.vacante.entity.HistorialEstadoVacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_HistorialEstadoVacanteRepository")
public interface HistorialEstadoVacanteRepository extends JpaRepository<HistorialEstadoVacante, Integer> {
}