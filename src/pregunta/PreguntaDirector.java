package pregunta;

public class PreguntaDirector {

	  private PreguntaBuilder preguntaBuilder;
	  
	    public void setPreguntaBuilder(PreguntaBuilder pb) {
	    	preguntaBuilder = pb;
	    }
	    
	    public Pregunta getPregunta() { 
	    	return preguntaBuilder.getPregunta(); 
	    }
	 
	    public void construirPregunta() {
	       preguntaBuilder.crearNuevaPregunta();
	       preguntaBuilder.buildEnunciado();
	       preguntaBuilder.buildContenido();
	       preguntaBuilder.buildFeedback();
	    }
}
