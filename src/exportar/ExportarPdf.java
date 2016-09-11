package exportar;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jsoup.Jsoup;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import pregunta.Pregunta;

public class ExportarPdf implements Exportar {

	OutputStream file;
	String ruta;
	String cabecera = "";
	String contenido = "";
	PdfWriter writer;
	Document documento;
	Pregunta pregunta;
	FileOutputStream ficheroPdf;
	
	public ExportarPdf (String path){
		this.ruta = path;
	}
	
	@Override
	public void exportar(Pregunta pregunta, String path) {
		this.pregunta = pregunta;
		addTitulo();
		addCabecera();
		addContenido();
		addRespuesta();
		documento.newPage();
	}
	
	public void addTitulo() {
		String titulo = pregunta.getTitulo();
		titulo = titulo.replaceAll("</p>", "\n");
		titulo =titulo.replaceAll("<p>", " ");
		titulo =titulo.replaceAll("</tr>", "\n");
		titulo =titulo.replaceAll("<tr>", " ");	
		titulo =titulo.replaceAll("</table>", "\n");
		titulo =titulo.replaceAll("<table>", "\n");
		titulo =titulo.replaceAll("</td>", "\t");	
		titulo =titulo.replaceAll("<td>", " ");	
		titulo =titulo.replaceAll("1:NUMERICAL:=", "");
		titulo =titulo.replaceAll("1:SHORTANSWER:=", "");

		try {
			documento.add(new Paragraph(titulo));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void cerrarFichero() {
		try {
			documento.close();
			ficheroPdf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void abrirFichero() {
		documento = new Document();
		
		try {
			ficheroPdf = new FileOutputStream(ruta);
			writer = PdfWriter.getInstance(documento, ficheroPdf);
			writer.setTagged();
			writer.setViewerPreferences(PdfWriter.DisplayDocTitle);
			writer.createXmpMetadata();
			
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		}
		documento.open();
		
	}

	public void addContenido() {
		String contenido = pregunta.getContenido();
		contenido = contenido.replaceAll("</p>", "\n");
		contenido =contenido.replaceAll("<p>", " ");
		contenido =contenido.replaceAll("</tr>", "\n");
		contenido =contenido.replaceAll("<tr>", " ");	
		contenido =contenido.replaceAll("</table>", "\n");
		contenido =contenido.replaceAll("<table>", "\n");
		contenido =contenido.replaceAll("</td>", "\t");	
		contenido =contenido.replaceAll("<td>", " ");	
		contenido =contenido.replaceAll("1:NUMERICAL:=", "");
		contenido =contenido.replaceAll("1:SHORTANSWER:=", "");
		
//		contenido = html2text(contenido);
		try {
			documento.add(new Paragraph(contenido));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void addCabecera() {
		String cabecera = pregunta.getEnunciado();
		
		cabecera = cabecera.replaceAll("</p>", "\n");
		cabecera =cabecera.replaceAll("<p>", " ");
		cabecera =cabecera.replaceAll("</tr>", "\n");
		cabecera =cabecera.replaceAll("<tr>", " ");	
		cabecera =cabecera.replaceAll("</table>", "\n");
		cabecera =cabecera.replaceAll("<table>", "\n");
		cabecera =cabecera.replaceAll("</td>", "\t");	
		cabecera =cabecera.replaceAll("<td>", " ");	
		cabecera =cabecera.replaceAll("1:NUMERICAL:=", "");
		cabecera =cabecera.replaceAll("1:SHORTANSWER:=", "");
 		
 		cabecera = html2text(cabecera);
		try {
			documento.add(new Paragraph(cabecera));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void addRespuesta() {
		String respuesta = pregunta.getRespuesta();
		respuesta = respuesta.replaceAll("</p>", "\n");
		respuesta =respuesta.replaceAll("<p>", " ");
		respuesta =respuesta.replaceAll("</tr>", "\n");
		respuesta =respuesta.replaceAll("<tr>", " ");	
		respuesta =respuesta.replaceAll("</table>", "\n");
		respuesta =respuesta.replaceAll("<table>", "\n");
		respuesta =respuesta.replaceAll("</td>", "\t");	
		respuesta =respuesta.replaceAll("<td>", " ");	
		respuesta =respuesta.replaceAll("1:NUMERICAL:=", "");
		respuesta =respuesta.replaceAll("1:SHORTANSWER:=", "");

		try {
			documento.add(new Paragraph(respuesta));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static String html2text(String html) {
		return Jsoup.parse(html).text();

	}
}
