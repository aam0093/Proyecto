package problemas;

import java.util.*;
import pregunta.Semilla;

/**
 * Clase que define la logica con la que se generaran los problemas de
 * Multiplicación de Matrices Encadenadas
 * 
 * @author: Asier Alonso Morante
 * @version: 20/01/2016/A
 */

public class MultiplicaMatrices implements Problema {

	/** Almacena la matriz con los valores de las operaciones */
	public static int[][] matrizResultado;

	/** Almacena la matriz con el número de las operaciones */
	public static int[][] matrizOperaciones;

	/** Variable que almacena el número de matrices que se van a multiplicar */
	public static int numMatrices;

	/**
	 * Matriz donde se almacenan las dimensiones de las matrices, contiene
	 * numMatrices-1 elementos ya que el segundo valor de cada matriz es el
	 * mismo que el primer valor de las dimensiones de la matriz que la sucede
	 */
	public int[] dimensiones;

	/** Almacena el tipo de Pregunta del problema */
	public int tipoPregunta;

	/** Indica el valor de la semilla del Problema */
	public long semilla = 0;

	int porcentaje = 0;

	/**
	 * Crea el problema el numero de matrices recibidas.
	 * 
	 * @param numMat
	 *            entero que indica el número de matrices que se van a
	 *            multiplicar
	 * @throws Exception
	 */
	public MultiplicaMatrices(int numMat) {
		numMatrices = numMat;
		dimensiones = new int[numMat + 1];
		Semilla seed = new Semilla(numMat, 0,0,0, "matrices");
		semilla = seed.getSeed();
	
	}

	public MultiplicaMatrices(int numMat, long sem) {
		numMatrices = numMat;
		dimensiones = new int[numMat + 1];
		semilla = sem;
		for (int i : dimensiones)
			System.out.println("dimensiones: " + i);
	}

	/**
	 * inicializa los valores de las matrices a partir de una semilla y los
	 * almacena en la matriz dimensiones
	 */
	public void initMatrices() {
		Random rnd = new Random(semilla);
		matrizResultado = new int[numMatrices][numMatrices + 1];
		matrizOperaciones = new int[numMatrices][numMatrices + 1];
		for (int i = 0; i < dimensiones.length; i++) {
			dimensiones[i] = rnd.nextInt((100 - 1) + 1) + 1;
		}
	}

	/**
	 * Ejecuta el problema
	 */
	@Override
	public String execute() {
		initMatrices();
		for (int i = 1; i < numMatrices; i++) {
			for (int j = 0; j <= numMatrices; j++) {
				if (i == j) {
					matrizResultado[i][j] = 0;
				} else {
					if (i == j - 1) {
						matrizResultado[i][j] = dimensiones[i - 1] * dimensiones[i] * dimensiones[i + 1];
					} else {
						llenarMatriz(i, j);
					}
				}
			}
		}
		return "OK";
	}

	/**
	 * Calcula de forma recursiva los valores menores de la multiplicacion de
	 * varias matrices
	 * 
	 * @param i
	 *            el indice de la primera matriz que se va a multiplicar
	 * @param j
	 *            el indice de la ultima matriz que se va a multiplicar
	 */
	public int llenarMatriz(int i, int j) {
		if (i == j)
			return 0;
		matrizResultado[i][j] = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int q = llenarMatriz(i, k) + llenarMatriz(k + 1, j) + dimensiones[i - 1] * dimensiones[k] * dimensiones[j];
			if (q < matrizResultado[i][j]) {
				matrizResultado[i][j] = q;
				matrizOperaciones[i][j] = k;
			}
		}
		return matrizResultado[i][j]; // and s;
	}

	/** Devuelve el numero de matrices del problema */
	public int getNumMatrices() {
		return numMatrices;
	}

	/** Devuelve la matriz que produce el problema */
	public int[][] getMatriz() {
		return matrizResultado;
	}

	/** Ejecuta el array con las dimensiones de las matrices */
	public int[] getDimensiones() {
		return dimensiones;
	}

	/** Devuelve el valor con el menor numero de operaciones */
	public int getResultado() {
		return matrizResultado[numMatrices - 1][numMatrices];
	}

	/** Devuelve el tipo de problema */
	@Override
	public String getTipo() {
		return TIPO.MATRICES.toString();
	}

	/**
	 * Recibe una semilla y permite recuperar un problema de matrices con unos
	 * valores ya determinados por la semilla
	 */
	@Override
	public Problema recuperarProblema(String semilla) {
		System.out.println("Entra a recuperar problema");
		MultiplicaMatrices matrices;
		int numMatrices = Integer.parseInt(semilla.substring(3, 6));
		System.out.println("Numero de matrices");
		matrices = new MultiplicaMatrices(numMatrices, Long.valueOf(semilla).longValue());
		return matrices;
	}


	public long getSemilla() {
		return semilla;
	}

	public void setPorcentaje(int pct) {
		porcentaje = pct;
	}

	public int getPorcentaje() {
		return porcentaje;
	}
	
	public static void main(String[]args){
		MultiplicaMatrices matrices = new MultiplicaMatrices(5);
		matrices.execute();
		int[][] matriz = matrices.getMatriz();
		System.out.println(matriz.length);
		for (int[] m : matriz){
			System.out.println();
			for (int a : m){
				System.out.print(a + " ");
			}
		}
	}
}