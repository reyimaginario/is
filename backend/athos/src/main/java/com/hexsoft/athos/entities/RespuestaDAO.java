package com.hexsoft.athos.entities;

import javax.persistence.*;

@Entity
@Table(name = "respuesta")
public class RespuestaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long respuestaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testAplicadoId")
    private TestAplicadoDAO testAplicadoDAO;

    private Integer pregunta;

    private Integer respuesta;


    public RespuestaDAO() {
    }

    public RespuestaDAO(Long respuestaId, TestAplicadoDAO testAplicadoDAO, Integer pregunta, Integer respuesta) {
        this.respuestaId = respuestaId;
        this.testAplicadoDAO = testAplicadoDAO;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }


    public Long getRespuestaId() {
        return respuestaId;
    }
    public void setRespuestaId(Long respuestaId) {
        this.respuestaId = respuestaId;
    }
    public TestAplicadoDAO getTestAplicadoDAO() {
        return testAplicadoDAO;
    }
    public void setTestAplicadoDAO(TestAplicadoDAO testAplicadoDAO) {
        this.testAplicadoDAO = testAplicadoDAO;
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
