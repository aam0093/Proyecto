package utiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H2;
import com.hp.gagawa.java.elements.H3;
import com.hp.gagawa.java.elements.P;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Tr;

import problemas.Floyd;
import problemas.Knapsack;
import problemas.MultiplicaMatrices;
import problemas.Problema;
import problemas.SubsecuenciaComun;

public class Utiles {

	private static String RUTA = "";
	private static String RUTARECUPERADO = "";
	List<Div> lista = new ArrayList<Div>();
	static StyleSheet estilo = new StyleSheet();
	static HTMLEditorKit editor = new HTMLEditorKit();

	public Utiles() {
		// TODO Auto-generated constructor stub
	}

	public static void añadirMochilaPanel(JTextPane panel, Knapsack p, String ruta) {
		Knapsack mochila = p;
		int numElementos = mochila.getNumElements();
		int capacidad = mochila.getCapacity();
		int[][] matriz = mochila.getMatrix();
		Div div;

		// body = new Body();
		div = new Div();
		H3 titulo = new H3();
		int num = Problema.problemasGenerados.size();
		titulo.appendText("Problema numero: " + num+1);
		P parrafo = new P();
		parrafo.appendText("Dada una mochila de capacidad " + capacidad + " y " + numElementos
				+ " elementos con las siguientes propiedades: <br> ");
		parrafo.appendText("Pesos: ");
		for (int el : mochila.getWeights()) {
			parrafo.appendText(el + " ");
		}
		parrafo.appendText("<br>");
		parrafo.appendText("Valores: ");
		for (int el : mochila.getValues()) {
			parrafo.appendText(el + " ");
		}
		Table tabla = new Table();
		for (int[] fila : matriz) {
			Tr tr = new Tr();
			for (int col : fila) {
				Td td = new Td();
				td.appendChild(new Text(col));
				tr.appendChild(td);
			}
			tabla.appendChild(tr);
		}
		div.appendChild(titulo);
		div.appendChild(parrafo);
		div.appendChild(tabla);
		P semilla = new P();
		semilla.appendText("La semilla de este problema es: " + mochila.getSemilla());
		div.appendChild(semilla);
		try {
			File doc = new File(ruta);
			PrintWriter out = new PrintWriter(new FileOutputStream(doc, true));
			out.println(div.write());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void añadirSubsecuenciaPanel(JTextPane panel, SubsecuenciaComun p, String ruta) {
		SubsecuenciaComun subsecuencia = p;
		String cadena1 = subsecuencia.getCadena1();
		String cadena2 = subsecuencia.getCadena2();
		int[][] matriz = subsecuencia.getMatriz();
		Div div;

		// body = new Body();
		div = new Div();
		H3 titulo = new H3();
		int num = Problema.problemasGenerados.size();
		titulo.appendText("Problema numero: " + num+1);
		P parrafo = new P();
		parrafo.appendText("Dadas dos cadenas " + cadena1 + " y " + cadena2 + ": <br> ");
		parrafo.appendText("<br> Que produce la siguiente matriz:");
		Table tabla = new Table();
		for (int[] fila : matriz) {
			Tr tr = new Tr();
			for (int col : fila) {
				Td td = new Td();
				td.appendChild(new Text(col));
				tr.appendChild(td);
			}
			tabla.appendChild(tr);
		}
		div.appendChild(titulo);
		div.appendChild(parrafo);
		div.appendChild(tabla);
		P resultado = new P();
		resultado.appendText("La subsecuencia común mas larga es: " + subsecuencia.getResult());
		div.appendChild(resultado);		
		
		P semilla = new P();
		semilla.appendText("La semilla de este problema es: " + subsecuencia.getSemilla());
		div.appendChild(semilla);
		try {
			File doc = new File(ruta);
			PrintWriter out = new PrintWriter(new FileOutputStream(doc, true));
			out.println(div.write());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void añadirFloydPanel(JTextPane textPaneResult, Floyd fl, String ruta) {
		Floyd floyd = fl;
		int numVertices = floyd.getNumVertices();
		int[][] distancias = floyd.getDistancias();
		int[][] matriz_resultado = floyd.getResultado();
		Div div;

		// body = new Body();
		div = new Div();
		H3 titulo = new H3();
		int num = Problema.problemasGenerados.size();
		titulo.appendText("Problema numero: " + num);
		P parrafo = new P();
		parrafo.appendText("Si tenemos un grafo de " + numVertices + " vértices. Y con una matriz"
				+ " de costes como la siguiente:");
		
		Table dist = new Table();
		for (int[] fila : distancias) {
			Tr tr = new Tr();
			for (int col : fila) {
				Td td = new Td();
				if (col == Integer.MAX_VALUE)
					td.appendChild(new Text("inf"));
				else
					td.appendChild(new Text(col));
				tr.appendChild(td);
			}
			dist.appendChild(tr);
		}
		div.appendChild(titulo);
		div.appendChild(parrafo);
		div.appendChild(dist);
		
		P parrafo2 = new P();
		parrafo2.appendText("<br>Rellena la siguiente matriz con las distancias mínimas desde un punto "
				+ "a otro: <br>");
		
		Table tablaRes = new Table();
		for (int[] fila : matriz_resultado) {
			Tr tr2 = new Tr();
			for (int c : fila) {
				Td td2 = new Td();
				td2.appendChild(new Text(c));
				tr2.appendChild(td2);
			}
			tablaRes.appendChild(tr2);
		}
		div.appendChild(parrafo2);
		div.appendChild(tablaRes);
		
		P semilla = new P();
		// semilla.appendText("La semilla de este problema es: " +
		// viajante.getSemilla());
		div.appendChild(semilla);
		
		try {
			File doc = new File(ruta);
			PrintWriter out = new PrintWriter(new FileOutputStream(doc, true));
			out.println(div.write());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
 public static void cargarTextPane(JTextPane panel, String ruta) {
		File file = new File(ruta);
		try {
			Document doc = panel.getDocument();
			doc.putProperty(Document.StreamDescriptionProperty, null);
			panel.setPage(file.toURI().toURL());
			System.out.println("Refresca");
		} catch (MalformedURLException e1) {
			System.out.println("Vacio");
		} catch (IOException e1) {
			System.out.println("No hay nada");
		}
	}

	public void setEstilo() {
		estilo = new HTMLEditorKit().getStyleSheet();
		estilo.addRule("div {color: black;}");
	}

	public static String getRuta() {
		return RUTA;
	}

	public static String getRutaRecuperado() {
		return RUTARECUPERADO;
	}

	public static HTMLEditorKit getEstilo() {
		estilo = editor.getStyleSheet();
		estilo.addRule("div {color: black;}");
		estilo.addRule("div {font-weight: bold;");
		return editor;
	}

	public static File borrarPanel(String ruta) {
		File tempFich = new File(ruta);
		tempFich.delete();
		return tempFich;
	}

	public static void setSistemaOperativo(String sistema) {
		if (sistema.startsWith("Linux")) {
			RUTA = ".\\DocInterno.html";
			RUTARECUPERADO = ".\\DocRecuperado.html";
		}
		if (sistema.startsWith("Windows")) {
			RUTA = "./DocInterno.html";
			RUTARECUPERADO = "./DocRecuperado.html";
		}
	}

	public static void añadirMatricesPanel(JTextPane textPaneResult, MultiplicaMatrices multiMatrices, String ruta) {
		MultiplicaMatrices matrices = multiMatrices;
		int numMatrices = matrices.getNumMatrices();
		int [] dimensiones = matrices.getDimensiones();
		int[][] matriz = matrices.getMatriz();
		Div div;

		// body = new Body();
		div = new Div();
		H3 titulo = new H3();
		int num = Problema.problemasGenerados.size();
		titulo.appendText("Problema numero: " + num+1);
		P parrafo = new P();
		parrafo.appendText("Teniendo " + numMatrices + " matrices encadenadas con los siguientes tamaños <br> ");
		Table dim = new Table();
		Tr trDim = new Tr();
		for (int valor : dimensiones) {
			Td td = new Td();
			td.appendChild(new Text(valor));
			trDim.appendChild(td);
		}
		dim.appendChild(trDim);
		
	
		P parrafo2 = new P();
		parrafo2.appendText("<br>Produce la siguiente matriz:");
		Table tabla = new Table();
		for (int[] fila : matriz) {
			Tr tr = new Tr();
			for (int col : fila) {
				Td td = new Td();
				if (col == 2147483647)
					td.appendChild(new Text("-"));
				else
					td.appendChild(new Text(col));
				tr.appendChild(td);
			}
			tabla.appendChild(tr);
		}
		div.appendChild(titulo);
		div.appendChild(parrafo);
		div.appendChild(dim);
		div.appendChild(parrafo2);
		div.appendChild(tabla);
		P semilla = new P();
		semilla.appendText("La semilla de este problema es: " + matrices.getSemilla());
		div.appendChild(semilla);
		try {
			File doc = new File(ruta);
			PrintWriter out = new PrintWriter(new FileOutputStream(doc, true));
			out.println(div.write());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
