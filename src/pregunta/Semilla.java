package pregunta;
import java.util.Date;



public class Semilla {
/*
 * Las semillas tendran la siguiente estructura:
 * 
 * ## 	tipo de problema
 * ##	Parametro 1
 * ##	Parametro 2
 * ##	Parametro 3
 * ##	Parametro 4
 * 
 * */

	public static final String MOCHILA = "10";
	
	
	public static final String SUBSECUENCIA = "20";
	

	public static final String FLOYD = "30";
	

	public static final String MULTI_MATRICES ="40";

	private String seedDelRandom;
	
	

	public Semilla(Object var1, Object var2, Object var3, Object var4, String tipo){
		if (tipo == "mochila"){
			String formatvar1 = "00".substring(Integer.toString((int) var1).length()) + var1;
			String formatvar2 = "00".substring(Integer.toString((int) var2).length()) + var2;
			System.out.println("var3__ : " + var3.toString() );
			String formatvar3 = (var3 == null) ? "00" : "00".substring(Integer.toString((int) var3).length()) + var3;
			String formatvar4 = (var4 == null) ? "00" : "00".substring(Integer.toString((int) var4).length()) + var4;
			//Cogemos las 7 ultimas cifras del tiempo actual y se añaden a la semilla
			String auxiliar = Long.toString(System.currentTimeMillis());
			auxiliar = auxiliar.substring(auxiliar.length()-7, auxiliar.length());
			seedDelRandom = MOCHILA + formatvar1 + formatvar2 + formatvar3 + formatvar4 + auxiliar;
			System.out.println("semilla creada para la mochila : " + seedDelRandom);
		}
		if (tipo == "lcs"){
			String formatvar1 = "00".substring(Integer.toString((int) var1).length()) + var1;
			String formatvar2 = "00".substring(Integer.toString((int) var2).length()) + var2;
			//Cogemos las 7 ultimas cifras del tiempo actual y se añaden a la semilla
			String auxiliar = Long.toString(System.currentTimeMillis());
			auxiliar = auxiliar.substring(auxiliar.length()-7, auxiliar.length());
			seedDelRandom = SUBSECUENCIA + formatvar1 + formatvar2 + "0000" + auxiliar;
			System.out.println("semilla creada para la mochila : " + seedDelRandom);
		}
		if (tipo == "floyd"){
			String formatvar1 = "00".substring(Integer.toString((int) var1).length()) + var1;
			//Cogemos las 7 ultimas cifras del tiempo actual y se añaden a la semilla
			String auxiliar = Long.toString(System.currentTimeMillis());
			auxiliar = auxiliar.substring(auxiliar.length()-7, auxiliar.length());
			seedDelRandom = FLOYD + formatvar1 + "000000" + auxiliar;
			System.out.println("semilla creada para floyd : " + seedDelRandom);
		}
		if (tipo == "matrices"){
			String formatvar1 = "00".substring(Integer.toString((int) var1).length()) + var1;
			//Cogemos las 7 ultimas cifras del tiempo actual y se añaden a la semilla
			String auxiliar = Long.toString(System.currentTimeMillis());
			auxiliar = auxiliar.substring(auxiliar.length()-7, auxiliar.length());
			seedDelRandom = MULTI_MATRICES + formatvar1 + "000000" + auxiliar;
			System.out.println("semilla creada para la mochila : " + seedDelRandom);
		}
	}
	


	public Semilla(int var, Date fecha){
		
	}

	public long getSeed(){
		return Long.parseLong(seedDelRandom);
	}
	


}