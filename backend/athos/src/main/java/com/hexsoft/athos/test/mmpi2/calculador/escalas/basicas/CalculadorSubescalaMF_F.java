package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaMF_F extends ACalculadorSubescalas {

	private static volatile CalculadorSubescalaMF_F instance;

	private CalculadorSubescalaMF_F() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaMF_F getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaMF_F();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		// MF_F Femeninas
		getSubEscalaFem().put(7,120);
		getSubEscalaFem().put(8,118);
		getSubEscalaFem().put(9,116);
		getSubEscalaFem().put(10,114);
		getSubEscalaFem().put(11,111);
		getSubEscalaFem().put(12,109);
		getSubEscalaFem().put(13,106);
		getSubEscalaFem().put(14,104);
		getSubEscalaFem().put(15,101);
		getSubEscalaFem().put(16,99);
		getSubEscalaFem().put(17,96);
		getSubEscalaFem().put(18,94);
		getSubEscalaFem().put(19,92);
		getSubEscalaFem().put(20,89);
		getSubEscalaFem().put(21,87);
		getSubEscalaFem().put(22,84);
		getSubEscalaFem().put(23,82);
		getSubEscalaFem().put(24,79);
		getSubEscalaFem().put(25,77);
		getSubEscalaFem().put(26,74);
		getSubEscalaFem().put(27,72);
		getSubEscalaFem().put(28,69);
		getSubEscalaFem().put(29,67);
		getSubEscalaFem().put(30,65);
		getSubEscalaFem().put(31,62);
		getSubEscalaFem().put(32,60);
		getSubEscalaFem().put(33,57);
		getSubEscalaFem().put(34,55);
		getSubEscalaFem().put(35,52);
		getSubEscalaFem().put(36,50);
		getSubEscalaFem().put(37,47);
		getSubEscalaFem().put(38,45);
		getSubEscalaFem().put(39,43);
		getSubEscalaFem().put(40,40);
		getSubEscalaFem().put(41,38);
		getSubEscalaFem().put(42,35);
		getSubEscalaFem().put(43,33);
		getSubEscalaFem().put(44,30);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.MF_F_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.MF_F_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_MF_F;
	}

}
