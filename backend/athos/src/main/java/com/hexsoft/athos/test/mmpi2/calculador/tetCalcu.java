package com.hexsoft.athos.test.mmpi2.calculador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas.CalculadorEscalasAdicionalesDeValidez;

public class tetCalcu {

	public static void main(String[] args) throws Exception {			
		JSONObject respuestasJSON = (JSONObject) readJsonSimpleDemo("src\\main\\java\\com\\hexsoft\\athos\\test\\mmpi2\\calculador\\respuestas.json");
		JSONObject respuestasTest = CalculadorEscalasAdicionalesDeValidez.getInstance().construirEscalas(respuestasJSON);
		Iterator it = respuestasTest.entrySet().iterator();
		while (it.hasNext()) {			
			System.out.println(it.next());
		}
		/*File f = new File("C:\\Users\\suare\\Desktop\\Coso loco.txt");
		BufferedReader r = new BufferedReader(new FileReader(f));
		while (r.ready()) {
			String line = r.readLine();
			String[] spl = line.split("=");
			System.out.print("respuestasAChequear.add(new String[]{\"");
			System.out.print(Integer.parseInt(spl[0].substring(1))-1);
			System.out.print("\", ");
			if (spl[0].charAt(0) == 'B') {
				System.out.print("\"True\"");
			} else if (spl[0].charAt(0) == 'C') {
				System.out.print("\"False\"");
			}

			System.out.print(", \"");
			
			System.out.print(Integer.parseInt(spl[1].substring(1))-1);
			System.out.print("\", ");
			if (spl[1].charAt(0) == 'B') {
				System.out.print("\"True\"");
			} else if (spl[1].charAt(0) == 'C') {
				System.out.print("\"False\"");
			}
			System.out.print("});");			
			System.out.println();
		}*/
		
    }
	
	public static Object readJsonSimpleDemo(String filename) throws Exception {
	    FileReader reader = new FileReader(filename);
	    JSONParser jsonParser = new JSONParser();
	    return jsonParser.parse(reader);
	}
}