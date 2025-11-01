package com.esp.estadovacante.controller;

import com.esp.estadovacante.dto.EstadoVacanteDtoCrear;
import com.esp.estadovacante.dto.EstadoVacanteDtoRespuesta;
import com.esp.estadovacante.service.EstadoVacanteService;
import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estado-vacante")
@CrossOrigin(origins = "*")
public class EstadoVacanteController {
    private final EstadoVacanteService service;

    public EstadoVacanteController(EstadoVacanteService service) {
        this.service = service;
    }
    @PostMapping("/add")
    public ResponseEntity<?> crearTipoEmpresa(@RequestBody EstadoVacanteDtoCrear dto) {
        EstadoVacanteDtoRespuesta respuesta = service.crear(dto);
        return ResponseHttp.ok("That is working", respuesta);
    }

}
