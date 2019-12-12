package com.hexsoft.athos.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "sujeto")
public class SujetoDAO {

    @Id
    @Column(length = 10)
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
    public SujetoDAO(String dni, @NotEmpty String nombre, @NotEmpty String apellido, String localidad, String edad, String genero, String nivelDeEstudio, String ocupacion, ProfesionalDAO profesionalDAO, List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.localidad = localidad;
        this.edad = edad;
        this.genero = genero;
        this.nivelDeEstudio = nivelDeEstudio;
        this.ocupacion = ocupacion;
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
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getNivelDeEstudio() {
        return nivelDeEstudio;
    }
    public void setNivelDeEstudio(String nivelDeEstudio) {
        this.nivelDeEstudio = nivelDeEstudio;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
}
