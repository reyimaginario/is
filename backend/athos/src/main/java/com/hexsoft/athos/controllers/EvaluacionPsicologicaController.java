package com.hexsoft.athos.controllers;

import com.hexsoft.athos.dtos.EvaluacionPsicologicaDTO;
import com.hexsoft.athos.dtos.RespuestaTemporalDTO;
import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.RespuestaTemporalDAO;
import com.hexsoft.athos.services.EvaluacionPsicologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
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
