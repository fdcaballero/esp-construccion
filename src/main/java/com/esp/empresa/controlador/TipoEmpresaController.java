package com.esp.empresa.controlador;


import com.esp.empresa.dto.TipoEmpresaDtoCrear;
import com.esp.empresa.dto.TipoEmpresaRespuestaDto;
import com.esp.empresa.service.TipoEmpresaService;
import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.infraestructura.utils.respuesta.ResponseHttpModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company-type")
@CrossOrigin(origins = "*")
public class TipoEmpresaController {

    private final TipoEmpresaService service;

    public TipoEmpresaController(TipoEmpresaService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseHttpModel<TipoEmpresaRespuestaDto>>crearTipoEmpresa(@RequestBody TipoEmpresaDtoCrear dto) {
        return ResponseHttp.ok("message",service.crearTipoEmpresa(dto));
    }
}
