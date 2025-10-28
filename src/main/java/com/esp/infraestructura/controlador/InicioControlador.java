package com.esp.infraestructura.controlador;


import com.esp.infraestructura.utils.respuesta.ResponseHttp;
import com.esp.infraestructura.utils.respuesta.ResponseHttpModel;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class InicioControlador {


    private final Environment environment;

    public InicioControlador(Environment environment) {
        this.environment = environment;
    }


    private Map<String,Object> construirRespuesta(){

        Map<String, Object > map = new LinkedHashMap<>();
        map.put("name", "Backend de especializacion 2025");
        map.put("version", "0.2.0");
        map.put("estado", "En desarrollo");
        map.put("Profiles SpringBoot", environment.getActiveProfiles());
        return map;

    }
    @GetMapping("/")
    public ResponseEntity<ResponseHttpModel<Map<String,Object>>> inicio() {
        return ResponseHttp.ok("Servicio iniciado correctamente ✅", construirRespuesta());
    }

}
