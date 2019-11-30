package com.hexsoft.athos.services;

import com.hexsoft.athos.entities.BaremoDAO;
import com.hexsoft.athos.entities.SujetoAnonimo;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaremoService {

    public void guardarBaremo(SujetoAnonimo sujetoAnonimo, List<JSONObject> listaResultados) {

        JSONObject mmpi2 = listaResultados.get(0);  // primer test mmpi2

        JSONObject escalaBasica = (JSONObject)mmpi2.get("Basicas");

        BaremoDAO baremoDAO = new BaremoDAO();

        // sujeto anonimo
        baremoDAO.setLocalidad(sujetoAnonimo.getLocalidad());
        baremoDAO.setEdad(sujetoAnonimo.getEdad());
        baremoDAO.setEdad(sujetoAnonimo.getGenero());
        baremoDAO.setNivelDeEstudio(sujetoAnonimo.getNivelDeEstudio());
        baremoDAO.setOcupacion(sujetoAnonimo.getOcupacion());

        // escala basica
        //baremoDAO.setBasica_l();

    }
}
