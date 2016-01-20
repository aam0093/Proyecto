package pregunta;

import problemas.*;

/** "ConcreteBuilder" */
public class PrMochilaTipo3 extends PreguntaBuilder {
	Knapsack mochila;

	public PrMochilaTipo3(Knapsack p) {
		mochila = p;
	}

	public int[][] getRespuesta() {
		return mochila.getMatrix();
	}

	public void buildEnunciado() {
		String encabezado = "";
		encabezado = "<p>Sea una mochila de Capacidad " + mochila.getCapacity() + " y con " + mochila.getNumElements()
				+ " elementos.</p>";
		pregunta.setEnunciado(encabezado);
	}

	public void buildContenido() {
		String valores = "<p> Valores: <table> <tr>";
		String pesos = "<p> Pesos: <table> <tr>";
		String res = "<table><tr>";
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
				res = res + "<td>" + c + "</td>";
			}
			res = res + "</tr>";
		}
		res = res + "</table>";
		
		res = res + "<p> Cúal es el valor máximo que podemos obtener sin exceder la capacidad de la mochila: {1:NUMERICAL:=" +
				mochila.getResultValue() + "}</p>";
		pregunta.setContenido(valores + pesos + res);

	}

	public void buildFeedback() {
		pregunta.setFeedback("Feedback de la pregunta 1 de tipo Mochila");
	}
	
	

}