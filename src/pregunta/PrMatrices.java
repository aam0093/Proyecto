package pregunta;

import problemas.MultiplicaMatrices;

/** "ConcreteBuilder" */
public class PrMatrices extends PreguntaBuilder {
	MultiplicaMatrices matrices;
	int inf = 9999;

	public PrMatrices(MultiplicaMatrices m) {
		matrices = m;
	}

	@Override
	public void buildEnunciado() {
		String encabezado = "";
		String dimensiones = "<table>";
		int[] dim = matrices.getDimensiones();
		encabezado = "<p>Dadas " + matrices.getNumMatrices()
				+ " matrices con las siguientes dimensiones (la segunda dimensión de la matriz "
				+ "corresponde con la primera de la matriz siguiente). </p> ";

		for (int i = 1; i < dim.length; i++) {
			dimensiones = dimensiones + "<tr>" + dim[i - 1] + "x" + dim[i] + "    </tr>";
		}
		dimensiones = dimensiones + "</table>";

		pregunta.setEnunciado(encabezado + dimensiones);

	}

	@Override
	public void buildContenido() {
		String res = "";
		res = res + "<p>Rellena la matriz que produce la multiplicación de dichas matrices </p> <table><tr>";
		int[][] matriz = matrices.getMatriz();
		double pct = matrices.getPorcentaje();

		pct = pct / 100;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				int c = matriz[i][j];
				if (j > i) {
					if (Math.random() >= pct) {
						res = res + "<td>{1:NUMERICAL:=" + c + "} </td>";
					} else {
						res = res + "<td>" + c + "</td>";
					}
				} else {
					res = res + "<td> 0 </td>";
				}
			}
			res = res + "</tr>";
		}
		res = res + "</table>";

//		res = res + "<p> Cúal es el número mínimo de multiplicaciones: {1:NUMERICAL:=" + matrices.getResultado()
//				+ "}</p>";

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
		pregunta.setTitulo(tipo + " " + matrices.getSemilla());
	}

	@Override
	public void buildRespuesta() {
		// TODO Auto-generated method stub

	}

}