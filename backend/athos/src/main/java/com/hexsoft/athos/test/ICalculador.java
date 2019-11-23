package com.hexsoft.athos.test;

import java.util.List;

import org.json.simple.JSONObject;

import com.hexsoft.athos.entities.RespuestaDAO;

public interface ICalculador {
    public JSONObject procesarRespuestas(List<RespuestaDAO> respuestas);
}