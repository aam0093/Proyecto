/**
 * Clase SubsecuenciaComun
 * 
 * Esta clase implementa la interface Problema y genera problemas de programación dinámica
 * del tipo de Subsecuencia Común Más Larga-
 *
 * @author Asier Alonso Morante
 * @version 1.2, 18/11/2015
 */

package problemas;

import java.util.Random;

import pregunta.Semilla;

public class SubsecuenciaComun implements Problema {

	/** Primera cadena objeto de la comparación */
	private String cadena1 = "";

	/** Segunda cadena objeto de la comparación */
	private String cadena2 = "";

	/** Almacena el resultado del problema */
	private String res = new String();

	/** Almacena la longitud maxima de la cadena resultado. Inicializa a -1 */
	int maxLength = -1;

	/** Matriz que resuelve el problema */
	int[][] matriz;

	long semilla = 0;
	int tipodePregunta;

	/**
	 * Crea el problema con las longitudes introducidas como parametros
	 * 
	 * @param longitud1
	 *            entero que indica la longitud deseada en la cadena 1
	 * @param longitud2
	 *            entero que indica la longitud deseada en la cadena 2
	 * @throws Exception
	 */
	public SubsecuenciaComun(int longitud1, int longitud2) {
		Random rd = new Random();
		int i = 0;
		int j = 0;
		while (i < longitud1) {
			char c = (char) (Math.random() * (102 - 97 + 1) + 97);
			cadena1 += c;
			i++;
		}
		while (j < longitud2) {
			char c = (char) (Math.random() * (102 - 97 + 1) + 97);
			cadena2 += c;
			j++;
		}
		Semilla seed = new Semilla(cadena1, cadena2, "lcs");
		semilla = seed.getSeed();
	}

	public boolean isValid(String c) {
		return c.isEmpty() ? true : false;
	}

	/** Obtiene la cadena 1 */
	public String getCadena1() {
		return cadena1;
	}

	/** Obtiene la cadena 2 */
	public String getCadena2() {
		return cadena2;
	}

	/** Obtiene la longitud de la cadena común */
	public int getMaxLenght() {
		return (maxLength > 0) ? maxLength : null;
	}

	/** Obtiene el resultado */
	public String getResult() {
		return res;
	}

	/** Obtiene la matriz */
	public int[][] getMatriz() {
		return matriz;
	}

	/** Obtiene el tipo de problema que es */
	@Override
	public String getTipo() {
		return "SUBSECUENCIA";
	}

	/**
	 * Ejecuta la resolución del problema con los datos obtenidos.
	 * 
	 * @throws
	 */
	@Override
	public String execute() {
		int n = cadena1.length();
		int m = cadena2.length();
		matriz = new int[n + 1][m + 1];
		int[][] aux = new int[n + 1][m + 1];

		initialize(n, m);

		// Rellena la matriz
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (cadena1.charAt(i - 1) == cadena2.charAt(j - 1)) {
					matriz[i][j] = matriz[i - 1][j - 1] + 1;
					aux[i][j] = 1; // 1 los valores son iguales
				} else if (matriz[i - 1][j] >= matriz[i][j - 1]) {
					matriz[i][j] = matriz[i - 1][j];
					aux[i][j] = 2; // toma el valor del elemento superior en la
									// matriz
				} else {
					matriz[i][j] = matriz[i][j - 1];
					aux[i][j] = 3; // toma el valor del elemento anterior en la
									// matriz
				}
			}
		}
		maxLength = matriz[n][m];

		// Lectura de la matriz
		int i = n;
		int j = m;
		while (i != 0 && j != 0) {
			if (aux[i][j] == 1) { // Coincidencia de caracteres, continua en
									// diagonal
				res = cadena1.charAt(i - 1) + res;
				i = i - 1;
				j = j - 1;
			}
			if (aux[i][j] == 2) { // Continúa hacia arriba
				i = i - 1;
			}
			if (aux[i][j] == 3) { // Continúa hacia la izquierda
				j = j - 1;
			}
		}
		return res;
	}

	/**
	 * Inicializa con ceros la matriz
	 * 
	 * @param n
	 *            tamaño de la cadena 1
	 * @param m
	 *            tamaño de la cadena 2
	 */
	private void initialize(int n, int m) {
		for (int i = 0; i <= n; i++) {
			matriz[i][0] = 0;
		}

		for (int j = 0; j <= m; j++) {
			matriz[0][j] = 0;
		}
	}

	@Override
	public Problema recuperarProblema(String semilla) {
		return null;
	}

	public long getSemilla() {
		return semilla;
	}

	@Override
	public int getTipoPregunta() {
		return tipodePregunta;
	}

	@Override
	public void setTipoPregunta(int tipoPregunta) {
		this.tipodePregunta = tipoPregunta;
	}

}
