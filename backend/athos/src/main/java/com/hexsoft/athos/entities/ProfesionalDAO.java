package com.hexsoft.athos.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "profesional")
public class ProfesionalDAO {

    @Id
    private String dni;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    private String matricula;

    @OneToMany(
            mappedBy = "profesionalDAO",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties({"profesional", "hibernateLazyInitializer", "handler"})
    private List<SujetoDAO> listaSujetosDAO;

    @OneToMany(
            mappedBy = "profesional",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO;


    public ProfesionalDAO() {
    }

    public ProfesionalDAO(String dni) {
        this.dni = dni;
    }

    public ProfesionalDAO(String dni, @NotEmpty String nombre, @NotEmpty String apellido, String matricula, List<SujetoDAO> listaSujetosDAO, List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.listaSujetosDAO = listaSujetosDAO;
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
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public List<SujetoDAO> getListaSujetosDAO() {
        return listaSujetosDAO;
    }
    public void setListaSujetosDAO(List<SujetoDAO> listaSujetosDAO) {
        this.listaSujetosDAO = listaSujetosDAO;
    }
    public List<EvaluacionPsicologicaDAO> getListaEvaluacionesPsicologicasDAO() {
        return listaEvaluacionesPsicologicasDAO;
    }
    public void setListaEvaluacionesPsicologicasDAO(List<EvaluacionPsicologicaDAO> listaEvaluacionesPsicologicasDAO) {
        this.listaEvaluacionesPsicologicasDAO = listaEvaluacionesPsicologicasDAO;
    }


}
