package pregunta;

import problemas.*;

/** "ConcreteBuilder" */
public class PrMochila extends PreguntaBuilder {
	Knapsack mochila;

	public PrMochila(Knapsack p) {
		mochila = p;
	}

	public int[][] getRespuesta() {
		return mochila.getMatrix();
	}

	public void buildEnunciado() {
		String encabezado = "";
		encabezado = "Sea una mochila de Capacidad " + mochila.getCapacity() + " y con " + mochila.getNumElements()
				+ " elementos.";
		pregunta.setEnunciado(encabezado);
	}

	public void buildContenido() {
		String valores = "<p> Valores: <table> <tr>";
		String pesos = "<p> Pesos: <table> <tr>";
		String res = "<table><tr>";
		double pct = mochila.getPorcentaje();
		pct = pct /100;
		
		int[][] matriz = mochila.getMatrix();
		for (int i : mochila.getValues()) {
			valores = valores + "<td>" + i + "</td>";
		}
		valores = valores + "</tr></table></p>";
		
		for (int i : mochila.getWeights()) {
			pesos = pesos + "<td>" + i + "</td>";
		}
		pesos = pesos + "</tr></table></p>";

		for (int[] f : matriz) {
			for (int c : f) {
				if (Math.random() >= pct) {
					res = res + "<td>{1:NUMERICAL:=" + c + "} </td>";
				} else {
					res = res + "<td>" + c + "</td>";
				}
			}
			res = res + "</tr>";
		}
		res = res + "</table>";
		pregunta.setContenido(valores + pesos + res);

	}

	public void buildFeedback() {
		pregunta.setFeedback("Feedback de la pregunta 2 de tipo Mochila");
	}


	public void buildTitulo() {
		String tipo = mochila.getTipo();
		pregunta.setTitulo(tipo + " " + mochila.getSemilla());
	}
	

}