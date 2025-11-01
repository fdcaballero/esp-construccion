package com.esp.vacante.repository;

import com.esp.vacante.entity.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_AnuncioRepository")
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {
}