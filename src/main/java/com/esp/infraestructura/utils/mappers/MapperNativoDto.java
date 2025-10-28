package com.esp.infraestructura.utils.mappers;

import jakarta.persistence.Tuple;

public interface MapperNativoDto<D> {
    D mapperTuple(Tuple entity);

}
