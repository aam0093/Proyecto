/**
 * 
 */
package pregunta;

/**
 * @author asier_000
 *
 */

public class Pregunta {
	private String titulo = "";
	private String enunciado = "";
	private String contenido = "";
	private String respuesta = "";
	private String resultado = "";
	private String feedback = "";

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public String getContenido() {
		return contenido;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public String getFeedback() {
		return feedback;
	}

	public String getResultado() {
		return resultado;
	}


}
