package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaSC extends ACalculadorSubescalas {

	private static CalculadorSubescalaSC instance;

	private CalculadorSubescalaSC() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaSC getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaSC();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		// SC Masculino
		getSubEscalaMasc().put(67,120);
		getSubEscalaMasc().put(66,118);
		getSubEscalaMasc().put(65,117);
		getSubEscalaMasc().put(64,115);
		getSubEscalaMasc().put(63,113);
		getSubEscalaMasc().put(62,111);
		getSubEscalaMasc().put(61,110);
		getSubEscalaMasc().put(60,108);
		getSubEscalaMasc().put(59,106);
		getSubEscalaMasc().put(58,105);
		getSubEscalaMasc().put(57,103);
		getSubEscalaMasc().put(56,101);
		getSubEscalaMasc().put(55,99);
		getSubEscalaMasc().put(54,98);
		getSubEscalaMasc().put(53,96);
		getSubEscalaMasc().put(52,94);
		getSubEscalaMasc().put(51,93);
		getSubEscalaMasc().put(50,91);
		getSubEscalaMasc().put(49,89);
		getSubEscalaMasc().put(48,87);
		getSubEscalaMasc().put(47,86);
		getSubEscalaMasc().put(46,84);
		getSubEscalaMasc().put(45,82);
		getSubEscalaMasc().put(44,81);
		getSubEscalaMasc().put(43,79);
		getSubEscalaMasc().put(42,77);
		getSubEscalaMasc().put(41,75);
		getSubEscalaMasc().put(40,74);
		getSubEscalaMasc().put(39,72);
		getSubEscalaMasc().put(38,70);
		getSubEscalaMasc().put(37,69);
		getSubEscalaMasc().put(36,67);
		getSubEscalaMasc().put(35,65);
		getSubEscalaMasc().put(34,63);
		getSubEscalaMasc().put(33,62);
		getSubEscalaMasc().put(32,60);
		getSubEscalaMasc().put(31,58);
		getSubEscalaMasc().put(30,56);
		getSubEscalaMasc().put(29,55);
		getSubEscalaMasc().put(28,53);
		getSubEscalaMasc().put(27,51);
		getSubEscalaMasc().put(26,49);
		getSubEscalaMasc().put(25,47);
		getSubEscalaMasc().put(24,45);
		getSubEscalaMasc().put(23,44);
		getSubEscalaMasc().put(22,42);
		getSubEscalaMasc().put(21,40);
		getSubEscalaMasc().put(20,39);
		getSubEscalaMasc().put(19,37);
		getSubEscalaMasc().put(18,36);
		getSubEscalaMasc().put(17,35);
		getSubEscalaMasc().put(16,34);
		getSubEscalaMasc().put(15,33);
		getSubEscalaMasc().put(14,32);
		getSubEscalaMasc().put(13,31);
		getSubEscalaMasc().put(12,30);
		
		// SC Femenino
		getSubEscalaFem().put(73,120);
		getSubEscalaFem().put(72,119);
		getSubEscalaFem().put(71,118);
		getSubEscalaFem().put(70,116);
		getSubEscalaFem().put(69,115);
		getSubEscalaFem().put(68,113);
		getSubEscalaFem().put(67,112);
		getSubEscalaFem().put(66,111);
		getSubEscalaFem().put(65,109);
		getSubEscalaFem().put(64,108);
		getSubEscalaFem().put(63,106);
		getSubEscalaFem().put(62,105);
		getSubEscalaFem().put(61,103);
		getSubEscalaFem().put(60,102);
		getSubEscalaFem().put(59,100);
		getSubEscalaFem().put(58,99);
		getSubEscalaFem().put(57,97);
		getSubEscalaFem().put(56,96);
		getSubEscalaFem().put(55,94);
		getSubEscalaFem().put(54,93);
		getSubEscalaFem().put(53,91);
		getSubEscalaFem().put(52,90);
		getSubEscalaFem().put(51,88);
		getSubEscalaFem().put(50,87);
		getSubEscalaFem().put(49,85);
		getSubEscalaFem().put(48,84);
		getSubEscalaFem().put(47,82);
		getSubEscalaFem().put(46,81);
		getSubEscalaFem().put(45,79);
		getSubEscalaFem().put(44,78);
		getSubEscalaFem().put(43,76);
		getSubEscalaFem().put(42,75);
		getSubEscalaFem().put(41,73);
		getSubEscalaFem().put(40,72);
		getSubEscalaFem().put(39,70);
		getSubEscalaFem().put(38,69);
		getSubEscalaFem().put(37,67);
		getSubEscalaFem().put(36,66);
		getSubEscalaFem().put(35,65);
		getSubEscalaFem().put(34,63);
		getSubEscalaFem().put(33,62);
		getSubEscalaFem().put(32,60);
		getSubEscalaFem().put(31,59);
		getSubEscalaFem().put(30,57);
		getSubEscalaFem().put(29,55);
		getSubEscalaFem().put(28,53);
		getSubEscalaFem().put(27,52);
		getSubEscalaFem().put(26,50);
		getSubEscalaFem().put(25,48);
		getSubEscalaFem().put(24,46);
		getSubEscalaFem().put(23,44);
		getSubEscalaFem().put(22,42);
		getSubEscalaFem().put(21,41);
		getSubEscalaFem().put(20,39);
		getSubEscalaFem().put(19,37);
		getSubEscalaFem().put(18,36);
		getSubEscalaFem().put(17,34);
		getSubEscalaFem().put(16,33);
		getSubEscalaFem().put(15,32);
		getSubEscalaFem().put(14,31);
		getSubEscalaFem().put(13,30);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.SC_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.SC_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_SC;
	}
	
	@Override
	protected Integer geDesvio(JSONObject respuestas) {
		return CalculadorSubescalaK.getInstance().getPuntajeBruto(respuestas);
	}

}
