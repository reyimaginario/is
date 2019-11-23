package com.hexsoft.athos.dtos;

import com.hexsoft.athos.entities.RespuestaDAO;

public class RespuestaDTO {

    private Long respuestaId;
    private Integer pregunta;
    private Integer respuesta;

    public RespuestaDTO() {
    }
    public RespuestaDTO(RespuestaDAO respuestaDAO) {
        this.respuestaId = respuestaDAO.getRespuestaId();
        this.pregunta    = respuestaDAO.getPregunta();
        this.respuesta   = respuestaDAO.getRespuesta();
    }
    public RespuestaDTO(Long respuestaId, Integer pregunta, Integer respuesta) {
        this.respuestaId = respuestaId;
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
    public Long getRespuestaId() {
        return respuestaId;
    }
    public void setRespuestaId(Long respuestaId) {
        this.respuestaId = respuestaId;
    }

    public RespuestaDAO toDAO() {
        RespuestaDAO respuestaDAO = new RespuestaDAO();
        respuestaDAO.setRespuestaId(getRespuestaId());
        respuestaDAO.setPregunta(getPregunta());
        respuestaDAO.setRespuesta(getRespuesta());
        return respuestaDAO;
    }
}
