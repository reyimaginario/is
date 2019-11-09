package com.hexsoft.athos.dtos;

import com.hexsoft.athos.entities.RespuestaDAO;
import com.hexsoft.athos.entities.TestAplicadoDAO;

import java.util.ArrayList;
import java.util.List;

public class TestAplicadoDTO {

    private Long testAplicadoId;
    private String testCode;
    private List<RespuestaDTO> listaRespuestasDTO;


    public TestAplicadoDTO() {
    }
    public TestAplicadoDTO(TestAplicadoDAO testAplicadoDAO) {
        this.testCode = testAplicadoDAO.getTestCode();
        this.listaRespuestasDTO = new ArrayList<>();
        for (RespuestaDAO respuestaDAO : testAplicadoDAO.getListaRespuestasDAO()) {
            RespuestaDTO respuestaDTO = new RespuestaDTO(respuestaDAO);
            this.listaRespuestasDTO.add(respuestaDTO);
        }
    }
    public TestAplicadoDTO(Long testAplicadoId, String testCode, List<RespuestaDTO> listaRespuestasDTO) {
        this.testAplicadoId = testAplicadoId;
        this.testCode = testCode;
        this.listaRespuestasDTO = listaRespuestasDTO;
    }

    public String getTestCode() {
        return testCode;
    }
    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }
    public List<RespuestaDTO> getListaRespuestasDTO() {
        return listaRespuestasDTO;
    }
    public void setListaRespuestasDTO(List<RespuestaDTO> listaRespuestasDTO) {
        this.listaRespuestasDTO = listaRespuestasDTO;
    }
    public Long getTestAplicadoId() {
        return testAplicadoId;
    }
    public void setTestAplicadoId(Long testAplicadoId) {
        this.testAplicadoId = testAplicadoId;
    }



    public TestAplicadoDAO toDAO() {
        TestAplicadoDAO testAplicadoDAO = new TestAplicadoDAO();
        List<RespuestaDAO> listaRespuestasDAOTmp = new ArrayList<>();
        if (getListaRespuestasDTO() != null) {
            for (RespuestaDTO respuestaDTO : getListaRespuestasDTO()) {
                RespuestaDAO respuestaDAO = respuestaDTO.toDAO();
                listaRespuestasDAOTmp.add(respuestaDAO);
            }
        }
        testAplicadoDAO.setTestAplicadoId(getTestAplicadoId());
        testAplicadoDAO.setTestCode(getTestCode());
        testAplicadoDAO.setListaRespuestasDAO(listaRespuestasDAOTmp);
        return testAplicadoDAO;
    }

}
