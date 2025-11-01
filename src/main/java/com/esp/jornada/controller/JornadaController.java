package com.esp.jornada.controller;

import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.jornada.dto.JornadaDtoCrear;
import com.esp.jornada.entity.Jornada;
import com.esp.jornada.service.JornadaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jornada")
@CrossOrigin(origins = "*")
public class JornadaController {

    private final JornadaService service;

    public JornadaController(JornadaService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody JornadaDtoCrear jornada) {
       return ResponseHttp.ok("creado", service.crear(jornada));
    }
}
