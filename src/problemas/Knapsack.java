/**
 * 
 */
package problemas;

/**
 * @author Asier Alonso
 *
 */
/**
 * Clase Knapsack
 *
 * @author <A HREF="mailto:aam0093@alu.ubu.es"> Asier Alonso Morante </A>
 * @version 1 
 */
public class Knapsack implements Problemas{
	int capacity;
	int numElements;
	double[] weight;
	double[] values;
	double [][] knaspackMatrix;

//
	public Knapsack(int maxWeight, int elements){
		capacity=maxWeight;
		numElements = elements;
		weight = new double[numElements];
		values = new double[numElements];
		knaspackMatrix = new double [numElements+1][capacity + 1];
	}//Constructor()
	
	
	/*
	 * Initialize objects with selected values
	 */
	public void initializeWeights(double[] weights, double[] values	){
		this.weight = weights;
		this.values = values;
	}
	
	/*
	 * Initialize objects with random values
	 */
	public void initializeWeights(){
		for (int i = 0; i < numElements ; i++){
			weight[i] = Math.random()*30;
			values[i] = Math.random()*30;
		}
	
	}

	public void fillKnaspackMatrix(){
		//Rellenamos la 1ª fila de ceros
		   for(int i = 0; i <= capacity; i++)
		            knaspackMatrix[0][i] = 0; 

		   //Rellenamos la 1ª columna de ceros
		   for(int i = 0; i <= weight.length; i++)  
		           knaspackMatrix[i][0] = 0;   

		        for(int j = 1; j <= weight.length ; j++)  {
					for(int c = 1; c <= capacity; c++){  
						if(c <  weight[j-1] ){   
							knaspackMatrix[j][c] = knaspackMatrix[j-1][c]; 
						}else{   
							if(knaspackMatrix[j-1][c] > knaspackMatrix[j-1][(int) (c-weight[j-1])]+ values[j-1]){
								knaspackMatrix[j][c] = knaspackMatrix[j-1][c];
							}else{
								knaspackMatrix[j][c] = knaspackMatrix[j-1][(int) (c-weight[j-1])]+values[j-1];
							}
						}
					}
				}
		     }

	public double[][] getMatrix(){
		return knaspackMatrix;
	}
	
	public double getMaxProfit() {
		// TODO Auto-generated method stub
		return knaspackMatrix[capacity+1][numElements+1];
	}

	

	@Override
	public void export(String format) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[]args){
		Knapsack mochila = new Knapsack(7,4);
		double[] pesos = {5.0,1.0,4.0,3.0};
		double[] beneficio = {8.0,2.0,3.0,2.0};
		mochila.initializeWeights(pesos, beneficio);
		mochila.fillKnaspackMatrix();
		double[][] matriz = mochila.getMatrix();
		for (double[] fila : matriz) {
			System.out.println();
			for (double el : fila){
				System.out.print(el+ " ");
			}
		}
	}


	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
}//Clase Knapsack

