package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import org.json.simple.JSONObject;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaHS extends ACalculadorSubescalas{

	private static CalculadorSubescalaHS instance;
	
	private CalculadorSubescalaHS() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaHS getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaHS();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {

		// HS Masculina
		getSubEscalaMasc().put(44,120);
		getSubEscalaMasc().put(43,119);
		getSubEscalaMasc().put(42,116);
		getSubEscalaMasc().put(41,114);
		getSubEscalaMasc().put(40,112);
		getSubEscalaMasc().put(39,110);
		getSubEscalaMasc().put(38,108);
		getSubEscalaMasc().put(37,105);
		getSubEscalaMasc().put(36,103);
		getSubEscalaMasc().put(35,101);
		getSubEscalaMasc().put(34,99);
		getSubEscalaMasc().put(33,97);
		getSubEscalaMasc().put(32,94);
		getSubEscalaMasc().put(31,92);
		getSubEscalaMasc().put(30,90);
		getSubEscalaMasc().put(29,88);
		getSubEscalaMasc().put(28,86);
		getSubEscalaMasc().put(27,84);
		getSubEscalaMasc().put(26,81);
		getSubEscalaMasc().put(25,79);
		getSubEscalaMasc().put(24,77);
		getSubEscalaMasc().put(23,75);
		getSubEscalaMasc().put(22,73);
		getSubEscalaMasc().put(21,70);
		getSubEscalaMasc().put(20,68);
		getSubEscalaMasc().put(19,66);
		getSubEscalaMasc().put(18,64);
		getSubEscalaMasc().put(17,62);
		getSubEscalaMasc().put(16,59);
		getSubEscalaMasc().put(15,57);
		getSubEscalaMasc().put(14,54);
		getSubEscalaMasc().put(13,51);
		getSubEscalaMasc().put(12,48);
		getSubEscalaMasc().put(11,45);
		getSubEscalaMasc().put(10,42);
		getSubEscalaMasc().put(9,39);
		getSubEscalaMasc().put(8,37);
		getSubEscalaMasc().put(7,35);
		getSubEscalaMasc().put(6,33);
		getSubEscalaMasc().put(5,32);
		getSubEscalaMasc().put(4,31);
		getSubEscalaMasc().put(3,30);

		// HS Femenina
		getSubEscalaFem().put(46,120);
		getSubEscalaFem().put(45,118);
		getSubEscalaFem().put(44,116);
		getSubEscalaFem().put(43,113);
		getSubEscalaFem().put(42,111);
		getSubEscalaFem().put(41,109);
		getSubEscalaFem().put(40,107);
		getSubEscalaFem().put(39,105);
		getSubEscalaFem().put(38,103);
		getSubEscalaFem().put(37,101);
		getSubEscalaFem().put(36,99);
		getSubEscalaFem().put(35,97);
		getSubEscalaFem().put(34,95);
		getSubEscalaFem().put(33,92);
		getSubEscalaFem().put(32,90);
		getSubEscalaFem().put(31,88);
		getSubEscalaFem().put(30,86);
		getSubEscalaFem().put(29,84);
		getSubEscalaFem().put(28,82);
		getSubEscalaFem().put(27,80);
		getSubEscalaFem().put(26,78);
		getSubEscalaFem().put(25,76);
		getSubEscalaFem().put(24,74);
		getSubEscalaFem().put(23,71);
		getSubEscalaFem().put(22,69);
		getSubEscalaFem().put(21,67);
		getSubEscalaFem().put(20,65);
		getSubEscalaFem().put(19,63);
		getSubEscalaFem().put(18,61);
		getSubEscalaFem().put(17,59);
		getSubEscalaFem().put(16,57);
		getSubEscalaFem().put(15,54);
		getSubEscalaFem().put(14,51);
		getSubEscalaFem().put(13,49);
		getSubEscalaFem().put(12,46);
		getSubEscalaFem().put(11,43);
		getSubEscalaFem().put(10,40);
		getSubEscalaFem().put(9,38);
		getSubEscalaFem().put(8,35);
		getSubEscalaFem().put(7,33);
		getSubEscalaFem().put(6,30);
	}
	
	@Override
	protected Integer geDesvio(JSONObject respuestas) {
		return (int) Math.ceil( CalculadorSubescalaK.getInstance().getPuntajeBruto(respuestas).doubleValue() /2.0);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.HS_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.HS_ANSWERS_F;
	}
	
	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_HS;
	}
}
