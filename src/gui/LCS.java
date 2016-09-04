package gui;

import java.awt.*;

import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import javax.swing.border.*;

import problemas.Knapsack;
import problemas.Problema;
import problemas.SubsecuenciaComun;

/**
 * Esta clase define la interfaz con la que se generaran los problemas de tipo LCS
 * @author: Asier Alonso Morante
 * @version: 20/01/2016/A
 */
public class LCS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// butimport javax.swing.border.*;tons
	private JPanel panelTitulo;
	private JPanel panelAjustes;
	private JPanel panelVista;
	private JPanel panelBotones;
	SubsecuenciaComun subsecuencia;
	String ruta = utiles.Utiles.getRuta();

	// constructor
	public LCS() {
		setTitle("Subsecuencia Común Más Larga");
		setSize(625,468);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(120,120,900,500);
		
		// content pane
		Container cp = getContentPane();
		cp.setPreferredSize(new Dimension(700,450));
		// add a panel for the size
		panelTitulo = new JPanel();
		panelTitulo.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to
															// panel
		FlowLayout flPanelTitulo = new FlowLayout();
		flPanelTitulo.setAlignment(FlowLayout.LEFT);
		panelTitulo.setLayout(flPanelTitulo);
		
		JLabel lblNewLabel = new JLabel("Subsecuencia Com\u00FAn M\u00E1s Larga");
		lblNewLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		panelTitulo.add(lblNewLabel);

		// añadir panel con parametros
		panelAjustes = new JPanel();
		panelAjustes.setBorder(new EmptyBorder(5, 5, 5, 5));


		// add view panel
		panelVista = new JPanel();
		panelVista.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to
															// panel
		final JTextPane textPaneResult = new JTextPane();
		textPaneResult.setEditable(false);
		// textPaneResult.setBounds(287, 89, 248, 199);
		textPaneResult.setContentType("text/html");
		textPaneResult.setEditorKit(utiles.Utiles.getEstilo());

		JScrollPane scrollLista = new JScrollPane(textPaneResult);
		scrollLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLista.setBounds(243, 75, 331, 227);
		panelVista.setLayout(new BorderLayout());
		
		JLabel lblNewLabel1 = new JLabel("Vista Preliminar");
		panelVista.add(lblNewLabel1, BorderLayout.NORTH);
		panelVista.add(scrollLista, BorderLayout.CENTER);

		if (!Problema.PROBGENERADOS.isEmpty()) {
			utiles.Utiles.cargarTextPane(textPaneResult, ruta);
		}

		// add bottom panel for output
		panelBotones = new JPanel();
		panelBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		// add panels to main pane
		cp.setLayout(new BorderLayout());
		cp.add(panelTitulo, BorderLayout.NORTH);
		GridBagLayout gblPanelAjustes = new GridBagLayout();
		gblPanelAjustes.columnWidths = new int[] {157, 173};
		gblPanelAjustes.rowHeights = new int[] {15, 30, 15, 30, 15, 30, 15, 30};
		gblPanelAjustes.columnWeights = new double[] { 0.0, 0.0 };
		gblPanelAjustes.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panelAjustes.setLayout(gblPanelAjustes);
		JLabel lblNumProblemas = new JLabel("N\u00FAmero de Problemas:");
		lblNumProblemas.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbcLblNumProblemas = new GridBagConstraints();
		gbcLblNumProblemas.fill = GridBagConstraints.BOTH;
		gbcLblNumProblemas.insets = new Insets(0, 0, 5, 5);
		gbcLblNumProblemas.gridx = 0;
		gbcLblNumProblemas.gridy = 1;
		panelAjustes.add(lblNumProblemas, gbcLblNumProblemas);
		lblNumProblemas.setPreferredSize(new Dimension(70, 10));
		final JSpinner spNumProb = new JSpinner();
		spNumProb.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spNumProb.setSize(new Dimension(5, 5));
		GridBagConstraints gbcSpNumProb = new GridBagConstraints();
		gbcSpNumProb.insets = new Insets(0, 0, 5, 0);
		gbcSpNumProb.gridx = 1;
		gbcSpNumProb.gridy = 1;
		panelAjustes.add(spNumProb, gbcSpNumProb);
		JLabel lblLongCad1 = new JLabel("Longitud Cadena 1:");
		GridBagConstraints gbcLblLongCad1 = new GridBagConstraints();
		gbcLblLongCad1.fill = GridBagConstraints.BOTH;
		gbcLblLongCad1.insets = new Insets(0, 0, 5, 5);
		gbcLblLongCad1.gridx = 0;
		gbcLblLongCad1.gridy = 3;
		panelAjustes.add(lblLongCad1, gbcLblLongCad1);

		final JSpinner longCad1 = new JSpinner();
		longCad1.setModel(new SpinnerNumberModel(new Integer(5), new Integer(1), null, new Integer(1)));
		longCad1.setMaximumSize(new Dimension(40, 20));
		GridBagConstraints gbcLongCad1 = new GridBagConstraints();
		gbcLongCad1.insets = new Insets(0, 0, 5, 0);
		gbcLongCad1.gridx = 1;
		gbcLongCad1.gridy = 3;
		panelAjustes.add(longCad1, gbcLongCad1);
		JLabel lblLongCad2 = new JLabel("Longitud Cadena 2:");
		GridBagConstraints gbcLblLongCad2 = new GridBagConstraints();
		gbcLblLongCad2.fill = GridBagConstraints.BOTH;
		gbcLblLongCad2.insets = new Insets(0, 0, 5, 5);
		gbcLblLongCad2.gridx = 0;
		gbcLblLongCad2.gridy = 5;
		panelAjustes.add(lblLongCad2, gbcLblLongCad2);

		final JSpinner longCad2 = new JSpinner();
		longCad2.setModel(new SpinnerNumberModel(new Integer(5), new Integer(1), null, new Integer(1)));
		longCad2.setMaximumSize(new Dimension(40, 20));
		GridBagConstraints gbcLongCad2 = new GridBagConstraints();
		gbcLongCad2.insets = new Insets(0, 0, 5, 0);
		gbcLongCad2.gridx = 1;
		gbcLongCad2.gridy = 5;
		panelAjustes.add(longCad2, gbcLongCad2);
		cp.add(panelAjustes, BorderLayout.WEST);
		
		JLabel lblPctRepuestas = new JLabel("Porcentaje de Respuestas");
		lblPctRepuestas.setToolTipText("N\u00FAmero de inc\u00F3gnitas resueltas de la pregunta, 100 = matriz resuelta y 0 = matriz vac\u00EDa");
		GridBagConstraints gbcLblPctRepuestas = new GridBagConstraints();
		gbcLblPctRepuestas.anchor = GridBagConstraints.WEST;
		gbcLblPctRepuestas.insets = new Insets(0, 0, 0, 5);
		gbcLblPctRepuestas.gridx = 0;
		gbcLblPctRepuestas.gridy = 7;
		panelAjustes.add(lblPctRepuestas, gbcLblPctRepuestas);
		
		final JSlider sl_PctRespuestas = new JSlider();
		GridBagConstraints gbcSlPctRespuestas = new GridBagConstraints();
		gbcSlPctRespuestas.fill = GridBagConstraints.HORIZONTAL;
		gbcSlPctRespuestas.gridx = 1;
		gbcSlPctRespuestas.gridy = 7;
		sl_PctRespuestas.setPaintTicks(true);
		sl_PctRespuestas.setPaintLabels(true);
		sl_PctRespuestas.setSnapToTicks(true);
		sl_PctRespuestas.setPaintLabels(true);
		sl_PctRespuestas.setMinorTickSpacing(1);
		sl_PctRespuestas.setMajorTickSpacing(25);
		sl_PctRespuestas.setPaintTicks(true);
		panelAjustes.add(sl_PctRespuestas, gbcSlPctRespuestas);
		cp.add(panelVista, BorderLayout.CENTER);
		cp.add(panelBotones, BorderLayout.SOUTH);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				utiles.Utiles.borrarPanel(ruta);
				textPaneResult.setText("");
			}
		});
		btnLimpiar.setBounds(189, 326, 89, 23);
		panelBotones.add(btnLimpiar);

		final JButton btnExportar = new JButton("Exportar");
		btnExportar.setEnabled(false);
		btnExportar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnExportar.isEnabled()) {
					ExportarFrame recuperarFrame = new ExportarFrame(new Knapsack(1, 2), 1);
					recuperarFrame.setVisible(true);
			
				}
			}
		});
		if (!Problema.PROBGENERADOS.isEmpty()) {
			btnExportar.setEnabled(true);
		} else {
			btnExportar.setEnabled(false);
		}

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					utiles.Utiles.cargarTextPane(textPaneResult, ruta);
					textPaneResult.update(textPaneResult.getGraphics());

					int cad1 = (int) longCad1.getValue();
					int cad2 = (int) longCad2.getValue();
					int numProblemas = (int) spNumProb.getValue();
					for (int i = 0; i < numProblemas; i++) {
						subsecuencia = new SubsecuenciaComun(cad1, cad2);
						subsecuencia.execute();
						subsecuencia.setPorcentaje((int) sl_PctRespuestas.getValue());
						Problema.PROBGENERADOS.add(subsecuencia);
						utiles.Utiles.añadirSubsecuenciaPanel(textPaneResult, subsecuencia, ruta);
					}
					File file = new File(ruta);
					textPaneResult.replaceSelection(file.toString());
					utiles.Utiles.cargarTextPane(textPaneResult, ruta);
					textPaneResult.update(textPaneResult.getGraphics());
					if (!btnExportar.isEnabled()) {
						btnExportar.setEnabled(true);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(new JFrame(), "Faltan datos por introducir", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnGenerar.setBounds(287, 326, 89, 23);
		panelBotones.add(btnGenerar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});

		panelBotones.add(btnExportar);
		panelBotones.add(btnCancelar);
		pack();
	}

}