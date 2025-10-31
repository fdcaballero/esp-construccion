package com.esp.tipocontrato.service;

import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.exception.ExceptionBusiness;
import com.esp.tipocontrato.dto.TipoContratoDtoCrear;
import com.esp.tipocontrato.dto.TipoContratoDtoResponse;
import com.esp.tipocontrato.entity.TipoContrato;
import com.esp.tipocontrato.repository.TipoContratoRepository;
import com.esp.tipocontrato.utils.mappers.TipoContratoMapper;
import com.esp.tipocontrato.utils.validators.TipoContratoValidator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoContratoService extends OperationCrudImpl<TipoContrato, Integer> {

    private final TipoContratoRepository repository;
    private final TipoContratoMapper mapper;

    public TipoContratoService(SearchService<TipoContrato, Integer> searchService,
                               TipoContratoRepository repository, TipoContratoMapper mapper) {
        super(searchService);
        this.repository = repository;
        this.mapper = mapper;
    }
    private void verificarExistenciaTipoContrato(String nombre) {
        Optional<TipoContrato> existente = repository.findByNombreTipoContratoIgnoreCase(nombre);
        if(existente.isPresent()) {
            throw new ExceptionBusiness("Ya existe " + nombre);
        }
    }

    public TipoContratoDtoResponse crear(TipoContratoDtoCrear dto) {
        String nombreSinEspacios = dto.nombreTipoContrato().trim();
        TipoContratoValidator.validarNombre(nombreSinEspacios);
        verificarExistenciaTipoContrato(nombreSinEspacios);
        TipoContrato objetoNuevo = new TipoContrato();
        objetoNuevo.setNombreTipoContrato(nombreSinEspacios);
        TipoContrato registrada = agregar(objetoNuevo);
        return mapper.toDto(registrada);
    }

    @Override
    protected JpaRepository<TipoContrato, Integer> getRepository() {
        return repository;
    }

}
