package com.hexsoft.athos.test.mmpi2.calculador.escalas.basicas;

import com.hexsoft.athos.test.mmpi2.calculador.ACalculadorSubescalas;

public class CalculadorSubescalaSI extends ACalculadorSubescalas {

	private static CalculadorSubescalaSI instance;

	private CalculadorSubescalaSI() {
		inicializarConstantesMyF();
	}

	public static CalculadorSubescalaSI getInstance() {
		if (instance == null) {
			instance = new CalculadorSubescalaSI();
		}
		return instance;
	}
	
	@Override
	protected void inicializarConstantesMyF() {
		// SI Masculino
		getSubEscalaMasc().put(69, 100);
		getSubEscalaMasc().put(68, 99);
		getSubEscalaMasc().put(67, 98);
		getSubEscalaMasc().put(66, 97);
		getSubEscalaMasc().put(65, 96);
		getSubEscalaMasc().put(64, 94);
		getSubEscalaMasc().put(63, 93);
		getSubEscalaMasc().put(62, 92);
		getSubEscalaMasc().put(61, 91);
		getSubEscalaMasc().put(60, 90);
		getSubEscalaMasc().put(59, 89);
		getSubEscalaMasc().put(58, 87);
		getSubEscalaMasc().put(57, 86);
		getSubEscalaMasc().put(56, 85);
		getSubEscalaMasc().put(55, 84);
		getSubEscalaMasc().put(54, 83);
		getSubEscalaMasc().put(53, 82);
		getSubEscalaMasc().put(52, 80);
		getSubEscalaMasc().put(51, 79);
		getSubEscalaMasc().put(50, 78);
		getSubEscalaMasc().put(49, 77);
		getSubEscalaMasc().put(48, 76);
		getSubEscalaMasc().put(47, 75);
		getSubEscalaMasc().put(46, 73);
		getSubEscalaMasc().put(45, 72);
		getSubEscalaMasc().put(44, 71);
		getSubEscalaMasc().put(43, 70);
		getSubEscalaMasc().put(42, 69);
		getSubEscalaMasc().put(41, 68);
		getSubEscalaMasc().put(40, 66);
		getSubEscalaMasc().put(39, 65);
		getSubEscalaMasc().put(38, 64);
		getSubEscalaMasc().put(37, 63);
		getSubEscalaMasc().put(36, 62);
		getSubEscalaMasc().put(35, 61);
		getSubEscalaMasc().put(34, 59);
		getSubEscalaMasc().put(33, 58);
		getSubEscalaMasc().put(32, 57);
		getSubEscalaMasc().put(31, 56);
		getSubEscalaMasc().put(30, 55);
		getSubEscalaMasc().put(29, 54);
		getSubEscalaMasc().put(28, 52);
		getSubEscalaMasc().put(27, 51);
		getSubEscalaMasc().put(26, 50);
		getSubEscalaMasc().put(25, 49);
		getSubEscalaMasc().put(24, 48);
		getSubEscalaMasc().put(23, 47);
		getSubEscalaMasc().put(22, 45);
		getSubEscalaMasc().put(21, 44);
		getSubEscalaMasc().put(20, 43);
		getSubEscalaMasc().put(19, 42);
		getSubEscalaMasc().put(18, 41);
		getSubEscalaMasc().put(17, 40);
		getSubEscalaMasc().put(16, 38);
		getSubEscalaMasc().put(15, 37);
		getSubEscalaMasc().put(14, 36);
		getSubEscalaMasc().put(13, 35);
		getSubEscalaMasc().put(12, 34);
		getSubEscalaMasc().put(11, 33);
		getSubEscalaMasc().put(10, 31);
		getSubEscalaMasc().put(9, 30);

		// SI Femenino
		getSubEscalaFem().put(69,95);
		getSubEscalaFem().put(68,94);
		getSubEscalaFem().put(67,93);
		getSubEscalaFem().put(66,91);
		getSubEscalaFem().put(65,90);
		getSubEscalaFem().put(64,89);
		getSubEscalaFem().put(63,88);
		getSubEscalaFem().put(62,87);
		getSubEscalaFem().put(61,86);
		getSubEscalaFem().put(60,85);
		getSubEscalaFem().put(59,84);
		getSubEscalaFem().put(58,83);
		getSubEscalaFem().put(57,82);
		getSubEscalaFem().put(56,81);
		getSubEscalaFem().put(55,79);
		getSubEscalaFem().put(54,78);
		getSubEscalaFem().put(53,77);
		getSubEscalaFem().put(52,76);
		getSubEscalaFem().put(51,75);
		getSubEscalaFem().put(50,74);
		getSubEscalaFem().put(49,73);
		getSubEscalaFem().put(48,72);
		getSubEscalaFem().put(47,71);
		getSubEscalaFem().put(46,70);
		getSubEscalaFem().put(45,69);
		getSubEscalaFem().put(44,67);
		getSubEscalaFem().put(43,66);
		getSubEscalaFem().put(42,65);
		getSubEscalaFem().put(41,64);
		getSubEscalaFem().put(40,63);
		getSubEscalaFem().put(39,62);
		getSubEscalaFem().put(38,61);
		getSubEscalaFem().put(37,60);
		getSubEscalaFem().put(36,59);
		getSubEscalaFem().put(35,58);
		getSubEscalaFem().put(34,57);
		getSubEscalaFem().put(33,55);
		getSubEscalaFem().put(32,54);
		getSubEscalaFem().put(31,53);
		getSubEscalaFem().put(30,52);
		getSubEscalaFem().put(29,51);
		getSubEscalaFem().put(28,50);
		getSubEscalaFem().put(27,49);
		getSubEscalaFem().put(26,48);
		getSubEscalaFem().put(25,47);
		getSubEscalaFem().put(24,46);
		getSubEscalaFem().put(23,45);
		getSubEscalaFem().put(22,43);
		getSubEscalaFem().put(21,42);
		getSubEscalaFem().put(20,41);
		getSubEscalaFem().put(19,40);
		getSubEscalaFem().put(18,39);
		getSubEscalaFem().put(17,38);
		getSubEscalaFem().put(16,37);
		getSubEscalaFem().put(15,36);
		getSubEscalaFem().put(14,35);
		getSubEscalaFem().put(13,34);
		getSubEscalaFem().put(12,33);
		getSubEscalaFem().put(11,32);
		getSubEscalaFem().put(10,30);
	}

	@Override
	protected Integer[] getPreguntasAChequearPorVerdadero() {
		return ConstantesEscalasBasicas.SI_ANSWERS_T;
	}

	@Override
	protected Integer[] getpreguntasAChequearPorFalso() {
		return ConstantesEscalasBasicas.SI_ANSWERS_F;
	}

	@Override
	public String getDenominadorEscala() {
		return ConstantesEscalasBasicas.SUBESCALA_SI;
	}

}
