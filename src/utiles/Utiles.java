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
import com.hp.gagawa.java.elements.Th;
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
		Div div, divContMochila, divSolMochila;

		// body = new Body();
		div = new Div();
		H3 tituloMochila = new H3();
		// tituloMochila.setCSSClass("title");
		int num = Problema.problemasGenerados.size();
		tituloMochila.appendText("*** Problema " + num + ". Tipo: Mochila ***");
		div.appendChild(tituloMochila);

		divContMochila = new Div();
		P enunMochila = new P();
		enunMochila.setCSSClass("boldText");
		enunMochila.appendText("- Dada una mochila de capacidad " + capacidad + " y " + numElementos
				+ " elementos con las siguientes propiedades:");

		Table tablaEnunMochila = new Table();
		// Pesos
		Tr trPesos = new Tr();
		Td tdPesos = new Td();
		tdPesos.setCSSClass("variable");
		tdPesos.setCSSClass("boldText");
		tdPesos.appendChild(new Text("Pesos:"));
		// trPesos.appendChild(td);
		// Td tdPesos = new Td();
		String pesos = "";
		for (int el : mochila.getWeights()) {
			pesos = pesos + el + " ";
		}
		tdPesos.appendChild(new Text(pesos));
		trPesos.appendChild(tdPesos);

		// Valores
		Tr trVal = new Tr();
		Td tdVal = new Td();
		tdVal.setCSSClass("variable");
		tdVal.setCSSClass("boldText");
		tdVal.appendChild(new Text("Valores:"));
		trVal.appendChild(tdVal);

		Td tdVal2 = new Td();
		String valores = "";
		for (int el : mochila.getValues()) {
			valores = valores + el + " ";
		}
		tdVal2.appendChild(new Text(valores));
		trVal.appendChild(tdVal2);

		// Semilla
		Tr trSem = new Tr();
		Td tdSem = new Td();
		tdSem.setCSSClass("variable");
		tdSem.setCSSClass("boldText");
		tdSem.appendChild(new Text("Semilla:"));
		trSem.appendChild(tdSem);
		Td tdSem2 = new Td();
		String semilla = "" + mochila.getSemilla();
		tdSem2.appendChild(new Text(semilla));
		trSem.appendChild(tdSem2);

		tablaEnunMochila.appendChild(trPesos);
		tablaEnunMochila.appendChild(trVal);
		tablaEnunMochila.appendChild(trSem);

		divContMochila.appendChild(enunMochila);
		divContMochila.appendChild(tablaEnunMochila);
		div.appendChild(divContMochila);

		// Solucion
		divSolMochila = new Div();
		P parrafo1 = new P();
		parrafo1.setCSSClass("restitle");
		parrafo1.appendText("Resultado: ");
		Table tabla = new Table();
		tabla.setCSSClass("res");
		Tr trRes = new Tr();
		Th th = new Th();
		th.setCSSClass("black");
		th.appendChild(new Text(""));
		trRes.appendChild(th);
		int header = 1;
		for (int h : matriz[0]) {
			Th th1 = new Th();
			th1.appendChild(new Text((char) (header)));
			header++;
			trRes.appendChild(th1);
		}
		tabla.appendChild(trRes);

		int header2 = 1;
		for (int[] fila : matriz) {
			Tr trRes4 = new Tr();
			Td td2 = new Td();
			td2.appendChild(new Text((char) (header2)));
			header2++;
			trRes4.appendChild(td2);
			for (int col : fila) {
				td2 = new Td();
				td2.appendChild(new Text(col));
				trRes4.appendChild(td2);
			}
			tabla.appendChild(trRes4);
		}

		divSolMochila.appendChild(parrafo1);
		divSolMochila.appendChild(tabla);
		div.appendChild(divSolMochila);

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
		Div div, div1, divSolSub;

		// body = new Body();
		div = new Div();
		H3 titulo = new H3();
		// titulo.setCSSClass("title");
		int num = Problema.problemasGenerados.size();
		titulo.appendText("*** Problema " + num + ". Tipo: Subsecuencia común ***");
		div.appendChild(titulo);

		div1 = new Div();
		P parrafo = new P();
		parrafo.setCSSClass("boldText");
		parrafo.appendText("Dadas dos cadenas y una semilla:");

		Table tablaSub = new Table();
		// Cadena1
		Tr trCad1 = new Tr();
		Td td = new Td();
		td.setCSSClass("variable");
		td.setCSSClass("boldText");
		td.appendChild(new Text("Cadena 1: "));
		trCad1.appendChild(td);
		String cad1 = "" + cadena1;
		Td td1 = new Td();
		td1.appendChild(new Text(cad1));
		trCad1.appendChild(td1);

		// Valores
		Tr trCad2 = new Tr();
		Td td3 = new Td();
		td3.setCSSClass("variable");
		td3.setCSSClass("boldText");
		td3.appendChild(new Text("Cadena 2:"));
		trCad2.appendChild(td3);
		Td td4 = new Td();
		String cad2 = "" + cadena2;
		td4.appendChild(new Text(cad2));
		trCad2.appendChild(td4);

		// Semilla
		Tr trSem = new Tr();
		Td td5 = new Td();
		td5.setCSSClass("variable");
		td5.setCSSClass("boldText");
		td5.appendChild(new Text("Semilla:"));
		trSem.appendChild(td5);
		Td td6 = new Td();
		String semilla = "" + subsecuencia.getSemilla();
		td6.appendChild(new Text(semilla));
		trSem.appendChild(td6);

		tablaSub.appendChild(trCad1);
		tablaSub.appendChild(trCad2);
		tablaSub.appendChild(trSem);

		div1.appendChild(parrafo);
		div1.appendChild(tablaSub);
		div.appendChild(div1);

		// Solucion
		divSolSub = new Div();
		P parrafo1 = new P();
		parrafo1.setCSSClass("restitle");
		parrafo1.appendText("Resultado: ");

		Table tablaSub2 = new Table();
		tablaSub2.setCSSClass("res");
		Tr tr3 = new Tr();
		Th th = new Th();
		th.setCSSClass("black");
		th.appendChild(new Text(""));
		tr3.appendChild(th);
		int i = 0;
		for (int h : matriz[0]) {

			Th th1 = new Th();
			th1.appendChild(new Text(i));
			tr3.appendChild(th1);
			i++;
		}
		tablaSub2.appendChild(tr3);

		int j = 0;
		for (int[] fila : matriz) {
			Tr tr4 = new Tr();
			Td td2 = new Td();
			td2.appendChild(new Text(j));
			j++;
			tr4.appendChild(td2);
			for (int col : fila) {
				td2 = new Td();
				td2.appendChild(new Text(col));
				tr4.appendChild(td2);
			}
			tablaSub2.appendChild(tr4);
		}

		P parrafoRes = new P();
		parrafoRes.appendText("El resultado es: " + subsecuencia.getResult());

		divSolSub.appendChild(parrafo1);
		divSolSub.appendChild(tablaSub2);
		divSolSub.appendChild(parrafoRes);
		div.appendChild(divSolSub);

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
		Div div, div1, div2;

		// body = new Body();
		div = new Div();
		H3 titulo = new H3();
//		titulo.setCSSClass("title");
		int num = Problema.problemasGenerados.size();
		titulo.appendText("*** Problema " + num + ". Tipo: Floyd ***");
		div.appendChild(titulo);

		div1 = new Div();
		P parrafo = new P();
		parrafo.setCSSClass("boldText");
		parrafo.appendText("- Si tenemos un grafo de " + numVertices + " vértices. Y con una matriz"
				+ " de costes como la siguiente:");

		Table tabla1 = new Table();

		// Semilla
		Tr tr2 = new Tr();
		Td td5 = new Td();
		td5.setCSSClass("variable");
		td5.setCSSClass("boldText");
		td5.appendChild(new Text("Semilla:"));
		tr2.appendChild(td5);
		Td td6 = new Td();
		String semilla = "" + floyd.getSemilla();
		td6.appendChild(new Text(semilla));
		tr2.appendChild(td6);

		tabla1.appendChild(tr2);

		// Costes
		P parrafo2 = new P();
		parrafo2.setCSSClass("boldText");
		parrafo2.appendText("Costes: ");

		Table tabla2 = new Table();
		tabla2.setCSSClass("res");
		Tr tr3 = new Tr();
		Th th = new Th();
		th.setCSSClass("black");
		th.appendChild(new Text(""));
		tr3.appendChild(th);
		int header = 1;
		for (int h : distancias[0]) {
			Th th1 = new Th();
			th1.appendChild(new Text(header));
			header++;
			tr3.appendChild(th1);
		}
		tabla2.appendChild(tr3);

		int header2 = 1;
		for (int[] fila : distancias) {
			Tr tr = new Tr();
			Td td = new Td();
			td.appendChild(new Text(header2));
			header2++;
			tr.appendChild(td);
			for (int col : fila) {
				td = new Td();
				if (col == Integer.MAX_VALUE)
					td.appendChild(new Text("inf"));
				else
					td.appendChild(new Text(col));
				tr.appendChild(td);
			}
			tabla2.appendChild(tr);
		}

		div1.appendChild(parrafo);
		div1.appendChild(tabla1);
		div1.appendChild(parrafo2);
		div1.appendChild(tabla2);
		div.appendChild(div1);

		// Solucion
		div2 = new Div();
		P parrafo1 = new P();
		parrafo1.setCSSClass("restitle");
		parrafo1.appendText("Resultado: ");

		Table tablaRes = new Table();
		tablaRes.setCSSClass("res");
		Tr tr4 = new Tr();
		Th th4 = new Th();
		th4.setCSSClass("black");
		th4.appendChild(new Text(""));
		tr4.appendChild(th);
		int header3 = 1;
		for (int h : matriz_resultado[0]) {
			Th th1 = new Th();
			th1.appendChild(new Text(header3));
			header3++;
			
			tr4.appendChild(th1);
		}
		tablaRes.appendChild(tr4);

		int header4 = 1;
		for (int[] fila : matriz_resultado) {
			Tr tr = new Tr();
			Td td = new Td();
			td.appendChild(new Text(header4));
			header4++;
			tr.appendChild(td);
			for (int col : fila) {
				
				td = new Td();
				if (col == Integer.MAX_VALUE)
					td.appendChild(new Text("-"));
				else
					td.appendChild(new Text(col));
				tr.appendChild(td);
			}
			tablaRes.appendChild(tr);
		}

		div2.appendChild(parrafo1);
		div2.appendChild(tablaRes);
		div.appendChild(div2);

		try {
			File doc = new File(ruta);
			PrintWriter out = new PrintWriter(new FileOutputStream(doc, true));
			out.println(div.write());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

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
		} catch (MalformedURLException e1) {
		} catch (IOException e1) {
			System.out.println("No hay nada");
		}
	}

	public static void setEstilo() {
		estilo = new HTMLEditorKit().getStyleSheet();
		estilo.addRule("div {color: black; padding: 0px 0px 20px 0px;}");
		estilo.addRule("div > h3 {text-align: center;}");
		estilo.addRule("table.res {margin-left: 50px; border: 1px solid black;}");
		estilo.addRule(
				"table.res > tbody > tr > td, , table.res > tbody > tr > th {text-align: center; border: 1px solid black; width: 25px; height: 25px;}");
		estilo.addRule(".black {background-color:black}");
		estilo.addRule(".variable {width: 80px !important;}");
		estilo.addRule(".boldText {font-weight: bold;}");
		estilo.addRule(".title {background-color: grey;color: white;}");
		estilo.addRule(".restitle {color: dodgerblue;text-decoration: underline;font-weight: bold;}");
		editor.setStyleSheet(estilo);
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
		int[] dim = matrices.getDimensiones();
		int[][] matriz = matrices.getMatriz();
		Div div, div1, div2;

		// body = new Body();
		div = new Div();
		H3 titulo = new H3();
		// titulo.setCSSClass("title");
		int num = Problema.problemasGenerados.size();
		titulo.appendText("*** Problema " + num + ". Tipo: Multiplica matrices ***");
		div.appendChild(titulo);

		div1 = new Div();
		P parrafo = new P();
		parrafo.setCSSClass("boldText");
		parrafo.appendText("Teniendo " + numMatrices + " matrices encadenadas con los siguientes tamaños:");

		Table tabla1 = new Table();
		// Dimensiones
		Tr tr = new Tr();
		Td tdDim = new Td();
		tdDim.setCSSClass("variable");
		tdDim.setCSSClass("boldText");
		tdDim.appendChild(new Text("Dimensiones:"));
		tr.appendChild(tdDim);
		Td td1 = new Td();
		String dimensiones = "";
		for (int i = 1; i < dim.length; i++) {
			dimensiones = dimensiones + " " + dim[i - 1] + "x" + dim[i];
		}
		td1.appendChild(new Text(dimensiones));
		tr.appendChild(td1);

		// Semilla
		Tr tr2 = new Tr();
		Td td5 = new Td();
		td5.setCSSClass("variable");
		td5.setCSSClass("boldText");
		td5.appendChild(new Text("Semilla:"));
		tr2.appendChild(td5);
		Td td6 = new Td();
		String semilla = "" + matrices.getSemilla();
		td6.appendChild(new Text(semilla));
		tr2.appendChild(td6);

		tabla1.appendChild(tr);
		tabla1.appendChild(tr2);

		div1.appendChild(parrafo);
		div1.appendChild(tabla1);
		div.appendChild(div1);

		// Solucion
		div2 = new Div();
		P parrafo1 = new P();
		parrafo1.setCSSClass("restitle");
		parrafo1.appendText("Resultado: ");

		Table tabla = new Table();
		tabla.setCSSClass("res");
		Tr tr3 = new Tr();
		Th th = new Th();
		th.setCSSClass("black");
		th.appendChild(new Text(""));
		tr3.appendChild(th);
		int header = 1;
		for (int h : matriz[0]) {
			Th th1 = new Th();
			th1.appendChild(new Text(header));
			header++;
			tr3.appendChild(th1);
		}
		tabla.appendChild(tr3);

		int headerMat1 = 1;
		for (int[] fila : matriz) {
			Tr trMat1 = new Tr();
			Td td2 = new Td();
			td2.appendChild(new Text(headerMat1));
			headerMat1++;
			trMat1.appendChild(td2);
			for (int col : fila) {
				td2 = new Td();
				if (col == 2147483647)
					td2.appendChild(new Text("-"));
				else
					td2.appendChild(new Text(col));
				trMat1.appendChild(td2);
			}
			tabla.appendChild(trMat1);
		}

		div2.appendChild(parrafo1);
		div2.appendChild(tabla);
		div.appendChild(div2);

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