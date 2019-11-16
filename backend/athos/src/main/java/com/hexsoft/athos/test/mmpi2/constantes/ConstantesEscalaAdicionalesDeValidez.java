package com.hexsoft.athos.test.mmpi2.constantes;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstantesEscalaAdicionalesDeValidez{

	public static final String ADICIONALES_DE_VALIDEZ = "Adicionales de Validez";

	public static final String PB = "PB";
	public static final String PTM = "PTM";
	public static final String PTF = "PTF";

	public static final String SUBESCALA_FB_BACK = "SUBESCALA_FB_BACK";
																		  //282, 292, 304, 312, 318, 320, 323, 324, 330, 333, 334, 335, 388, 396, 408, 432, 451, 455, 464, 469, 477, 479, 485, 490, 507, 517, 518, 521, 525, 526, 527, 529, 531, 540, 541, 545, 556
	public static final Integer[] FB_BACK_RESPUESTAS_T =     new Integer[] {281, 291, 303, 311, 317, 319, 322, 323, 329, 332, 333, 334, 387, 395, 407, 431, 450, 454, 463, 468, 476, 478, 484, 489, 506, 516, 517, 520, 524, 525, 526, 528, 530, 539, 540, 544, 555};
																		  //384, 405, 502
	public static final Integer[] FB_BACK_RESPUESTAS_F =     new Integer[] {383, 404, 501};
	public static final HashMap<Integer, Integer> FB_BACK_MASCULINA = new HashMap<>();
	static {
		FB_BACK_MASCULINA.put(19, 120);
		FB_BACK_MASCULINA.put(18, 116);
		FB_BACK_MASCULINA.put(17, 112);
		FB_BACK_MASCULINA.put(16, 108);
		FB_BACK_MASCULINA.put(15, 104);
		FB_BACK_MASCULINA.put(14, 100);
		FB_BACK_MASCULINA.put(13, 96);
		FB_BACK_MASCULINA.put(12, 92);
		FB_BACK_MASCULINA.put(11, 87);
		FB_BACK_MASCULINA.put(10, 83);
		FB_BACK_MASCULINA.put(9, 79);
		FB_BACK_MASCULINA.put(8, 75);
		FB_BACK_MASCULINA.put(7, 71);
		FB_BACK_MASCULINA.put(6, 67);
		FB_BACK_MASCULINA.put(5, 63);
		FB_BACK_MASCULINA.put(4, 59);
		FB_BACK_MASCULINA.put(3, 55);
		FB_BACK_MASCULINA.put(2, 51);
		FB_BACK_MASCULINA.put(1, 46);
		FB_BACK_MASCULINA.put(0, 42);
	}
	public static final HashMap<Integer, Integer> FB_BACK_FEMENINA = new HashMap<>();
	static {
		FB_BACK_FEMENINA.put(20, 120);
		FB_BACK_FEMENINA.put(19, 116);
		FB_BACK_FEMENINA.put(18, 112);
		FB_BACK_FEMENINA.put(17, 108);
		FB_BACK_FEMENINA.put(16, 105);
		FB_BACK_FEMENINA.put(15, 101);
		FB_BACK_FEMENINA.put(14, 97);
		FB_BACK_FEMENINA.put(13, 93);
		FB_BACK_FEMENINA.put(12, 89);
		FB_BACK_FEMENINA.put(11, 85);
		FB_BACK_FEMENINA.put(10, 81);
		FB_BACK_FEMENINA.put(9, 77);
		FB_BACK_FEMENINA.put(8, 74);
		FB_BACK_FEMENINA.put(7, 70);
		FB_BACK_FEMENINA.put(6, 66);
		FB_BACK_FEMENINA.put(5, 62);
		FB_BACK_FEMENINA.put(4, 58);
		FB_BACK_FEMENINA.put(3, 54);
		FB_BACK_FEMENINA.put(2, 50);
		FB_BACK_FEMENINA.put(1, 46);
		FB_BACK_FEMENINA.put(0, 42);
	}
	
	public static final String SUBESCALA_F_P = "SUBESCALA_F(P)";
																	  //67, 115, 163, 194, 217, 229, 253, 271, 283, 292, 295, 323, 324, 337, 372, 388, 479, 556
	public static final Integer[] F_P_RESPUESTAS_T =     new Integer[] {66, 114, 162, 193, 216, 228, 252, 270, 282, 291, 294, 322, 323, 336, 371, 387, 478, 555};
	//																	52, 78, 91, 94, 103, 127, 193, 277, 502
	public static final Integer[] F_P_RESPUESTAS_F =     new Integer[] {51, 77, 90, 93, 102, 126, 192, 276, 501};
	public static final HashMap<Integer, Integer> F_P_MASCULINA = new HashMap<>();
	static {
		F_P_MASCULINA.put(11, 120);
		F_P_MASCULINA.put(10, 113);
		F_P_MASCULINA.put(9, 106);
		F_P_MASCULINA.put(8, 99);
		F_P_MASCULINA.put(7, 94);
		F_P_MASCULINA.put(6, 84);
		F_P_MASCULINA.put(5, 77);
		F_P_MASCULINA.put(4, 70);
		F_P_MASCULINA.put(3, 63);
		F_P_MASCULINA.put(2, 56);
		F_P_MASCULINA.put(1, 48);
		F_P_MASCULINA.put(0, 41);
	}
	public static final HashMap<Integer, Integer> F_P_FEMENINA = new HashMap<>();
	static {
		F_P_FEMENINA.put(10, 120);
		F_P_FEMENINA.put(9, 113);
		F_P_FEMENINA.put(8, 105);
		F_P_FEMENINA.put(7, 97);
		F_P_FEMENINA.put(6, 89);
		F_P_FEMENINA.put(5, 81);
		F_P_FEMENINA.put(4, 73);
		F_P_FEMENINA.put(3, 65);
		F_P_FEMENINA.put(2, 57);
		F_P_FEMENINA.put(1, 49);
		F_P_FEMENINA.put(0, 41);
	}
	
	public static final String SUBESCALA_DS = "SUBESCALA_DS";
	public static final Integer[] DS_RESPUESTAS_T =     new Integer[] {11, 17, 18, 19, 22, 28, 30, 31, 40, 42, 44, 54, 61, 72, 81, 85, 92, 111, 166, 190, 195, 205, 221, 252, 258, 268, 274, 287, 292, 294, 300, 307, 310, 320, 329, 362, 395, 412, 419, 421, 431, 433, 435, 436, 451, 458, 463};
	public static final Integer[] DS_RESPUESTAS_F =     new Integer[] {57, 75, 83, 108, 125, 188, 278, 318, 404, 429};
	public static final HashMap<Integer, Integer> DS_MASCULINA = new HashMap<>();
	public static final HashMap<Integer, Integer> DS_FEMENINA = new HashMap<>();
	
	public static final String SUBESCALA_DS_R = "SUBESCALA_DS_R";
	public static final Integer[] DS_R_RESPUESTAS_T =     new Integer[] {11, 18, 22, 28, 30, 31, 40, 44, 81, 85, 92, 111, 205, 221, 274, 292, 300, 320, 329, 362, 395, 419, 433, 451, 458, 463};
	public static final Integer[] DS_R_RESPUESTAS_F =     new Integer[] {57, 75, 83, 108, 278, 318};
	public static final HashMap<Integer, Integer> DS_R_MASCULINA = new HashMap<>();
	public static final HashMap<Integer, Integer> DS_R_FEMENINA = new HashMap<>();
	
	public static final String SUBESCALA_S = "SUBESCALA_S";
	public static final Integer[] S_RESPUESTAS_T =     new Integer[] {121, 148, 184, 194, 534, 560};
	public static final Integer[] S_RESPUESTAS_F =     new Integer[] {15, 50, 58, 76, 81, 87, 89, 104, 110, 120, 123, 154, 196, 205, 213, 225, 264, 279, 284, 290, 302, 337, 341, 346, 352, 373, 374, 403, 420, 423, 428, 430, 433, 442, 445, 449, 461, 486, 487, 523, 538, 542, 545, 547};
	public static final HashMap<Integer, Integer> S_MASCULINA = new HashMap<>();
	public static final HashMap<Integer, Integer> S_FEMENINA = new HashMap<>();
	
	public static final String SUBESCALA_SD = "SUBESCALA_SD";
	public static final Integer[] SD_RESPUESTAS_T =     new Integer[] {25, 49, 80, 100, 131, 133, 184, 194, 201, 206, 207, 211, 220, 249, 257, 263, 345, 351, 354, 356, 366, 402, 416, 439};
	public static final Integer[] SD_RESPUESTAS_F =     new Integer[] {29, 41, 77, 93, 183, 203, 232, 326, 341};
	public static final HashMap<Integer, Integer> SD_MASCULINA = new HashMap<>();
	public static final HashMap<Integer, Integer> SD_FEMENINA = new HashMap<>();
	
	public static final String SUBESCALA_SO = "SUBESCALA_SO";
	public static final Integer[] SO_RESPUESTAS_T =     new Integer[] {8, 20, 78, 95, 152, 186, 318, 335};
	public static final Integer[] SO_RESPUESTAS_F =     new Integer[] {31, 39, 48, 54, 127, 136, 146, 158, 168, 172, 221, 238, 243, 270, 273, 288, 289, 299, 300, 301, 306, 320, 324, 338, 349, 368, 415, 420, 469};
	public static final HashMap<Integer, Integer> SO_MASCULINA = new HashMap<>();
	public static final HashMap<Integer, Integer> SO_FEMENINA = new HashMap<>();
	
	public static final String SUBESCALA_VRIN = "SUBESCALA_VRIN";
	public static final HashMap<Integer, Integer> VRIN_MASCULINA = new HashMap<>();
	static {
		VRIN_MASCULINA.put(24, 120);
		VRIN_MASCULINA.put(23, 118);
		VRIN_MASCULINA.put(22, 115);
		VRIN_MASCULINA.put(21, 111);
		VRIN_MASCULINA.put(20, 107);
		VRIN_MASCULINA.put(19, 103);
		VRIN_MASCULINA.put(18, 99);
		VRIN_MASCULINA.put(17, 96);
		VRIN_MASCULINA.put(16, 92);
		VRIN_MASCULINA.put(15, 88);
		VRIN_MASCULINA.put(14, 84);
		VRIN_MASCULINA.put(13, 80);
		VRIN_MASCULINA.put(12, 76);
		VRIN_MASCULINA.put(11, 73);
		VRIN_MASCULINA.put(10, 69);
		VRIN_MASCULINA.put(9, 65);
		VRIN_MASCULINA.put(8, 61);
		VRIN_MASCULINA.put(7, 57);
		VRIN_MASCULINA.put(6, 54);
		VRIN_MASCULINA.put(5, 50);
		VRIN_MASCULINA.put(4, 46);
		VRIN_MASCULINA.put(3, 42);
		VRIN_MASCULINA.put(2, 38);
		VRIN_MASCULINA.put(1, 34);
		VRIN_MASCULINA.put(0, 30);
	}
	public static final HashMap<Integer, Integer> VRIN_FEMENINA = new HashMap<>();
	static {
		VRIN_FEMENINA.put(23, 120);
		VRIN_FEMENINA.put(22, 118);
		VRIN_FEMENINA.put(21, 114);
		VRIN_FEMENINA.put(20, 110);
		VRIN_FEMENINA.put(19, 106);
		VRIN_FEMENINA.put(18, 102);
		VRIN_FEMENINA.put(17, 98);
		VRIN_FEMENINA.put(16, 94);
		VRIN_FEMENINA.put(15, 90);
		VRIN_FEMENINA.put(14, 86);
		VRIN_FEMENINA.put(13, 82);
		VRIN_FEMENINA.put(12, 78);
		VRIN_FEMENINA.put(11, 74);
		VRIN_FEMENINA.put(10, 70);
		VRIN_FEMENINA.put(9, 66);
		VRIN_FEMENINA.put(8, 62);
		VRIN_FEMENINA.put(7, 58);
		VRIN_FEMENINA.put(6, 54);
		VRIN_FEMENINA.put(5, 50);
		VRIN_FEMENINA.put(4, 46);
		VRIN_FEMENINA.put(3, 42);
		VRIN_FEMENINA.put(2, 38);
		VRIN_FEMENINA.put(1, 34);
	}
	
	public static final String SUBESCALA_TRIN = "SUBESCALA_TRIN";
	public static final Integer[] TRIN_RESPUESTAS_T =     new Integer[] {};
	public static final Integer[] TRIN_RESPUESTAS_F =     new Integer[] {};
	public static final HashMap<Integer, Integer> TRIN_MASCULINA = new HashMap<>();
	static {
		/*TRIN_MASCULINA.put(19, 120);
		TRIN_MASCULINA.put(18 / 0, 114);
		TRIN_MASCULINA.put(17 / 1, 107);
		TRIN_MASCULINA.put(16 / 7, 99);
		TRIN_MASCULINA.put(15 / 3, 92);
		TRIN_MASCULINA.put(14 / 4, 86);
		TRIN_MASCULINA.put(13 / 5, 79);
		TRIN_MASCULINA.put(12 / 6, 72);
		TRIN_MASCULINA.put(11 / 7, 64);
		TRIN_MASCULINA.put(10, 57);
		TRIN_MASCULINA.put(9, 50);*/
	}
	public static final HashMap<Integer, Integer> TRIN_FEMENINA = new HashMap<>();
	static {
		/*TRIN_FEMENINA.put(19, 120);
		TRIN_FEMENINA.put(18 / 0, 118);
		TRIN_FEMENINA.put(17 / 1, 111);
		TRIN_FEMENINA.put(16 / 2, 103);
		TRIN_FEMENINA.put(15 / 3, 95);
		TRIN_FEMENINA.put(14 / 4, 88);
		TRIN_FEMENINA.put(13 / 5, 80);
		TRIN_FEMENINA.put(12 / 6, 73);
		TRIN_FEMENINA.put(11 / 7, 65);
		TRIN_FEMENINA.put(10, 58);
		TRIN_FEMENINA.put(9, 50);*/
	}
}
