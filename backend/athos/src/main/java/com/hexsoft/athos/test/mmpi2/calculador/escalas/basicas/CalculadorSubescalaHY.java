package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaHY extends ACalculadorSubescalas {

	private static CalculadorSubescalaHY instance;

	private CalculadorSubescalaHY() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaHY getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaHY();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		// HY Masculino
		getSubEscalaMasc().put(50,120);
		getSubEscalaMasc().put(49,119);
		getSubEscalaMasc().put(48,116);
		getSubEscalaMasc().put(47,114);
		getSubEscalaMasc().put(46,111);
		getSubEscalaMasc().put(45,109);
		getSubEscalaMasc().put(44,106);
		getSubEscalaMasc().put(43,104);
		getSubEscalaMasc().put(42,101);
		getSubEscalaMasc().put(41,99);
		getSubEscalaMasc().put(40,97);
		getSubEscalaMasc().put(39,94);
		getSubEscalaMasc().put(38,91);
		getSubEscalaMasc().put(37,89);
		getSubEscalaMasc().put(36,86);
		getSubEscalaMasc().put(35,84);
		getSubEscalaMasc().put(34,81);
		getSubEscalaMasc().put(33,79);
		getSubEscalaMasc().put(32,76);
		getSubEscalaMasc().put(31,74);
		getSubEscalaMasc().put(30,71);
		getSubEscalaMasc().put(29,69);
		getSubEscalaMasc().put(28,66);
		getSubEscalaMasc().put(27,64);
		getSubEscalaMasc().put(26,61);
		getSubEscalaMasc().put(25,59);
		getSubEscalaMasc().put(24,57);
		getSubEscalaMasc().put(23,54);
		getSubEscalaMasc().put(22,52);
		getSubEscalaMasc().put(21,50);
		getSubEscalaMasc().put(20,47);
		getSubEscalaMasc().put(19,45);
		getSubEscalaMasc().put(18,43);
		getSubEscalaMasc().put(17,42);
		getSubEscalaMasc().put(16,40);
		getSubEscalaMasc().put(15,38);
		getSubEscalaMasc().put(14,37);
		getSubEscalaMasc().put(13,35);
		getSubEscalaMasc().put(12,34);
		getSubEscalaMasc().put(11,33);
		getSubEscalaMasc().put(10,32);
		getSubEscalaMasc().put(9,31);
		getSubEscalaMasc().put(8,30);

		// HY Femenino
		getSubEscalaFem().put(52,120);
		getSubEscalaFem().put(51,118);
		getSubEscalaFem().put(50,115);
		getSubEscalaFem().put(49,113);
		getSubEscalaFem().put(48,111);
		getSubEscalaFem().put(47,108);
		getSubEscalaFem().put(46,106);
		getSubEscalaFem().put(45,104);
		getSubEscalaFem().put(44,101);
		getSubEscalaFem().put(43,99);
		getSubEscalaFem().put(42,96);
		getSubEscalaFem().put(41,94);
		getSubEscalaFem().put(40,92);
		getSubEscalaFem().put(39,89);
		getSubEscalaFem().put(38,87);
		getSubEscalaFem().put(37,84);
		getSubEscalaFem().put(36,82);
		getSubEscalaFem().put(35,80);
		getSubEscalaFem().put(34,77);
		getSubEscalaFem().put(33,75);
		getSubEscalaFem().put(32,73);
		getSubEscalaFem().put(31,70);
		getSubEscalaFem().put(30,68);
		getSubEscalaFem().put(29,65);
		getSubEscalaFem().put(28,63);
		getSubEscalaFem().put(27,61);
		getSubEscalaFem().put(26,58);
		getSubEscalaFem().put(25,56);
		getSubEscalaFem().put(24,54);
		getSubEscalaFem().put(23,51);
		getSubEscalaFem().put(22,49);
		getSubEscalaFem().put(21,47);
		getSubEscalaFem().put(20,45);
		getSubEscalaFem().put(19,43);
		getSubEscalaFem().put(18,41);
		getSubEscalaFem().put(17,39);
		getSubEscalaFem().put(16,38);
		getSubEscalaFem().put(15,36);
		getSubEscalaFem().put(14,35);
		getSubEscalaFem().put(13,34);
		getSubEscalaFem().put(11,32);
		getSubEscalaFem().put(10,31);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.HY_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.HY_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_HY;
	}

}
