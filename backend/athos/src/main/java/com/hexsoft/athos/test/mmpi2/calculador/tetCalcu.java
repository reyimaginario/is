package com.hexsoft.athos.test.mmpi2.calculador;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaD;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaF;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaHS;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaHY;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaK;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaL;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaMF_F;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaMF_M;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaPA;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaPD;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.ConstantesEscalasBasicas;

public class tetCalcu {

	public static void main(String[] args) throws Exception {
		JSONObject respuestasJSON = (JSONObject) readJsonSimpleDemo("G:\\Mis Documentos\\ORT Analista de Sistemas\\3° 2°\\Integración de Sistemas\\is\\backend\\athos\\src\\main\\java\\com\\hexsoft\\athos\\test\\mmpi2\\calculador\\respuestas.json");
		JSONObject puntajesL = CalculadorSubescalaL.getInstance().getPuntajes(respuestasJSON);
		JSONObject puntajesF = CalculadorSubescalaF.getInstance().getPuntajes(respuestasJSON);
		JSONObject puntajesK = CalculadorSubescalaK.getInstance().getPuntajes(respuestasJSON);
		JSONObject puntajesHS = CalculadorSubescalaHS.getInstance().getPuntajes(respuestasJSON);
		JSONObject puntajesD = CalculadorSubescalaD.getInstance().getPuntajes(respuestasJSON);
		System.out.println(CalculadorSubescalaL.getInstance().getDenominadorEscala() + puntajesL);
		System.out.println(CalculadorSubescalaF.getInstance().getDenominadorEscala() + puntajesF);
		System.out.println(CalculadorSubescalaK.getInstance().getDenominadorEscala() + puntajesK);
		System.out.println(CalculadorSubescalaHS.getInstance().getDenominadorEscala() + puntajesHS);
		System.out.println(CalculadorSubescalaD.getInstance().getDenominadorEscala() + puntajesD);
		System.out.println(CalculadorSubescalaHY.getInstance().getDenominadorEscala() + CalculadorSubescalaHY.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaPD.getInstance().getDenominadorEscala() + CalculadorSubescalaPD.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaMF_M.getInstance().getDenominadorEscala() + CalculadorSubescalaMF_M.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaMF_F.getInstance().getDenominadorEscala() + CalculadorSubescalaMF_F.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaPA.getInstance().getDenominadorEscala() + CalculadorSubescalaPA.getInstance().getPuntajes(respuestasJSON));
    }
	
	public static Object readJsonSimpleDemo(String filename) throws Exception {
	    FileReader reader = new FileReader(filename);
	    JSONParser jsonParser = new JSONParser();
	    return jsonParser.parse(reader);
	}
}