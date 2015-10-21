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
	private int[][] dist;
	private List<Integer> path;
	private int nodes;
	private int maxDist;
	public void numNodes(int n){
		nodes = n;
	}
	public void startNode(int n){
		int start = n;
	}
	public void initialize(int maxDist ){
		// this.maxDist = maxDist != null ? maxDist : 0;
		//Comprobar si son posibles argumentos opcionales.
		for (int i =0 ; i< dist.length; i++){
			for (int j=0; j< dist.length; j++){
				if ( i == j){
					dist[i][j] = -1; 
				}else{ 
					dist[i][j] = (maxDist != null) ? Math.random() * maxDist : Math.random(); 
					//if maxDist is null, asign random number without max.
				}
			}
		}
	}
	public int getDistance (int n,List<Integer> S){
		int distancia = 0, masCorto, nat;
		if (S.isEmpty()){
			return dist[n][1];
		}else{
			masCorto = Integer.MAX_VALUE; 
			for(int j : S ){
				S.remove(j); distancia = dist[n][j] + g(j,S); 
				if (distancia < masCorto){
					masCorto = distancia; 
				}
			}
		return distancia;
		}
	}
	
			
	public int resolve() {
		List<Integer> s = new ArrayList<Integer>();
		int distance = Integer.MAX_VALUE; 
		numNodes(4);
		initialize(15); 
		//	int startN = 1;
		for (int i =1 ; i < nodes; i++){
			//	if (i != startNode){
			if (g(i,s) < distance){
				distance = g(i,s); //}
			}
		}
	}
	
	
/* get the lowest distance between two different points 
 * 
 */
	private int g(int i, List<Integer> s) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	}