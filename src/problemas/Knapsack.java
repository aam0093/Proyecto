/**
 * Clase Knapsack
 *
 * Esta clase implementa la interface Problema y genera problemas de programación dinámica
 * del tipo de Mochila o Knapsack
 * 
 * @author Asier Alonso Morante 
 * @version 1.2 23/11/2015
 */
package problemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pregunta.Semilla;

/**
 * Clase que define la logica con la que se generaran los problemas del tipo
 * Mochila o Knapsack
 * 
 * @author: Asier Alonso Morante
 * @version: 20/01/2016/A
 */

/**
 * @author asier_000
 *
 */
public class Knapsack implements Problema {

	/** Indica el valor de la semilla del Problema */
	long semilla = 0;

	/** Indica el tipo de pregunta al que se exportará el problema. */
	int tipoPregunta = 0;

	/** Indica la Capacidad que tendrá la Mochila */
	int capacidad;

	/** Número de elementos que tendremos disponibles */
	int numElements;

	/**
	 * Array con pesos de cada elemento, posicion 0 peso del elemento 1; pos
	 * 1,elemento 2..
	 */
	int[] weight;

	/** Valor máximo para cualquier peso de los valores de la mochila */
	int maxWeight = 0;

	/** Valor máximo para cualquier valor de los elementos de la mochila */
	int maxValue = 0;

	/**
	 * Array con valor de cada elemento, posicion 0 peso del elemento 1; pos
	 * 1,elemento 2..
	 */
	int[] values;

	/** Matriz de la mochila */
	int[][] matriz;
	
	int[][] matrizAux;
	
	/** Matriz de la mochila */
	int porcentaje = 0;

	/**
	 * Crea el problema con la capacidad y numero de elementos introducidos
	 * 
	 * @param capacidad
	 *            entero que indica la capacidad deseada
	 * @param elementos
	 *            entero que indica el numero de elementos del problema.
	 * @throws Exception
	 */
	public Knapsack(int capacidad, int elementos) {
		this.capacidad = capacidad;
		numElements = elementos;
		Semilla seed = new Semilla(capacidad, elementos,0, 0, "mochila");
		semilla = seed.getSeed();
		weight = new int[numElements];
		values = new int[numElements];
		matriz = new int[numElements + 1][capacidad + 1];
		matrizAux = new int[numElements + 1][capacidad + 1];
		for (int i = 0; i < matrizAux.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matrizAux[i][j] = 0;
			}
		}
	}// Constructor()

	/**
	 * Contructor que recibe una semilla que se utilizará a la hora de recuperar
	 * un problema
	 * 
	 * @param capacidad
	 *            entero que indica la capacidad del problema.
	 * @param elementos
	 *            entero que indica el numero de elementos del problema.
	 * @param seed
	 *            variable tipo long que indica el valor de la semilla del
	 *            problema que se quiere recuperar.
	 * @throws Exception
	 */
	public Knapsack(int capacidad, int elementos, long seed) {
		this.capacidad = capacidad;
		this.numElements = elementos;
		semilla = seed;
		weight = new int[numElements];
		values = new int[numElements];
		matriz = new int[numElements + 1][capacidad + 1];
		matrizAux = new int[numElements + 1][capacidad + 1];
		for (int i = 0; i < matrizAux.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matrizAux[i][j] = 0;
			}
		}
	}

	/**
	 * Crea el problema con las longitudes introducidas como parametros
	 * 
	 * @param pesos cadena con los pesos deseados para cada elemento del problema
	 * @param valores cadena con los valores deseados para cada elemento del problema
	 * @throws Exception
	 */
	public void initializeWeights(int valores, int pesos) {
		Random rnd = new Random(semilla);
		for (int i = 0; i < numElements; i++) {
			weight[i] = (int) Math.round(rnd.nextDouble() * pesos + 1);
			values[i] = (int) Math.round(rnd.nextDouble() * valores + 1);
		}
	}

	/**
	 * Inicializa los pesos y valores con valores aleatorios.
	 * 
	 * @throws Exception
	 */
	public void initializeWeights() {
		Random rnd = new Random(semilla);
		for (int i = 0; i < numElements; i++) {
			weight[i] = (int) Math.round(rnd.nextDouble() * 30 + 1);
			values[i] = (int) Math.round(rnd.nextDouble() * 30 + 1);
		}
	}

	/**
	 * Rellena la matriz con los datos del problema
	 * 
	 * @throws Exception
	 */
	public void llenarMatriz() {
		// Rellenamos la 1ª fila de ceros
		for (int i = 0; i <= capacidad; i++)
			matriz[0][i] = 0;

		// Rellenamos la 1ª columna de ceros
		for (int i = 0; i <= weight.length; i++)
			matriz[i][0] = 0;

		for (int j = 1; j <= weight.length; j++) {
			for (int c = 1; c <= capacidad; c++) {
				if (c < weight[j - 1]) {
					matriz[j][c] = matriz[j - 1][c];
					matrizAux[j][c] = -1;
				} else {
					if (matriz[j - 1][c] > matriz[j - 1][(int) (c - weight[j - 1])] + values[j - 1]) {
						matriz[j][c] = matriz[j - 1][c];
						matrizAux[j][c] = 1;
					} else {
						matriz[j][c] = matriz[j - 1][(int) (c - weight[j - 1])] + values[j - 1];
						matrizAux[j][c] = -1;
					}
				}
			}
		}
	}

	/**
	 * Devuelve el valor de la semilla del problema
	 * 
	 * @throws Exception
	 */
	public long getSemilla() {
		return semilla;
	}

	/** Obtiene la matriz del problema */
	public int[][] getMatrix() {
		return matriz;
	}

	/** Obtiene el maximo beneficio obtenido */
	public double getMaxProfit() {
		return matriz[capacidad + 1][numElements + 1];
	}

	/** Ejecuta el problema */
	@Override
	public String execute() {
//		if (maxValue != 0 && maxWeight != 0) {
//			initializeWeights(maxValue, maxWeight);
//		} else {
			initializeWeights();
//		}

		llenarMatriz();
		return "";
	}

	/** Obtiene el tipo de problema */
	@Override
	public String getTipo() {
		return TIPO.MOCHILA.toString();
	}

	/** Obtiene la capacidad de la mochila */
	public int getCapacity() {
		return capacidad;
	}

	public void setMaxValue(int v) {
		maxValue = v;
	}

	public void setMaxWeigth(int w) {
		maxWeight = w;
	}

	/** Obtiene el numero de elementos del problema */
	public int getNumElements() {
		return numElements;
	}

	/** Obtiene los pesos de los elementos del problema */
	public int[] getWeights() {
		return weight;
	}

	/** Obtiene los valores de los elementos del problema */
	public int[] getValues() {
		return values;
	}

	/**
	 * Método que recibe una semilla y crea un problema con los datos que se
	 * generaran a partir de esa semilla
	 * 
	 * @param semilla
	 *            de tipo String
	 */
	@Override
	public Problema recuperarProblema(String semilla) {
		Knapsack mochila;
		int cantidad = Integer.parseInt(semilla.substring(3, 6));
		int numElem = Integer.parseInt(semilla.substring(6, 9));
		mochila = new Knapsack(cantidad, numElem,  Long.valueOf(semilla).longValue());
		return mochila;
	}

	/** Obtiene el valor final de la Mochila */
	public int getResultValue() {
		return matriz[numElements][capacidad];
	}

	/** Obtiene los elementos seleccionados para llenar la mochila */
	public List<Integer> getResultItems() {
		int elementos = numElements;
		List<Integer> listaElegidos = new ArrayList<Integer>();
		int[] elemElegidos = new int[numElements];
		int pos = 0;
		int i = numElements;
		int k = capacidad;
		while (i > 0){
			if(matriz[i][k] != matriz[i-1][k]){
				listaElegidos.add(i);
				i = i -1;
				k = k - weight[i];
			}else{
				i --;
			}
		}
		return listaElegidos;
	}

	public void setPorcentaje (int pct){
		porcentaje = pct;
	}
	
	public int getPorcentaje (){
		return porcentaje;
	}
	
	
	public static void main(String [] args){
		Knapsack m = new Knapsack(45,5);
		m.initializeWeights();
		System.out.print("Pesos: ");
		for (int r : m.getWeights()){
			System.out.print(r +"-");
		}
		System.out.print("Valores: ");
		for (int r : m.getValues()){
			System.out.print(r +"-");
		}
		m.execute();
		System.out.print("Matriz: ");
		for (int f[] : m.getMatrix()){
			System.out.println();
			for(int c : f)
				System.out.print(c +"-");
		}
		System.out.println("Valor obtenido: " + m.getResultValue());
		System.out.println("Elementos seleccionados: " + m.getResultItems().size() + " " +  m.getResultItems());
		m.getResultItems();
		
	}

}// Clase Knapsack
