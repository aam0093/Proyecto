package pregunta;

import problemas.*;

/** "ConcreteBuilder" */
public class PrMatrices extends PreguntaBuilder {
	MultiplicaMatrices matrices;

	public PrMatrices(MultiplicaMatrices m) {
		matrices = m;
		int [][] matriz = m.getMatriz();
		
	}	

	@Override
	public void buildEnunciado() {
		String encabezado = "";
		String dimensiones = "<table>";
		int[] dim = matrices.getDimensiones();
		encabezado = "<p>Dadas " + matrices.getNumMatrices()
				+ " matrices con las siguientes dimensiones (la segunda dimensi�n de la matriz"
				+ "corresponde con la primera de la matriz siguiente). </p> ";

		for (int i = 1; i < dim.length ; i++) {
			dimensiones = dimensiones + "<tr>" + dim[i-1] + "x" + dim [i] + "    </tr>";
		}
		dimensiones = dimensiones + "</table>";

		pregunta.setEnunciado(encabezado + dimensiones);

	}

	@Override
	public void buildContenido() {
		String res = "<p>Rellena la matriz que produce la multiplicaci�n de dichas matrices </p> <table><tr>";
		int[][] matriz = matrices.getMatriz();
		double pct = matrices.getPorcentaje();
		for (int fila[] : matriz){
			for (int c : fila){
				System.out.println("Matriz: " + c);
			}
		}
		pct = pct /100;
		for (int[] f : matriz) {
			for (int c : f) {
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[0].length; j++) {
						if (j > i) {
							if (Math.random() >= pct) {
								res = res + "<td>{1:NUMERICAL:=" + c + "} </td>";
							} else {
								res = res + "<td>" + c + "</td>";
							}
						} else {
							res = res + "<td>0</td>";
						}
					}
				}

			}
			res = res + "</tr>";
		}
		res = res + "</table>";

		res = res + "<p> C�al es el n�mero m�nimo de multiplicaciones: {1:NUMERICAL:=" + matrices.getResultado()
				+ "}</p>";
		
		String semilla = "";
		semilla = "La semilla de este problema es: " + matrices.getSemilla();
		pregunta.setContenido(res + semilla);
	}

	@Override
	public void buildFeedback() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildTitulo() {
		String tipo = matrices.getTipo();
		pregunta.setTitulo(tipo + " " +  matrices.getSemilla());
	}

}