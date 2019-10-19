package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.RespuestaTemporalDAO;
import com.hexsoft.athos.repositories.IRespuestaTemporalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaTemporalService {

    @Autowired
    private IRespuestaTemporalRepo respuestaTemporalRepo;


    public RespuestaTemporalDAO guardarRespuestaTemporal(RespuestaTemporalDAO respuestaTemporal) {
        return respuestaTemporalRepo.save(respuestaTemporal);
    }
}
