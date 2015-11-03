/**
 * 
 */
package problemas;

import java.util.*;

/**
 * @author Asier Alonso Morante
 *
 */
public class TSP { 
	private static int[][] dist;
	private static List<Integer> path = new ArrayList<Integer>();
	private int nodes;
	private int maxDist;
	private int start ;	
	public TSP(int n){
		nodes = n;
		dist = new int[nodes][nodes];
	}
	public void startNode(int n){
		int start = 0;
	}
	
	public void initialize(int maxDist ){
		for (int i =0 ; i< dist.length; i++){
			for (int j=0; j< dist.length; j++){
				if ( i == j){
					dist[i][j] = -1; 
				}else{ 
					dist[i][j] = (int) (Math.random() * maxDist); 
				}
			}
		}
	}
	public int getDistance (int n,int sta){
		int distancia = 0;
		distancia = dist[sta][n];
		return distancia;
		}
	
	public List<Integer>getPath(){
		return path;
	}
	
	public int[][] getDist(){
		return dist;
	}
			
	public void resolve() {
		List<Integer> s = new ArrayList<Integer>();
		int aux=-5;
		int next = start;
		//	int startN = 1;
		while(s.size() < nodes){
			int distance = Integer.MAX_VALUE; 
			//	if (i != startNode){
			for (int i = 0; i < nodes;i++){
				if (next != i && !path.contains(i+1)){
					if (getDistance(i,next) < distance){
						distance = getDistance(i,next); //}
						aux = i; 
					}
				}
			}
			s.add(aux);
			path.add(aux+1);
			next = aux;
		}
		
	}
	
	public static void main(String[]args){
		TSP viajante = new TSP(4);
		viajante.startNode(0);
		viajante.initialize(10);
		for (int [] fila : dist  ){
			System.out.println("");
			for (int el : fila){
				System.out.print(el + " ");
			}
			
		}
		System.out.println("");
		viajante.resolve();
		System.out.println("Camino minimo : " + viajante.getPath());
		
	
	}
}