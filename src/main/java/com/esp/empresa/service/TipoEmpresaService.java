package com.esp.empresa.service;


import com.esp.empresa.dto.TipoEmpresaDtoCrear;
import com.esp.empresa.dto.TipoEmpresaRespuestaDto;
import com.esp.empresa.entity.TipoEmpresa;
import com.esp.empresa.repository.TipoEmpresaRepository;
import com.esp.empresa.utils.mappers.TipoEmpresaMapper;

import com.esp.empresa.utils.validation.TipoEmpresaValidator;
import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.exception.ExceptionBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoEmpresaService extends OperationCrudImpl<TipoEmpresa, Integer> {

    private final TipoEmpresaRepository tipoEmpresaRepository;
    private final TipoEmpresaMapper mapper;

    public TipoEmpresaService(TipoEmpresaRepository tipoEmpresaRepository,
                              TipoEmpresaMapper mapper,
                              SearchService<TipoEmpresa, Integer> searchService) {
        super(searchService);
        this.tipoEmpresaRepository = tipoEmpresaRepository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<TipoEmpresa, Integer> getRepository() {
        return tipoEmpresaRepository;
    }

    private void verificarExistenciaTipoEmpresa(String nombre) {
        Optional<TipoEmpresa> existe = tipoEmpresaRepository
                .findByNombreTipoEmpresaIgnoreCase(nombre);
        if (existe.isPresent())
             throw new ExceptionBusiness("El tipo de empresa con nombre '" + nombre + "' ya existe.");
    }
    public TipoEmpresaRespuestaDto crearTipoEmpresa(TipoEmpresaDtoCrear dto){
        String nombreSinEspacios = dto.nombreTipoEmpresa().trim();
        Short estadoAjustado = TipoEmpresaValidator.estadoAjustado(dto.estadoTipoEmpresa());

        TipoEmpresaValidator.validateNombre(nombreSinEspacios);
        verificarExistenciaTipoEmpresa(nombreSinEspacios);

        TipoEmpresa nuevoTipoEmpresa  = new TipoEmpresa();
        nuevoTipoEmpresa.setNombreTipoEmpresa(nombreSinEspacios);
        nuevoTipoEmpresa.setEstadoTipoEmpresa(estadoAjustado);
        TipoEmpresa tipoEmpresa = agregar(nuevoTipoEmpresa);

        return mapper.toDto(tipoEmpresa);
    }
}
