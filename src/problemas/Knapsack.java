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

public class Knapsack implements Problema {
	/** Indica la Capacidad que tendrá la Mochila */
	int capacidad;

	/** Número de elementos que tendremos disponibles */
	int numElements;

	/**
	 * Array con pesos de cada elemento, posicion 0 peso del elemento 1; pos
	 * 1,elemento 2..
	 */
	double[] weight;

	/**
	 * Array con valor de cada elemento, posicion 0 peso del elemento 1; pos
	 * 1,elemento 2..
	 */
	double[] values;

	/** Matriz de la mochila */
	double[][] matriz;

	/**
     * Crea el problema con la capacidad y numero de elementos introducidos
     * 
     * @param capacidad entero que indica la capacidad deseada
     * @param elementos entero que indica el numero de elementos del problema.
     * @throws Exception 
     */
	public Knapsack(int capacidad, int elementos) {
		this.capacidad = capacidad;
		numElements = elementos;
		weight = new double[numElements];
		values = new double[numElements];
		matriz = new double[numElements + 1][capacidad + 1];
	}// Constructor()

	/**
	 * Crea el problema con las longitudes introducidas como parametros
	 * 
	 * @param pesos
	 *            cadena con los pesos deseados para cada elemento del problema
	 * @param valores
	 *            cadena con los valores deseados para cada elemento del
	 *            problema
	 * @throws Exception
	 */
	public void initializeWeights(double[] pesos, double[] valores) {
		this.weight = pesos;
		this.values = valores;
	}

	/**
	 * Inicializa los pesos y valores con valores aleatorios.
	 * 
	 * @throws Exception
	 */
	public void initializeWeights() {
		for (int i = 0; i < numElements; i++) {
			weight[i] = Math.round((Math.random() * 30) + 1000) / 1000;
			values[i] = Math.round((Math.random() * 30) + 1000) / 1000;
		}
	}

	/**
	 * Rellena la matriz con los datos del problema
	 * 
	 * @throws Exception
	 */
	public void fillKnaspackMatrix() {
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
				} else {
					if (matriz[j - 1][c] > matriz[j - 1][(int) (c - weight[j - 1])] + values[j - 1]) {
						matriz[j][c] = matriz[j - 1][c];
					} else {
						matriz[j][c] = matriz[j - 1][(int) (c - weight[j - 1])] + values[j - 1];
					}
				}
			}
		}
	}

	/** Obtiene la matriz del problema */
	public double[][] getMatrix() {
		return matriz;
	}

	/** Obtiene el maximo beneficio obtenido */
	public double getMaxProfit() {
		return matriz[capacidad + 1][numElements + 1];
	}

	/** Ejecuta el problema */
	@Override
	public String execute() {
		initializeWeights();
		fillKnaspackMatrix();
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

	/** Obtiene el numero de elementos del problema */
	public int getNumElements() {
		return numElements;
	}


}// Clase Knapsack
