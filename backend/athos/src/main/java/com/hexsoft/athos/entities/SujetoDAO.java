package com.hexsoft.athos.entities;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesionalDni")
    private ProfesionalDAO profesional;

    @OneToMany(
            mappedBy = "sujeto",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EvaluacionPsicologicaDAO> evaluacionesPsicologicas;


    public SujetoDAO() {
    }

    public SujetoDAO(String dni, @NotEmpty String nombre, @NotEmpty String apellido, ProfesionalDAO profesional, List<EvaluacionPsicologicaDAO> evaluacionesPsicologicas) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesional = profesional;
        this.evaluacionesPsicologicas = evaluacionesPsicologicas;
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
    public ProfesionalDAO getProfesional() {
        return profesional;
    }
    public void setProfesional(ProfesionalDAO profesional) {
        this.profesional = profesional;
    }
    public List<EvaluacionPsicologicaDAO> getEvaluacionesPsicologicas() {
        return evaluacionesPsicologicas;
    }
    public void setEvaluacionesPsicologicas(List<EvaluacionPsicologicaDAO> evaluacionesPsicologicas) {
        this.evaluacionesPsicologicas = evaluacionesPsicologicas;
    }

}
