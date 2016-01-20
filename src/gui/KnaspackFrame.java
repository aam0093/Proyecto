package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import problemas.Knapsack;
import problemas.Problema;

public class KnaspackFrame extends JFrame {

	// butimport javax.swing.border.*;tons
	private JPanel panelTitulo;
	private JPanel panelAjustes;
	private JPanel panelVista;
	private JPanel panelBotones;
	Knapsack subsecuencia;
	String ruta = utiles.Utiles.getRuta();
	Knapsack mochila;
	JTextField textField;
	private JTextField tf_ValorMax;

	// constructor
	public KnaspackFrame() {
		setTitle("Problema de la Mochila");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// content pane
		Container cp = getContentPane();
		cp.setPreferredSize(new Dimension(600, 400));
		cp.setLayout(new BorderLayout());

		// ** Panel Título **
		panelTitulo = new JPanel();
		panelTitulo.setBorder(new EmptyBorder(5, 5, 5, 5));

		FlowLayout fl_panelTitulo = new FlowLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		panelTitulo.setLayout(fl_panelTitulo);
		JLabel lblNewLabel = new JLabel("Problema de la Mochila");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		panelTitulo.add(lblNewLabel);

		cp.add(panelTitulo, BorderLayout.NORTH);

		// ** Añadir panel Ajustes
		panelAjustes = new JPanel();
		panelAjustes.setBorder(new EmptyBorder(5, 15, 5, 5));

		SpinnerNumberModel m_numberSpinnerModel = new SpinnerNumberModel(1, 1, 3, 1);

		GridBagLayout gbl_panelAjustes = new GridBagLayout();
		gbl_panelAjustes.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panelAjustes.rowHeights = new int[] { 0, 30, 0, 20, 42, 30, 0, 30, 0, 30, 25 };
		gbl_panelAjustes.columnWidths = new int[] { 115, 85 };
		panelAjustes.setLayout(gbl_panelAjustes);

		JLabel lblNumProblemas = new JLabel("Numero de Problemas:");
		lblNumProblemas.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbc_lblNumProblemas = new GridBagConstraints();
		gbc_lblNumProblemas.anchor = GridBagConstraints.WEST;
		gbc_lblNumProblemas.fill = GridBagConstraints.VERTICAL;
		gbc_lblNumProblemas.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumProblemas.gridx = 0;
		gbc_lblNumProblemas.gridy = 0;
		panelAjustes.add(lblNumProblemas, gbc_lblNumProblemas);

		final JSpinner spNumProb = new JSpinner();
		spNumProb.setSize(new Dimension(5, 5));
		GridBagConstraints gbc_spNumProb = new GridBagConstraints();
		gbc_spNumProb.insets = new Insets(0, 0, 5, 0);
		gbc_spNumProb.gridx = 1;
		gbc_spNumProb.gridy = 0;
		panelAjustes.add(spNumProb, gbc_spNumProb);
		spNumProb.setSize(new Dimension(5, 5));
		gbc_spNumProb.insets = new Insets(0, 0, 5, 0);
		gbc_spNumProb.gridx = 1;
		gbc_spNumProb.gridy = 0;

		JLabel lblCapacidad = new JLabel("Capacidad:");
		GridBagConstraints gbc_lblLongCad1 = new GridBagConstraints();
		gbc_lblLongCad1.anchor = GridBagConstraints.WEST;
		gbc_lblLongCad1.fill = GridBagConstraints.VERTICAL;
		gbc_lblLongCad1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLongCad1.gridx = 0;
		gbc_lblLongCad1.gridy = 2;
		panelAjustes.add(lblCapacidad, gbc_lblLongCad1);
		
		tf_ValorMax = new JTextField();
		GridBagConstraints gbc_tf_ValorMax = new GridBagConstraints();
		gbc_tf_ValorMax.insets = new Insets(0, 0, 5, 0);
		gbc_tf_ValorMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ValorMax.gridx = 1;
		gbc_tf_ValorMax.gridy = 8;
		panelAjustes.add(tf_ValorMax, gbc_tf_ValorMax);
		tf_ValorMax.setColumns(10);
		
		JLabel lblTipoProblema = new JLabel("Tipo de Problema: ");
		GridBagConstraints gbc_lblTipoProblema = new GridBagConstraints();
		gbc_lblTipoProblema.anchor = GridBagConstraints.WEST;
		gbc_lblTipoProblema.fill = GridBagConstraints.VERTICAL;
		gbc_lblTipoProblema.insets = new Insets(0, 0, 0, 5);
		gbc_lblTipoProblema.gridx = 0;
		gbc_lblTipoProblema.gridy = 10;
		panelAjustes.add(lblTipoProblema, gbc_lblTipoProblema);

		final JSpinner spTipProblem = new JSpinner();
		GridBagConstraints gbc_spTipProb = new GridBagConstraints();
		gbc_spTipProb.fill = GridBagConstraints.VERTICAL;
		gbc_spTipProb.gridx = 1;
		gbc_spTipProb.gridy = 10;
		panelAjustes.add(spTipProblem, gbc_spTipProb);
		
		final JFormattedTextField textF_numElementos = new JFormattedTextField();
		textF_numElementos.setMaximumSize(new Dimension(40, 20));
		GridBagConstraints gbc_numElementos = new GridBagConstraints();
		gbc_numElementos.fill = GridBagConstraints.HORIZONTAL;
		gbc_numElementos.insets = new Insets(0, 0, 5, 0);
		gbc_numElementos.gridx = 1;
		gbc_numElementos.gridy = 4;
		panelAjustes.add(textF_numElementos, gbc_numElementos);

		JLabel lblPesoMaxElem = new JLabel("Peso Max / Elem.");
		GridBagConstraints gbc_lblPesoMaxElem = new GridBagConstraints();
		gbc_lblPesoMaxElem.fill = GridBagConstraints.VERTICAL;
		gbc_lblPesoMaxElem.insets = new Insets(0, 0, 5, 5);
		gbc_lblPesoMaxElem.anchor = GridBagConstraints.WEST;
		gbc_lblPesoMaxElem.gridx = 0;
		gbc_lblPesoMaxElem.gridy = 6;
		panelAjustes.add(lblPesoMaxElem, gbc_lblPesoMaxElem);

		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 6;
		panelAjustes.add(textField, gbc_textField);

		JLabel lblValorMaxElemento = new JLabel("Valor Max/ Elemento");
		GridBagConstraints gbc_lblValorMaxElemento = new GridBagConstraints();
		gbc_lblValorMaxElemento.fill = GridBagConstraints.VERTICAL;
		gbc_lblValorMaxElemento.anchor = GridBagConstraints.WEST;
		gbc_lblValorMaxElemento.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorMaxElemento.gridx = 0;
		gbc_lblValorMaxElemento.gridy = 8;
		panelAjustes.add(lblValorMaxElemento, gbc_lblValorMaxElemento);

		final JFormattedTextField fTextFld_Capacidad = new JFormattedTextField();
		GridBagConstraints gbc_longCad1 = new GridBagConstraints();
		gbc_longCad1.fill = GridBagConstraints.BOTH;
		gbc_longCad1.insets = new Insets(0, 0, 5, 0);
		gbc_longCad1.gridx = 1;
		gbc_longCad1.gridy = 2;
		panelAjustes.add(fTextFld_Capacidad, gbc_longCad1);

		JLabel lblNumelementos = new JLabel("Num.Elementos");
		GridBagConstraints gbc_lblNumelementos = new GridBagConstraints();
		gbc_lblNumelementos.anchor = GridBagConstraints.WEST;
		gbc_lblNumelementos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumelementos.gridx = 0;
		gbc_lblNumelementos.gridy = 4;
		panelAjustes.add(lblNumelementos, gbc_lblNumelementos);

		// ** Añadir panel Vista
		panelVista = new JPanel();
		panelVista.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to
		final JTextPane textPaneResult = new JTextPane();
		textPaneResult.setEditable(true);
		textPaneResult.setEnabled(false);
		textPaneResult.setContentType("text/html");
		textPaneResult.setEditorKit(utiles.Utiles.getEstilo());

		JScrollPane scrollLista = new JScrollPane(textPaneResult);
		scrollLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLista.setBounds(243, 75, 331, 227);
		panelVista.setLayout(new BorderLayout());
		panelVista.add(scrollLista, BorderLayout.CENTER);

		// ** Añadir Panel Botones
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
		panelBotones.add(btnLimpiar);

		JButton btn_Generar = new JButton("Generar");
		btn_Generar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int capacidad = Integer.parseInt(fTextFld_Capacidad.getText());
					int numValores = Integer.parseInt(textF_numElementos.getText());
					int numProblemas = (int) spNumProb.getValue();
					for (int i = 0; i < numProblemas; i++) {
						mochila = new Knapsack(capacidad, numValores);
						mochila.execute();
						mochila.setTipoPregunta((int) spTipProblem.getValue());
						Problema.problemasGenerados.add(mochila);
						utiles.Utiles.añadirMochilaPanel(textPaneResult, mochila, ruta);
					}
					utiles.Utiles.cargarTextPane(textPaneResult, ruta);
					textPaneResult.update(textPaneResult.getGraphics());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(new JFrame(), "Faltan datos por introducir", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelBotones.add(btn_Generar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		panelBotones.add(btnCancelar);

		// panelBotones.add(btnExportar);
		cp.setLayout(new BorderLayout());
		cp.add(panelTitulo, BorderLayout.NORTH);
		cp.add(panelAjustes, BorderLayout.WEST);

		
		cp.add(panelVista, BorderLayout.CENTER);
		cp.add(panelBotones, BorderLayout.SOUTH);
		pack();
	}

}