package pregunta;

import problemas.*;

/** "ConcreteBuilder" */
public class PrFloyd extends PreguntaBuilder {
	Floyd floyd;

	public PrFloyd(Floyd fl) {
		floyd = fl;
	}

	@Override
	public void buildEnunciado() {
		String encabezado = "";
		String grafo = "<table>";
		int[][] dim = floyd.getGrafoInicial();
		encabezado = "<p>Dados " + floyd.getNumVertices() 
				+ " vertices con los siguiente costes: </p> ";

		for (int[] fila : dim) {
			grafo = grafo + "<tr>";
			for (int c : fila){
				grafo = grafo + "<td>" + c + "</td>";
			}
			grafo = grafo + "</tr>";
		}
		grafo = grafo + "</table>";

		pregunta.setEnunciado(encabezado + grafo);

	}

	@Override
	public void buildContenido() {
		String res = "<p>Rellena la matriz que produce la multiplicación de dichas matrices (En caso de ser infinito rellene con '9999')</p> <table>";
		int[][] matriz = floyd.getResultado();
		int[][] caminos = floyd.getCaminos();
		double pct = floyd.getPorcentaje();
		pct = pct /100;
		for (int i = 0; i < matriz.length; i++) {
			res = res + "<tr>";
			for (int j = 0; j < matriz[0].length; j++) {
				int c = matriz[i][j];
				if (j != i) {
					if (Math.random() >= pct) {
						res = res + "<td>{1:NUMERICAL:=" + c + "} </td>";
					} else {
						res = res + "<td>" + c + "</td>";
					}
				} else {
					res = res + "<td>0</td>";
				}
			}
			res = res + "</tr>";
		}
		res = res + "</table>";

	//	res = res + "<p> Cúal es el camino minimo: {1:NUMERICAL:=" + floyd.getResultado() + "}</p>";
		pregunta.setContenido(res);
	}

	@Override
	public void buildFeedback() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildTitulo() {
		String tipo = floyd.getTipo();
	//	pregunta.setTitulo(tipo + floyd.getSemilla());
	}

	@Override
	public void buildRespuesta() {
		// TODO Auto-generated method stub
		
	}

}