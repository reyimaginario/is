package com.hexsoft.athos.dtos;

public class FiltroBaremoDTO {

    private String localidad;
    private String edadDesde;
    private String edadHasta;
    private String genero;
    private String nivelDeEstudio;
    private String ocupacion;


    public FiltroBaremoDTO() {
    }
    public FiltroBaremoDTO(String localidad, String edadDesde, String edadHasta, String genero, String nivelDeEstudio, String ocupacion) {
        this.localidad = localidad;
        this.edadDesde = edadDesde;
        this.edadHasta = edadHasta;
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
    public String getEdadDesde() {
        return edadDesde;
    }
    public void setEdadDesde(String edadDesde) {
        this.edadDesde = edadDesde;
    }
    public String getEdadHasta() {
        return edadHasta;
    }
    public void setEdadHasta(String edadHasta) {
        this.edadHasta = edadHasta;
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
