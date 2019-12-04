package com.hexsoft.athos.entities;

import javax.persistence.*;

@Entity
@Table(name = "ocupacion")
public class OcupacionDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ocupacionId;

    private String ocupacion;


    public OcupacionDAO() {
    }
    public OcupacionDAO(Long ocupacionId) {
        this.ocupacionId = ocupacionId;
    }
    public OcupacionDAO(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public OcupacionDAO(Long ocupacionId, String ocupacion) {
        this.ocupacionId = ocupacionId;
        this.ocupacion = ocupacion;
    }


    public Long getOcupacionId() {
        return ocupacionId;
    }
    public void setOcupacionId(Long ocupacionId) {
        this.ocupacionId = ocupacionId;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

}
