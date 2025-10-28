package com.esp.infraestructura.utils.respuesta;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHttp {

    public static <T> ResponseEntity<ResponseHttpModel<T>> ok(String mensaje, T datos) {
        return ResponseEntity.ok(new ResponseHttpModel<>(HttpStatus.OK.value(), mensaje, datos));
    }

    public static <T> ResponseEntity<ResponseHttpModel<T>> creado(String mensaje, T datos) {
        return new ResponseEntity<ResponseHttpModel<T>>(new ResponseHttpModel<>(HttpStatus.CREATED.value(), mensaje, datos), HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<ResponseHttpModel<T>> personalizado(HttpStatus estado, String mensaje, T datos) {
        return new ResponseEntity<>(new ResponseHttpModel<>(estado.value(), mensaje, datos), estado);
    }

    public static <T> ResponseEntity<ResponseHttpModel<T>> sinContenido(String mensaje) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public static ResponseEntity<?> error(String mensaje, int codigoEstado) {
        Map<String, Object> cuerpo = new LinkedHashMap<>();
        cuerpo.put("codigoEstado", codigoEstado);
        cuerpo.put("mensaje", mensaje);
        cuerpo.put("fechaHora", OffsetDateTime.now());
        cuerpo.put("datos", null);
        return ResponseEntity.status(codigoEstado).body(cuerpo);
    }


}
