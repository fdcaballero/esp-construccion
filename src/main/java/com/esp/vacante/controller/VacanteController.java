package com.esp.vacante.controller;


import com.esp.infraestructura.dto.ArchivoDtoMetadato;
import com.esp.infraestructura.utils.respuesta.ResponseHttp;

import com.esp.infraestructura.utils.validators.ArchivoRegla;
import com.esp.vacante.dto.AnuncioDtoMetadato;
import com.esp.vacante.dto.VacanteDtoCrear;
import com.esp.vacante.service.VacanteCrearService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/vacancy")
@CrossOrigin(origins = "*")
public class VacanteController {


    private static final long TAMANIO_ARCHIVO = 1024 * 1024 * 5; // 5 MB
    private static final List<String> TIPO_ARCHIVO = List.of(
            "image/png",
            "image/jpg",
            "image/jpeg");

    private final VacanteCrearService service;

    public VacanteController(VacanteCrearService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> crear(@ModelAttribute VacanteDtoCrear dto) {
         MultipartFile file = dto.getArchivo();
        ArchivoRegla.verificar(file, TIPO_ARCHIVO, TAMANIO_ARCHIVO);
        ArchivoDtoMetadato metadato = ArchivoRegla.extraerMetadatos(file);
        AnuncioDtoMetadato anuncioDtoArchivo = new AnuncioDtoMetadato(
                metadato.getNombrePublico(),
                metadato.getNombrePrivado(),
                metadato.getTipoMime(), metadato.getTamanio()
        );
        return ResponseHttp.ok("Crear Vacante", service.crear(dto, anuncioDtoArchivo));
    }


}
