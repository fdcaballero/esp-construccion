package com.esp.modalidad.service;

import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.exception.ExceptionBusiness;
import com.esp.modalidad.dto.ModalidadDtoCrear;
import com.esp.modalidad.dto.ModalidadDtoResponse;
import com.esp.modalidad.entity.Modalidad;
import com.esp.modalidad.repository.ModalidadRepository;
import com.esp.modalidad.utils.mappers.ModalidadMapper;
import com.esp.modalidad.utils.validators.ModalidadValidator;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModalidadService extends OperationCrudImpl<Modalidad,Integer> {


    private final ModalidadRepository repository;
    private final ModalidadMapper mapper;

    public ModalidadService(SearchService<Modalidad, Integer> searchService, ModalidadRepository repository, ModalidadMapper mapper) {
        super(searchService);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<Modalidad, Integer> getRepository() {
        return repository;
    }


    private void verificarExistenciaModalidad(String nombre) {
        Optional<Modalidad> existe = repository.findByNombreModalidadIgnoreCase(nombre);
        if (existe.isPresent())
            throw new ExceptionBusiness("La  modalidad con nombre '" + nombre + "' ya existe.");
    }

    @Transactional
    public ModalidadDtoResponse crear(ModalidadDtoCrear dto) {
        String nombreSinEspacios = dto.nombreModalidad().trim();

        ModalidadValidator.validateNombre(nombreSinEspacios);
        verificarExistenciaModalidad(nombreSinEspacios);

        Modalidad modalidadNew = new Modalidad();
        modalidadNew.setNombreModalidad(nombreSinEspacios);
        return mapper.toDto(agregar(modalidadNew));
    }

}
