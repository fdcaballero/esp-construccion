package com.esp.usuario.service;

import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.exception.ExceptionBusiness;
import com.esp.infraestructura.s3.S3Service;
import com.esp.usuario.dto.UsuarioDtoConsulta;
import com.esp.usuario.entity.Usuario;
import com.esp.usuario.repository.ImagenRepository;
import com.esp.usuario.repository.UsuarioRepository;
import com.esp.usuario.utils.SqlBuilderUsuario;
import com.esp.usuario.utils.mappers.UsuarioMapperNativo;
import jakarta.annotation.Resource;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioConsultaService extends OperationCrudImpl<Usuario, Integer> {

    private final UsuarioRepository repositorio;
    private final UsuarioMapperNativo mapperNativo;
    private final ImagenRepository imagenRepository;

    private final S3Service s3Service;

    @Value("${especializacion.ruta.imagenes}")
    private String nameBucket;

    public UsuarioConsultaService(SearchService<Usuario, Integer> searchService,
                                  UsuarioRepository repositorio,
                                  S3Service s3Service,
                                  ImagenRepository imagenRepository,
                                  UsuarioMapperNativo mapperNativo) {
        super(searchService);
        this.repositorio = repositorio;
        this.mapperNativo = mapperNativo;
        this.s3Service = s3Service;
        this.imagenRepository = imagenRepository;
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

    public String getImageUserById(Integer id) {
        return  repositorio.findById(id)
                .map(user -> imagenRepository.getImagenByIdUsuario(user)
                        .orElseThrow(() -> new ExceptionBusiness("Imagen no encontrada")))
                .map(imagen -> s3Service.generatePreSignedUrl(this.nameBucket, imagen.getNombrePublico()))
                .orElseThrow(() -> new ExceptionBusiness("Error al obtener el archivo"));
     }
}
