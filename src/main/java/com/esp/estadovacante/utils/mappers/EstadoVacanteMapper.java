package com.esp.estadovacante.utils.mappers;

import com.esp.estadovacante.dto.EstadoVacanteDtoRespuesta;
import com.esp.estadovacante.entity.EstadoVacante;
import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;
import org.springframework.stereotype.Component;

@Component
public class EstadoVacanteMapper implements MapperEntitytoDto<EstadoVacante, EstadoVacanteDtoRespuesta> {
    @Override
    public EstadoVacanteDtoRespuesta toDto(EstadoVacante entity) {
        if(entity == null) {
            return null;
        }
        return new EstadoVacanteDtoRespuesta(
                entity.getIdEstadoVacante(),
                entity.getNombreEstadoVacante(),
                entity.getOrdenEstadoVacante());
    }

    @Override
    public EstadoVacante toEntity(EstadoVacanteDtoRespuesta dto) {
        if(dto == null) {
            return null;
        }
        EstadoVacante entidad = new EstadoVacante();
        entidad.setIdEstadoVacante(dto.idEstadoVacante());
        entidad.setNombreEstadoVacante(dto.nombreEstadoVacante());
        entidad.setOrdenEstadoVacante(dto.ordenEstadoVacante());
        return entidad;
    }
}
