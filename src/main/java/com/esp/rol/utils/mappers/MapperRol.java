package com.esp.rol.utils.mappers;

import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;
import com.esp.rol.dto.RolRespuestaDto;
import com.esp.rol.entity.Rol;
import org.springframework.stereotype.Component;

@Component
public class MapperRol implements MapperEntitytoDto<Rol, RolRespuestaDto> {


    @Override
    public RolRespuestaDto toDto(Rol entity) {
        if (entity == null) return null;
        return new RolRespuestaDto(entity.getIdRol(), entity.getNombreRol(),
                entity.getEstadoRol());
    }

    @Override
    public Rol toEntity(RolRespuestaDto dto) {
        if (dto == null) return null;
        return new Rol(dto.idRol(), dto.nombreRol(), dto.estadoRol());
    }
}
