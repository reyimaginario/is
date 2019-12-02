package com.hexsoft.athos.entities;

public class SujetoAnonimo {

    private String localidad;
    private String edad;
    private String genero;
    private String nivelDeEstudio;
    private String ocupacion;

    public SujetoAnonimo(String localidad, String edad, String genero, String nivelDeEstudio, String ocupacion) {
        this.localidad = localidad;
        this.edad = edad;
        this.genero = genero;
        this.nivelDeEstudio = nivelDeEstudio;
        this.ocupacion = ocupacion;
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
