package com.esp.modalidad.controller;


import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.modalidad.dto.ModalidadDtoCrear;
import com.esp.modalidad.service.ModalidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modalidad")
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
