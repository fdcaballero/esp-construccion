package com.esp.infraestructura.core.search;

import com.esp.infraestructura.exception.ExceptionBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchService<T, ID> {

    public T byId(JpaRepository<T, ID> repository, ID id) {
        String message = " No se encontró el registro con id: " + id;
        return byId(repository, id, message);
    }

    public T byId(JpaRepository<T, ID> repository, ID id, String message) {
        return repository.findById(id)
                .orElseThrow(() -> new ExceptionBusiness(message));
    }


}
