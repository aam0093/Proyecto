package gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
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

import problemas.Floyd;
import problemas.Problema;
import javax.swing.JSlider;

/**
 * Esta clase define la interfaz con la que se generaran los problemas de tipo
 * TSP
 * 
 * @author: Asier Alonso Morante
 * @version: 20/01/2016/A
 */
public class FloydFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// butimport javax.swing.border.*;tons
	private JPanel panelTitulo;
	private JPanel panelAjustes;
	private JPanel panelVista;
	private JPanel panelBotones;
	Floyd floyd;
	String ruta = utiles.Utiles.getRuta();

	// constructor
	public FloydFrame() {
		setTitle("Algoritmo de Floyd");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(120,120,900,500);
		
		// content pane
		Container cp = getContentPane();
		cp.setPreferredSize(new Dimension(700, 450));
		// add a panel for the size
		panelTitulo = new JPanel();
		panelTitulo.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to
															// panel
		FlowLayout fl_panelTitulo = new FlowLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		panelTitulo.setLayout(fl_panelTitulo);
		JLabel lblNewLabel = new JLabel("Algoritmo de Floyd");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelTitulo.add(lblNewLabel);

		// añadir panel con parametros
		panelAjustes = new JPanel();
		panelAjustes.setBorder(new EmptyBorder(5, 5, 5, 5));


		GridBagLayout gbl_panelAjustes = new GridBagLayout();
		gbl_panelAjustes.columnWidths = new int[] { 115, 85 };
		gbl_panelAjustes.rowHeights = new int[] { 20, 50, 20, 50, 20, 50 };
		panelAjustes.setLayout(gbl_panelAjustes);

		JLabel lblNumProblemas = new JLabel("N\u00FAmero de Problemas:");
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

		JLabel lblNumNodos = new JLabel("N\u00FAmero de V\u00E9rtices: ");
		GridBagConstraints gbc_lblLongCad1 = new GridBagConstraints();
		gbc_lblLongCad1.fill = GridBagConstraints.BOTH;
		gbc_lblLongCad1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLongCad1.gridx = 0;
		gbc_lblLongCad1.gridy = 3;
		panelAjustes.add(lblNumNodos, gbc_lblLongCad1);

		final JSpinner numNodos = new JSpinner();
		numNodos.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(1)));
		numNodos.setMaximumSize(new Dimension(40, 20));
		GridBagConstraints gbc_longCad1 = new GridBagConstraints();
		gbc_longCad1.insets = new Insets(0, 0, 5, 0);
		gbc_longCad1.gridx = 1;
		gbc_longCad1.gridy = 3;
		panelAjustes.add(numNodos, gbc_longCad1);

		JLabel lblTipoProblema = new JLabel("Porcentaje Respuestas");
		lblTipoProblema.setToolTipText("N\u00FAmero de inc\u00F3gnitas a resolver en la pregunta, 100 = matriz vac\u00EDa y 0 = matriz llena");
		GridBagConstraints gbc_lblTipoProblema = new GridBagConstraints();
		gbc_lblTipoProblema.fill = GridBagConstraints.BOTH;
		gbc_lblTipoProblema.insets = new Insets(0, 0, 0, 5);
		gbc_lblTipoProblema.gridx = 0;
		gbc_lblTipoProblema.gridy = 5;
		panelAjustes.add(lblTipoProblema, gbc_lblTipoProblema);
		
		final JSlider slider = new JSlider();
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 5;
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(25);
		slider.setPaintTicks(true);
		panelAjustes.add(slider, gbc_slider);

		// ** Añadir panel Vista **
		panelVista = new JPanel();
		panelVista.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to

		final JTextPane textPaneResult = new JTextPane();
		textPaneResult.setEditable(false);
		textPaneResult.setContentType("text/html");
		textPaneResult.setEditorKit(utiles.Utiles.getEstilo());

		JScrollPane scrollLista = new JScrollPane(textPaneResult);
		scrollLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLista.setBounds(243, 75, 331, 227);
		panelVista.setLayout(new BorderLayout());
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
					ExportarFrame recuperarFrame = new ExportarFrame(new Floyd(1), 1);
					recuperarFrame.setVisible(true);
					
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
					textPaneResult.update(textPaneResult.getGraphics());

					int cad1 = (int) numNodos.getValue();
					int numProblemas = (int) spNumProb.getValue();
					for (int i = 0; i < numProblemas; i++) {
						floyd = new Floyd(cad1);
						floyd.execute();
						floyd.setPorcentaje((int) slider.getValue());
						Problema.problemasGenerados.add(floyd);
						utiles.Utiles.añadirFloydPanel(textPaneResult, floyd, ruta);

					}
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

		cp.setLayout(new BorderLayout());
		cp.add(panelTitulo, BorderLayout.NORTH);
		cp.add(panelAjustes, BorderLayout.WEST);
		cp.add(panelVista, BorderLayout.CENTER);
		
		JLabel lblVistaPreliminar = new JLabel("Vista Preliminar");
		panelVista.add(lblVistaPreliminar, BorderLayout.NORTH);
		cp.add(panelBotones, BorderLayout.SOUTH);
		pack();
		
		
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	if (JOptionPane.showConfirmDialog(null, "¿Desea Salir?", "Salir",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					utiles.Utiles.borrarPanel(ruta);
					utiles.Utiles.borrarPanel(utiles.Utiles.getRutaRecuperado());
					dispose();
				} 			
		    }
		});
	
	}

}