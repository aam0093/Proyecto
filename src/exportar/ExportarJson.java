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
public class ExportarJson implements Exportar {

	@Override
	public void exportar(Pregunta pregunta, String path) {
		ExportarXml ex = new ExportarXml();
		String rutaJson = "./DocJson.xml";
		ex.abrirFichero();
		ex.exportar(pregunta, rutaJson);
		ex.cerrarFichero();
		File fXmlFile = new File(rutaJson);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = (Document) dBuilder.parse(fXmlFile);
			XMLSerializer xmlSerializer = new XMLSerializer();  
			JSON json = xmlSerializer.read( doc.getText(0, doc.getLength() ));
			FileWriter fichero = new FileWriter(path);
			fichero.write(json.toString(0, json.size()));
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void cerrarFichero() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abrirFichero() {
		
		
	}
}
