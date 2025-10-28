package com.esp.infraestructura.core.crud;

import com.esp.infraestructura.core.search.SearchService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class OperationCrudImpl<T, ID> implements OperationCrud<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final SearchService<T, ID> searchService;

    public OperationCrudImpl(SearchService<T, ID> searchService) {
        this.searchService = searchService;
    }

    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public Long cantidad() {
        return getRepository().count();
    }

    @Override
    public List<T> consultar(Sort sort) {
        return getRepository().findAll(sort);
    }


    @Override
    public T findById(ID id) {
        return searchService.byId(getRepository(), id);
    }

    @Override
    public T findById(ID id, String message) {
        return searchService.byId(getRepository(), id, message);
    }

    @Override
    public boolean deleteById(ID id) {

        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public T update(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T agregar(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public List<T> agregar(List<T> entity) {
        return getRepository().saveAll(entity);
    }
}
