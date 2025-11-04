package com.esp.usuario.service;

import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.dto.ArchivoDtoMetadato;
import com.esp.infraestructura.utils.validators.ArchivoRegla;
import com.esp.usuario.dto.UsuarioDtoCrear;
import com.esp.usuario.dto.UsuarioDtoRespuesta;
import com.esp.usuario.entity.Usuario;
import com.esp.usuario.repository.ImagenRepository;
import com.esp.usuario.repository.UsuarioRepository;
import com.esp.usuario.utils.mappers.UsuarioMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UsuarioCrearService extends OperationCrudImpl<Usuario, Integer> {

    private final UsuarioRepository repositorio;
    private final ImagenRepository imagenRepository;
    private final UsuarioMapper mapper;


    private static final long TAMANIO_ARCHIVO = 1024 * 1024 * 5; // 5 MB
    private static final List<String> TIPO_ARCHIVO = List.of(
            "image/png",
            "image/jpg",
            "image/jpeg");

    public UsuarioCrearService(SearchService<Usuario, Integer> searchService,
                               UsuarioRepository repositorio,
                               ImagenRepository imagenRepository,
                               UsuarioMapper mapper) {
        super(searchService);
        this.repositorio = repositorio;
        this.imagenRepository = imagenRepository;
        this.mapper = mapper;
    }


    public UsuarioDtoRespuesta crearUsuario(UsuarioDtoCrear dto) {
        MultipartFile file = dto.getArchivo();
        ArchivoRegla.verificar(file, TIPO_ARCHIVO, TAMANIO_ARCHIVO);
        ArchivoDtoMetadato metadato = ArchivoRegla.extraerMetadatos(file);
//        Guardar información del usuario
//Guardar la imagen usando imagenRepository (lógica no implementada aquí)
//        Guardar el file
        Usuario usuario = agregar(mapper.fromDto(dto));

        return mapper.toDto(usuario);
    }

    @Override
    protected JpaRepository<Usuario, Integer> getRepository() {
        return repositorio;
    }
}
