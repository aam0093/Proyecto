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
		String caminos = "<table>";
		int[][] dim = floyd.getDistancias();
		encabezado = "<p>Dados " + floyd.getNumVertices() 
				+ " vertices con los siguiente costes: </p> ";

		for (int[] fila : dim) {
			for (int c : fila){
				caminos = caminos + "<tr>" + c + "</tr>";
			}
			
		}
		caminos = caminos + "</table>";

		pregunta.setEnunciado(encabezado + caminos);

	}

	@Override
	public void buildContenido() {
		String res = "<p>Rellena la matriz que produce la multiplicación de dichas matrices </p> <table><tr>";
		int[][] matriz = floyd.getResultado();
		double pct = floyd.getPorcentaje();
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

	//	res = res + "<p> Cúal es el número mínimo de multiplicaciones: {1:NUMERICAL:=" + floyd.getResultado() + "}</p>";
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

}