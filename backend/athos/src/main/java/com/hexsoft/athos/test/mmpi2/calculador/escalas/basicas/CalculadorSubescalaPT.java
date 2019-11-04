package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaPT extends ACalculadorSubescalas {

	private static CalculadorSubescalaPT instance;

	private CalculadorSubescalaPT() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaPT getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaPT();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		// PT Masculinos
		getSubEscalaMasc().put(60,120);
		getSubEscalaMasc().put(59,119);
		getSubEscalaMasc().put(58,117);
		getSubEscalaMasc().put(57,115);
		getSubEscalaMasc().put(56,113);
		getSubEscalaMasc().put(55,111);
		getSubEscalaMasc().put(54,109);
		getSubEscalaMasc().put(53,106);
		getSubEscalaMasc().put(52,104);
		getSubEscalaMasc().put(51,102);
		getSubEscalaMasc().put(50,100);
		getSubEscalaMasc().put(49,98);
		getSubEscalaMasc().put(48,96);
		getSubEscalaMasc().put(47,94);
		getSubEscalaMasc().put(46,91);
		getSubEscalaMasc().put(45,89);
		getSubEscalaMasc().put(44,87);
		getSubEscalaMasc().put(43,85);
		getSubEscalaMasc().put(42,83);
		getSubEscalaMasc().put(41,81);
		getSubEscalaMasc().put(40,79);
		getSubEscalaMasc().put(39,77);
		getSubEscalaMasc().put(38,74);
		getSubEscalaMasc().put(37,72);
		getSubEscalaMasc().put(36,70);
		getSubEscalaMasc().put(35,68);
		getSubEscalaMasc().put(34,66);
		getSubEscalaMasc().put(33,64);
		getSubEscalaMasc().put(32,62);
		getSubEscalaMasc().put(31,59);
		getSubEscalaMasc().put(30,57);
		getSubEscalaMasc().put(29,55);
		getSubEscalaMasc().put(28,53);
		getSubEscalaMasc().put(27,51);
		getSubEscalaMasc().put(26,49);
		getSubEscalaMasc().put(25,47);
		getSubEscalaMasc().put(24,44);
		getSubEscalaMasc().put(23,43);
		getSubEscalaMasc().put(22,41);
		getSubEscalaMasc().put(21,39);
		getSubEscalaMasc().put(20,37);
		getSubEscalaMasc().put(19,36);
		getSubEscalaMasc().put(18,34);
		getSubEscalaMasc().put(17,33);
		getSubEscalaMasc().put(16,32);
		getSubEscalaMasc().put(15,31);
		getSubEscalaMasc().put(14,30);

		// PT Femeninos
		getSubEscalaFem().put(66,120);
		getSubEscalaFem().put(65,119);
		getSubEscalaFem().put(64,117);
		getSubEscalaFem().put(63,115);
		getSubEscalaFem().put(62,114);
		getSubEscalaFem().put(61,112);
		getSubEscalaFem().put(60,110);
		getSubEscalaFem().put(59,108);
		getSubEscalaFem().put(58,106);
		getSubEscalaFem().put(57,104);
		getSubEscalaFem().put(56,103);
		getSubEscalaFem().put(55,101);
		getSubEscalaFem().put(54,99);
		getSubEscalaFem().put(53,97);
		getSubEscalaFem().put(52,95);
		getSubEscalaFem().put(51,94);
		getSubEscalaFem().put(50,92);
		getSubEscalaFem().put(49,90);
		getSubEscalaFem().put(48,88);
		getSubEscalaFem().put(47,87);
		getSubEscalaFem().put(46,84);
		getSubEscalaFem().put(45,83);
		getSubEscalaFem().put(44,81);
		getSubEscalaFem().put(43,79);
		getSubEscalaFem().put(42,77);
		getSubEscalaFem().put(41,75);
		getSubEscalaFem().put(40,73);
		getSubEscalaFem().put(39,72);
		getSubEscalaFem().put(38,70);
		getSubEscalaFem().put(37,68);
		getSubEscalaFem().put(36,66);
		getSubEscalaFem().put(35,64);
		getSubEscalaFem().put(34,62);
		getSubEscalaFem().put(33,61);
		getSubEscalaFem().put(32,59);
		getSubEscalaFem().put(31,57);
		getSubEscalaFem().put(30,55);
		getSubEscalaFem().put(29,53);
		getSubEscalaFem().put(28,51);
		getSubEscalaFem().put(27,49);
		getSubEscalaFem().put(26,47);
		getSubEscalaFem().put(25,44);
		getSubEscalaFem().put(24,42);
		getSubEscalaFem().put(23,40);
		getSubEscalaFem().put(22,39);
		getSubEscalaFem().put(21,37);
		getSubEscalaFem().put(20,35);
		getSubEscalaFem().put(19,34);
		getSubEscalaFem().put(18,32);
		getSubEscalaFem().put(17,31);
		getSubEscalaFem().put(16,30);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.PT_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.PT_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_PT;
	}

	@Override
	protected Integer geDesvio(JSONObject respuestas) {	
		return CalculadorSubescalaK.getInstance().getPuntajeBruto(respuestas);
	}
}
