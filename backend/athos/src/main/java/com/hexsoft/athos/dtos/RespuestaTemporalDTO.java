package com.hexsoft.athos.dtos;

public class RespuestaTemporalDTO {

    private Long evaluacionId;
    private String testCode;;
    private Integer pregunta;
    private Integer respuesta;

    public RespuestaTemporalDTO() {
    }

    public RespuestaTemporalDTO(Long evaluacionId, String testCode, Integer pregunta, Integer respuesta) {
        this.evaluacionId = evaluacionId;
        this.testCode = testCode;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
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
}
