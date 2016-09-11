/**
 * 
 */
package problemas;

import java.util.Random;

import pregunta.Semilla;

/**
 * @author asier_000
 *
 */
public class Floyd implements Problema {
	int[][] caminos;
	int resultado[][];
	int numVertices = 0;
	int porcentaje;
	int[][] grafo;
	public static int inf = 9999;

	/** Indica el valor de la semilla del Problema */
	public long semilla = 0;

	public Floyd(int numV) {
		numVertices = numV;
		Semilla seed = new Semilla(numV,0,0, 0, "floyd");
		semilla = seed.getSeed();
		grafo = new int[numV][numV];
		caminos = new int[numV][numV];
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


		for (int k = 1; k < numVertices; k++) {
			for (int i = 1; i < numVertices; i++) {
				for (int j = 1; j < numVertices; j++) {
					if (resultado[i][k] + resultado[k][j] < resultado[i][j]) {
						resultado[i][j] = resultado[i][k] + resultado[k][j];
						caminos[i][j] = caminos[k][j];
					}
				}
			}
		}
		return null;
	}

	public int[][] getGrafoInicial() {
		return grafo;
	}

	public int getNumVertices() {
		return numVertices;
	}

	public int[][] getResultado() {
		return resultado;
	}

	public int[][] getCaminos() {
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
		floyd = new Floyd(numVertices, Long.valueOf(semilla).longValue());
		return floyd;
	}

	public void initGrafo() {
		Random rnd = new Random(semilla);
		Random values = new Random(semilla);
		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				if (i == j) {
					grafo[i][j] = 0;
					caminos[i][j] = i;
				} else {
					if (rnd.nextInt(100) >= 74) {
						grafo[i][j] = inf;
						caminos[i][j] = -1;
					} else {
						grafo[i][j] = values.nextInt(14) + 1;
						caminos[i][j] = i;
					}
				}
			}
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
