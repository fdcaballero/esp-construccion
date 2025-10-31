package com.esp.area.controller;


import com.esp.area.dto.AreaDtoCrear;
import com.esp.area.service.AreaService;
import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/area")
public class AreaController {

    private final AreaService service;

    public AreaController(AreaService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<?> crear(@RequestBody AreaDtoCrear dto) {
        return ResponseHttp.ok("create", service.crearArea(dto));
    }
}
