package com.esp.infraestructura.utils.mappers;

import com.esp.infraestructura.exception.ExceptionBusiness;

public interface MapperEntitytoDto<E, D> {

    D toDto(E entity);

    E toEntity(D dto);

    default E fromDto(D dto, Object... objects) {
        throw new ExceptionBusiness("El mapper no está implementado");
    }
}
