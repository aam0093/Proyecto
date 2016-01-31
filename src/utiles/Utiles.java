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
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.P;
import com.hp.gagawa.java.elements.Table;
import com.hp.gagawa.java.elements.Td;
import com.hp.gagawa.java.elements.Text;
import com.hp.gagawa.java.elements.Tr;

import problemas.Knapsack;
import problemas.MultiplicaMatrices;
import problemas.Problema;
import problemas.SubsecuenciaComun;
import problemas.TSP;

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

	public static void añadirViajantePanel(JTextPane textPaneResult, TSP viaj, String ruta) {
		TSP viajante = viaj;
		int numNodos = viajante.getNumNodos();
		int[][] matriz = viajante.getDist();
		Div div;

		// body = new Body();
		div = new Div();
		P parrafo = new P();
		parrafo.appendText("Teniendo un viajero que quiere visitar" + numNodos
				+ " lugares distintos con las siguientes distancias <br> ");
		Table distancias = new Table();
		for (int[] fila : matriz) {
			Tr tr = new Tr();
			for (int col : fila) {
				Td td = new Td();
				td.appendChild(new Text(col));
				tr.appendChild(td);
			}
			distancias.appendChild(tr);
		}
		parrafo.appendText("<br>Produce la siguiente matriz:");
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
		div.appendChild(parrafo);
		div.appendChild(tabla);
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
		System.out.println("Despues de limpiar: " + file.length());
		try {
			panel.setPage(file.toURI().toURL());
			System.out.println("Refresca");
			panel.repaint();
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

	public static void borrarPanel(String ruta) {
		System.out.println("Entra a limpiar");
		File tempFich = new File(ruta);
		System.out.println("Recupera fichero: " + tempFich.length());
		tempFich.delete();
		System.out.println("Borra fichero: " + tempFich.length());
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
