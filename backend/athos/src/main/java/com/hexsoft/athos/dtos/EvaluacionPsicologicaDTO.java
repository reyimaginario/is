package com.hexsoft.athos.dtos;

import com.hexsoft.athos.entities.EvaluacionPsicologicaDAO;
import com.hexsoft.athos.entities.ProfesionalDAO;
import com.hexsoft.athos.entities.SujetoDAO;
import com.hexsoft.athos.entities.TestAplicadoDAO;
import com.hexsoft.athos.utils.FechaUtils;

import java.util.ArrayList;
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
    private Integer finalizado;


    public EvaluacionPsicologicaDTO() {
    }
    public EvaluacionPsicologicaDTO(EvaluacionPsicologicaDAO evaluacionPsicologicaDAO) {
        this.evaluacionId           = evaluacionPsicologicaDAO.getEvaluacionId();
        this.motivo                 = evaluacionPsicologicaDAO.getMotivo();
        //this.profesionalDTO         = new ProfesionalDTO(evaluacionPsicologicaDAO.getProfesionalDAO());  // TODO borrar si funciona
        //this.profesionalDTO         = (new ProfesionalDTO(evaluacionPsicologicaDAO.getProfesionalDAO())).sinSujetos();
        this.profesionalDTO         = new ProfesionalDTO(evaluacionPsicologicaDAO.getProfesionalDAO().getDni());
        //this.sujetoDTO              = new SujetoDTO(evaluacionPsicologicaDAO.getSujetoDAO());  // TODO borar si funciona
        //this.sujetoDTO              = (new SujetoDTO(evaluacionPsicologicaDAO.getSujetoDAO())).sinProfesionalNiEvaluaciones();
        this.sujetoDTO              = new SujetoDTO(evaluacionPsicologicaDAO.getSujetoDAO().getDni());
        this.informe                = evaluacionPsicologicaDAO.getInforme();
        this.listaTestsAplicadosDTO = new ArrayList<>();
        this.finalizado             = evaluacionPsicologicaDAO.getFinalizado();
        if (evaluacionPsicologicaDAO.getFechaInicio() != null) {
            this.fechaInicio = FechaUtils.fechaToString(evaluacionPsicologicaDAO.getFechaInicio());
        }
        if (evaluacionPsicologicaDAO.getFechaFin() != null) {
            this.fechaFin = FechaUtils.fechaToString(evaluacionPsicologicaDAO.getFechaFin());
        }
        for (TestAplicadoDAO testAplicadoDAO: evaluacionPsicologicaDAO.getListaTestsAplicadosDAO()) {
            TestAplicadoDTO testAplicadoDTO = new TestAplicadoDTO(testAplicadoDAO);
            this.listaTestsAplicadosDTO.add(testAplicadoDTO);
        }
    }
    public EvaluacionPsicologicaDTO(Long evaluacionId, String fechaInicio, String fechaFin, String motivo, ProfesionalDTO profesionalDTO, SujetoDTO sujetoDTO, List<TestAplicadoDTO> listaTestsAplicadosDTO, String informe, Integer finalizado) {
        this.evaluacionId = evaluacionId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.motivo = motivo;
        this.profesionalDTO = profesionalDTO;
        this.sujetoDTO = sujetoDTO;
        this.listaTestsAplicadosDTO = listaTestsAplicadosDTO;
        this.informe = informe;
        this.finalizado = finalizado;
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
        SujetoDTO sujetoDTOTmp = this.sujetoDTO.sinProfesionalNiEvaluaciones();
        return sujetoDTOTmp;
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
    public Integer getFinalizado() {
        return finalizado;
    }
    public void setFinalizado(Integer finalizado) {
        this.finalizado = finalizado;
    }


    public EvaluacionPsicologicaDTO sinSujetoNiProfesional() {
        EvaluacionPsicologicaDTO evaluacionTmp = new EvaluacionPsicologicaDTO(getEvaluacionId()
                                                                            , getFechaInicio()
                                                                            , getFechaFin()
                                                                            , getMotivo()
                                                                            , new ProfesionalDTO()
                                                                            , new SujetoDTO()
                                                                            , getListaTestsAplicadosDTO()
                                                                            , getInforme()
                                                                            , getFinalizado());
        return evaluacionTmp;
    }

    public EvaluacionPsicologicaDAO toDAO() {
        ProfesionalDAO profesionalDAO = new ProfesionalDAO(getProfesionalDTO().getDni());
        SujetoDAO sujetoDAO = new SujetoDAO(getSujetoDTO().getDni());
        List<TestAplicadoDAO> listaTestsAplicadosDAO = new ArrayList<>();
        for (TestAplicadoDTO testAplicadoDTO : getListaTestsAplicadosDTO()) {
            TestAplicadoDAO testAplicadoDAO = testAplicadoDTO.toDAO();
            listaTestsAplicadosDAO.add(testAplicadoDAO);
        }

        EvaluacionPsicologicaDAO evaluacionPsicologicaDAO = new EvaluacionPsicologicaDAO( getEvaluacionId()
                , FechaUtils.stringToDate(getFechaInicio())
                , FechaUtils.stringToDate(getFechaFin())
                , getMotivo()
                , profesionalDAO
                , sujetoDAO
                , listaTestsAplicadosDAO
                , getInforme()
                , getFinalizado());

        return evaluacionPsicologicaDAO;
    }
}
