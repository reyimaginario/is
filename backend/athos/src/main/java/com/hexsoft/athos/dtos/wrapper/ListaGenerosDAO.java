package com.hexsoft.athos.dtos.wrapper;

import com.hexsoft.athos.entities.GeneroDAO;

import java.util.List;

public class ListaGenerosDAO {

    private List<GeneroDAO> listaGenerosDAO;

    public ListaGenerosDAO() {
    }
    public ListaGenerosDAO(List<GeneroDAO> listaGenerosDAO) {
        this.listaGenerosDAO = listaGenerosDAO;
    }

    public List<GeneroDAO> getListaGenerosDAO() {
        return listaGenerosDAO;
    }
    public void setListaGenerosDAO(List<GeneroDAO> listaGenerosDAO) {
        this.listaGenerosDAO = listaGenerosDAO;
    }
}
