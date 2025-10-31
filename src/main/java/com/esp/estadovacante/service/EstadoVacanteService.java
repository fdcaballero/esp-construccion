package com.esp.estadovacante.service;

import com.esp.estadovacante.dto.EstadoVacanteDtoCrear;
import com.esp.estadovacante.dto.EstadoVacanteDtoRespuesta;
import com.esp.estadovacante.entity.EstadoVacante;
import com.esp.estadovacante.repository.EstadoVacanteRepository;
import com.esp.estadovacante.utils.mappers.EstadoVacanteMapper;
import com.esp.estadovacante.utils.validators.EstadoVacanteValidator;
import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoVacanteService extends OperationCrudImpl<EstadoVacante, Integer> {

    private final EstadoVacanteRepository repository;
    private final EstadoVacanteMapper mapper;

    public EstadoVacanteService(SearchService<EstadoVacante, Integer> searchService,
                                EstadoVacanteRepository repository,
                                EstadoVacanteMapper mapper) {
        super(searchService);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected JpaRepository<EstadoVacante, Integer> getRepository() {
        return repository;
    }

    public EstadoVacanteDtoRespuesta crear(EstadoVacanteDtoCrear dto) {
        String nombreSinEspacios = dto.nombreEstadoVacante().trim();
        Short orden = EstadoVacanteValidator.ordenAjustado(dto.ordenEstadoVacante());
        EstadoVacanteValidator.validarNombre(nombreSinEspacios);
        EstadoVacante objetoNuevo = new EstadoVacante();
        objetoNuevo.setNombreEstadoVacante(nombreSinEspacios);
        objetoNuevo.setOrdenEstadoVacante(orden);
        EstadoVacante registrada = agregar(objetoNuevo);
        return mapper.toDto(registrada);
    }
}
