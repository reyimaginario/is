package com.hexsoft.athos.controllers;

import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.RespuestaTemporalDAO;
import com.hexsoft.athos.services.EvaluacionPsicologicaService;
import com.hexsoft.athos.services.RespuestaTemporalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/evaluacion")
public class EvaluacionController {

    @Autowired
    private EvaluacionPsicologicaService evaluacionPsicologicaService;

    @Autowired
    private RespuestaTemporalService respuestaTemporalService;


    @PostMapping(value = "/respuestaTemporal")
    public RespuestaTemporalDAO guardarRespuestaTemporal(@RequestBody RespuestaTemporalDAO respuestaTemporal) {
        return respuestaTemporalService.guardarRespuestaTemporal(respuestaTemporal);
    }


    @GetMapping(value = "/porSujeto/{dni}")
    public List<EvaluacionPsicologicaDAO> listarEvaluacionesPorSujeto(@RequestBody )



}
