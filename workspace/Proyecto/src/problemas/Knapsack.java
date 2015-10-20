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
	double capacity;
	int numElements;
	double[] weight;
	double[] values;

//
	public Knapsack(double maxWeight, int elements){
		capacity=maxWeight;
		numElements = elements;
	}//Constructor()

	public void initializeObjects(double[] weights, double[] values	){
		this.weight = weights;
		this.values = values;
	}
	
	/*
	 * Initialize objects with random values
	 */
	public void initializeObjects(){
		for (int i = 0; i < numElements ; i++){
			weight[i] = Math.random()*30;
			values[i] = Math.random()*30;
		}
	
	}
	
	/**
	 * Método que calcula el peso total de los elementos en la mochila
	 * @return
	 */
	public int solutionWeight() {
		
		double[] proporcionPeso= solution();
		double[] pesosSolucion = new double[proporcionPeso.length];
		int pesoSolucion=0;
		
		for(int i=0; i<proporcionPeso.length; i++){
			pesosSolucion[i]=weight[i]*proporcionPeso[i];
		}
		for(int i=0; i<pesosSolucion.length;i++){
			if(i>0)
			pesosSolucion[i]=pesosSolucion[i-1]+pesosSolucion[i];
			pesoSolucion=(int) pesosSolucion[i];
		}

		return pesoSolucion;
	}//solutionWeight()

	
	/**
	 * Método que calcula el valor total de los elementos en la mochila
	 * @return
	 */
	public int solutionValue() {
		double[] proporcionValor= solution();
		double[] valoresSolucion = new double[proporcionValor.length];
		int valorSolucion=0;
		
		for(int i=0; i<proporcionValor.length; i++){
			valoresSolucion[i]=values[i]*proporcionValor[i];
		}
		for(int i=0; i<valoresSolucion.length;i++){
			if(i>0)
			valoresSolucion[i]=valoresSolucion[i-1]+valoresSolucion[i];
			valorSolucion=(int) valoresSolucion[i];
		}

		return valorSolucion;
	}//solutionValue()

	/**
	 * Método que calcula la proporción de cada objeto en la mochila
	 * 
	 * @return
	 */
	public double[] solution() {
		double[] solucion = new double[values.length];
		double pesoSolucion=0;
		int i=0;
		int[] posicion=mejorAjuste();
		
		for(int j=0; j<values.length; j++){
			solucion[j]=0;
		}
		while(i<values.length){
			if(pesoSolucion + weight[posicion[i]]<=capacity){
				solucion[posicion[i]]=1;
				pesoSolucion=pesoSolucion+weight[posicion[i]];
			}else{
				solucion[posicion[i]]=(capacity-pesoSolucion)/weight[posicion[i]];
				pesoSolucion=capacity;
			}
			i++;
		}
		return solucion;
	}//solution()
	
	/**
	 * Método privado, que crea un array con el orden (de máximo a mínimo)
	 *  de los elementos segun la proporcion entre valor y peso 
	 * @return
	 */
	private int[] mejorAjuste(){
		double[] valorPeso = new double[values.length];
		double maximo=0;
		int solucion=0;
		int[] posicion= new int[values.length];
		for(int i=0; i<values.length; i++){
			valorPeso[i]=values[i]/weight[i];
		}
		for(int j=0; j<values.length; j++){
			for(int i=0; i<values.length; i++){
				if(valorPeso[i]> maximo ){
					maximo = valorPeso[i];
					solucion=i;
				}
			}
			posicion[j]= solucion ;
			valorPeso[solucion]=0;
			maximo=0;
		}
		return posicion;
	}//mejorAjuste()


	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void export(String format) {
		// TODO Auto-generated method stub
		
	}
	

}//Clase Knapsack
