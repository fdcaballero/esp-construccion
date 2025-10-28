package com.esp.rol.service;

import com.esp.empresa.entity.TipoEmpresa;
import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.exception.ExceptionBusiness;
import com.esp.infraestructura.utils.mappers.MapperEntitytoDto;
import com.esp.rol.dto.RolDtoCrear;
import com.esp.rol.dto.RolRespuestaDto;
import com.esp.rol.entity.Rol;
import com.esp.rol.repository.RolRepository;
import com.esp.rol.utils.mappers.MapperRol;
import com.esp.rol.utils.validators.RolValidator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService extends OperationCrudImpl<Rol, Integer> {

    private final RolRepository rolRepository;
    private final MapperRol mapper;


    public RolService(SearchService<Rol, Integer> searchService,
                      RolRepository rolRepository,
                      MapperRol mapper) {
        super(searchService);
        this.rolRepository = rolRepository;
        this.mapper = mapper;
    }

    private void existeRolByName(String name) {
        Optional<Rol> existe = rolRepository
                .findByNombreRolIgnoreCase(name);
        if (existe.isPresent())
            throw new ExceptionBusiness("El Rol con nombre '" + name + "' ya existe.");
    }

    public RolRespuestaDto crearRol(RolDtoCrear dto) {
        String nombreSinEspacio = dto.nombreRol().trim();
        Short estado = RolValidator.estadoAjustado(dto.estadoRol());

        RolValidator.validateNombre(nombreSinEspacio);
        existeRolByName(nombreSinEspacio);

        Rol rol = new Rol();
        rol.setNombreRol(nombreSinEspacio);
        rol.setEstadoRol(estado);
        Rol rolDB = agregar(rol);
        return mapper.toDto(rolDB);
    }

    @Override
    protected JpaRepository<Rol, Integer> getRepository() {
        return rolRepository;
    }
}
