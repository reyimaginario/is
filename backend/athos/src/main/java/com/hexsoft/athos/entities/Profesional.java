package com.hexsoft.athos.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "profesional")
public class Profesional {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(unique = true)
    private String dni;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @OneToMany(mappedBy = "profesional")
    private List<Sujeto> sujetos;


    public Profesional() {
    }

    public Profesional(@NotEmpty String dni, @NotEmpty String nombre, @NotEmpty String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Profesional(Long id, @NotEmpty String dni, @NotEmpty String nombre, @NotEmpty String apellido) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
}
