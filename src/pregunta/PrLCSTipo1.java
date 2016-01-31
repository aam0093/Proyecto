package pregunta;

import problemas.SubsecuenciaComun;

public class PrLCSTipo1 extends PreguntaBuilder {
	SubsecuenciaComun subsecuencia;

	public PrLCSTipo1(SubsecuenciaComun p) {
		subsecuencia = p;
	}

	public int[][] getRespuesta() {
		return subsecuencia.getMatriz();
	}

	@Override
	public void buildTitulo() {
		String tipo = subsecuencia.getTipo();
		pregunta.setTitulo(tipo + subsecuencia.getSemilla());
	}

	public void buildEnunciado() {
		String encabezado = "";
		encabezado = "Sean dos cadenas " + subsecuencia.getCadena1() + " y " + subsecuencia.getCadena2()
				+ "Que producen la siguiente Matriz: ";
		pregunta.setEnunciado(encabezado);
	}

	public void buildContenido() {
		String res = "<table><tr>";
		int[][] matriz = subsecuencia.getMatriz();

		for (int[] f : matriz) {
			for (int c : f) {
				res = res + "<td>" + c + "</td>";
			}
			res = res + "</tr>";
		}
		res = res + "</table>";

		res = res + "<p> La subsecuencia mas larga de las dos cadenas con la tabla anterior es: {1:SHORTANSWER:="
				+ subsecuencia.getResult() + "}</p>";

		String semilla = "<p>La semilla de este problema es: " + subsecuencia.getSemilla() + "</p><br><br>";

		pregunta.setContenido(res + semilla);

	}

	public void buildFeedback() {
		pregunta.setFeedback("Feedback de la pregunta 1 de tipo Mochila");
	}

}
