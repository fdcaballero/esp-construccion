package com.esp.area.utils.mappers;

import com.esp.area.dto.AreaDtoRespuesta;
import com.esp.area.entity.Area;
import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;
import org.springframework.stereotype.Component;

@Component
public class AreaMapper implements MapperEntitytoDto<Area, AreaDtoRespuesta> {

    @Override
    public AreaDtoRespuesta toDto(Area entity) {
        if (entity == null) return null;
        return new AreaDtoRespuesta(entity.getIdArea(), entity.getNombreArea());
    }

    @Override
    public Area toEntity(AreaDtoRespuesta dto) {
        if (dto == null) return null;
        Area entidad = new Area();
        entidad.setIdArea(dto.idArea());
        entidad.setNombreArea(dto.nombreArea());
        return entidad;
    }
}
