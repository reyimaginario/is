package com.hexsoft.athos.test;

import java.util.List;
import com.hexsoft.athos.entities.Respuesta;

public interface ICalculador {
    public String procesarRespuestas(List<Respuesta> respuestas);
}