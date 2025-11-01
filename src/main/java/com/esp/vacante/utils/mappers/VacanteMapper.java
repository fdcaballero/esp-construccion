package com.esp.vacante.utils.mappers;

import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;
import com.esp.vacante.dto.VacanteDtoCrear;
import com.esp.vacante.dto.VacanteDtoRespuesta;
import com.esp.vacante.entity.*;
import com.esp.vacante.entity.pk.RelUsuarioEmpresaPK;
import org.springframework.stereotype.Component;

@Component
public class VacanteMapper implements MapperEntitytoDto<Vacante, VacanteDtoRespuesta> {

    @Override
    public VacanteDtoRespuesta toDto(Vacante entity) {
        if (entity == null) return null;

        VacanteDtoRespuesta dto = new VacanteDtoRespuesta();
        dto.setIdVacante(entity.getIdVacante());
        dto.setTituloVacante(entity.getTituloVacante());
        return dto;
    }

    @Override
    public Vacante toEntity(VacanteDtoRespuesta dto) {
        if (dto == null) return null;
        Vacante entity = new Vacante();
        entity.setIdVacante(dto.getIdVacante());
        entity.setTituloVacante(dto.getTituloVacante());
        return entity;
    }


    public Vacante fromDto(VacanteDtoCrear dto, Object... objects) {
        if (dto == null) return null;
        Vacante vacante = new Vacante();
        vacante.setTituloVacante(dto.getTituloVacante());
        vacante.setDetalleVacante(dto.getDetalleVacante());
        vacante.setFechaInicioVacante(dto.getFechaInicioVacante());
        vacante.setFechaFinVacante(dto.getFechaFinVacante());
        vacante.setEstadoVacante(dto.getEstadoVacante());
        vacante.setMinSalarioVacante(dto.getMinSalarioVacante());
        vacante.setMaxSalarioVacante(dto.getMaxSalarioVacante());

        if (dto.getIdUbicacion() != null) {
            vacante.setIdUbicacion(new Ubicacion(dto.getIdUbicacion()));
        }
        if (dto.getIdJornada() != null) {
            vacante.setIdJornada(new Jornada(dto.getIdJornada()));
        }
        if (dto.getIdModalidad() != null)
            vacante.setIdModalidad(new Modalidad(dto.getIdModalidad()));

        if (dto.getIdTipoContrato() != null)
            vacante.setIdTipoContrato(new TipoContrato(dto.getIdTipoContrato()));

        if (dto.getIdEmpresa() != null && dto.getIdUsuario() != null)
            vacante.setIdRelUsuarioEmpresa(new RelUsuarioEmpresa(dto.getIdUsuario(),
                    dto.getIdEmpresa(), (short) 1));

        return vacante;
    }
}
