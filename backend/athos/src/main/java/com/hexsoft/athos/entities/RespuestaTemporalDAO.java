package com.hexsoft.athos.entities;

import javax.persistence.*;

@Entity
@Table(name = "respuestaTemporal")
public class RespuestaTemporalDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long respuestaId;

    private EvaluacionPsicologicaDAO evaluacionPsicologica;

    private String testCode;;

    private Integer pregunta;

    private Integer respuesta;


    public RespuestaTemporalDAO() {
    }
    public RespuestaTemporalDAO(Long respuestaId, EvaluacionPsicologicaDAO evaluacionPsicologica, String testCode, Integer pregunta, Integer respuesta) {
        this.respuestaId = respuestaId;
        this.evaluacionPsicologica = evaluacionPsicologica;
        this.testCode = testCode;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }
    public Long getRespuestaId() {
        return respuestaId;
    }
    public void setRespuestaId(Long respuestaId) {
        this.respuestaId = respuestaId;
    }
    public EvaluacionPsicologicaDAO getEvaluacionPsicologica() {
        return evaluacionPsicologica;
    }
    public void setEvaluacionPsicologica(EvaluacionPsicologicaDAO evaluacionPsicologica) {
        this.evaluacionPsicologica = evaluacionPsicologica;
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
