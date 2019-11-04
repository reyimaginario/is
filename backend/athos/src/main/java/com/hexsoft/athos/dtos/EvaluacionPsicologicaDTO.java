package com.hexsoft.athos.dtos;

import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.TestAplicadoDAO;
import com.hexsoft.athos.utils.FechaUtils;

import java.util.List;

public class EvaluacionPsicologicaDTO {

    private Long evaluacionId;
    private String fechaInicio;
    private String fechaFin;
    private String motivo;
    private ProfesionalDTO profesionalDTO;
    private SujetoDTO sujetoDTO;
    private List<TestAplicadoDTO> listaTestsAplicadosDTO;
    private String informe;


    public EvaluacionPsicologicaDTO() {
    }
    public EvaluacionPsicologicaDTO(EvaluacionPsicologicaDAO evaluacionPsicologicaDAO) {
        this.evaluacionId           = evaluacionPsicologicaDAO.getEvaluacionId();
        this.fechaInicio            = FechaUtils.fechaToString(evaluacionPsicologicaDAO.getFechaInicio());
        this.fechaFin               = FechaUtils.fechaToString(evaluacionPsicologicaDAO.getFechaFin());
        this.motivo                 = evaluacionPsicologicaDAO.getMotivo();
        this.profesionalDTO         = new ProfesionalDTO(evaluacionPsicologicaDAO.getProfesionalDAO());
        this.sujetoDTO              = new SujetoDTO(evaluacionPsicologicaDAO.getSujetoDAO());
        this.informe                = evaluacionPsicologicaDAO.getInforme();
        for (TestAplicadoDAO testAplicadoDAO: evaluacionPsicologicaDAO.getListaTestsAplicadosDAO()) {
            TestAplicadoDTO testAplicadoDTO = new TestAplicadoDTO(testAplicadoDAO);
            this.listaTestsAplicadosDTO.add(testAplicadoDTO);
        }
    }
    public EvaluacionPsicologicaDTO(Long evaluacionId, String fechaInicio, String fechaFin, String motivo, ProfesionalDTO profesionalDTO, SujetoDTO sujetoDTO, List<TestAplicadoDTO> listaTestsAplicadosDTO, String informe) {
        this.evaluacionId = evaluacionId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.motivo = motivo;
        this.profesionalDTO = profesionalDTO;
        this.sujetoDTO = sujetoDTO;
        this.listaTestsAplicadosDTO = listaTestsAplicadosDTO;
        this.informe = informe;
    }

    public Long getEvaluacionId() {
        return evaluacionId;
    }
    public void setEvaluacionId(Long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public ProfesionalDTO getProfesionalDTO() {
        return profesionalDTO;
    }
    public void setProfesionalDTO(ProfesionalDTO profesionalDTO) {
        this.profesionalDTO = profesionalDTO;
    }
    public SujetoDTO getSujetoDTO() {
        return sujetoDTO;
    }
    public void setSujetoDTO(SujetoDTO sujetoDTO) {
        this.sujetoDTO = sujetoDTO;
    }
    public List<TestAplicadoDTO> getListaTestsAplicadosDTO() {
        return listaTestsAplicadosDTO;
    }
    public void setListaTestsAplicadosDTO(List<TestAplicadoDTO> listaTestsAplicadosDTO) {
        this.listaTestsAplicadosDTO = listaTestsAplicadosDTO;
    }
    public String getInforme() {
        return informe;
    }
    public void setInforme(String informe) {
        this.informe = informe;
    }

}
