package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.EvaluacionPsicologicaDTO;
import com.hexsoft.athos.dtos.RespuestaTemporalDTO;
import com.hexsoft.athos.services.EvaluacionPsicologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/evaluacion")
public class EvaluacionPsicologicaController {

    @Autowired
    private EvaluacionPsicologicaService evaluacionPsicologicaService;


    @PostMapping
    public EvaluacionPsicologicaDTO crearEvaluacion(@RequestBody EvaluacionPsicologicaDTO evaluacionPsicologicaDTO) {
        return evaluacionPsicologicaService.crearEvaluacion(evaluacionPsicologicaDTO);
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


    @GetMapping(value = "/{evaluacionId}/respuestastemporales")
    public List<RespuestaTemporalDTO> obtenerRespuestasTemporales(@PathVariable(value = "evaluacionId") Long evaluacionId) {
        return evaluacionPsicologicaService.obtenerRespuestasTemporales(evaluacionId);
    }



}
