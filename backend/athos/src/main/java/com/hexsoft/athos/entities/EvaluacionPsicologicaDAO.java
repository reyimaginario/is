package com.hexsoft.athos.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evaluacionPsicologica")
public class EvaluacionPsicologicaDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long evaluacionId;

    private Date fechaInicio;

    private Date fechaFin;

    private String motivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesionalDni")
    private ProfesionalDAO profesionalDAO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sujetoDni")
    private SujetoDAO sujetoDAO;

    @OneToMany(
            mappedBy = "evaluacionPsicologicaDAO",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TestAplicadoDAO> listaTestsAplicadosDAO;

    private String informe;

    @OneToMany(
            mappedBy = "evaluacionPsicologica",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RespuestaTemporalDAO> respuestasTemporalesDAO;


    public EvaluacionPsicologicaDAO() {
    }

    public EvaluacionPsicologicaDAO(Long evaluacionId, Date fechaInicio, Date fechaFin, String motivo, ProfesionalDAO profesionalDAO, SujetoDAO sujetoDAO, List<TestAplicadoDAO> listaTestsAplicadosDAO, String informe, List<RespuestaTemporalDAO> respuestasTemporalesDAO) {
        this.evaluacionId = evaluacionId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.motivo = motivo;
        this.profesionalDAO = profesionalDAO;
        this.sujetoDAO = sujetoDAO;
        this.listaTestsAplicadosDAO = listaTestsAplicadosDAO;
        this.informe = informe;
        this.respuestasTemporalesDAO = respuestasTemporalesDAO;
    }

    public Long getEvaluacionId() {
        return evaluacionId;
    }
    public void setEvaluacionId(Long evaluacionId) {
        this.evaluacionId = evaluacionId;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public ProfesionalDAO getProfesionalDAO() {
        return profesionalDAO;
    }
    public void setProfesionalDAO(ProfesionalDAO profesionalDAO) {
        this.profesionalDAO = profesionalDAO;
    }
    public SujetoDAO getSujetoDAO() {
        return sujetoDAO;
    }
    public void setSujetoDAO(SujetoDAO sujetoDAO) {
        this.sujetoDAO = sujetoDAO;
    }
    public List<TestAplicadoDAO> getListaTestsAplicadosDAO() {
        return listaTestsAplicadosDAO;
    }
    public void setListaTestsAplicadosDAO(List<TestAplicadoDAO> listaTestsAplicadosDAO) {
        this.listaTestsAplicadosDAO = listaTestsAplicadosDAO;
    }
    public String getInforme() {
        return informe;
    }
    public void setInforme(String informe) {
        this.informe = informe;
    }
    public List<RespuestaTemporalDAO> getRespuestasTemporalesDAO() {
        return respuestasTemporalesDAO;
    }
    public void setRespuestasTemporalesDAO(List<RespuestaTemporalDAO> respuestasTemporalesDAO) {
        this.respuestasTemporalesDAO = respuestasTemporalesDAO;
    }

}
