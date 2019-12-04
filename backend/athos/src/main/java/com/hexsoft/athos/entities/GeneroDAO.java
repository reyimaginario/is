package com.hexsoft.athos.entities;

import javax.persistence.*;

@Entity
@Table(name = "genero")
public class GeneroDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long generoId;

    private String genero;


    public GeneroDAO() {
    }
    public GeneroDAO(Long generoId) {
        this.generoId = generoId;
    }
    public GeneroDAO(String genero) {
        this.genero = genero;
    }
    public GeneroDAO(Long generoId, String genero) {
        this.generoId = generoId;
        this.genero = genero;
    }

    public Long getGeneroId() {
        return generoId;
    }
    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

}
