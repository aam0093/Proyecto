package pregunta;

/** "Abstract Builder" */
public abstract class PreguntaBuilder {
	protected Pregunta pregunta;
	
    public Pregunta getPregunta() { 
    	return pregunta; 
    }
    
    public void crearNuevaPregunta() { 
    	pregunta = new Pregunta(); 
    }
 
    public abstract void buildEnunciado();
    public abstract void buildContenido();
    public abstract void buildFeedback();
}


