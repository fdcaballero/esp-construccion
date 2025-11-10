package com.esp.vacante.utils.mappers;

import com.esp.infraestructura.utils.mappers.MapperNativoDto;
import com.esp.vacante.dto.VacanteDtoConsulta;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class VacanteMapperNativo implements MapperNativoDto<VacanteDtoConsulta> {

    @Override
    public VacanteDtoConsulta mapperTuple(Tuple entity) {

        String palabrasClaveRaw = entity.get("palabras_clave", String.class);
        List<String> palabrasClave = (palabrasClaveRaw == null || palabrasClaveRaw.isBlank()) ? Collections.emptyList() :
                Arrays.stream(palabrasClaveRaw.split(",")).map(String::trim).toList();

        Instant instantFechaInicio = entity.get("fecha_inicio_vacante", Instant.class);
        OffsetDateTime offsetFechaInicio = null;
        if (instantFechaInicio != null)
            offsetFechaInicio = instantFechaInicio.atZone(ZoneId.systemDefault()).toOffsetDateTime();


        Instant instantFechaFin = entity.get("fecha_fin_vacante", Instant.class);
        OffsetDateTime offsetFechaFin = null;
        if (instantFechaInicio != null)
            offsetFechaFin = instantFechaFin.atZone(ZoneId.systemDefault()).toOffsetDateTime();

        return new VacanteDtoConsulta(
                entity.get("id_vacante", Integer.class),
                entity.get("titulo_vacante", String.class),
                entity.get("detalle_vacante", String.class),
                offsetFechaInicio,
                offsetFechaFin,
                entity.get("min_salario_vacante", String.class),
                entity.get("max_salario_vacante", String.class),
                entity.get("nombre_ubicacion", String.class),
                entity.get("nombre_empresa", String.class),
                entity.get("nombre_jornada", String.class),
                entity.get("nombre_modalidad", String.class),
                entity.get("nombre_tipo_contrato", String.class),
                entity.get("anuncio", String.class),
                entity.get("nombre_estado_vacante", String.class),
                palabrasClave);
    }
}
