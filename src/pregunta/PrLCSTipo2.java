package pregunta;


import problemas.SubsecuenciaComun;

public class PrLCSTipo2 extends PreguntaBuilder {
	SubsecuenciaComun subsecuencia;

	public PrLCSTipo2(SubsecuenciaComun p) {
		subsecuencia = p;
	}

	public int[][] getRespuesta() {
		return subsecuencia.getMatriz();
	}

	
	public void buildEnunciado() {
		String encabezado = "";
		encabezado = "Sean dos cadenas " +  subsecuencia.getCadena1() + " y " + subsecuencia.getCadena2() + 
				"Que producen la siguiente Matriz: ";
		pregunta.setEnunciado(encabezado);
	}

	public void buildContenido() {
		String valores = "<p> Valores: <table> <tr>";
		String pesos = "<p> Pesos: <table> <tr>";
		String res = "<table><tr>";
		int[][] matriz = subsecuencia.getMatriz();

		for (int[] f : matriz) {
			for (int c : f) {
				if(Math.random()>= 0.75){
					res = res + "<td>{1:NUMERICAL:=" + c + "} </td>";
				}else{
					res = res + "<td>" + c + "</td>";
				}
			}
			res = res + "</tr>";
		}
		res = res + "</table>";
		String semilla = "<p>La semilla de este problema es: " + subsecuencia.getSemilla();
		pregunta.setContenido(res + semilla);
	}

	public void buildFeedback() {
		pregunta.setFeedback("Feedback de la pregunta 1 de tipo Mochila");
	}
	
}
