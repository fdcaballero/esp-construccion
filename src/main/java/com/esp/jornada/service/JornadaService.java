package com.esp.jornada.service;

import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.exception.ExceptionBusiness;
import com.esp.jornada.dto.JornadaDtoCrear;
import com.esp.jornada.dto.JornadaDtoResponse;
import com.esp.jornada.entity.Jornada;
import com.esp.jornada.repository.JornadaRepository;
import com.esp.jornada.utils.mappers.JornadaMapper;
import com.esp.jornada.utils.validations.JornadaValidator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JornadaService extends OperationCrudImpl<Jornada, Integer> {

    private final JornadaRepository repository;
    private final JornadaMapper mapper;


    public JornadaService(SearchService<Jornada, Integer> searchService, JornadaRepository repository, JornadaMapper mapper) {
        super(searchService);
        this.repository = repository;
        this.mapper = mapper;
    }

    private void verificarExistenciaJornada(String nombre){
        Optional<Jornada> existente = repository.findByNombreJornadaIgnoreCase(nombre);

        if(existente.isPresent()){
            throw new ExceptionBusiness(nombre +" ya existe");
        }
    }

    public JornadaDtoResponse crear(JornadaDtoCrear dto) {
        String nombreSinEspacios = dto.nombreJornada().trim();

        JornadaValidator.validarNombre(nombreSinEspacios);
        verificarExistenciaJornada(nombreSinEspacios);

        Jornada objetoNuevo = new Jornada();
        objetoNuevo.setNombreJornada(nombreSinEspacios);

        Jornada registrada = agregar(objetoNuevo);

        return mapper.toDto(registrada);
    }

    @Override
    protected JpaRepository<Jornada, Integer> getRepository() {
        return repository;
    }
}
