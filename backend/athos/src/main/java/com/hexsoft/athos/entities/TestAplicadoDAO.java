package com.hexsoft.athos.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "testAplicado")
public class TestAplicadoDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long testAplicadoId;

    private String testCode;

    @OneToMany(
            mappedBy = "testAplicadoDAO",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RespuestaDAO> listaRespuestasDAO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacionId")
    private EvaluacionPsicologicaDAO evaluacionPsicologicaDAO;


    public TestAplicadoDAO() {
    }
    public TestAplicadoDAO(String testCode, List<RespuestaDAO> listaRespuestasDAO, EvaluacionPsicologicaDAO evaluacionPsicologicaDAO) {
        this.testCode = testCode;
        this.listaRespuestasDAO = listaRespuestasDAO;
        this.evaluacionPsicologicaDAO = evaluacionPsicologicaDAO;
    }
    public TestAplicadoDAO(Long testAplicadoId, String testCode, List<RespuestaDAO> listaRespuestasDAO, EvaluacionPsicologicaDAO evaluacionPsicologicaDAO) {
        this.testAplicadoId = testAplicadoId;
        this.testCode = testCode;
        this.listaRespuestasDAO = listaRespuestasDAO;
        this.evaluacionPsicologicaDAO = evaluacionPsicologicaDAO;
    }


    public Long getTestAplicadoId() {
        return testAplicadoId;
    }
    public void setTestAplicadoId(Long testAplicadoId) {
        this.testAplicadoId = testAplicadoId;
    }
    public String getTestCode() {
        return testCode;
    }
    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }
    public List<RespuestaDAO> getListaRespuestasDAO() {
        return listaRespuestasDAO;
    }
    public void setListaRespuestasDAO(List<RespuestaDAO> listaRespuestasDAO) {
        this.listaRespuestasDAO = listaRespuestasDAO;
    }
    public EvaluacionPsicologicaDAO getEvaluacionPsicologicaDAO() {
        return evaluacionPsicologicaDAO;
    }
    public void setEvaluacionPsicologicaDAO(EvaluacionPsicologicaDAO evaluacionPsicologicaDAO) {
        this.evaluacionPsicologicaDAO = evaluacionPsicologicaDAO;
    }

}
