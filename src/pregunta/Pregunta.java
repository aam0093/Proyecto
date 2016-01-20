/**
 * 
 */
package pregunta;

import exportar.ExportarXml;
import problemas.Problema;

/**
 * @author asier_000
 *
 */
	
	public class Pregunta {
	    private String enunciado = "";
	    private String contenido = "";
	    private String respuesta = "";
		private String feedback = "";
	 
	    public void setEnunciado(String enunciado)     {
	    	this.enunciado = enunciado;
	    }
	    
	    public void setContenido(String contenido)     { 
	    	this.contenido = contenido;
	    }
	    
	    public void setRespuesta(String respuesta) {
	    	this.respuesta = respuesta;
	    }
	    
		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		
	   public String getEnunciado()     {
	    	return enunciado;
	    }
	    
	    public String getContenido()     { 
	    	return contenido;
	    }
	    
	    public String getRespuesta() {
	    	return respuesta;
	    }
	    
		public String getFeedback() {
			return feedback;
		}
		
	/*	public void exportarXml(Pregunta p, String ruta){
			ExportarXml ex = new ExportarXml(p, ruta, "XML");
			ex.exportMochila();
		}
		*/

}
