package com.hexsoft.athos.controllers;

import com.hexsoft.athos.entities.RespuestaTemporalDAO;
import com.hexsoft.athos.services.EvaluacionPsicologicaService;
import com.hexsoft.athos.services.RespuestaTemporalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}
