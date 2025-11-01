package com.esp.tipocontrato.controller;

import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.tipocontrato.dto.TipoContratoDtoCrear;
import com.esp.tipocontrato.service.TipoContratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tipos_contratos-type")
public class TipoContratoController {

    private final TipoContratoService service;

    public TipoContratoController(TipoContratoService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> crear(@RequestBody TipoContratoDtoCrear dto) {
        return ResponseHttp.ok("create", service.crear(dto));

    }
}
