/*Asier Alonso Morante */

package problemas;

public class MultiplicaMatrices implements Problema {
	private int num_Matrices;
	private int [][] matriz;

	public MultiplicaMatrices(int numMatriz) {
		num_Matrices = numMatriz;
		matriz = new int[num_Matrices][num_Matrices];
	}
	
	@Override
	public String execute() {
		int j =0 ;
		for (int d = 1; d < num_Matrices -1; d++){
			for(int i = 1; i < num_Matrices - d; i ++){
				j = i + d;
				//Siguientes linias completan la matriz
				matriz [i][j] = Integer.MAX_VALUE;
				for (int k = 1 + 1; k < j; k++){
				//	matriz[i][j] = obtenerMin(matriz[i,j], matriz[i][k-1] + matriz[k][j] + )
				}
			}
		}
		return null;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initialize(){
		for (int i = 1; i < num_Matrices; i++){
			
			
		}
	}
}
