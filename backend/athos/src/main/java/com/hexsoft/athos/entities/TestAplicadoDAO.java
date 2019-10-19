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
            mappedBy = "testAplicado",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RespuestaDAO> listaRespuestas;


    public TestAplicadoDAO() {
    }

    public TestAplicadoDAO(Long testAplicadoId, String testCode, List<RespuestaDAO> listaRespuestas) {
        this.testAplicadoId = testAplicadoId;
        this.testCode = testCode;
        this.listaRespuestas = listaRespuestas;
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

    public List<RespuestaDAO> getListaRespuestas() {
        return listaRespuestas;
    }

    public void setListaRespuestas(List<RespuestaDAO> listaRespuestas) {
        this.listaRespuestas = listaRespuestas;
    }

}
