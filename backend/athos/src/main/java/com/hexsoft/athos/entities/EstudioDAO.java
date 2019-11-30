package com.hexsoft.athos.entities;

import javax.persistence.*;

@Entity
@Table(name = "estudio")
public class EstudioDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long estudioId;

    private String estudio;

    public EstudioDAO() {
    }

    public EstudioDAO(Long estudioId, String estudio) {
        this.estudioId = estudioId;
        this.estudio = estudio;
    }

    public Long getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(Long estudioId) {
        this.estudioId = estudioId;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
}
