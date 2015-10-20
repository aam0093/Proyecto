package problemas;

public class subsecuenciaComun implements Problemas{

	private String cadena1 ="";
	private String cadena2 ="";
	String res = "";
	
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
	
	public String getLCS(){
     
        int n = cadena1.length();
        int m = cadena2.length();
        int[][] C = new int[n+1][m+1];
        int[][] B = new int[n+1][m+1];
	
        /* C[i][0] = 0 for 0<=i<=n */
        for (int i = 0; i <= n; i++) {
            C[i][0] = 0;
        }
	
        /* C[0][j] = 0 for  0<=j<=m */
        for (int j = 0; j <= m; j++) {
            C[0][j] = 0;
        }
        
        /* dynamic programming */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (cadena1.charAt(i-1) == cadena2.charAt(j-1)) {
                    C[i][j]=C[i-1][j-1]+1;
                    B[i][j]=1;  /* diagonal */
                }
                else if (C[i-1][j]>=C[i][j-1]) {
                    C[i][j]=C[i-1][j];
                    B[i][j] = 2;  /* down */
                }
                else {
                    C[i][j]=C[i][j-1];     
                    B[i][j]=3;   /* forword */
                }
            }
        }
        /* Backtracking */
        String lcs = new String();
        int i=n;
        int  j=m;
        while (i!=0 && j!=0) {
            if (B[i][j] ==1) {   /* diagonal */
                lcs =cadena1.charAt(i-1) + lcs;
                i = i - 1;
                j = j - 1;
            }
            if (B[i][j] == 2) {  /* up */
                i = i - 1;
            }
            if (B[i][j] == 3) {  /* backword */
                j = j - 1;
            }
        }
        
        return lcs;

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

