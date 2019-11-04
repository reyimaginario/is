package com.hexsoft.athos.dtos;

import com.hexsoft.athos.entities.RespuestaDAO;

public class RespuestaDTO {

    private Integer pregunta;
    private Integer respuesta;

    public RespuestaDTO() {
    }
    public RespuestaDTO(RespuestaDAO respuestaDAO) {
        this.pregunta  = respuestaDAO.getPregunta();
        this.respuesta = respuestaDAO.getRespuesta();
    }
    public RespuestaDTO(Integer pregunta, Integer respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public Integer getPregunta() {
        return pregunta;
    }
    public void setPregunta(Integer pregunta) {
        this.pregunta = pregunta;
    }
    public Integer getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(Integer respuesta) {
        this.respuesta = respuesta;
    }

}
