package com.esp.modalidad.controller;


import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.modalidad.dto.ModalidadDtoCrear;
import com.esp.modalidad.service.ModalidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modalidad")
@CrossOrigin(origins = "*")
public class ModalidadController {

    private final ModalidadService service;

    public ModalidadController(ModalidadService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> crear(@RequestBody ModalidadDtoCrear dto) {
        return ResponseHttp.ok("create", service.crear(dto));
    }
}
