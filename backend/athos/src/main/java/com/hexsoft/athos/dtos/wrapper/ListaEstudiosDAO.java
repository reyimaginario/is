package com.hexsoft.athos.dtos.wrapper;

import com.hexsoft.athos.entities.EstudioDAO;

import java.util.List;

public class ListaEstudiosDAO {

    private List<EstudioDAO> listaEstudiosDAO;

    public ListaEstudiosDAO() {
    }
    public ListaEstudiosDAO(List<EstudioDAO> listaEstudiosDAO) {
        this.listaEstudiosDAO = listaEstudiosDAO;
    }

    public List<EstudioDAO> getListaEstudiosDAO() {
        return listaEstudiosDAO;
    }
    public void setListaEstudiosDAO(List<EstudioDAO> listaEstudiosDAO) {
        this.listaEstudiosDAO = listaEstudiosDAO;
    }
}
