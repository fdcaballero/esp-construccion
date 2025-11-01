package com.esp.vacante.service;

import com.esp.infraestructura.core.crud.OperationCrudImpl;
import com.esp.infraestructura.core.search.SearchService;
import com.esp.infraestructura.exception.ExceptionBusiness;
import com.esp.infraestructura.utils.archivo.GestorArchivoAdmin;
import com.esp.infraestructura.utils.archivo.GestorArchivoInstancia;
import com.esp.vacante.dto.AnuncioDtoMetadato;
import com.esp.vacante.dto.VacanteDtoCrear;
import com.esp.vacante.dto.VacanteDtoRespuesta;
import com.esp.vacante.entity.*;
import com.esp.vacante.entity.pk.RelVacantePalabraClavePK;
import com.esp.vacante.repository.*;
import com.esp.vacante.utils.mappers.VacanteMapper;
import org.apache.catalina.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class VacanteCrearService extends OperationCrudImpl<Vacante, Integer> {


    private final VacanteRepository repository;
    private final RelVacantePalabraClaveRepository relVacantePalabraClaveRepository;
    private final AnuncioRepository anuncioRepository;
    private final HistorialEstadoVacanteRepository historialEstadoVacanteRepository;
    private final EstadoVacanteRepository estadoVacanteRepository;
    private final VacanteMapper mapper;
    private final VacanteMapper vacanteMapper;
    private final GestorArchivoAdmin gestorArchivoAdmin;

    public VacanteCrearService(SearchService<Vacante, Integer> searchService,
                               VacanteRepository repository,
                               RelVacantePalabraClaveRepository relVacantePalabraClaveRepository,
                               AnuncioRepository anuncioRepository,
                               HistorialEstadoVacanteRepository historialEstadoVacanteRepository,
                               EstadoVacanteRepository estadoVacanteRepository,
                               GestorArchivoAdmin gestorArchivoAdmin,
                               VacanteMapper mapper, VacanteMapper vacanteMapper) {
        super(searchService);
        this.repository = repository;
        this.relVacantePalabraClaveRepository = relVacantePalabraClaveRepository;
        this.anuncioRepository = anuncioRepository;
        this.historialEstadoVacanteRepository = historialEstadoVacanteRepository;
        this.estadoVacanteRepository = estadoVacanteRepository;
        this.mapper = mapper;
        this.gestorArchivoAdmin = gestorArchivoAdmin;
        this.vacanteMapper = vacanteMapper;
    }

    @Override
    protected JpaRepository<Vacante, Integer> getRepository() {
        return repository;
    }

    @Transactional
    public VacanteDtoRespuesta crear(VacanteDtoCrear dto, AnuncioDtoMetadato archivoDto) {
        Vacante vacanteNueva = vacanteMapper.fromDto(dto);
        vacanteNueva = repository.save(vacanteNueva);
        guardarPalabrasClaves(dto, vacanteNueva);
        guardarAnuncio(archivoDto, vacanteNueva);
        guardarHistorial(dto, vacanteNueva);
        guardarFile(dto.getArchivo(), archivoDto);
        return mapper.toDto(vacanteNueva);
    }

    private void guardarFile(MultipartFile archivo, AnuncioDtoMetadato dto) {
        GestorArchivoInstancia instancia = gestorArchivoAdmin.crear(
                com.esp.infraestructura.constants.ConstTipoArchivo.IMAGEN_VACANTE,
                dto.getNombrePrivatdo(),
                null,
                archivo);
        boolean exito = instancia.guardar();
        if (!exito) {
            throw new ExceptionBusiness("Error al guardar el archivo de anuncio");
        }

    }

    private void guardarHistorial(VacanteDtoCrear dto, Vacante vacanteNueva) {
        EstadoVacante estado = estadoVacanteRepository.findById((int) dto.getEstadoVacante())
                .orElseThrow(() -> new ExceptionBusiness("Estado de Vacante no encontrado"));

        HistorialEstadoVacante historial = new HistorialEstadoVacante();
        historial.setIdVacante(vacanteNueva);
        historial.setFechaHistorialEstadoVacante(OffsetDateTime.now());
        historial.setIdEstadoVacante(estado);
        historialEstadoVacanteRepository.save(historial);
    }

    private void guardarPalabrasClaves(VacanteDtoCrear dto, Vacante vacanteNueva) {
        if (dto.getIdPalabraClave() == null || dto.getIdPalabraClave().isEmpty()) return;

        List<RelVacantePalabraClave> relaciones = dto.getIdPalabraClave()
                .stream().map(idPalabraClave -> {
                    RelVacantePalabraClave relacion = new RelVacantePalabraClave(
                            new RelVacantePalabraClavePK(vacanteNueva.getIdVacante(), idPalabraClave));
                    relacion.setVacante(vacanteNueva);
                    relacion.setPalabraClave(entityManager.getReference(PalabraClave.class, idPalabraClave));
                    return relacion;
                }).toList();
        relVacantePalabraClaveRepository.saveAll(relaciones);
    }

    private void guardarAnuncio(AnuncioDtoMetadato archivo, Vacante vacanteNueva) {
        Anuncio anuncio = new Anuncio();
        anuncio.setVacante(vacanteNueva);
        anuncio.setNombrePublicoAnuncio(archivo.getNombrePublico());
        anuncio.setNombrePrivadoAnuncio(archivo.getNombrePrivatdo());
        anuncio.setTipoAnuncio(archivo.getTipoAnuncio());
        anuncio.setTamanioAnuncio(archivo.getTamanio());
        anuncioRepository.save(anuncio);
    }
}
