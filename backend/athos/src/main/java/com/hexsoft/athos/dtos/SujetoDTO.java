package com.hexsoft.athos.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hexsoft.athos.entities.ProfesionalDAO;
import com.hexsoft.athos.entities.SujetoDAO;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties("listaSujetos")
public class SujetoDTO {

    private String dni;
    private String nombre;
    private String apellido;
    private String localidad;
    private String edad;
    private String genero;
    private String nivelDeEstudio;
    private String ocupacion;
    private ProfesionalDTO profesionalDTO;


    public SujetoDTO() {
    }
    public SujetoDTO(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public SujetoDTO(String dni, String nombre, String apellido, ProfesionalDTO profesionalDTO) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesionalDTO = profesionalDTO;
    }
    public SujetoDTO(String dni, String nombre, String apellido, String localidad, String edad, String genero, String nivelDeEstudio, String ocupacion, ProfesionalDTO profesionalDTO) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.localidad = localidad;
        this.edad = edad;
        this.genero = genero;
        this.nivelDeEstudio = nivelDeEstudio;
        this.ocupacion = ocupacion;
        this.profesionalDTO = profesionalDTO;
    }
    public SujetoDTO(SujetoDAO sujetoDAO) {

        String profesionalDni = sujetoDAO.getProfesionalDAO().getDni();
        String profesionalNombre = sujetoDAO.getProfesionalDAO().getNombre();
        String profesionalApellido = sujetoDAO.getProfesionalDAO().getApellido();
        String profesionalMatricula = sujetoDAO.getProfesionalDAO().getMatricula();
        List<SujetoDTO> profesionalListaSujetos = new ArrayList<>();

        ProfesionalDTO profesionalDTO = new ProfesionalDTO(profesionalDni, profesionalNombre, profesionalApellido, profesionalMatricula, profesionalListaSujetos);

        this.dni = sujetoDAO.getDni();
        this.nombre = sujetoDAO.getNombre();
        this.apellido = sujetoDAO.getApellido();
        this.profesionalDTO = profesionalDTO;
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
    public ProfesionalDTO getProfesionalDTO() {
        ProfesionalDTO profesionalTmp = this.profesionalDTO.sinSujetos();
        return profesionalTmp;
    }
    public void setProfesionalDTO(ProfesionalDTO profesionalDTO) {
        this.profesionalDTO = profesionalDTO;
    }


    public SujetoDTO sinProfesional() {
        SujetoDTO sujetoTmp = new SujetoDTO(this.getDni()
                                            ,this.getNombre()
                                            ,this.getApellido()
                                            ,new ProfesionalDTO());
        return sujetoTmp;
    }

    public SujetoDAO toDAO() {
        ProfesionalDAO profesionalDAO = new ProfesionalDAO(getProfesionalDTO().getDni());
        SujetoDAO sujetoDAO = new SujetoDAO(getDni(), getNombre(), getApellido(), profesionalDAO, null);
        return sujetoDAO;
    }



}
