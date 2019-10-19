package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.RespuestaTemporalDAO;
import com.hexsoft.athos.repositories.IEvaluacionPsicologicaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluacionPsicologicaService {

    @Autowired
    private IEvaluacionPsicologicaRepo evaluacionPsicologicaRepo;


    public EvaluacionPsicologicaDAO guardarEvaluacion(EvaluacionPsicologicaDAO evaluacion) {
        return evaluacionPsicologicaRepo.save(evaluacion);
    }

    public RespuestaTemporalDAO guardarRespuestaTemporal(RespuestaTemporalDAO respuestaTemporal) {
        return e
    }

}
