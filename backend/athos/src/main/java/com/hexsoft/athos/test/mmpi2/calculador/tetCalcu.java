package com.hexsoft.athos.test.mmpi2.calculador;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hexsoft.athos.test.mmpi2.TestMMPI2;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaD;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaF;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaHS;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaHY;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaK;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaL;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaMA;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaMF_F;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaMF_M;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaPA;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaPD;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaPT;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaSC;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorSubescalaSI;
import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.ConstantesEscalasBasicas;

public class tetCalcu {

	public static void main(String[] args) throws Exception {
		TestMMPI2 mmpi2 = new TestMMPI2();
			
		System.out.println(mmpi2.obtenerPreguntasComoJSON());
		/*JSONObject respuestasJSON = (JSONObject) readJsonSimpleDemo("src\\main\\java\\com\\hexsoft\\athos\\test\\mmpi2\\calculador\\respuestas.json");

		System.out.println(CalculadorSubescalaL.getInstance().getDenominadorEscala() + CalculadorSubescalaL.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaF.getInstance().getDenominadorEscala() + CalculadorSubescalaF.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaK.getInstance().getDenominadorEscala() + CalculadorSubescalaK.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaHS.getInstance().getDenominadorEscala() + CalculadorSubescalaHS.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaD.getInstance().getDenominadorEscala() + CalculadorSubescalaD.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaHY.getInstance().getDenominadorEscala() + CalculadorSubescalaHY.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaPD.getInstance().getDenominadorEscala() + CalculadorSubescalaPD.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaMF_M.getInstance().getDenominadorEscala() + CalculadorSubescalaMF_M.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaMF_F.getInstance().getDenominadorEscala() + CalculadorSubescalaMF_F.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaPA.getInstance().getDenominadorEscala() + CalculadorSubescalaPA.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaPT.getInstance().getDenominadorEscala() + CalculadorSubescalaPT.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaSC.getInstance().getDenominadorEscala() + CalculadorSubescalaSC.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaMA.getInstance().getDenominadorEscala() + CalculadorSubescalaMA.getInstance().getPuntajes(respuestasJSON));
		System.out.println(CalculadorSubescalaSI.getInstance().getDenominadorEscala() + CalculadorSubescalaSI.getInstance().getPuntajes(respuestasJSON));
		*/
    }
	
	public static Object readJsonSimpleDemo(String filename) throws Exception {
	    FileReader reader = new FileReader(filename);
	    JSONParser jsonParser = new JSONParser();
	    return jsonParser.parse(reader);
	}
}