package com.esp.modalidad.utils.mappers;

import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;
import com.esp.modalidad.dto.ModalidadDtoResponse;
import com.esp.modalidad.entity.Modalidad;
import org.springframework.stereotype.Component;

@Component
public class ModalidadMapper implements MapperEntitytoDto<Modalidad, ModalidadDtoResponse> {

    @Override
    public ModalidadDtoResponse toDto(Modalidad entity) {
        if (entity == null) return null;
        return new ModalidadDtoResponse(entity.getIdModalidad(),
                entity.getNombreModalidad());
    }

    @Override
    public Modalidad toEntity(ModalidadDtoResponse dto) {
        if (dto == null) return null;
        return new Modalidad(dto.idModalidad(), dto.nombreModalidad());
    }
}
