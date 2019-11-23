package com.hexsoft.athos.dtos.wrapper;

import com.hexsoft.athos.dtos.RespuestaTemporalDTO;

import java.util.List;

public class ListaRespuestasTemporalesDTO {

    private List<RespuestaTemporalDTO> listaRespuestasTemporalesDTO;

    public ListaRespuestasTemporalesDTO() {
    }

    public ListaRespuestasTemporalesDTO(List<RespuestaTemporalDTO> listaRespuestasTemporalesDTO) {
        this.listaRespuestasTemporalesDTO = listaRespuestasTemporalesDTO;
    }

    public List<RespuestaTemporalDTO> getListaRespuestasTemporalesDTO() {
        return listaRespuestasTemporalesDTO;
    }

    public void setListaRespuestasTemporalesDTO(List<RespuestaTemporalDTO> listaRespuestasTemporalesDTO) {
        this.listaRespuestasTemporalesDTO = listaRespuestasTemporalesDTO;
    }
}
