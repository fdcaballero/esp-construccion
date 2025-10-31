package com.esp.tipocontrato.repository;

import com.esp.tipocontrato.entity.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository("vacante_TipoContratoRepositorio")
public interface TipoContratoRepository extends JpaRepository<TipoContrato, Integer> {
    Optional<TipoContrato> findByNombreTipoContratoIgnoreCase(String nombre);

}
