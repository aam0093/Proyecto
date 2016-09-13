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
		encabezado = "Sean dos cadenas " + subsecuencia.getCadena1() + " y " + subsecuencia.getCadena2();
		pregunta.setEnunciado(encabezado);
	}

	public void buildContenido() {
		String res = "Resuelve la matriz que forman y obten la subsecuencia común mas larga <br> <table><tr>";
		int[][] matriz = subsecuencia.getMatriz();
		double pct = subsecuencia.getPorcentaje();
		pct = pct / 100;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				int c = matriz[i][j];
				if (Math.random() < pct || i == 0 || j == 0) {
					if (i == 0 && j == 0) {
						res = res + "<td>" + "-" + "</td>";
					} else {
						if (i == 0) {
							res = res + "<td>" + subsecuencia.getCadena1().charAt(j - 1) + "</td>";
						} else {
							if (j == 0) {
								res = res + "<td>" + subsecuencia.getCadena2().charAt(i-1) + "</td>";
							} else {
								res = res + "<td>" + c + "</td>";
							}
						}
					}

				} else {
					res = res + "<td>{1:NUMERICAL:=" + c + "} </td>";
				}
			}
			res = res + "</tr>";
		}
		res = res + "</table>";
		String resultado = "<p>La subsecuemcia común más larga es: : {1:SHORTANSWER:=" + subsecuencia.getResult()
				+ "} </p>";
		String semilla = "<p>La semilla de este problema es: " + subsecuencia.getSemilla();
		pregunta.setContenido(res + resultado + semilla);
	}

	public void buildFeedback() {
		pregunta.setFeedback("http://lcs-demo.sourceforge.net/");
	}

	@Override
	public void buildTitulo() {
		String tipo = subsecuencia.getTipo();
		pregunta.setTitulo(tipo + " " + subsecuencia.getSemilla());
	}

	@Override
	public void buildRespuesta() {
		// TODO Auto-generated method stub

	}

}
