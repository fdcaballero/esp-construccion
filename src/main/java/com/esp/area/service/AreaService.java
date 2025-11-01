package com.esp.area.service;

import com.esp.area.dto.AreaDtoCrear;
import com.esp.area.dto.AreaDtoRespuesta;
import com.esp.area.entity.Area;
import com.esp.area.repository.AreaRepository;
import com.esp.area.utils.mappers.AreaMapper;
import com.esp.area.utils.validators.AreaValidator;
import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.exception.ExceptionBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AreaService extends OperationCrudImpl<Area, Integer> {

    private final AreaRepository repository;
    private final AreaMapper mapper;

    public AreaService(SearchService<Area, Integer> searchService, AreaRepository repository, AreaMapper mapper) {
        super(searchService);
        this.repository = repository;
        this.mapper = mapper;
    }


    private void verificarExistenciaArea(String nombre) {
        Optional<Area> existente = repository.findByNombreAreaIgnoreCase(nombre);
        if (existente.isPresent()) {
            throw new ExceptionBusiness("El nombre del área ya existe!!!!");
        }
    }

    public AreaDtoRespuesta crearArea(AreaDtoCrear area) {

        String nombreSinEspacio = area.nombreArea() == null ? "" : area.nombreArea().trim();
        AreaValidator.validarNombre(nombreSinEspacio);

        verificarExistenciaArea(nombreSinEspacio);

        Area objNuevo = new Area();
        objNuevo.setNombreArea(nombreSinEspacio);

        Area registrada = agregar(objNuevo);

        return mapper.toDto(registrada);
    }


    @Override
    protected JpaRepository<Area, Integer> getRepository() {
        return repository;
    }


}
