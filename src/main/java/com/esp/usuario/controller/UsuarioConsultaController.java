package com.esp.usuario.controller;

import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.infraestructura.utils.respuesta.ResponseHttpModel;
import com.esp.usuario.dto.UsuarioDtoConsulta;
import com.esp.usuario.service.UsuarioConsultaService;
import com.esp.vacante.dto.VacanteDtoConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsuarioConsultaController {

    private final UsuarioConsultaService service;


    public UsuarioConsultaController(UsuarioConsultaService service) {
        this.service = service;
    }


    @GetMapping("/get-all")
    public ResponseEntity<ResponseHttpModel<List<UsuarioDtoConsulta>>>
    consultarUsuarios(@RequestParam(defaultValue = "u.id_usuario") String campoOrden,
                      @RequestParam(defaultValue = "ASC") String tipoOrden) {
        List<UsuarioDtoConsulta> resultado = service.consultaUsuarios(campoOrden, tipoOrden);
        if (resultado.isEmpty()) return ResponseHttp.sinContenido("No hay datos para mostrar");
        return ResponseHttp.ok("usuarios", resultado);
    }
}
