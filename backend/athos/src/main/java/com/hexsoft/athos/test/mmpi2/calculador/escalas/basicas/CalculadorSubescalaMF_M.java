package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaMF_M extends ACalculadorSubescalas {

	private static volatile CalculadorSubescalaMF_M instance;

	private CalculadorSubescalaMF_M() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaMF_M getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaMF_M();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		// MF_M Masculinas
		getSubEscalaMasc().put(56,109);
		getSubEscalaMasc().put(55,107);
		getSubEscalaMasc().put(54,105);
		getSubEscalaMasc().put(53,103);
		getSubEscalaMasc().put(52,101);
		getSubEscalaMasc().put(51,99);
		getSubEscalaMasc().put(50,97);
		getSubEscalaMasc().put(49,95);
		getSubEscalaMasc().put(48,93);
		getSubEscalaMasc().put(47,91);
		getSubEscalaMasc().put(46,89);
		getSubEscalaMasc().put(45,87);
		getSubEscalaMasc().put(44,85);
		getSubEscalaMasc().put(43,83);
		getSubEscalaMasc().put(42,81);
		getSubEscalaMasc().put(41,79);
		getSubEscalaMasc().put(40,78);
		getSubEscalaMasc().put(39,76);
		getSubEscalaMasc().put(38,74);
		getSubEscalaMasc().put(37,72);
		getSubEscalaMasc().put(36,70);
		getSubEscalaMasc().put(35,68);
		getSubEscalaMasc().put(34,66);
		getSubEscalaMasc().put(33,64);
		getSubEscalaMasc().put(32,62);
		getSubEscalaMasc().put(31,60);
		getSubEscalaMasc().put(30,58);
		getSubEscalaMasc().put(29,56);
		getSubEscalaMasc().put(28,54);
		getSubEscalaMasc().put(27,52);
		getSubEscalaMasc().put(26,50);
		getSubEscalaMasc().put(25,48);
		getSubEscalaMasc().put(24,46);
		getSubEscalaMasc().put(23,44);
		getSubEscalaMasc().put(22,42);
		getSubEscalaMasc().put(21,40);
		getSubEscalaMasc().put(20,38);
		getSubEscalaMasc().put(19,36);
		getSubEscalaMasc().put(18,34);
		getSubEscalaMasc().put(17,32);
		getSubEscalaMasc().put(16,30);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.MF_M_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.MF_M_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_MF_M;
	}

}
