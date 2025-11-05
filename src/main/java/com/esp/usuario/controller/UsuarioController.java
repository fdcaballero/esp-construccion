package com.esp.usuario.controller;

import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.usuario.dto.UsuarioDtoCrear;
import com.esp.usuario.service.UsuarioCrearService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioCrearService service;


    public UsuarioController(UsuarioCrearService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<?> post(@ModelAttribute UsuarioDtoCrear dto) {
        return ResponseHttp.ok("usuario creado", service.crearUsuario(dto));
    }
}
