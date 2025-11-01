package com.esp.rol.controller;

import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.infraestructura.utils.respuesta.ResponseHttpModel;
import com.esp.rol.dto.RolDtoCrear;
import com.esp.rol.dto.RolRespuestaDto;
import com.esp.rol.service.RolService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*")
public class RolController {

    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseHttpModel<RolRespuestaDto>> crearRol( @RequestBody RolDtoCrear dto){
        return ResponseHttp.ok("message", service.crearRol(dto));
    }
}
