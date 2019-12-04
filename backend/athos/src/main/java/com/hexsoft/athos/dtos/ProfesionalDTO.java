package com.hexsoft.athos.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hexsoft.athos.entities.ProfesionalDAO;
import com.hexsoft.athos.entities.SujetoDAO;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties("profesionalDTO")
    public class ProfesionalDTO {

        private String dni;
        private String nombre;
        private String apellido;
        private String matricula;
        private List<SujetoDTO> listaSujetosDTO;

    public ProfesionalDTO() {
    }
    public ProfesionalDTO(String dni) {
        this.dni = dni;
        this.listaSujetosDTO = new ArrayList<>();
    }
    public ProfesionalDTO(String dni, String nombre, String apellido, String matricula, List<SujetoDTO> listaSujetosDTO) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.listaSujetosDTO = listaSujetosDTO;
    }
    public ProfesionalDTO(ProfesionalDAO profesionalDAO) {

        List<SujetoDTO> listaSujetosDTO = new ArrayList<>();

        if (profesionalDAO.getListaSujetosDAO() != null){
            for (SujetoDAO sujetoDAO : profesionalDAO.getListaSujetosDAO()) {
                SujetoDTO sujetoDTO = (new SujetoDTO(sujetoDAO)).sinProfesionalNiEvaluaciones();
                listaSujetosDTO.add(sujetoDTO);
            }
        }

        this.dni = profesionalDAO.getDni();
        this.nombre = profesionalDAO.getNombre();
        this.apellido = profesionalDAO.getApellido();
        this.matricula = profesionalDAO.getMatricula();
        this.listaSujetosDTO = listaSujetosDTO;
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
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public List<SujetoDTO> getListaSujetosDTO() {

        List<SujetoDTO> listaSujetosTmp = new ArrayList<>();

        if (this.listaSujetosDTO != null) {
            for (SujetoDTO sujetoDTO : this.listaSujetosDTO) {
                SujetoDTO sujetoTmp = sujetoDTO.sinProfesionalNiEvaluaciones();
                listaSujetosTmp.add(sujetoTmp);
            }
        }
        return listaSujetosTmp;
    }
    public void setListaSujetosDTO(List<SujetoDTO> listaSujetosDTO) {
        this.listaSujetosDTO = listaSujetosDTO;
    }


    public ProfesionalDTO sinSujetos() {
        ProfesionalDTO profesionalTmp = new ProfesionalDTO( this.getDni()
                                                            ,this.getNombre()
                                                            ,this.getApellido()
                                                            ,this.getMatricula()
                                                            ,new ArrayList<SujetoDTO>());
        return profesionalTmp;
    }

    public ProfesionalDAO toDAO() {
        List<SujetoDAO> listaSujetosDAO = new ArrayList<>();
        for (SujetoDTO sujetoDTO : getListaSujetosDTO()) {
            SujetoDAO sujetoDAO = new SujetoDAO(sujetoDTO.getDni());
            listaSujetosDAO.add(sujetoDAO);
        }
        ProfesionalDAO profesionalDAO = new ProfesionalDAO( getDni()
                                                           ,getNombre()
                                                           ,getApellido()
                                                           ,getMatricula()
                                                           ,listaSujetosDAO
                                                           ,new ArrayList<>());
        return profesionalDAO;
    }

}
