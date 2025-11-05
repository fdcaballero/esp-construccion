package com.esp.usuario.service;

import com.esp.infraestructura.constants.ConstTipoArchivo;
import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.dto.ArchivoDtoMetadato;
import com.esp.infraestructura.exception.ExceptionBusiness;
import com.esp.infraestructura.utils.archivo.GestorArchivoAdmin;
import com.esp.infraestructura.utils.archivo.GestorArchivoInstancia;
import com.esp.infraestructura.utils.validators.ArchivoRegla;
import com.esp.usuario.dto.ImagenDtoMetadato;
import com.esp.usuario.dto.UsuarioDtoCrear;
import com.esp.usuario.dto.UsuarioDtoRespuesta;
import com.esp.usuario.entity.Imagen;
import com.esp.usuario.entity.Usuario;
import com.esp.usuario.repository.ImagenRepository;
import com.esp.usuario.repository.UsuarioRepository;
import com.esp.usuario.utils.mappers.UsuarioMapper;
import com.esp.usuario.utils.validators.UsuarioValidator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioCrearService extends OperationCrudImpl<Usuario, Integer> {

    private final UsuarioRepository repositorio;
    private final ImagenRepository imagenRepository;
    private final UsuarioMapper mapper;
    private final GestorArchivoAdmin gestorArchivoAdmin;


    private static final long TAMANIO_ARCHIVO = 1024 * 1024 * 5; // 5 MB
    private static final List<String> TIPO_ARCHIVO = List.of(
            "image/png",
            "image/jpg",
            "image/jpeg");

    private final static int LONGITUD_NOMBRE = 50;
    private final static int LONGITUD_APELLIDO = 50;
    private final static int LONGITUD_DOCUMENTO = 150;

    public UsuarioCrearService(SearchService<Usuario, Integer> searchService,
                               UsuarioRepository repositorio,
                               GestorArchivoAdmin gestorArchivoAdmin,
                               ImagenRepository imagenRepository,
                               UsuarioMapper mapper) {
        super(searchService);
        this.repositorio = repositorio;
        this.imagenRepository = imagenRepository;
        this.mapper = mapper;
        this.gestorArchivoAdmin = gestorArchivoAdmin;
    }

    @Override
    protected JpaRepository<Usuario, Integer> getRepository() {
        return repositorio;
    }

    private void existeUsuarioByDocumento(String documento) {
        Optional<Usuario> usuarioOptional = repositorio.findByDocumentoUsuario(documento);
        if (usuarioOptional.isPresent())
            throw new ExceptionBusiness("Ya existe un usuario registrado con el documento '" + documento + "'");

    }

    public UsuarioDtoRespuesta crearUsuario(UsuarioDtoCrear dto) {
        MultipartFile file = dto.getArchivo();
        ArchivoRegla.verificar(file, TIPO_ARCHIVO, TAMANIO_ARCHIVO);
        ArchivoDtoMetadato metadato = ArchivoRegla.extraerMetadatos(file);
        ImagenDtoMetadato imagenDtoMetadato = new ImagenDtoMetadato(
                metadato.getNombrePublico(), metadato.getNombrePrivado(),
                metadato.getTipoMime(),
                metadato.getTamanio(), dto.getFavoritaImagen());

        UsuarioValidator.ValidateStringField(dto.getNombresUsuario(), "nombresUsuario", LONGITUD_NOMBRE);
        UsuarioValidator.ValidateStringField(dto.getApellidosUsuario(), "apellidosUsuario", LONGITUD_APELLIDO);
        UsuarioValidator.ValidateStringField(dto.getDocumentoUsuario(), "documentoUsuario", LONGITUD_DOCUMENTO);
        existeUsuarioByDocumento(dto.getDocumentoUsuario());

        Usuario usuario = agregar(mapper.fromDto(dto));
        guardarImagen(usuario, imagenDtoMetadato);
        guardarFile(file, imagenDtoMetadato);
        return mapper.toDto(usuario);
    }

    private void guardarImagen(Usuario usuario, ImagenDtoMetadato metadato) {
        Imagen imagen = new Imagen();
        imagen.setIdUsuario(usuario);
        imagen.setNombrePublico(metadato.nombrePublico());
        imagen.setNombrePrivado(metadato.nombrePrivado());
        imagen.setTipoImagen(metadato.tipoImagen());
        imagen.setTamanioImagen(metadato.tamanio());
        imagen.setFavoritaImagen(metadato.favorita());
        imagenRepository.save(imagen);
    }

    private void guardarFile(MultipartFile file, ImagenDtoMetadato metadato) {
        GestorArchivoInstancia instancia = gestorArchivoAdmin.crear(
                ConstTipoArchivo.IMAGEN,
                metadato.nombrePrivado(),
                null, file);
        if (!instancia.guardar())
            throw new ExceptionBusiness("Error al guardar la imagen del usuario");

    }


}
