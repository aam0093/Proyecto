/**
 * 
 */
package problemas;

import java.util.*;

import pregunta.Semilla;
import problemas.Problema.TIPO;

import java.lang.*;
import java.io.*;

/**
 * @author asier_000
 *
 */
public class Floyd implements Problema {


	int caminos[][];
	int resultado[][];
	int inf = Integer.MAX_VALUE;
	int numVertices = 0;
	int porcentaje;
	int[][] grafo;

	/** Indica el valor de la semilla del Problema */
	public long semilla = 0;

	public Floyd(int n) {
		numVertices = n;
		grafo = new int[n][n];
		caminos = new int[n][n];
	}

	public Floyd(int numV, long sem) {
		numVertices = numV;
		grafo = new int[numV][numV];
		caminos = new int[numV][numV];
		semilla = sem;

	}

	@Override
	public String execute() {
		initGrafo();
		resultado = new int[numVertices][numVertices];
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo.length; j++) {
				resultado[i][j] = grafo[i][j];
			}
		}	
//		 System.out.println("grafo");
//			for (int[] fila : grafo) {
//				for (int c : fila) {
//					System.out.print(c + " ");
//				}
//				System.out.println("");
			
			
		int resultado[][] = new int[numVertices][numVertices];
		resultado = grafo.clone();
		
		for (int i = 0; i<numVertices; i++)
		 	for(int j = 0; j<numVertices; j++)
		 		caminos[i][j] = 0;
		 for (int k = 0; k < numVertices; k++){
		 	for(int i = 0; i < numVertices; i++){
		 		for(int j = 0; j<numVertices; j++)
		 		{
		 			if (resultado[i][k] + resultado[k][j]< resultado[i][j])
		 			{
		 				resultado[i][j] = resultado[i][k] + resultado[k][j];
		 				caminos[i][j] = k;
		 			}
		 		}
	}
		 }
		
		 
		 System.out.println("resultado");
			for (int[] fila : resultado) {
				for (int c : fila) {
					System.out.print(c + " ");
				}
				System.out.println("");
			}
			
			
		 System.out.println("caminos");
			for (int[] fila : caminos) {
				for (int c : fila) {
					System.out.print(c + " ");
				}
				System.out.println("");
			}
		
		return null;
	}

	/**
	 * @param n
	 * @param enlaces
	 * @return
	 */
	public String getPath(int n, String[][] enlaces) {
		String enlacesres = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (enlaces[i][j].equals("") == true) {
						enlacesres += " De ( " + (i + 1) + " a " + (j + 1) + " ) = " + "( " + (i + 1) + " , " + (j + 1)
								+ " )" + "\n";
					} else
						enlacesres += " De ( " + (i + 1) + " a " + (j + 1) + " ) = ( " + (i + 1) + " , " + enlaces[i][j]
								+ " , " + (j + 1) + ")\n";
				}
			}
		}
		return enlacesres;
	}

	public static void main(String[] args) {

		Floyd floyd = new Floyd(3);
		System.out.println(floyd.execute());
	}

	public int[][] getDistancias() {
		return grafo;
	}

	public int getNumVertices() {
		return numVertices;
	}

	public int[][] getResultado() {
		return resultado;
	}
	
	public int[][] getCamino() {
		return caminos;
	}

	@Override
	public String getTipo() {
		return TIPO.FLOYD.toString();
	}

	@Override
	public Problema recuperarProblema(String semilla) {
		System.out.println("Entra a recuperar problema");
		Floyd floyd;
		int numVertices = Integer.parseInt(semilla.substring(3, 6));
		System.out.println("Numero de matrices");
		floyd = new Floyd(numVertices, Long.valueOf(semilla).longValue());
		return floyd;
	}

	public void initGrafo() {
		int inf = Integer.MAX_VALUE;
		 Random rnd = new Random();
		 for (int i = 0; i < numVertices; i++){
			 for (int j = 0; j < numVertices; j++){
				 	if (i == j){
				 		grafo [i][j] = 0;
				 	}else{
				 		if (Math.random()>= 0.75){
				 			grafo [i][j] = inf;
				 		}else{
				 			grafo [i][j] = rnd.nextInt(12);
				 		}
				 	}
			 	}
			 }
		 
		 

	 System.out.println("grafo");
	 for (int[] fila : grafo) {
		 for (int c : fila) {
			 System.out.print(c + " ");
		 }
		 System.out.println("");
	 	}
	 }

	public void setPorcentaje(int pct) {
		porcentaje = pct;
	}

	public int getPorcentaje() {
		return porcentaje;
	}
	
	public long getSemilla() {
		return semilla;
	}
}
