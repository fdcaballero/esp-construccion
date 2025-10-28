package com.esp.infraestructura.utils.mappers;

public interface MapperEntitytoDto<E, D> {

    D toDto(E entity);

    E toEntity(D dto);
}
