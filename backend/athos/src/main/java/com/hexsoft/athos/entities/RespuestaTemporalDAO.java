package com.hexsoft.athos.entities;

import javax.persistence.*;

@Entity
@Table(name = "respuestaTemporal")
public class RespuestaTemporalDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long respuestaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacionId")
    private EvaluacionPsicologicaDAO evaluacionPsicologicaDAO;

    private String testCode;;

    private Integer pregunta;

    private Integer respuesta;


    public RespuestaTemporalDAO() {
    }

    public RespuestaTemporalDAO(String testCode, Integer pregunta, Integer respuesta) {
        this.testCode = testCode;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public RespuestaTemporalDAO(Long respuestaId, EvaluacionPsicologicaDAO evaluacionPsicologicaDAO, String testCode, Integer pregunta, Integer respuesta) {
        this.respuestaId = respuestaId;
        this.evaluacionPsicologicaDAO = evaluacionPsicologicaDAO;
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
    public EvaluacionPsicologicaDAO getEvaluacionPsicologicaDAO() {
        return evaluacionPsicologicaDAO;
    }
    public void setEvaluacionPsicologicaDAO(EvaluacionPsicologicaDAO evaluacionPsicologicaDAO) {
        this.evaluacionPsicologicaDAO = evaluacionPsicologicaDAO;
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
