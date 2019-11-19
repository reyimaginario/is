package com.hexsoft.athos.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "sujeto")
public class SujetoDAO {

    @Id
    private String dni;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    private String localidad;

    private String edad;

    private String genero;

    private String nivelDeEstudio;

    private String ocupacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesionalDni")
    @JsonIgnoreProperties("listaSujetos")
    private ProfesionalDAO profesionalDAO;

    @OneToMany(
            mappedBy = "sujetoDAO",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO;


    public SujetoDAO() {
    }

    public SujetoDAO(String dni) {
        this.dni = dni;
    }

    public SujetoDAO(String dni, @NotEmpty String nombre, @NotEmpty String apellido, ProfesionalDAO profesionalDAO, List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesionalDAO = profesionalDAO;
        this.listaEvaluacionesPsicologicasDAO = listaEvaluacionesPsicologicasDAO;
    }


    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public ProfesionalDAO getProfesionalDAO() {
        return profesionalDAO;
    }
    public void setProfesionalDAO(ProfesionalDAO profesionalDAO) {
        this.profesionalDAO = profesionalDAO;
    }
    public List<EvaluacionPsicologicaDAO> getListaEvaluacionesPsicologicasDAO() {
        return listaEvaluacionesPsicologicasDAO;
    }
    public void setListaEvaluacionesPsicologicasDAO(List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO) {
        this.listaEvaluacionesPsicologicasDAO = listaEvaluacionesPsicologicasDAO;
    }

}
