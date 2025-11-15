package com.esp.usuario.service;

import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.usuario.dto.UsuarioDtoConsulta;
import com.esp.usuario.entity.Usuario;
import com.esp.usuario.repository.UsuarioRepository;
import com.esp.usuario.utils.SqlBuilderUsuario;
import com.esp.usuario.utils.mappers.UsuarioMapperNativo;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioConsultaService extends OperationCrudImpl<Usuario, Integer> {

    private final UsuarioRepository repositorio;
    private final UsuarioMapperNativo mapperNativo;


    public UsuarioConsultaService(SearchService<Usuario, Integer> searchService,
                                  UsuarioRepository repositorio,
                                  UsuarioMapperNativo mapperNativo) {
        super(searchService);
        this.repositorio = repositorio;
        this.mapperNativo = mapperNativo;
    }

    @Override
    protected JpaRepository<Usuario, Integer> getRepository() {
        return repositorio;
    }

    public List<UsuarioDtoConsulta> consultaUsuarios(String campoOrden, String tipoOrden) {

        String tipoOrdenNormalize = (tipoOrden != null && !tipoOrden.isBlank()
                && tipoOrden.equalsIgnoreCase("DESC")) ? tipoOrden : "ASC";

        String campoOrdenNormalize = (tipoOrden != null && !campoOrden.isBlank())
                ? campoOrden : "u.id_usuario";//TODO se puede reemplazar por otra columna

        String sql = SqlBuilderUsuario.consulta(campoOrdenNormalize, tipoOrdenNormalize);
        System.out.println(sql);

        Query query = entityManager.createNativeQuery(sql, Tuple.class);
        List<Tuple> result = query.getResultList();
        return result.stream().map(mapperNativo::mapperTuple).toList();

    }
}
