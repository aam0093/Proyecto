package pregunta;

import problemas.*;
import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Html;
import com.hp.gagawa.java.elements.P;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Tr;

/** "ConcreteBuilder" */
public class PrMochilaTipo1 extends PreguntaBuilder {
	Knapsack mochila;

	public PrMochilaTipo1(Knapsack p) {
		mochila = p;
	}

	public int[][] getRespuesta() {
		return mochila.getMatrix();
	}

	public void buildEnunciado() {
		String encabezado = "";
		encabezado = "<p>Sea una mochila de Capacidad " + mochila.getCapacity() + " y con " + mochila.getNumElements()
				+ " elementos. </p>";
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