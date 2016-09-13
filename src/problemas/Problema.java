package problemas;

import java.util.ArrayList;
import java.util.List;

public interface Problema {
	List<Problema> PROBGENERADOS = new ArrayList<Problema>();
	List<Problema> PROBRECUPERADOS = new ArrayList<Problema>();
//	final int semilla = 0;
	enum TIPO { MOCHILA , SUBSECUENCIA, FLOYD, MATRICES}; 
	String execute();
	String getTipo();
	Problema recuperarProblema(String semilla);
	int getPorcentaje();
	long getSemilla();
	void setPorcentaje(int pct);
}
