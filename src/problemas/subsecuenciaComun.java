package problemas;

public class subsecuenciaComun implements Problemas{

	private String cadena1 ="";
	private String cadena2 ="";
	String res = "";
	int maxLength = -1;
	int[][] matriz;
	
	
	public subsecuenciaComun (String c1 , String c2){
		cadena1 = c1;
		cadena2 = c2;
		
	}
	public boolean isValid (String c){
		return c.isEmpty() ? true : false;
	}
	
//	public void cadenaMayor (){
//		
//		cadena1.length() > cadena2.length() ? mayor = cadena1 : menor = cadena2 ;
//		
//	}
	
	public int getMaxLenght(){
		return (maxLength > 0)? maxLength : null;  
	}
	
	public String getLCS(){
     
        int n = cadena1.length();
        int m = cadena2.length();
        matriz = new int[n+1][m+1];
        int[][] aux = new int[n+1][m+1];
	
        initialize(n, m);
        
        /* dynamic programming */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cadena1.charAt(i-1) == cadena2.charAt(j-1)) {
                    matriz[i][j]=matriz[i-1][j-1]+1;
                    aux[i][j]=1;  /* diagonal */
                }
                else if (matriz[i-1][j]>=matriz[i][j-1]) {
                    matriz[i][j]=matriz[i-1][j];
                    aux[i][j] = 2;  /* down */
                }
                else {
                    matriz[i][j]=matriz[i][j-1];     
                    aux[i][j]=3;   /* right */
                }
            }
        }
        maxLength = matriz[n][m];
        /* Backtracking */
        String lcs = new String();
        int i=n;
        int  j=m;
        while (i!=0 && j!=0) {
            if (aux[i][j] ==1) {   /* diagonal */
                lcs =cadena1.charAt(i-1) + lcs;
                i = i - 1;
                j = j - 1;
            }
            if (aux[i][j] == 2) {  /* up */
                i = i - 1;
            }
            if (aux[i][j] == 3) {  /* left */
                j = j - 1;
            }
        }
        
        return lcs;

	}
/**
 * @param n
 * @param m
 * @param matriz
 */
private void initialize(int n, int m) {
	/* C[i][0] = 0 for 0<=i<=n */
	for (int i = 0; i <= n; i++) {
	    matriz[i][0] = 0;
	}

	/* C[0][j] = 0 for  0<=j<=m */
	for (int j = 0; j <= m; j++) {
	    matriz[0][j] = 0;
	}
}  

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return res;
	}
	@Override
	public void export(String format) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main ( String [] args ){
		subsecuenciaComun sec = new subsecuenciaComun("ASIER", "ASOI");
		System.out.println("salida: " + sec.getResult());
	}
}

