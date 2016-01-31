package pregunta;
import java.util.Calendar;
import java.util.Date;

import problemas.Knapsack;
import problemas.Problema;
import problemas.SubsecuenciaComun;
import problemas.TSP;



public class Semilla {


	public static final Integer MOCHILA = 10;
	
	
	public static final Integer SUBSECUENCIA = 20;
	

	public static final Integer VIAJANTE = 30;
	

	public static final Integer MULTIPLICACION_MATRICES = 40;

	private String seedDelRandom;
	
	

	public Semilla(Object var1, Object var2, String tipo){
		if (tipo == "mochila"){
		
			String formatvar1 = "000".substring(Integer.toString((int) var1).length()) + var1;
			String formatvar2 = "000".substring(Integer.toString((int) var2).length()) + var2;
			//Cogemos las 7 ultimas cifras del tiempo actual y se añaden a la semilla
			String auxiliar = Long.toString(System.currentTimeMillis());
			auxiliar = auxiliar.substring(auxiliar.length()-7, auxiliar.length());
			seedDelRandom = MOCHILA.toString() + formatvar1 + formatvar2 + auxiliar;
		}
		if (tipo == "lcs"){
			String formatvar1 = "000".substring(Integer.toString((int) var1).length()) + var1;
			String formatvar2 = "000".substring(Integer.toString((int) var2).length()) + var2;
			String auxiliar = Long.toString(System.currentTimeMillis());
			auxiliar = auxiliar.substring(auxiliar.length()-7, auxiliar.length());
			seedDelRandom = SUBSECUENCIA.toString() + formatvar1 + formatvar2 + auxiliar;
		}
		if (tipo == "TSP"){
			String formatvar1 = "000".substring(Integer.toString((int) var1).length()) + var1;
			String auxiliar = Long.toString(System.currentTimeMillis());
			auxiliar = auxiliar.substring(auxiliar.length()-10, auxiliar.length());
			seedDelRandom = VIAJANTE.toString() + formatvar1 + auxiliar;
		}
		if (tipo == "matrices"){
			String formatvar1 = "000".substring(Integer.toString((int) var1).length()) + var1;
			String auxiliar = Long.toString(System.currentTimeMillis());
			auxiliar = auxiliar.substring(auxiliar.length()-10, auxiliar.length());
			seedDelRandom = MULTIPLICACION_MATRICES.toString() + formatvar1 + auxiliar;
		}
	}
	


	public Semilla(int var, Date fecha){
		
	}

	public long getSeed(){
		return Long.parseLong(seedDelRandom);
	}
	


}