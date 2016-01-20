/**
 * 
 */
package exportar;



import pregunta.Pregunta;


/**
 * @author asier_000
 *
 */
public interface Exportar {
	   void exportar(Pregunta pregunta, String path);
	   void cerrarFichero();
	void abrirFichero();
	}