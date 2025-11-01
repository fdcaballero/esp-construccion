package com.esp.vacante.repository;

import com.esp.vacante.entity.RelVacantePalabraClave;
import com.esp.vacante.entity.pk.RelVacantePalabraClavePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_RelVacantePalabraClaveRepository")
public interface RelVacantePalabraClaveRepository extends JpaRepository<RelVacantePalabraClave, RelVacantePalabraClavePK> {
}