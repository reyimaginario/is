package com.hexsoft.athos.entities;

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

    @OneToMany(
            mappedBy = "profesional",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SujetoDAO> sujetos;


    public ProfesionalDAO() {
    }

    public ProfesionalDAO(String dni, @NotEmpty String nombre, @NotEmpty String apellido, List<SujetoDAO> sujetos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sujetos = sujetos;
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
    public List<SujetoDAO> getSujetos() {
        return sujetos;
    }
    public void setSujetos(List<SujetoDAO> sujetos) {
        this.sujetos = sujetos;
    }

}
