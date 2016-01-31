// http://sourcecodesforfree.blogspot.com.es/2013/05/24-travelling-sales-person-problem-tsp.html
package problemas;

import java.util.*;

/**
 * @author Asier Alonso Morante
 *
 */
public class TSP implements Problema {
	private static int[][] distancias;
	private int[] path;
	private int numNodos;
	private int finalCost = 0;
	private int maxDist;
	private int start;
	private String camino = "1-";
	private Stack<Integer> stack = new Stack<Integer>();

	public TSP(int n) {
		numNodos = n;
		path =new int[numNodos-1];
		distancias = new int[numNodos + 1][numNodos + 1];
	}

	public void startNode(int n) {
		int start = 0;
	}

	public void initialize(int maxDist) {
		/*
		 * for (int i = 0; i < distancias.length; i++) { for (int j = 0; j <
		 * distancias.length; j++) { if (i == j) { distancias[i][j] = -1; } else
		 * { distancias[i][j] = (int) (Math.random() * maxDist); } } }
		 */

		distancias[0][0] = 0;
		distancias[0][1] = 10;
		distancias[0][2] = 8;
		distancias[0][3] = 9;
		distancias[0][4] = 7;

		distancias[1][0] = 10;
		distancias[1][1] = 0;
		distancias[1][2] = 10;
		distancias[1][3] = 5;
		distancias[1][4] = 6;

		distancias[2][0] = 8;
		distancias[2][1] = 10;
		distancias[2][2] = 0;
		distancias[2][3] = 8;
		distancias[2][4] = 9;

		distancias[3][0] = 9;
		distancias[3][1] = 5;
		distancias[3][2] = 8;
		distancias[3][3] = 0;
		distancias[3][4] = 6;

		distancias[4][0] = 7;
		distancias[4][1] = 6;
		distancias[4][2] = 9;
		distancias[4][3] = 6;
		distancias[4][4] = 0;

	}

	public int[][] getMatriz() {
		return distancias;
	}

	public int getNumNodos() {
		return numNodos;
	}

	public int getDistance(int n, int sta) {
		int distancia = 0;
		distancia = distancias[sta][n];
		return distancia;
	}

	public int[] getPath() {
		return path;
	}

	public int[][] getDist() {
		return distancias;
	}

	public void resolve() {
		int dummySet[] = new int[numNodos - 1];
		for (int i = 1; i < numNodos; i++)
			dummySet[i - 1] = i;
		finalCost = COST(0, dummySet, numNodos - 1);
		constructTour();
	}

	public int COST(int currentNode, int inputSet[], int setSize) {
		if (setSize == 0)
			return distancias[currentNode][0];
		int min = Integer.MAX_VALUE, minindex = 0;
		int setToBePassedOnToNextCallOfCOST[] = new int[numNodos - 1];
		for (int i = 0; i < setSize; i++) {
			int k = 0;// initialise new set
			for (int j = 0; j < setSize; j++) {
				if (inputSet[i] != inputSet[j])
					setToBePassedOnToNextCallOfCOST[k++] = inputSet[j];
			}
			int temp = COST(inputSet[i], setToBePassedOnToNextCallOfCOST, setSize - 1);
			if ((distancias[currentNode][inputSet[i]] + temp) < min) {
				min = distancias[currentNode][inputSet[i]] + temp;
				minindex = inputSet[i];
			}
		}
		return min;
	}

	public void constructTour() {
		int previousSet[] = new int[numNodos - 1];
		int nextSet[] = new int[numNodos - 2];
		for (int i = 1; i < numNodos; i++)
			previousSet[i - 1] = i;
		int setSize = numNodos - 1;
		path[0] = MIN(0, previousSet, setSize);
		for (int i = 1; i < numNodos - 1; i++) {
			int k = 0;
			for (int j = 0; j < setSize; j++) {
				if (path[i - 1] != previousSet[j])
					nextSet[k++] = previousSet[j];
			}
			// setSize;
			path[i] = MIN(path[i - 1], nextSet, setSize);
			for (int j = 0; j < setSize; j++)
				previousSet[j] = nextSet[j];
		}
	}

	public String execute() {
		int coleccion[] = new int[numNodos - 1];
		for (int i = 1; i < numNodos; i++)
			coleccion[i - 1] = i;
		finalCost = COST(0, coleccion, numNodos - 1);
		constructTour();
		return "";
	}

	public int MIN(int currentNode,int inputSet[],int setSize){
		if(setSize==0)
			return distancias[currentNode][0];
		int min=Integer.MAX_VALUE ,minindex=0;
		int setToBePassedOnToNextCallOfCOST[]=new int[numNodos-1];
		for(int i=0;i<setSize;i++){//considers each node of inputSet
			int k=0;
			for(int j=0;j<setSize;j++){
				System.out.println("PASE" );
				if(inputSet[i]!=inputSet[j])
					setToBePassedOnToNextCallOfCOST[k++]=inputSet[j];
			}
			int temp=COST(inputSet[i],setToBePassedOnToNextCallOfCOST,setSize-1);
			if((distancias[currentNode][inputSet[i]]+temp) < min){
				min=distancias[currentNode][inputSet[i]]+temp;
				minindex=inputSet[i];
			}
		}
	return minindex;
	}
	
	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Problema recuperarProblema(String semilla) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTipoPregunta() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCamino() {
		return camino;
	}

	@Override
	public void setTipoPregunta(int tipoPregunta) {
		// TODO Auto-generated method stub

	}
	
	   public static void main(String[] args){
		   TSP viajante = new TSP(5);
		   viajante.execute();
		   System.out.println("Tamaño minimo " + viajante.finalCost);
	   }
}
