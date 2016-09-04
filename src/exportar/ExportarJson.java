package exportar;

import pregunta.Pregunta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.xml.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.*;
import org.json.simple.JSONObject;
import org.xml.sax.SAXException;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;
import org.json.simple.JSONObject;

public class ExportarJson implements Exportar {

	@SuppressWarnings("unchecked")
	@Override
	public void exportar(Pregunta pregunta, String path) {
		JSONObject div = new JSONObject();
		JSONObject obj = new JSONObject();
	
	      obj.put("name", "foo");
	      obj.put("num", new Integer(100));
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));
	      div.putAll(obj);
	      System.out.print(obj);
	      System.out.print(div);
	} 
		
	

	@Override
	public void cerrarFichero() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abrirFichero() {
		
		
	}
}
