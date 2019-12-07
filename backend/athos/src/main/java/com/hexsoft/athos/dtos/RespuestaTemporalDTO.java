package com.hexsoft.athos.dtos;

import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.RespuestaTemporalDAO;

public class RespuestaTemporalDTO {

    private Long respuestaTemporalId;
    private Long evaluacionId;
    private String testCode;;
    private Integer pregunta;
    private Integer respuesta;

    public RespuestaTemporalDTO() {
    }
    public RespuestaTemporalDTO(RespuestaTemporalDAO respuestaTemporalDAO) {
        this.respuestaTemporalId = respuestaTemporalDAO.getRespuestaId();
        this.evaluacionId = respuestaTemporalDAO.getEvaluacionPsicologicaDAO().getEvaluacionId();
        this.testCode     = respuestaTemporalDAO.getTestCode();
        this.pregunta     = respuestaTemporalDAO.getPregunta();
        this.respuesta    = respuestaTemporalDAO.getRespuesta();
    }
    public RespuestaTemporalDTO(Long respuestaTemporalId, Long evaluacionId, String testCode, Integer pregunta, Integer respuesta) {
        this.respuestaTemporalId = respuestaTemporalId;
        this.evaluacionId = evaluacionId;
        this.testCode = testCode;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public Long getRespuestaTemporalId() {
        return respuestaTemporalId;
    }
    public void setRespuestaTemporalId(Long respuestaTemporalId) {
        this.respuestaTemporalId = respuestaTemporalId;
    }
    public Long getEvaluacionId() {
        return evaluacionId;
    }
    public void setEvaluacionId(Long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }
    public String getTestCode() {
        return testCode;
    }
    public void setTestCode(String testCode) {
        this.testCode = testCode;
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


    public RespuestaTemporalDAO toDAO() {
        RespuestaTemporalDAO respuestaTemporalDAO = new RespuestaTemporalDAO();
        respuestaTemporalDAO.setRespuestaId(this.getEvaluacionId());
        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = new EvaluacionPsicologicaDAO(this.getEvaluacionId());
        respuestaTemporalDAO.setEvaluacionPsicologicaDAO(evaluacionPsicologicaDAO);
        respuestaTemporalDAO.setTestCode(this.getTestCode());
        respuestaTemporalDAO.setPregunta(this.getPregunta());
        respuestaTemporalDAO.setRespuesta(this.getRespuesta());
        return respuestaTemporalDAO;
    }
}
