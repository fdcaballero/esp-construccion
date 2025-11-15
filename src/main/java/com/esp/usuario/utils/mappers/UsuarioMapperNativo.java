package com.esp.usuario.utils.mappers;

import com.esp.infraestructura.utils.mappers.MapperNativoDto;
import com.esp.usuario.dto.UsuarioDtoConsulta;
import jakarta.persistence.Tuple;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperNativo implements MapperNativoDto<UsuarioDtoConsulta> {

    @Override
    public UsuarioDtoConsulta mapperTuple(Tuple entity) {
        return new UsuarioDtoConsulta(
                entity.get("id_usuario", Integer.class),
                entity.get("nombres", String.class),
                entity.get("apellidos", String.class),
                entity.get("identificacion", String.class),
                entity.get("ubicacion", String.class)
        );
    }
}
