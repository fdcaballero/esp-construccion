package com.esp.vacante.service;

import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.exception.ExceptionBusiness;
import com.esp.vacante.dto.VacanteDtoConsulta;
import com.esp.vacante.entity.Vacante;
import com.esp.vacante.repository.VacanteRepository;
import com.esp.vacante.utils.SqlBuilderVacante;
import com.esp.vacante.utils.mappers.VacanteMapperNativo;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VacanteConsultaServicio extends OperationCrudImpl<Vacante, Integer> {

    @Value("${especializacion.url.base-imagenes}")
    private String baseRutaImagen;

    private final VacanteRepository repository;
    private final VacanteMapperNativo mapperNativo;


    public VacanteConsultaServicio(SearchService<Vacante, Integer> searchService,
                                   VacanteMapperNativo mapperNativo,
                                   VacanteRepository repository) {
        super(searchService);
        this.repository = repository;
        this.mapperNativo = mapperNativo;
    }

    @Override
    protected JpaRepository<Vacante, Integer> getRepository() {
        return repository;
    }

    @Transactional(readOnly = true)
    public List<VacanteDtoConsulta> consultaVacantes(String campoOrden, String tipoOrden) {
        String tipoOrdenNormalize = (tipoOrden != null && !tipoOrden.isBlank()
                                     && tipoOrden.equalsIgnoreCase("DESC")) ? tipoOrden : "ASC";

        String campoOrdenNormalize = (tipoOrden != null && !campoOrden.isBlank())
                ? campoOrden : "v.fecha_inicio_vacante";

        String sql = SqlBuilderVacante.consulta(campoOrdenNormalize, tipoOrdenNormalize);
        System.out.println(sql);

        Query query = entityManager.createNativeQuery(sql, Tuple.class);
        List<Tuple> result = query.getResultList();
        return result.stream().map(item -> {
            VacanteDtoConsulta dto = mapperNativo.mapperTuple(item);
            String url = "%s/%s".formatted(baseRutaImagen, dto.getNombrePrivadoAnuncio());
            return dto.conUrl(url);
        }).toList();


    }
}
