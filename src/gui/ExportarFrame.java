package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import exportar.Exportar;
import exportar.ExportarFactory;
import pregunta.*;
import problemas.Floyd;
import problemas.Knapsack;
import problemas.MultiplicaMatrices;
import problemas.Problema;
import problemas.SubsecuenciaComun;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;

public class ExportarFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFGuarda;
	private JTextField txtFSemilla;

	String rutaRecuperado = utiles.Utiles.getRutaRecuperado();

	public static void main(String[] args) {

		/*Cuidado con esto, puede ser borrable */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema p = new Knapsack(2, 3);
					ExportarFrame frame = new ExportarFrame(p, 2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ExportarFrame(Problema proble, int i) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Parametros asociados a la ventana
		this.setBounds(100, 100, 500, 400);
		setVisible(true);
		setTitle("Exportar / Recuperar Problemas");

		// Creamos el conjunto de pestañas
		JTabbedPane pestañas = new JTabbedPane();

		// Creamos el panel y lo añadimos a las pestañas
		JPanel panelExportar = new JPanel();

		// Añadimos un nombre de la pestaña y el panel
		pestañas.addTab("Exportar", panelExportar);
		panelExportar.setLayout(new BorderLayout(0, 0));

		// **Añadir panel Titulo
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());

		JLabel lblTitulo = new JLabel("Exportar: ");
		lblTitulo.setFont(new Font("Tahoma", Font.ITALIC, 20));

		panelTitulo.add(lblTitulo);

		// ***Añadir Panel Central
		JPanel panelCentral = new JPanel();
		GridBagLayout gblPanelCentral = new GridBagLayout();
		gblPanelCentral.columnWidths = new int[] { 100, 89, 110, 0, 100, 0 };
		gblPanelCentral.rowHeights = new int[] { 58, 19, 51, 49, 0, 43, 0, 38, 58, 0 };
		gblPanelCentral.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gblPanelCentral.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCentral.setLayout(gblPanelCentral);

		JLabel lblGuardarEn = new JLabel("Guardar en: ");
		GridBagConstraints gbcLblGuardarEn = new GridBagConstraints();
		gbcLblGuardarEn.fill = GridBagConstraints.BOTH;
		gbcLblGuardarEn.insets = new Insets(0, 0, 5, 5);
		gbcLblGuardarEn.gridx = 1;
		gbcLblGuardarEn.gridy = 3;
		panelCentral.add(lblGuardarEn, gbcLblGuardarEn);

		textFGuarda = new JTextField();
		GridBagConstraints gbcTextFGuarda = new GridBagConstraints();
		gbcTextFGuarda.fill = GridBagConstraints.HORIZONTAL;
		gbcTextFGuarda.insets = new Insets(0, 0, 5, 5);
		gbcTextFGuarda.gridx = 2;
		gbcTextFGuarda.gridy = 3;
		panelCentral.add(textFGuarda, gbcTextFGuarda);
		textFGuarda.setColumns(25);

		JButton btnBrowse = new JButton("Browse..");
		GridBagConstraints gbcBtnBrowse = new GridBagConstraints();
		gbcBtnBrowse.fill = GridBagConstraints.HORIZONTAL;
		gbcBtnBrowse.insets = new Insets(0, 0, 5, 5);
		gbcBtnBrowse.gridx = 3;
		gbcBtnBrowse.gridy = 3;
		panelCentral.add(btnBrowse, gbcBtnBrowse);
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Creamos selector de apertura
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Seleccionar Directorio");
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					textFGuarda.setText(chooser.getSelectedFile().toString());
				} else {
		//			System.out.println("No seleccion ");
					JOptionPane.showMessageDialog(new JFrame(), "No se ha seleccionado nada", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnBrowse.setBackground(Color.WHITE);

		final JRadioButton rdbtnHtml = new JRadioButton("HTML");
		rdbtnHtml.setSelected(true);
		GridBagConstraints gbcRdbtnHtml = new GridBagConstraints();
		gbcRdbtnHtml.fill = GridBagConstraints.BOTH;
		gbcRdbtnHtml.insets = new Insets(0, 0, 5, 5);
		gbcRdbtnHtml.gridx = 1;
		gbcRdbtnHtml.gridy = 6;
		panelCentral.add(rdbtnHtml, gbcRdbtnHtml);

		final JRadioButton rdbtnMoodle = new JRadioButton("Moodle");
		GridBagConstraints gbcRdbtnMoodle = new GridBagConstraints();
		gbcRdbtnMoodle.fill = GridBagConstraints.BOTH;
		gbcRdbtnMoodle.insets = new Insets(0, 0, 5, 5);
		gbcRdbtnMoodle.gridx = 2;
		gbcRdbtnMoodle.gridy = 6;
		panelCentral.add(rdbtnMoodle, gbcRdbtnMoodle);

		JRadioButton rdbtnJson = new JRadioButton("Json");
		GridBagConstraints gbcRdbtnJson = new GridBagConstraints();
		gbcRdbtnJson.fill = GridBagConstraints.BOTH;
		gbcRdbtnJson.insets = new Insets(0, 0, 5, 5);
		gbcRdbtnJson.gridx = 3;
		gbcRdbtnJson.gridy = 6;
		panelCentral.add(rdbtnJson, gbcRdbtnJson);

		final ButtonGroup formatos = new ButtonGroup();
		formatos.add(rdbtnHtml);
		formatos.add(rdbtnMoodle);
		formatos.add(rdbtnJson);

		// Componentes del panel1
		panelTitulo.add(lblTitulo, FlowLayout.LEFT);

		// Añadir panel Botones
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFGuarda.getText().isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Campo directorio vacio", "Acerca De",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					ArrayList<Problema> problemas = (ArrayList<Problema>) Problema.PROBGENERADOS;
					String ruta = textFGuarda.getText();
					String tipo = "";
					if (rdbtnMoodle.isSelected()) {
						tipo = "XML";
						if (!ruta.substring(ruta.length() - 4, ruta.length()).equals(".xml")) {
							ruta = ruta + ".xml";
						}
					} else {
						if (rdbtnHtml.isSelected()){
							tipo = "HTML";
							if (!ruta.substring(ruta.length() - 5, ruta.length()).equals(".html")) 
								ruta = ruta + ".html";
						} else {
							tipo = "JSON";
							if (!ruta.substring(ruta.length() - 5, ruta.length()).equals(".json")) 
								ruta = ruta + ".json";
						}
					}
					if (problemas.size() == 0) {
						JOptionPane.showMessageDialog(new JFrame(), "No se ha generado ningun problema", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						ExportarFactory exportarFactory = new ExportarFactory();
						Exportar ex;
						ex = exportarFactory.getFormato(tipo);
						ex.abrirFichero();
						int contador = 0 ;
						//Aqui llegan mal ya los problemas,

						for (Problema p : problemas) {
							if (p.getTipo() == "MATRICES"){
								contador ++;
								MultiplicaMatrices m = (MultiplicaMatrices) p;
								System.out.println("matriz qe entra, resul: " + m.getResultado() + "   cont; " + contador);
							}
							Pregunta preg = construirPregunta(p);
							ex.exportar(preg, ruta);
						}
						ex.cerrarFichero();
						JOptionPane.showMessageDialog(new JFrame(), "Fichero Guardado", "Info",
								JOptionPane.OK_CANCEL_OPTION);
					}
					dispose();
				}
				
			}

		});
		panelBotones.add(btnGuardar);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panelBotones.add(btnCancel);
		panelExportar.add(panelTitulo, BorderLayout.NORTH);
		panelExportar.add(panelCentral, BorderLayout.CENTER);
		panelExportar.add(panelBotones, BorderLayout.SOUTH);

		// ****PANEL RECUPERAR ****** //

		JPanel panelRecuperar = new JPanel();
		panelRecuperar.setLayout(new BorderLayout());

		JPanel panelParametros = new JPanel();

		panelRecuperar.add(panelParametros, BorderLayout.WEST);

		JPanel panelVista = new JPanel();
		panelVista = new JPanel();
		panelVista.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to
		final JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setContentType("text/html");
		textPane.setEditorKit(utiles.Utiles.getEstilo());

		JScrollPane scrollLista = new JScrollPane(textPane);
		scrollLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLista.setBounds(243, 75, 331, 227);
		panelVista.setLayout(new BorderLayout());
		panelVista.add(scrollLista, BorderLayout.CENTER);

		panelRecuperar.add(panelVista, BorderLayout.CENTER);

		GridBagLayout gblPanelParametros = new GridBagLayout();
		gblPanelParametros.columnWidths = new int[] { 30, 0, 0, 0 };
		gblPanelParametros.rowHeights = new int[] { 14, 0, 0 };
		gblPanelParametros.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gblPanelParametros.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panelParametros.setLayout(gblPanelParametros);
		JLabel lblNewLabel = new JLabel("Semilla: ");
		GridBagConstraints gbcLblNewLabel = new GridBagConstraints();
		gbcLblNewLabel.anchor = GridBagConstraints.WEST;
		gbcLblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbcLblNewLabel.gridx = 0;
		gbcLblNewLabel.gridy = 1;
		panelParametros.add(lblNewLabel, gbcLblNewLabel);

		JButton btnVer = new JButton("Recuperar");
		btnVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtFSemilla.getText().isEmpty() || txtFSemilla.getText().length() != 17) {
					JOptionPane.showMessageDialog(new JFrame(), "Introduce un valor valido para la semilla", "Dialog",
							JOptionPane.INFORMATION_MESSAGE);
			//		txtFSemilla.setText("");
				} else {
					Problema p = recuperarProblema(txtFSemilla.getText().toString());
					if (p.getTipo().equals(Problema.TIPO.MOCHILA.toString())) {
						Knapsack mochila = (Knapsack) p;
						mochila.execute();
						utiles.Utiles.añadirMochilaPanel(textPane, mochila, rutaRecuperado);
					} else {
						if (p.getTipo().equals(Problema.TIPO.SUBSECUENCIA.toString())) {
							SubsecuenciaComun subsecuencia = (SubsecuenciaComun) p;
							subsecuencia.execute();
							utiles.Utiles.añadirSubsecuenciaPanel(textPane, subsecuencia, rutaRecuperado);
						}
						if (p.getTipo().equals(Problema.TIPO.FLOYD.toString())) {
							Floyd floyd = (Floyd) p;
							floyd.execute();
							utiles.Utiles.añadirFloydPanel(textPane, floyd, rutaRecuperado);
						}
						if (p.getTipo().equals(Problema.TIPO.MATRICES.toString())) {
							MultiplicaMatrices matrices = (MultiplicaMatrices) p;
							matrices.execute();
							utiles.Utiles.añadirMatricesPanel(textPane, matrices, rutaRecuperado);
						}
					}
					utiles.Utiles.cargarTextPane(textPane, rutaRecuperado);
					

				}
			}
		});

		txtFSemilla = new JTextField();
		txtFSemilla.setAlignmentY(Component.TOP_ALIGNMENT);
		txtFSemilla.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtFSemilla.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				{
					if (txtFSemilla.getText().length() == 15)
						arg0.consume();
				}
			}
		});
		txtFSemilla.setColumns(10);
		GridBagConstraints gbcTxtFSemilla = new GridBagConstraints();
		gbcTxtFSemilla.anchor = GridBagConstraints.NORTHEAST;
		gbcTxtFSemilla.insets = new Insets(0, 0, 5, 5);
		gbcTxtFSemilla.gridx = 1;
		gbcTxtFSemilla.gridy = 1;
		panelParametros.add(txtFSemilla, gbcTxtFSemilla);
		GridBagConstraints gbcBtnVer = new GridBagConstraints();
		gbcBtnVer.insets = new Insets(0, 0, 0, 5);
		gbcBtnVer.anchor = GridBagConstraints.WEST;
		gbcBtnVer.gridx = 1;
		gbcBtnVer.gridy = 3;
		panelParametros.add(btnVer, gbcBtnVer);

		JPanel panelBotonRecuperar = new JPanel();

		JButton btnNewButton1 = new JButton("Limpiar");
		btnNewButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				utiles.Utiles.borrarPanel(rutaRecuperado);
				textPane.setText("");
				
				
			}
		});
		btnNewButton1.setBounds(260, 286, 89, 23);
		panelBotonRecuperar.add(btnNewButton1);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(526, 286, 75, 23);
		panelBotonRecuperar.add(btnCancelar);

		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				utiles.Utiles.borrarPanel(rutaRecuperado);
				dispose();
			}
		});

		btnCancelar.setBounds(380, 286, 89, 23);
		panelBotonRecuperar.add(btnCancelar);

		panelRecuperar.add(panelBotonRecuperar, BorderLayout.SOUTH);

		pestañas.addTab("Recuperar", panelRecuperar);
		getContentPane().add(pestañas);
	}

	public Problema recuperarProblema(String seed) {
		String tipo = seed.substring(0, 2);
		Problema problema = null;
		if (tipo.equals("10")) {
			int cantidad = Integer.parseInt(seed.substring(2, 4));
			int numElem = Integer.parseInt(seed.substring(4, 6));
			problema = new Knapsack(cantidad, numElem, Long.valueOf(seed).longValue());
			return problema;
		}
		if (tipo.equals("20")) {
			int longcad1 = Integer.parseInt(seed.substring(2, 4));
			int longcad2 = Integer.parseInt(seed.substring(4, 6));
			problema = new SubsecuenciaComun(longcad1, longcad2, Long.valueOf(seed).longValue());
			return problema;
		}
		if (tipo.equals("30")) {
			problema = new Floyd(0);
			return problema.recuperarProblema(seed);
		}
		if (tipo.equals("40")) {
			int numMat = Integer.parseInt(seed.substring(1, 4));
			problema = new MultiplicaMatrices(numMat, Long.parseLong(seed));
			return problema;
		}

		return null;
	}

	public Pregunta construirPregunta(Problema p) {

		PreguntaDirector creadorPregunta = new PreguntaDirector();
		PreguntaBuilder pr = null;
		switch (p.getTipo()) {
		case "MOCHILA":
			pr = new PrMochila((Knapsack) p);
			break;
		case "SUBSECUENCIA":
			pr = new PrLCS((SubsecuenciaComun) p);
			break;
		 case "FLOYD":
			 pr = new PrFloyd((Floyd) p);
			 break;
		case "MATRICES":	
			pr = new PrMatrices((MultiplicaMatrices) p);
			MultiplicaMatrices mn;
			mn = (MultiplicaMatrices) p;
			
			System.out.println("---problema---" + mn.getResultado());
			
			break;
		 default: 
		     break;
		 
		}

		creadorPregunta.setPreguntaBuilder(pr);
		creadorPregunta.construirPregunta();

		Pregunta pregunta = creadorPregunta.getPregunta();
		return pregunta;
	}

}