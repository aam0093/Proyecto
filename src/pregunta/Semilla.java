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
			String auxiliar = Long.toString(System.currentTimeMillis()).substring(0, 7);
			seedDelRandom = MOCHILA.toString() + formatvar1 + formatvar2 + auxiliar;
		}
		if (tipo == "lcs"){
			int cad1 = ((String) var1).length();
			int cad2 = ((String) var2).length();
			String formatvar1 = "000".substring(Integer.toString(cad1).length()) + cad1;
			String formatvar2 = "000".substring(Integer.toString(cad2).length()) + cad2;
			String auxiliar = Long.toString(System.currentTimeMillis()).substring(0, 7);
			seedDelRandom = SUBSECUENCIA.toString() + formatvar1 + formatvar2 + auxiliar;
		}
		if (tipo == "TSP")
			seedDelRandom = VIAJANTE.toString() + Integer.toString((int) var1) + Integer.toString((int) var2);
		if (tipo == "matrices"){
			String formatvar1 = "000".substring(Integer.toString((int) var1).length()) + var1;
			String formatvar2 = "000".substring(Integer.toString((int) var2).length()) + var2;
			String auxiliar = Long.toString(System.currentTimeMillis()).substring(0, 7);
			seedDelRandom = SUBSECUENCIA.toString() + formatvar1 + formatvar2 + auxiliar;
		}
	}
	


	public Semilla(int var, Date fecha){
		
	}

	public long getSeed(){
		return Long.parseLong(seedDelRandom);
	}
	


}