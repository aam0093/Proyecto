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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
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

import problemas.Floyd;
import problemas.Problema;

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
		FlowLayout flPanelTitulo = new FlowLayout();
		flPanelTitulo.setAlignment(FlowLayout.LEFT);
		panelTitulo.setLayout(flPanelTitulo);
		JLabel lblNewLabel = new JLabel("Algoritmo de Floyd");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelTitulo.add(lblNewLabel);

		// añadir panel con parametros
		panelAjustes = new JPanel();
		panelAjustes.setBorder(new EmptyBorder(5, 5, 5, 5));


		GridBagLayout gblPanelAjustes = new GridBagLayout();
		gblPanelAjustes.columnWidths = new int[] { 115, 85 };
		gblPanelAjustes.rowHeights = new int[] { 20, 50, 20, 50, 20, 50 };
		panelAjustes.setLayout(gblPanelAjustes);

		JLabel lblNumProblemas = new JLabel("N\u00FAmero de Problemas:");
		lblNumProblemas.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbcLblNumProblemas = new GridBagConstraints();
		// gbc_lblNumProblemas.fill = GridBagConstraints.BOTH;
		gbcLblNumProblemas.insets = new Insets(0, 0, 5, 5);
		gbcLblNumProblemas.gridx = 0;
		gbcLblNumProblemas.gridy = 1;
		panelAjustes.add(lblNumProblemas, gbcLblNumProblemas);

		final JSpinner spNumProb = new JSpinner();
		spNumProb.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spNumProb.setSize(new Dimension(5, 5));
		GridBagConstraints gbcSpNumProb = new GridBagConstraints();
		gbcSpNumProb.insets = new Insets(0, 0, 5, 0);
		gbcSpNumProb.gridx = 1;
		gbcSpNumProb.gridy = 1;
		panelAjustes.add(spNumProb, gbcSpNumProb);

		JLabel lblNumNodos = new JLabel("N\u00FAmero de V\u00E9rtices: ");
		GridBagConstraints gbcLblLongCad1 = new GridBagConstraints();
		gbcLblLongCad1.fill = GridBagConstraints.BOTH;
		gbcLblLongCad1.insets = new Insets(0, 0, 5, 5);
		gbcLblLongCad1.gridx = 0;
		gbcLblLongCad1.gridy = 3;
		panelAjustes.add(lblNumNodos, gbcLblLongCad1);

		final JSpinner numNodos = new JSpinner();
		numNodos.setModel(new SpinnerNumberModel(new Integer(6), new Integer(2), null, new Integer(1)));
		numNodos.setMaximumSize(new Dimension(40, 20));
		GridBagConstraints gbcLongCad1 = new GridBagConstraints();
		gbcLongCad1.insets = new Insets(0, 0, 5, 0);
		gbcLongCad1.gridx = 1;
		gbcLongCad1.gridy = 3;
		panelAjustes.add(numNodos, gbcLongCad1);

		JLabel lblTipoProblema = new JLabel("Porcentaje Respuestas");
		lblTipoProblema.setToolTipText("N\u00FAmero de inc\u00F3gnitas resueltas de la pregunta, 100 = matriz resuelta y 0 = matriz vac\u00EDa");
		GridBagConstraints gbcLblTipoProblema = new GridBagConstraints();
		gbcLblTipoProblema.fill = GridBagConstraints.BOTH;
		gbcLblTipoProblema.insets = new Insets(0, 0, 0, 5);
		gbcLblTipoProblema.gridx = 0;
		gbcLblTipoProblema.gridy = 5;
		panelAjustes.add(lblTipoProblema, gbcLblTipoProblema);
		
		final JSlider slider = new JSlider();
		GridBagConstraints gbcSlider = new GridBagConstraints();
		gbcSlider.gridx = 1;
		gbcSlider.gridy = 5;
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(25);
		slider.setPaintTicks(true);
		panelAjustes.add(slider, gbcSlider);

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
		
		if (!Problema.PROBGENERADOS.isEmpty()) {
			utiles.Utiles.cargarTextPane(textPaneResult, ruta);
		}

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
					textPaneResult.update(textPaneResult.getGraphics());

					int cad1 = (int) numNodos.getValue();
					int numProblemas = (int) spNumProb.getValue();
					for (int i = 0; i < numProblemas; i++) {
						
						floyd = new Floyd(cad1);
						floyd.execute();
						floyd.setPorcentaje((int) slider.getValue());
						Problema.PROBGENERADOS.add(floyd);
						utiles.Utiles.añadirFloydPanel(textPaneResult, floyd, ruta);

					}
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
		    public void windowClosing(WindowEvent windowEvent) {
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