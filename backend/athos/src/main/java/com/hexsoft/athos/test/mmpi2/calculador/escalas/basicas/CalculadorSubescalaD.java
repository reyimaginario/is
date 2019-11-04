package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaD extends ACalculadorSubescalas {

	private static CalculadorSubescalaD instance;

	private CalculadorSubescalaD() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaD getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaD();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		// D Masculinas
		getSubEscalaMasc().put(55,120);
		getSubEscalaMasc().put(54,119);
		getSubEscalaMasc().put(53,117);
		getSubEscalaMasc().put(52,115);
		getSubEscalaMasc().put(51,114);
		getSubEscalaMasc().put(50,112);
		getSubEscalaMasc().put(49,110);
		getSubEscalaMasc().put(48,108);
		getSubEscalaMasc().put(47,106);
		getSubEscalaMasc().put(46,104);
		getSubEscalaMasc().put(45,102);
		getSubEscalaMasc().put(44,100);
		getSubEscalaMasc().put(43,98);
		getSubEscalaMasc().put(42,97);
		getSubEscalaMasc().put(41,95);
		getSubEscalaMasc().put(40,93);
		getSubEscalaMasc().put(39,91);
		getSubEscalaMasc().put(38,89);
		getSubEscalaMasc().put(37,87);
		getSubEscalaMasc().put(36,85);
		getSubEscalaMasc().put(35,83);
		getSubEscalaMasc().put(34,81);
		getSubEscalaMasc().put(33,80);
		getSubEscalaMasc().put(32,78);
		getSubEscalaMasc().put(31,76);
		getSubEscalaMasc().put(30,74);
		getSubEscalaMasc().put(29,72);
		getSubEscalaMasc().put(28,70);
		getSubEscalaMasc().put(27,68);
		getSubEscalaMasc().put(26,66);
		getSubEscalaMasc().put(25,64);
		getSubEscalaMasc().put(24,62);
		getSubEscalaMasc().put(23,61);
		getSubEscalaMasc().put(22,59);
		getSubEscalaMasc().put(21,57);
		getSubEscalaMasc().put(20,54);
		getSubEscalaMasc().put(19,52);
		getSubEscalaMasc().put(18,50);
		getSubEscalaMasc().put(17,47);
		getSubEscalaMasc().put(16,45);
		getSubEscalaMasc().put(15,42);
		getSubEscalaMasc().put(14,40);
		getSubEscalaMasc().put(13,38);
		getSubEscalaMasc().put(12,36);
		getSubEscalaMasc().put(11,34);
		getSubEscalaMasc().put(10,32);
		getSubEscalaMasc().put(9,30);
		
		// D Femeninas
		getSubEscalaFem().put(53,120);
		getSubEscalaFem().put(52,118);
		getSubEscalaFem().put(51,116);
		getSubEscalaFem().put(50,114);
		getSubEscalaFem().put(49,112);
		getSubEscalaFem().put(48,109);
		getSubEscalaFem().put(47,107);
		getSubEscalaFem().put(46,105);
		getSubEscalaFem().put(45,103);
		getSubEscalaFem().put(44,101);
		getSubEscalaFem().put(43,99);
		getSubEscalaFem().put(42,96);
		getSubEscalaFem().put(41,94);
		getSubEscalaFem().put(40,92);
		getSubEscalaFem().put(39,90);
		getSubEscalaFem().put(38,88);
		getSubEscalaFem().put(37,86);
		getSubEscalaFem().put(36,83);
		getSubEscalaFem().put(35,81);
		getSubEscalaFem().put(34,79);
		getSubEscalaFem().put(33,77);
		getSubEscalaFem().put(32,75);
		getSubEscalaFem().put(31,72);
		getSubEscalaFem().put(30,70);
		getSubEscalaFem().put(29,68);
		getSubEscalaFem().put(28,66);
		getSubEscalaFem().put(27,64);
		getSubEscalaFem().put(26,62);
		getSubEscalaFem().put(25,59);
		getSubEscalaFem().put(24,57);
		getSubEscalaFem().put(23,55);
		getSubEscalaFem().put(22,53);
		getSubEscalaFem().put(21,51);
		getSubEscalaFem().put(20,49);
		getSubEscalaFem().put(19,47);
		getSubEscalaFem().put(18,46);
		getSubEscalaFem().put(17,44);
		getSubEscalaFem().put(16,42);
		getSubEscalaFem().put(15,40);
		getSubEscalaFem().put(14,38);
		getSubEscalaFem().put(13,36);
		getSubEscalaFem().put(12,34);
		getSubEscalaFem().put(11,32);
		getSubEscalaFem().put(10,30);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.D_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.D_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_D;
	}

}
