package com.esp.infraestructura.core.crud;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface OperationCrud<T, ID> {

    Long cantidad();

    List<T> consultar(Sort sort);

    T findById(ID id);

    T findById(ID id, String message);

    boolean deleteById(ID id);

    T update(T entity);

    T agregar(T entity);

    List<T> agregar(List<T> entity);
}
