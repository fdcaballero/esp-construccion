package com.esp.jornada.utils.mappers;

import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;
import com.esp.jornada.dto.JornadaDtoResponse;
import com.esp.jornada.entity.Jornada;
import org.springframework.stereotype.Component;

@Component
public class JornadaMapper implements MapperEntitytoDto<Jornada, JornadaDtoResponse> {

    @Override
    public JornadaDtoResponse toDto(Jornada entity) {
        if (entity == null) return null;
        return new JornadaDtoResponse(entity.getIdJornada(), entity.getNombreJornada());
    }

    @Override
    public Jornada toEntity(JornadaDtoResponse dto) {
        if (dto == null) return null;
        return new Jornada(dto.idJornada(), dto.nombreJornada());
    }
}
