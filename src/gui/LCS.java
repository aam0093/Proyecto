package gui;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

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
		setTitle("Subsecuencia Comun Mas Larga");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(120,120,700,500);
		
		// content pane
		Container cp = getContentPane();

		// add a panel for the size
		panelTitulo = new JPanel();
		panelTitulo.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to
															// panel
		FlowLayout fl_panelTitulo = new FlowLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		panelTitulo.setLayout(fl_panelTitulo);
		JLabel lblNewLabel = new JLabel("Subsecuencia Comun Mas Larga");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		panelTitulo.add(lblNewLabel);

		// añadir panel con parametros
		panelAjustes = new JPanel();
		panelAjustes.setBorder(new EmptyBorder(5, 15, 5, 5));

		SpinnerNumberModel m_numberSpinnerModel = new SpinnerNumberModel(1, 1, 3, 1);

		// add view panel
		panelVista = new JPanel();
		panelVista.setBorder(new EmptyBorder(5, 90, 5, 15));// adds margin to
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
		
		JLabel lblNewLabel_1 = new JLabel("Vista Preeliminar");
		panelVista.add(lblNewLabel_1, BorderLayout.NORTH);
		panelVista.add(scrollLista, BorderLayout.CENTER);

		if (!Problema.problemasGenerados.isEmpty()) {
			utiles.Utiles.cargarTextPane(textPaneResult, ruta);
		}

		// add bottom panel for output
		panelBotones = new JPanel();
		panelBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		// add panels to main pane
		cp.setLayout(new BorderLayout());
		cp.add(panelTitulo, BorderLayout.NORTH);
		GridBagLayout gbl_panelAjustes = new GridBagLayout();
		gbl_panelAjustes.columnWidths = new int[] {115, 85};
		gbl_panelAjustes.rowHeights = new int[] {30, 50, 30, 50};
		gbl_panelAjustes.columnWeights = new double[] { 0.0, 0.0 };
		gbl_panelAjustes.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panelAjustes.setLayout(gbl_panelAjustes);
		JLabel lblNumProblemas = new JLabel("Numero de Problemas:");
		lblNumProblemas.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbc_lblNumProblemas = new GridBagConstraints();
		gbc_lblNumProblemas.fill = GridBagConstraints.BOTH;
		gbc_lblNumProblemas.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumProblemas.gridx = 0;
		gbc_lblNumProblemas.gridy = 1;
		panelAjustes.add(lblNumProblemas, gbc_lblNumProblemas);
		lblNumProblemas.setPreferredSize(new Dimension(70, 10));
		final JSpinner spNumProb = new JSpinner();
		spNumProb.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spNumProb.setSize(new Dimension(5, 5));
		GridBagConstraints gbc_spNumProb = new GridBagConstraints();
		gbc_spNumProb.insets = new Insets(0, 0, 5, 0);
		gbc_spNumProb.gridx = 1;
		gbc_spNumProb.gridy = 1;
		panelAjustes.add(spNumProb, gbc_spNumProb);
		JLabel lblLongCad1 = new JLabel("Longitud Cadena 1:");
		GridBagConstraints gbc_lblLongCad1 = new GridBagConstraints();
		gbc_lblLongCad1.fill = GridBagConstraints.BOTH;
		gbc_lblLongCad1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLongCad1.gridx = 0;
		gbc_lblLongCad1.gridy = 3;
		panelAjustes.add(lblLongCad1, gbc_lblLongCad1);

		final JSpinner longCad1 = new JSpinner();
		longCad1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		longCad1.setMaximumSize(new Dimension(40, 20));
		GridBagConstraints gbc_longCad1 = new GridBagConstraints();
		gbc_longCad1.insets = new Insets(0, 0, 5, 0);
		gbc_longCad1.gridx = 1;
		gbc_longCad1.gridy = 3;
		panelAjustes.add(longCad1, gbc_longCad1);
		JLabel lblLongCad2 = new JLabel("Longitud Cadena 2:");
		GridBagConstraints gbc_lblLongCad2 = new GridBagConstraints();
		gbc_lblLongCad2.fill = GridBagConstraints.BOTH;
		gbc_lblLongCad2.insets = new Insets(0, 0, 5, 5);
		gbc_lblLongCad2.gridx = 0;
		gbc_lblLongCad2.gridy = 5;
		panelAjustes.add(lblLongCad2, gbc_lblLongCad2);

		final JSpinner longCad2 = new JSpinner();
		longCad2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		longCad2.setMaximumSize(new Dimension(40, 20));
		GridBagConstraints gbc_longCad2 = new GridBagConstraints();
		gbc_longCad2.insets = new Insets(0, 0, 5, 0);
		gbc_longCad2.gridx = 1;
		gbc_longCad2.gridy = 5;
		panelAjustes.add(longCad2, gbc_longCad2);
		cp.add(panelAjustes, BorderLayout.WEST);
		
		JLabel lblPctRepuestas = new JLabel("PCT. Repuestas");
		GridBagConstraints gbc_lblPctRepuestas = new GridBagConstraints();
		gbc_lblPctRepuestas.anchor = GridBagConstraints.WEST;
		gbc_lblPctRepuestas.insets = new Insets(0, 0, 0, 5);
		gbc_lblPctRepuestas.gridx = 0;
		gbc_lblPctRepuestas.gridy = 7;
		panelAjustes.add(lblPctRepuestas, gbc_lblPctRepuestas);
		
		final JSlider sl_PctRespuestas = new JSlider();
		GridBagConstraints gbc_sl_PctRespuestas = new GridBagConstraints();
		gbc_sl_PctRespuestas.fill = GridBagConstraints.HORIZONTAL;
		gbc_sl_PctRespuestas.gridx = 1;
		gbc_sl_PctRespuestas.gridy = 7;
		panelAjustes.add(sl_PctRespuestas, gbc_sl_PctRespuestas);
		cp.add(panelVista, BorderLayout.CENTER);
		cp.add(panelBotones, BorderLayout.SOUTH);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				utiles.Utiles.borrarPanel(ruta);
				// textPaneResult.update(textPaneResult.getGraphics());
				File file = new File(ruta);
				try {
					textPaneResult.setPage(file.toURI().toURL());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textPaneResult.repaint();
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
					dispose();
				}
			}
		});
		if (!Problema.problemasGenerados.isEmpty()) {
			btnExportar.setEnabled(true);
		} else {
			btnExportar.setEnabled(false);
		}

		JButton btn_Generar = new JButton("Generar");
		btn_Generar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					utiles.Utiles.cargarTextPane(textPaneResult, "");
					utiles.Utiles.cargarTextPane(textPaneResult, ruta);
					textPaneResult.update(textPaneResult.getGraphics());

					int cad1 = (int) longCad1.getValue();
					int cad2 = (int) longCad2.getValue();
					int numProblemas = (int) spNumProb.getValue();
					for (int i = 0; i < numProblemas; i++) {
						subsecuencia = new SubsecuenciaComun(cad1, cad2);
						subsecuencia.execute();
						subsecuencia.setPorcentaje((int) sl_PctRespuestas.getValue());
						Problema.problemasGenerados.add(subsecuencia);
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
					System.out.println(e.toString());
					JOptionPane.showMessageDialog(new JFrame(), "Faltan datos por introducir", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btn_Generar.setBounds(287, 326, 89, 23);
		panelBotones.add(btn_Generar);

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