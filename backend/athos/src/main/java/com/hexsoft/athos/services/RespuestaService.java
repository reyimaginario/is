package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.RespuestaTemporalDAO;
import com.hexsoft.athos.repositories.IRespuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private IRespuestaRepo respuestaRepo;

    @Autowired
    private TestAplicadoService testAplicadoService;


    public void persistirRespuestaTemporal(RespuestaTemporalDAO respuestaTemporalDAO) {
        Integer pregunta = respuestaTemporalDAO.getPregunta();
        Integer respuesta = respuestaTemporalDAO.getRespuesta();

    }

}
