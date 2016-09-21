package gui;

import java.awt.BorderLayout;
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

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import problemas.Knapsack;
import problemas.Problema;


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
	
	private JPanel panelTitulo;
	private JPanel panelAjustes;
	private JPanel panelVista;
	private JPanel panelBotones;
	Knapsack subsecuencia;
	String ruta = utiles.Utiles.getRuta();
	Knapsack mochila;
	private JTextPane textPaneResult;
	private JScrollPane scrollLista;

	// constructor
	public KnapsackFrame() {
		setTitle("Problema de la Mochila");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(120,120,900,500);

		// content pane
		Container cp = getContentPane();
		cp.setPreferredSize(new Dimension(700, 450));
		cp.setBounds(new Rectangle(120, 120));
		cp.setLayout(new BorderLayout());

		// ** Panel Título **
		panelTitulo = new JPanel();
		panelTitulo.setBorder(new EmptyBorder(5, 5, 5, 5));

		FlowLayout flPanelTitulo = new FlowLayout();
		flPanelTitulo.setAlignment(FlowLayout.LEFT);
		panelTitulo.setLayout(flPanelTitulo);
		JLabel lblNewLabel = new JLabel("Problema de la Mochila");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		panelTitulo.add(lblNewLabel);

		cp.add(panelTitulo, BorderLayout.NORTH);

		// ** Añadir panel Ajustes
		panelAjustes = new JPanel();
		panelAjustes.setBorder(new EmptyBorder(5, 15, 5, 5));

		GridBagLayout gblPanelAjustes = new GridBagLayout();
		gblPanelAjustes.columnWidths = new int[] { 115, 0, 85 };
		gblPanelAjustes.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gblPanelAjustes.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gblPanelAjustes.rowHeights = new int[] { 30, 0, 30, 0, 25, 0, 25, 0, 0, 24, 25 };
		panelAjustes.setLayout(gblPanelAjustes);
								
										JLabel lblNumProblemas = new JLabel("N\u00FAmero de Problemas: ");
										GridBagConstraints gbcLblNumProblemas = new GridBagConstraints();
										gbcLblNumProblemas.anchor = GridBagConstraints.WEST;
										gbcLblNumProblemas.insets = new Insets(0, 0, 5, 5);
										gbcLblNumProblemas.gridx = 0;
										gbcLblNumProblemas.gridy = 3;
										panelAjustes.add(lblNumProblemas, gbcLblNumProblemas);
						
								final JSpinner spNumProb = new JSpinner();
								spNumProb.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
								spNumProb.setSize(new Dimension(5, 5));
								GridBagConstraints gbcSpNumProb = new GridBagConstraints();
								gbcSpNumProb.anchor = GridBagConstraints.WEST;
								gbcSpNumProb.insets = new Insets(0, 0, 5, 0);
								gbcSpNumProb.gridx = 2;
								gbcSpNumProb.gridy = 3;
								panelAjustes.add(spNumProb, gbcSpNumProb);
								spNumProb.setSize(new Dimension(5, 5));
								gbcSpNumProb.insets = new Insets(0, 0, 5, 0);
								gbcSpNumProb.gridx = 1;
								gbcSpNumProb.gridy = 0;
				
						JLabel lblCapacidad = new JLabel("Capacidad: ");
						GridBagConstraints gbcLblCapacidad = new GridBagConstraints();
						gbcLblCapacidad.anchor = GridBagConstraints.WEST;
						gbcLblCapacidad.insets = new Insets(0, 0, 5, 5);
						gbcLblCapacidad.gridx = 0;
						gbcLblCapacidad.gridy = 5;
						panelAjustes.add(lblCapacidad, gbcLblCapacidad);
		
				final JFormattedTextField fTextFld_Capacidad = new JFormattedTextField();
				fTextFld_Capacidad.setColumns(10);
				fTextFld_Capacidad.setText("15");
				GridBagConstraints gbcLongCad1 = new GridBagConstraints();
				gbcLongCad1.fill = GridBagConstraints.BOTH;
				gbcLongCad1.insets = new Insets(0, 0, 5, 0);
				gbcLongCad1.gridx = 2;
				gbcLongCad1.gridy = 5;
				panelAjustes.add(fTextFld_Capacidad, gbcLongCad1);
				
						JLabel lblNumelementos = new JLabel("N\u00FAmero de Elementos");
						GridBagConstraints gbcLblNumelementos = new GridBagConstraints();
						gbcLblNumelementos.fill = GridBagConstraints.HORIZONTAL;
						gbcLblNumelementos.insets = new Insets(0, 0, 5, 5);
						gbcLblNumelementos.gridx = 0;
						gbcLblNumelementos.gridy = 7;
						panelAjustes.add(lblNumelementos, gbcLblNumelementos);
		
				final JFormattedTextField textF_numElementos = new JFormattedTextField();
				textF_numElementos.setMaximumSize(new Dimension(40, 20));
				textF_numElementos.setText("4");
				GridBagConstraints gbcNumElementos = new GridBagConstraints();
				gbcNumElementos.fill = GridBagConstraints.HORIZONTAL;
				gbcNumElementos.insets = new Insets(0, 0, 5, 0);
				gbcNumElementos.gridx = 2;
				gbcNumElementos.gridy = 7;
				panelAjustes.add(textF_numElementos, gbcNumElementos);

		JLabel lblPctRespuestas = new JLabel("Porcentaje de Respuestas");
		lblPctRespuestas.setToolTipText(
				"N\u00FAmero de inc\u00F3gnitas resueltas de la pregunta, 100 = matriz resuelta y 0 = matriz vac\u00EDa");
		GridBagConstraints gbcLblPctRespuestas = new GridBagConstraints();
		gbcLblPctRespuestas.anchor = GridBagConstraints.EAST;
		gbcLblPctRespuestas.insets = new Insets(0, 0, 0, 5);
		gbcLblPctRespuestas.gridx = 0;
		gbcLblPctRespuestas.gridy = 10;
		panelAjustes.add(lblPctRespuestas, gbcLblPctRespuestas);

		final JSlider sldrPctRespuestas = new JSlider();
		sldrPctRespuestas.setToolTipText("");
	
		sldrPctRespuestas.setPaintTicks(true);
		sldrPctRespuestas.setPaintLabels(true);
		sldrPctRespuestas.setSnapToTicks(true);
		GridBagConstraints gbcSldrPctRespuestas = new GridBagConstraints();
		gbcSldrPctRespuestas.gridx = 2;
		gbcSldrPctRespuestas.gridy = 10;
		sldrPctRespuestas.setPaintLabels(true);
		sldrPctRespuestas.setMinorTickSpacing(1);
		sldrPctRespuestas.setMajorTickSpacing(25);
		sldrPctRespuestas.setPaintTicks(true);
		panelAjustes.add(sldrPctRespuestas, gbcSldrPctRespuestas);

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

		if (!Problema.PROBGENERADOS.isEmpty()) {
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
					int capacidad = Integer.parseInt(fTextFld_Capacidad.getText());
					int numValores = Integer.parseInt(textF_numElementos.getText());
					int numProblemas = (int) spNumProb.getValue();

					for (int i = 0; i < numProblemas; i++) {
						
						mochila = new Knapsack(capacidad, numValores);
						mochila.execute();
						mochila.setPorcentaje((int) sldrPctRespuestas.getValue());
						Problema.PROBGENERADOS.add(mochila);
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

		// panelBotones.add(btnExportar);
		cp.setLayout(new BorderLayout());
		cp.add(panelTitulo, BorderLayout.NORTH);
		cp.add(panelAjustes, BorderLayout.WEST);
		cp.add(panelVista, BorderLayout.CENTER);
		cp.add(panelBotones, BorderLayout.SOUTH);
		pack();
	}

}