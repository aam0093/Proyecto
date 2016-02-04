package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

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
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;

import problemas.Knapsack;
import problemas.Problema;
import javax.swing.JToolBar;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * Esta clase define la interfaz con la que se generaran los problemas del tipo
 * Mochila
 * 
 * @author: Asier Alonso Morante
 * @version: 20/01/2016/A
 */
public class KnapsackFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// butimport javax.swing.border.*;tons
	private JPanel panelTitulo;
	private JPanel panelAjustes;
	private JPanel panelVista;
	private JPanel panelBotones;
	Knapsack subsecuencia;
	String ruta = utiles.Utiles.getRuta();
	Knapsack mochila;
	JTextField tf_PesoMax;
	private JTextField tf_ValorMax;
	private JTextPane textPaneResult;
	private JScrollPane scrollLista;

	// constructor
	public KnapsackFrame() {
		setTitle("Problema de la Mochila");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(120, 120, 700, 500);

		// content pane
		Container cp = getContentPane();
		cp.setPreferredSize(new Dimension(600, 400));
		cp.setBounds(new Rectangle(120, 120));
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

		GridBagLayout gbl_panelAjustes = new GridBagLayout();
		gbl_panelAjustes.columnWidths = new int[] { 115, 85 };
		gbl_panelAjustes.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panelAjustes.columnWeights = new double[] { 0.0, 0.0 };
		gbl_panelAjustes.rowHeights = new int[] { 30, 0, 30, 0, 25, 0, 25, 0, 0, 24, 25 };
		panelAjustes.setLayout(gbl_panelAjustes);

		JLabel lblNumProblemas = new JLabel("Numero de Problemas: ");
		GridBagConstraints gbc_lblNumProblemas = new GridBagConstraints();
		gbc_lblNumProblemas.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumProblemas.gridx = 0;
		gbc_lblNumProblemas.gridy = 0;
		panelAjustes.add(lblNumProblemas, gbc_lblNumProblemas);

		final JSpinner spNumProb = new JSpinner();
		spNumProb.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		spNumProb.setSize(new Dimension(5, 5));
		GridBagConstraints gbc_spNumProb = new GridBagConstraints();
		gbc_spNumProb.anchor = GridBagConstraints.WEST;
		gbc_spNumProb.insets = new Insets(0, 0, 5, 0);
		gbc_spNumProb.gridx = 1;
		gbc_spNumProb.gridy = 0;
		panelAjustes.add(spNumProb, gbc_spNumProb);
		spNumProb.setSize(new Dimension(5, 5));
		gbc_spNumProb.insets = new Insets(0, 0, 5, 0);
		gbc_spNumProb.gridx = 1;
		gbc_spNumProb.gridy = 0;

		JLabel lblCapacidad = new JLabel("Capacidad: ");
		GridBagConstraints gbc_lblCapacidad = new GridBagConstraints();
		gbc_lblCapacidad.anchor = GridBagConstraints.WEST;
		gbc_lblCapacidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCapacidad.gridx = 0;
		gbc_lblCapacidad.gridy = 2;
		panelAjustes.add(lblCapacidad, gbc_lblCapacidad);

		final JFormattedTextField fTextFld_Capacidad = new JFormattedTextField();
		fTextFld_Capacidad.setColumns(10);
		fTextFld_Capacidad.setText("10");
		GridBagConstraints gbc_longCad1 = new GridBagConstraints();
		gbc_longCad1.fill = GridBagConstraints.BOTH;
		gbc_longCad1.insets = new Insets(0, 0, 5, 0);
		gbc_longCad1.gridx = 1;
		gbc_longCad1.gridy = 2;
		panelAjustes.add(fTextFld_Capacidad, gbc_longCad1);

		JLabel lblNumelementos = new JLabel("Num.Elementos");
		GridBagConstraints gbc_lblNumelementos = new GridBagConstraints();
		gbc_lblNumelementos.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNumelementos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumelementos.gridx = 0;
		gbc_lblNumelementos.gridy = 4;
		panelAjustes.add(lblNumelementos, gbc_lblNumelementos);

		final JFormattedTextField textF_numElementos = new JFormattedTextField();
		textF_numElementos.setMaximumSize(new Dimension(40, 20));
		textF_numElementos.setText("4");
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

		tf_PesoMax = new JTextField();
		tf_PesoMax.setColumns(10);
		tf_PesoMax.setText("6");
		GridBagConstraints gbc_tf_PesoMax = new GridBagConstraints();
		gbc_tf_PesoMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_PesoMax.insets = new Insets(0, 0, 5, 0);
		gbc_tf_PesoMax.gridx = 1;
		gbc_tf_PesoMax.gridy = 6;
		panelAjustes.add(tf_PesoMax, gbc_tf_PesoMax);

		JLabel lblvalorMax = new JLabel("Valor Max / Elem");
		GridBagConstraints gbc_lblvalorMax = new GridBagConstraints();
		gbc_lblvalorMax.anchor = GridBagConstraints.WEST;
		gbc_lblvalorMax.insets = new Insets(0, 0, 5, 5);
		gbc_lblvalorMax.gridx = 0;
		gbc_lblvalorMax.gridy = 8;
		panelAjustes.add(lblvalorMax, gbc_lblvalorMax);

		tf_ValorMax = new JTextField();
		tf_ValorMax.setText("6");
		GridBagConstraints gbc_tf_ValorMax = new GridBagConstraints();
		gbc_tf_ValorMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ValorMax.anchor = GridBagConstraints.NORTH;
		gbc_tf_ValorMax.insets = new Insets(0, 0, 5, 0);
		gbc_tf_ValorMax.gridx = 1;
		gbc_tf_ValorMax.gridy = 8;
		panelAjustes.add(tf_ValorMax, gbc_tf_ValorMax);
		tf_ValorMax.setColumns(10);

		JLabel lblPctRespuestas = new JLabel("PCT. Respuestas");
		lblPctRespuestas.setToolTipText(
				"N\u00FAmero de inc\u00F3gnitas a resolver en la pregunta, 100 = matriz vac\u00EDa y 0 = matriz llena");
		GridBagConstraints gbc_lblPctRespuestas = new GridBagConstraints();
		gbc_lblPctRespuestas.anchor = GridBagConstraints.WEST;
		gbc_lblPctRespuestas.insets = new Insets(0, 0, 0, 5);
		gbc_lblPctRespuestas.gridx = 0;
		gbc_lblPctRespuestas.gridy = 10;
		panelAjustes.add(lblPctRespuestas, gbc_lblPctRespuestas);

		final JSlider sldrPctRespuestas = new JSlider();
		sldrPctRespuestas.setToolTipText("");
	
		sldrPctRespuestas.setPaintTicks(true);
		sldrPctRespuestas.setPaintLabels(true);
		sldrPctRespuestas.setSnapToTicks(true);
		GridBagConstraints gbc_sldrPctRespuestas = new GridBagConstraints();
		gbc_sldrPctRespuestas.gridx = 1;
		gbc_sldrPctRespuestas.gridy = 10;
		sldrPctRespuestas.setPaintLabels(true);
		sldrPctRespuestas.setMinorTickSpacing(1);
		sldrPctRespuestas.setMajorTickSpacing(25);
		sldrPctRespuestas.setPaintTicks(true);
		panelAjustes.add(sldrPctRespuestas, gbc_sldrPctRespuestas);

		// ** Añadir panel Vista
		panelVista = new JPanel();
		panelVista.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to
		textPaneResult = new JTextPane();
		textPaneResult.setEditable(false);
		textPaneResult.setContentType("text/html");
		textPaneResult.setEditorKit(utiles.Utiles.getEstilo());

		scrollLista = new JScrollPane(textPaneResult);
		scrollLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLista.setBounds(243, 75, 331, 227);
		panelVista.setLayout(new BorderLayout());

		JLabel lblVistaPreeliminar = new JLabel("Vista Preeliminar");
		panelVista.add(lblVistaPreeliminar, BorderLayout.NORTH);
		panelVista.add(scrollLista, BorderLayout.CENTER);

		if (!Problema.problemasGenerados.isEmpty()) {
			utiles.Utiles.cargarTextPane(textPaneResult, ruta);
		}

		// ** Añadir Panel Botones
		panelBotones = new JPanel();
		panelBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					utiles.Utiles.borrarPanel(ruta);
					textPaneResult.setText("");
			}
		});
		panelBotones.add(btnLimpiar);

		final JButton btnExportar = new JButton("Exportar");
		btnExportar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btnExportar.isEnabled()) {
					ExportarFrame exportar = new ExportarFrame(mochila, 3);
					exportar.setVisible(true);
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
					int capacidad = Integer.parseInt(fTextFld_Capacidad.getText());
					int numValores = Integer.parseInt(textF_numElementos.getText());
					int numProblemas = (int) spNumProb.getValue();

					for (int i = 0; i < numProblemas; i++) {
						mochila = new Knapsack(capacidad, numValores);
						int valMax = Integer.parseInt(tf_ValorMax.getText());
						int pesMax = Integer.parseInt(tf_PesoMax.getText());
						if (valMax != 0)
							mochila.setMaxValue(valMax);
						if (pesMax != 0)
							mochila.setMaxWeigth(pesMax);
						mochila.execute();
						mochila.setPorcentaje((int) sldrPctRespuestas.getValue());
						Problema.problemasGenerados.add(mochila);
						utiles.Utiles.añadirMochilaPanel(textPaneResult, mochila, ruta);
					}
//					Document doc = textPaneResult.getDocument();
//					doc.putProperty(Document.StreamDescriptionProperty, null);
					utiles.Utiles.cargarTextPane(textPaneResult, ruta);

					scrollLista.setViewportView(textPaneResult);
					scrollLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

					if (!btnExportar.isEnabled()) {
						btnExportar.setEnabled(true);
					}
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

		panelBotones.add(btnExportar);
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