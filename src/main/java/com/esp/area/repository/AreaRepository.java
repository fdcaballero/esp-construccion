package com.esp.area.repository;

import com.esp.area.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository("area_AreaRepository")
public interface AreaRepository extends JpaRepository<Area, Integer> {

    Optional<Area> findByNombreAreaIgnoreCase(String nombre);

    boolean existsByNombreAreaIgnoreCase(String nombre);
}
