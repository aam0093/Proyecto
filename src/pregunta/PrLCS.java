package pregunta;


import problemas.SubsecuenciaComun;

public class PrLCS extends PreguntaBuilder {
	SubsecuenciaComun subsecuencia;

	public PrLCS(SubsecuenciaComun p) {
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
		String res = "<table><tr>";
		int[][] matriz = subsecuencia.getMatriz();
		double pct = subsecuencia.getPorcentaje();
		pct = pct /100;
		for (int[] f : matriz) {
			for (int c : f) {
				if(Math.random()>= pct){
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
	
	@Override
	public void buildTitulo() {
		String tipo = subsecuencia.getTipo();
		pregunta.setTitulo(tipo + subsecuencia.getSemilla());
	}
	
}
