package com.esp.vacante.controller;

import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.infraestructura.utils.respuesta.ResponseHttpModel;
import com.esp.vacante.dto.VacanteDtoConsulta;
import com.esp.vacante.service.VacanteConsultaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vacancy")
public class VacanteConsultaController {

    private final VacanteConsultaServicio servicio;

    public VacanteConsultaController(VacanteConsultaServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/get-all")
    public ResponseEntity<ResponseHttpModel<List<VacanteDtoConsulta>>>
    consultarVacantes(@RequestParam(defaultValue = "v.id_vacante") String campoOrden,
                      @RequestParam(defaultValue = "ASC") String tipoOrden) {
        List<VacanteDtoConsulta> resultado = servicio.consultaVacantes(campoOrden, tipoOrden);
        if (resultado.isEmpty()) return ResponseHttp.sinContenido("No hay datos para mostrar");
        return ResponseHttp.ok("Estas son", resultado);
    }
}
