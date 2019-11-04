package com.hexsoft.athos.dtos;

import com.hexsoft.athos.entities.RespuestaDAO;
import com.hexsoft.athos.entities.TestAplicadoDAO;

import java.util.List;

public class TestAplicadoDTO {

    private String testCode;
    private List<RespuestaDTO> listaRespuestasDTO;


    public TestAplicadoDTO() {
    }
    public TestAplicadoDTO(TestAplicadoDAO testAplicadoDAO) {
        this.testCode = testAplicadoDAO.getTestCode();
        for (RespuestaDAO respuestaDAO : testAplicadoDAO.getListaRespuestasDAO()) {
            RespuestaDTO respuestaDTO = new RespuestaDTO(respuestaDAO);
            this.listaRespuestasDTO.add(respuestaDTO);
        }
    }
    public TestAplicadoDTO(String testCode, List<RespuestaDTO> listaRespuestasDTO) {
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

}
