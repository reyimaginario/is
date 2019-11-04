package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaMA extends ACalculadorSubescalas {
	
	private static CalculadorSubescalaMA instance;

	private CalculadorSubescalaMA() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaMA getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaMA();
		}
		return instance;
	}
	@Override
	protected void inicializarConstantesMyF() {
		// MA Masculino
		getSubEscalaMasc().put(43,120);
		getSubEscalaMasc().put(42,117);
		getSubEscalaMasc().put(41,114);
		getSubEscalaMasc().put(40,110);
		getSubEscalaMasc().put(39,107);
		getSubEscalaMasc().put(38,104);
		getSubEscalaMasc().put(37,101);
		getSubEscalaMasc().put(36,98);
		getSubEscalaMasc().put(35,94);
		getSubEscalaMasc().put(34,91);
		getSubEscalaMasc().put(33,88);
		getSubEscalaMasc().put(32,85);
		getSubEscalaMasc().put(31,81);
		getSubEscalaMasc().put(30,78);
		getSubEscalaMasc().put(29,75);
		getSubEscalaMasc().put(28,72);
		getSubEscalaMasc().put(27,69);
		getSubEscalaMasc().put(26,65);
		getSubEscalaMasc().put(25,62);
		getSubEscalaMasc().put(24,59);
		getSubEscalaMasc().put(23,56);
		getSubEscalaMasc().put(22,53);
		getSubEscalaMasc().put(21,51);
		getSubEscalaMasc().put(20,49);
		getSubEscalaMasc().put(19,47);
		getSubEscalaMasc().put(18,45);
		getSubEscalaMasc().put(17,43);
		getSubEscalaMasc().put(16,41);
		getSubEscalaMasc().put(15,39);
		getSubEscalaMasc().put(14,38);
		getSubEscalaMasc().put(13,36);
		getSubEscalaMasc().put(12,35);
		getSubEscalaMasc().put(11,33);
		getSubEscalaMasc().put(10,31);
		getSubEscalaMasc().put(9,30);

		// MA Femenino
		getSubEscalaFem().put(44,120);
		getSubEscalaFem().put(43,118);
		getSubEscalaFem().put(42,115);
		getSubEscalaFem().put(41,112);
		getSubEscalaFem().put(40,109);
		getSubEscalaFem().put(39,106);
		getSubEscalaFem().put(38,103);
		getSubEscalaFem().put(37,100);
		getSubEscalaFem().put(36,97);
		getSubEscalaFem().put(35,94);
		getSubEscalaFem().put(34,91);
		getSubEscalaFem().put(33,88);
		getSubEscalaFem().put(32,85);
		getSubEscalaFem().put(31,82);
		getSubEscalaFem().put(30,79);
		getSubEscalaFem().put(29,76);
		getSubEscalaFem().put(28,74);
		getSubEscalaFem().put(27,71);
		getSubEscalaFem().put(26,68);
		getSubEscalaFem().put(25,65);
		getSubEscalaFem().put(24,62);
		getSubEscalaFem().put(23,59);
		getSubEscalaFem().put(22,56);
		getSubEscalaFem().put(21,53);
		getSubEscalaFem().put(20,51);

		getSubEscalaFem().put(18,47);
		getSubEscalaFem().put(17,45);
		getSubEscalaFem().put(16,43);
		getSubEscalaFem().put(15,41);
		getSubEscalaFem().put(14,39);
		getSubEscalaFem().put(13,37);
		getSubEscalaFem().put(12,35);
		getSubEscalaFem().put(11,33);
		getSubEscalaFem().put(10,31);
		getSubEscalaFem().put(9,30);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.MA_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.MA_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_MA;
	}

	@Override
	protected Integer geDesvio(JSONObject respuestas) {
		return (int) Math.ceil(CalculadorSubescalaK.getInstance().getPuntajeBruto(respuestas)*0.2);
	}
}
