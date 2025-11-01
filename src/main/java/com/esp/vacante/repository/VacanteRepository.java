package com.esp.vacante.repository;

import com.esp.vacante.entity.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_VacanteRepository")
public interface VacanteRepository extends JpaRepository<Vacante, Integer> {
}