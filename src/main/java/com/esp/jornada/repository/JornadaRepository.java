package com.esp.jornada.repository;

import com.esp.jornada.entity.Jornada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("jornada_Jornada")
public interface JornadaRepository extends JpaRepository<Jornada, Integer> {

    Optional<Jornada> findByNombreJornadaIgnoreCase(String nombre);

}
