package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.EvaluacionPsicologicaDTO;
import com.hexsoft.athos.dtos.RespuestaTemporalDTO;
import com.hexsoft.athos.dtos.wrapper.ListaRespuestasTemporalesDTO;
import com.hexsoft.athos.exceptions.NoExisteElProfesionalException;
import com.hexsoft.athos.services.EvaluacionPsicologicaService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/evaluacion")
public class EvaluacionPsicologicaController {

    @Autowired
    private EvaluacionPsicologicaService evaluacionPsicologicaService;


    @PostMapping
    public ResponseEntity<EvaluacionPsicologicaDTO> crearEvaluacion(@RequestBody EvaluacionPsicologicaDTO evaluacionPsicologicaDTO) {
        EvaluacionPsicologicaDTO evaluacionPsicologicaDTOTmp = null;
        try {
            evaluacionPsicologicaDTOTmp =  evaluacionPsicologicaService.crearEvaluacion(evaluacionPsicologicaDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(evaluacionPsicologicaDTOTmp);
        }
        catch (NoExisteElProfesionalException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Mensaje", e.getMessage())
                    .body(null);
        }

    }


    @GetMapping
    public List<EvaluacionPsicologicaDTO> obtenerEvaluaciones() {
        return evaluacionPsicologicaService.obtenerEvaluaciones();
    }


    @GetMapping(value = "/{evaluacionId}")
    public EvaluacionPsicologicaDTO obtenerEvaluacion(@PathVariable(value = "evaluacionId") Long evaluacionId) {
        return evaluacionPsicologicaService.obtenerEvaluacion(evaluacionId);
    }


    @GetMapping(value = "/{evaluacionId}/finalizar")
    public EvaluacionPsicologicaDTO finalizarEvaluacion(@PathVariable(value = "evaluacionId") Long evaluacionId) {
        return evaluacionPsicologicaService.finalizarEvaluacion(evaluacionId);
    }


    @PostMapping(value = "/respuestaTemporal")
    public boolean guardarRespuestaTemporal(@RequestBody RespuestaTemporalDTO respuestaTemporalDTO) {
        return evaluacionPsicologicaService.guardarRespuestaTemporal(respuestaTemporalDTO);
    }


    @PostMapping(value = "/guardarRespuestasTemporales")
    public boolean guardarTodasLasRespuestasTemporales(@RequestBody ListaRespuestasTemporalesDTO listaRespuestasTemporalesDTO) {
        return evaluacionPsicologicaService.guardarTodasLasRespuestasTemporales(listaRespuestasTemporalesDTO);
    }


    @GetMapping(value = "/{evaluacionId}/respuestastemporales")
    public List<RespuestaTemporalDTO> obtenerRespuestasTemporales(@PathVariable(value = "evaluacionId") Long evaluacionId) {
        return evaluacionPsicologicaService.obtenerRespuestasTemporales(evaluacionId);
    }


    @GetMapping(value = "/{evaluacionId}/calcular")
    public List<JSONObject> calularEvaluacion(@PathVariable(value = "evaluacionId") Long evaluacionId) {
        return evaluacionPsicologicaService.calcularEvaluacion(evaluacionId);
    }

}
