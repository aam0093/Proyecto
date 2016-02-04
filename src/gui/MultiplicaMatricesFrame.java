package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import problemas.MultiplicaMatrices;
import problemas.Problema;
import javax.swing.JSlider;

/**
 * Esta clase define la interfaz con la que se generaran los problemas de Multiplicacion Encadenada de Matrices
 * @author: Asier Alonso Morante
 * @version: 20/01/2016/A
 */
public class MultiplicaMatricesFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// butimport javax.swing.border.*;tons
	private JPanel panelTitulo;
	private JPanel panelAjustes;
	private JPanel panelVista;
	private JPanel panelBotones;
	MultiplicaMatrices matrices;
	String ruta = utiles.Utiles.getRuta();

	// constructor
	public MultiplicaMatricesFrame() {
		setTitle("Problema Multiplicar Matrices");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		JLabel lblNewLabel = new JLabel("Problema Multiplicar Matrices");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		panelTitulo.add(lblNewLabel);

		// añadir panel con parametros
		panelAjustes = new JPanel();
		panelAjustes.setBorder(new EmptyBorder(5, 5, 5, 5));

		SpinnerNumberModel m_numberSpinnerModel = new SpinnerNumberModel(1, 1, 3, 1);

		GridBagLayout gbl_panelAjustes = new GridBagLayout();
		gbl_panelAjustes.columnWidths = new int[] { 115, 85 };
		gbl_panelAjustes.rowHeights = new int[] { 20, 50, 20, 50, 20, 50 };
		panelAjustes.setLayout(gbl_panelAjustes);

		JLabel lblNumProblemas = new JLabel("Numero de Problemas:");
		lblNumProblemas.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbc_lblNumProblemas = new GridBagConstraints();
		// gbc_lblNumProblemas.fill = GridBagConstraints.BOTH;
		gbc_lblNumProblemas.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumProblemas.gridx = 0;
		gbc_lblNumProblemas.gridy = 1;
		panelAjustes.add(lblNumProblemas, gbc_lblNumProblemas);

		final JSpinner spNumProb = new JSpinner();
		spNumProb.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spNumProb.setSize(new Dimension(5, 5));
		GridBagConstraints gbc_spNumProb = new GridBagConstraints();
		gbc_spNumProb.insets = new Insets(0, 0, 5, 0);
		gbc_spNumProb.gridx = 1;
		gbc_spNumProb.gridy = 1;
		panelAjustes.add(spNumProb, gbc_spNumProb);

		JLabel lblNumMatrices = new JLabel("Numero de Matrices:");
		GridBagConstraints gbc_lblNumMatrices = new GridBagConstraints();
		gbc_lblNumMatrices.fill = GridBagConstraints.BOTH;
		gbc_lblNumMatrices.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumMatrices.gridx = 0;
		gbc_lblNumMatrices.gridy = 3;
		panelAjustes.add(lblNumMatrices, gbc_lblNumMatrices);

		final JSpinner numNodos = new JSpinner();
		numNodos.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(1)));
		numNodos.setMaximumSize(new Dimension(40, 20));
		GridBagConstraints gbc_longCad1 = new GridBagConstraints();
		gbc_longCad1.insets = new Insets(0, 0, 5, 0);
		gbc_longCad1.gridx = 1;
		gbc_longCad1.gridy = 3;
		panelAjustes.add(numNodos, gbc_longCad1);

		JLabel lblPCT_Respuestas = new JLabel("PCT. Respuestas: ");
		GridBagConstraints gbc_lblPCT_Respuestas = new GridBagConstraints();
		gbc_lblPCT_Respuestas.fill = GridBagConstraints.BOTH;
		gbc_lblPCT_Respuestas.insets = new Insets(0, 0, 0, 5);
		gbc_lblPCT_Respuestas.gridx = 0;
		gbc_lblPCT_Respuestas.gridy = 5;
		panelAjustes.add(lblPCT_Respuestas, gbc_lblPCT_Respuestas);

		final JSlider slider = new JSlider();
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 5;
		panelAjustes.add(slider, gbc_slider);

		
		// ** Añadir panel Vista **
		panelVista = new JPanel();
		panelVista.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to

		final JTextPane textPaneResult = new JTextPane();
		textPaneResult.setEditable(false);
		textPaneResult.setContentType("text/html");
		textPaneResult.setEditorKit(utiles.Utiles.getEstilo());

		utiles.Utiles.cargarTextPane(textPaneResult, "http://www.marca.com/");

		JScrollPane scrollLista = new JScrollPane(textPaneResult);
		scrollLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLista.setBounds(243, 75, 331, 227);
		panelVista.setLayout(new BorderLayout());
		
		JLabel lblNewLabel_1 = new JLabel("Vista Preeliminar");
		panelVista.add(lblNewLabel_1, BorderLayout.NORTH);
		panelVista.add(scrollLista, BorderLayout.CENTER);

		// ** Añadir panel Botones **
		panelBotones = new JPanel();
		panelBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

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
					ExportarFrame recuperarFrame = new ExportarFrame(new MultiplicaMatrices(1), 1);
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
					textPaneResult.update(textPaneResult.getGraphics());

					int cad1 = (int) numNodos.getValue();
					int numProblemas = (int) spNumProb.getValue();
					for (int i = 0; i < numProblemas; i++) {
						matrices = new MultiplicaMatrices(cad1);
						matrices.execute();
						matrices.setPorcentaje((int) slider.getValue());
						Problema.problemasGenerados.add(matrices);
						utiles.Utiles.añadirMatricesPanel(textPaneResult, matrices, ruta);

					}
					utiles.Utiles.cargarTextPane(textPaneResult, ruta);
					
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

		cp.setLayout(new BorderLayout());
		cp.add(panelTitulo, BorderLayout.NORTH);
		cp.add(panelAjustes, BorderLayout.WEST);
		cp.add(panelVista, BorderLayout.CENTER);
		cp.add(panelBotones, BorderLayout.SOUTH);
		pack();
	}

}
