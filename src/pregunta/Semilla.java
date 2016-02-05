package pregunta;
import java.util.Calendar;
import java.util.Date;

import problemas.Knapsack;
import problemas.Problema;
import problemas.SubsecuenciaComun;



public class Semilla {


	public static final Integer MOCHILA = 1;
	
	
	public static final Integer SUBSECUENCIA = 2;
	

	public static final Integer FLOYD = 3;
	

	public static final Integer MULTIPLICACION_MATRICES = 4;

	private String seedDelRandom;
	
	

	public Semilla(Object var1, Object var2, String tipo){
		if (tipo == "mochila"){
			String formatvar1 = "000".substring(Integer.toString((int) var1).length()) + var1;
			String formatvar2 = "000".substring(Integer.toString((int) var2).length()) + var2;

			//String porcentaje = "000".substring(Integer.toString((int) pct).length()) + pct;
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
		if (tipo == "floyd"){
			String formatvar1 = "000".substring(Integer.toString((int) var1).length()) + var1;
			String auxiliar = Long.toString(System.currentTimeMillis());
			auxiliar = auxiliar.substring(auxiliar.length()-10, auxiliar.length());
			seedDelRandom = FLOYD.toString() + formatvar1 + auxiliar;
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