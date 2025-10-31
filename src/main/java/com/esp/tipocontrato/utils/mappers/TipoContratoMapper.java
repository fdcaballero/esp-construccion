package com.esp.tipocontrato.utils.mappers;

import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;
import com.esp.tipocontrato.dto.TipoContratoDtoResponse;
import com.esp.tipocontrato.entity.TipoContrato;
import org.springframework.stereotype.Component;

@Component
public class TipoContratoMapper implements MapperEntitytoDto<TipoContrato, TipoContratoDtoResponse> {


    @Override
    public TipoContratoDtoResponse toDto(TipoContrato entity) {
        if (entity == null)
            return null;

        return new TipoContratoDtoResponse(
                entity.getIdTipoContrato(),
                entity.getNombreTipoContrato());
    }


    @Override
    public TipoContrato toEntity(TipoContratoDtoResponse dto) {
        if (dto == null)
            return null;

        TipoContrato entidad = new TipoContrato();
        entidad.setIdTipoContrato(dto.idTipoContrato());
        entidad.setNombreTipoContrato(dto.nombreTipoContrato());

        return entidad;
    }
}
