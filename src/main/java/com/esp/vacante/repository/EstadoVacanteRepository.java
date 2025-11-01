package com.esp.vacante.repository;

import com.esp.vacante.entity.EstadoVacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_EstadoVacanteRepository")
public interface EstadoVacanteRepository extends JpaRepository<EstadoVacante, Integer> {
}