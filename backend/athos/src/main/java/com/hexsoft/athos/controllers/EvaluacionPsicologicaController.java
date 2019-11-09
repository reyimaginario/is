package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.EvaluacionPsicologicaDTO;
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

    @GetMapping(value = "/finalizar/{evaluacionId}")
    public EvaluacionPsicologicaDTO finalizarEvaluacion(@PathVariable(value = "evaluacionId") Long evaluacionId) {
        return evaluacionPsicologicaService.finalizarEvaluacion(evaluacionId);
    }

/*
    @PostMapping(value = "/respuestaTemporal")
    public boolean guardarRespuestaTemporal(@RequestBody RespuestaTemporalDTO respuestaTemporal) {
        return evaluacionPsicologicaService.guardarRespuestaTemporal(respuestaTemporal);
    }

 */

/*
    @GetMapping(value = "/porSujeto/{dni}")
    public List<EvaluacionPsicologicaDAO> listarEvaluacionesPorSujeto(@PathVariable(value = "dni") String dni) {
        return evaluacionPsicologicaService.obtenerEvaluacionesPsicologicas(dni);
    }

 */

/*
    @GetMapping(value = "/finalizar")
    public EvaluacionPsicologicaDAO finalizarEvaluacion(@RequestBody )
*/


}
