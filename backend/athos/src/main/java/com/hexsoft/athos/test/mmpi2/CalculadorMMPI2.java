package com.hexsoft.athos.test.mmpi2;

import java.util.List;

import org.json.simple.JSONObject;

import com.hexsoft.athos.entities.RespuestaDAO;
import com.hexsoft.athos.test.ICalculador;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorEscalasAdicionalesDeValidez;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorEscalasBasicas;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorEscalasContenido;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorEscalasSuplementarias;
import com.hexsoft.athos.test.mmpi2.constantes.ConstantesEscalaAdicionalesDeValidez;
import com.hexsoft.athos.test.mmpi2.constantes.ConstantesEscalaBasica;
import com.hexsoft.athos.test.mmpi2.constantes.ConstantesEscalaContenido;
import com.hexsoft.athos.test.mmpi2.constantes.ConstantesEscalaSuplementaria;

public class CalculadorMMPI2 implements ICalculador {
	
	@Override
	public JSONObject procesarRespuestas(List<RespuestaDAO> respuestas) {
		JSONObject respuestasJSON = pasarRespuestasAJSON(respuestas);
		return construirEscalas(respuestasJSON);
	}

	private JSONObject pasarRespuestasAJSON(List<RespuestaDAO> respuestas) {
		JSONObject resultado =  new JSONObject();
		for (RespuestaDAO respuestaDAO : respuestas) {
			String key = respuestaDAO.getPregunta().toString();
			String value = decodificar(respuestaDAO.getRespuesta());
			resultado.put(key, value);
		}
		return resultado;
	}

	private String decodificar(Integer respuesta) {
		String result = null;
		switch (respuesta) {
			case 1:
				result = "True";
				break;
			case 0:
				result = "False";
				break;
			case -1:
				result = "Null";
				break;
		}
		return result;
	}

	public JSONObject construirEscalas(JSONObject respuestasAProcesar) {
		JSONObject result = new JSONObject();
		result.put(ConstantesEscalaBasica.BASICAS, CalculadorEscalasBasicas.getInstance().construirEscalas(respuestasAProcesar));
		result.put(ConstantesEscalaContenido.CONTENIDO, CalculadorEscalasContenido.getInstance().construirEscalas(respuestasAProcesar));
		result.put(ConstantesEscalaSuplementaria.SUPLEMENTARIAS, CalculadorEscalasSuplementarias.getInstance().construirEscalas(respuestasAProcesar));
		result.put(ConstantesEscalaAdicionalesDeValidez.ADICIONALES_DE_VALIDEZ, CalculadorEscalasAdicionalesDeValidez.getInstance().construirEscalas(respuestasAProcesar));
		return result;
	}
}
