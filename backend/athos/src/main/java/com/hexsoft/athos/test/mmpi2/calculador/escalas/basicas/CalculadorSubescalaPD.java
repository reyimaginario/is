package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaPD extends ACalculadorSubescalas {

	private static CalculadorSubescalaPD instance;

	private CalculadorSubescalaPD() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaPD getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaPD();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		// PD Masculino
		getSubEscalaMasc().put(51,120);
		getSubEscalaMasc().put(50,117);
		getSubEscalaMasc().put(49,115);
		getSubEscalaMasc().put(48,112);
		getSubEscalaMasc().put(47,110);
		getSubEscalaMasc().put(46,107);
		getSubEscalaMasc().put(45,105);
		getSubEscalaMasc().put(44,102);
		getSubEscalaMasc().put(43,100);
		getSubEscalaMasc().put(42,97);
		getSubEscalaMasc().put(41,95);
		getSubEscalaMasc().put(40,92);
		getSubEscalaMasc().put(39,90);
		getSubEscalaMasc().put(38,87);
		getSubEscalaMasc().put(37,84);
		getSubEscalaMasc().put(36,82);
		getSubEscalaMasc().put(35,79);
		getSubEscalaMasc().put(34,77);
		getSubEscalaMasc().put(33,74);
		getSubEscalaMasc().put(32,72);
		getSubEscalaMasc().put(31,69);
		getSubEscalaMasc().put(30,67);
		getSubEscalaMasc().put(29,64);
		getSubEscalaMasc().put(28,62);
		getSubEscalaMasc().put(27,59);
		getSubEscalaMasc().put(26,57);
		getSubEscalaMasc().put(25,54);
		getSubEscalaMasc().put(24,52);
		getSubEscalaMasc().put(23,50);
		getSubEscalaMasc().put(22,48);
		getSubEscalaMasc().put(21,46);
		getSubEscalaMasc().put(20,44);
		getSubEscalaMasc().put(19,42);
		getSubEscalaMasc().put(18,40);
		getSubEscalaMasc().put(17,39);
		getSubEscalaMasc().put(16,37);
		getSubEscalaMasc().put(15,35);
		getSubEscalaMasc().put(14,34);
		getSubEscalaMasc().put(13,33);
		getSubEscalaMasc().put(12,31);
		getSubEscalaMasc().put(11,30);
		
		// PD Femenino
		getSubEscalaFem().put(50,120);
		getSubEscalaFem().put(49,118);
		getSubEscalaFem().put(48,115);
		getSubEscalaFem().put(47,113);
		getSubEscalaFem().put(46,110);
		getSubEscalaFem().put(45,107);
		getSubEscalaFem().put(44,105);
		getSubEscalaFem().put(43,102);
		getSubEscalaFem().put(42,100);
		getSubEscalaFem().put(41,97);
		getSubEscalaFem().put(40,94);
		getSubEscalaFem().put(39,92);
		getSubEscalaFem().put(38,89);
		getSubEscalaFem().put(37,87);
		getSubEscalaFem().put(36,84);
		getSubEscalaFem().put(35,81);
		getSubEscalaFem().put(34,79);
		getSubEscalaFem().put(33,76);
		getSubEscalaFem().put(32,73);
		getSubEscalaFem().put(31,71);
		getSubEscalaFem().put(30,68);
		getSubEscalaFem().put(29,66);
		getSubEscalaFem().put(28,63);
		getSubEscalaFem().put(27,60);
		getSubEscalaFem().put(26,58);
		getSubEscalaFem().put(25,55);
		getSubEscalaFem().put(24,53);
		getSubEscalaFem().put(23,51);
		getSubEscalaFem().put(22,49);
		getSubEscalaFem().put(21,47);
		getSubEscalaFem().put(20,45);
		getSubEscalaFem().put(19,43);
		getSubEscalaFem().put(18,41);
		getSubEscalaFem().put(17,39);
		getSubEscalaFem().put(16,37);
		getSubEscalaFem().put(15,36);
		getSubEscalaFem().put(14,34);
		getSubEscalaFem().put(13,32);
		getSubEscalaFem().put(12,30);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.PD_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.PD_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_PD;
	}
	
	@Override
	protected Integer geDesvio(JSONObject respuestas) {
		return (int) Math.ceil( CalculadorSubescalaK.getInstance().getPuntajeBruto(respuestas).doubleValue() * 0.4);
	}

}
