package com.esp.empresa.repository;

import com.esp.empresa.entity.TipoEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("empresa_tipoEmpresaRepository")
public interface TipoEmpresaRepository extends JpaRepository<TipoEmpresa, Integer> {

    Optional<TipoEmpresa> findByNombreTipoEmpresaIgnoreCase(String nombreTipoEmpresa);
}
