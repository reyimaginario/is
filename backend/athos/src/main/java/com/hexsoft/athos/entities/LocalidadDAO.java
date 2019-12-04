package com.hexsoft.athos.entities;

import javax.persistence.*;

@Entity
@Table(name = "localidad")
public class LocalidadDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long localidadId;

    private String localidad;


    public LocalidadDAO() {
    }
    public LocalidadDAO(Long localidadId) {
        this.localidadId = localidadId;
    }
    public LocalidadDAO(String localidad) {
        this.localidad = localidad;
    }
    public LocalidadDAO(Long localidadId, String localidad) {
        this.localidadId = localidadId;
        this.localidad = localidad;
    }

    public Long getLocalidadId() {
        return localidadId;
    }
    public void setLocalidadId(Long localidadId) {
        this.localidadId = localidadId;
    }
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

}
