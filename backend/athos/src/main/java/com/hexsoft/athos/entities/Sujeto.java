package com.hexsoft.athos.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sujeto")
public class Sujeto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_sujeto_profesional", nullable = false, updatable = false)
    private Profesional profesional;

    @NotEmpty
    @Column(unique = true)
    private String dni;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;


    public Sujeto() {
    }

    public Sujeto(@NotEmpty String dni, @NotNull Profesional profesional, @NotEmpty String nombre, @NotEmpty String apellido) {
        this.dni = dni;
        this.profesional = profesional;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Sujeto(Long id, @NotEmpty String dni, @NotNull Profesional profesional, @NotEmpty String nombre, @NotEmpty String apellido) {
        this.id = id;
        this.profesional = profesional;
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
