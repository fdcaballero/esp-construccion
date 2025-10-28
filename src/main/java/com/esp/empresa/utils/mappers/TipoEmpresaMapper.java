package com.esp.empresa.utils.mappers;

import com.esp.empresa.dto.TipoEmpresaRespuestaDto;
import com.esp.empresa.entity.TipoEmpresa;
import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;
import org.springframework.stereotype.Component;

@Component
public class TipoEmpresaMapper implements MapperEntitytoDto<TipoEmpresa, TipoEmpresaRespuestaDto> {

    @Override
    public TipoEmpresaRespuestaDto toDto(TipoEmpresa entity) {
        if (entity == null) return null;
        return new TipoEmpresaRespuestaDto(
                entity.getIdTipoEmpresa(),
                entity.getNombreTipoEmpresa(),
                entity.getEstadoTipoEmpresa()
        );
    }

    @Override
    public TipoEmpresa toEntity(TipoEmpresaRespuestaDto dto) {
        if (dto == null) return null;
        return new TipoEmpresa(
                dto.idTipoEmpresa(),
                dto.nombreTipoEmpresa(),
                dto.estadoTipoEmpresa());

    }
}
