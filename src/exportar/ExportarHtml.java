/**
 * @author asier_000
 *
 */
package exportar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;

import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Html;
import com.hp.gagawa.java.elements.P;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Tr;

import pregunta.Pregunta;
import problemas.*;


public class ExportarHtml implements Exportar  {

	Problema problem;
    File doc;
    String format;
    String ruta;
    Html html;
    Head head;
    Body body;
    List<Div> lista = new ArrayList<Div>();
    Div div;
	
	@Override
	public void abrirFichero(){
		html = new Html();
		head = new Head();
		html.appendChild(head);
		body = new Body();
	}

	public void cerrarFichero(){
		File doc = new File(ruta);
	    PrintWriter out;
		try {
			html.appendChild(body);
			out = new PrintWriter(new FileOutputStream(doc,true));
			out.println(html.write());
		    out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	   
	}

	@Override
	public void exportar(Pregunta pregunta, String path) {
		ruta = path;
		div = new Div();
		P enunciado = new P();
		enunciado.appendText(pregunta.getEnunciado());
		P contenido = new P();
		contenido.appendText(pregunta.getContenido());
	
		 div.appendChild(enunciado);
		 div.appendChild(contenido);
		 body.appendChild(div);
	}

}