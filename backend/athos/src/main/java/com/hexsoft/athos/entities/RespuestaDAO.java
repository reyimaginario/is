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
    private TestAplicadoDAO testAplicado;

    private Integer pregunta;

    private Integer respuesta;


    public RespuestaDAO() {
    }

    public RespuestaDAO(Long respuestaId, TestAplicadoDAO testAplicado, Integer pregunta, Integer respuesta) {
        this.respuestaId = respuestaId;
        this.testAplicado = testAplicado;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }


    public Long getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(Long respuestaId) {
        this.respuestaId = respuestaId;
    }

    public TestAplicadoDAO getTestAplicado() {
        return testAplicado;
    }

    public void setTestAplicado(TestAplicadoDAO testAplicado) {
        this.testAplicado = testAplicado;
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
