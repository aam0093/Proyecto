package gui;

import java.awt.*;
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

import problemas.Problema;
import problemas.TSP;

/**
 * Esta clase define la interfaz con la que se generaran los problemas de tipo TSP
 * @author: Asier Alonso Morante
 * @version: 20/01/2016/A
 */
public class TspFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// butimport javax.swing.border.*;tons
	private JPanel panelTitulo;
	private JPanel panelAjustes;
	private JPanel panelVista;
	private JPanel panelBotones;
	TSP viajero;
	String ruta = utiles.Utiles.getRuta();

	// constructor
	public TspFrame() {
		setTitle("Problema del Viajero");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// content pane
		Container cp = getContentPane();
		cp.setPreferredSize(new Dimension(600, 400));
		cp.setBounds(new Rectangle(120, 120));
		// add a panel for the size
		panelTitulo = new JPanel();
		panelTitulo.setBorder(new EmptyBorder(5, 5, 5, 5));// adds margin to
															// panel
		FlowLayout fl_panelTitulo = new FlowLayout();
		fl_panelTitulo.setAlignment(FlowLayout.LEFT);
		panelTitulo.setLayout(fl_panelTitulo);
		JLabel lblNewLabel = new JLabel("Problema del Viajero");
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
		spNumProb.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spNumProb.setSize(new Dimension(5, 5));
		GridBagConstraints gbc_spNumProb = new GridBagConstraints();
		gbc_spNumProb.insets = new Insets(0, 0, 5, 0);
		gbc_spNumProb.gridx = 1;
		gbc_spNumProb.gridy = 1;
		panelAjustes.add(spNumProb, gbc_spNumProb);

		JLabel lblNumNodos = new JLabel("Numero de Nodos:");
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

		JLabel lblTipoProblema = new JLabel("Tipo de Problema: ");
		GridBagConstraints gbc_lblTipoProblema = new GridBagConstraints();
		gbc_lblTipoProblema.fill = GridBagConstraints.BOTH;
		gbc_lblTipoProblema.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoProblema.gridx = 0;
		gbc_lblTipoProblema.gridy = 5;
		panelAjustes.add(lblTipoProblema, gbc_lblTipoProblema);

		final JSpinner spTipProblem = new JSpinner(m_numberSpinnerModel);
		spTipProblem.setPreferredSize(new Dimension(40, 20));
		GridBagConstraints gbc_spTipProblem = new GridBagConstraints();
		gbc_spTipProblem.insets = new Insets(0, 0, 5, 0);
		gbc_spTipProblem.gridx = 1;
		gbc_spTipProblem.gridy = 5;
		panelAjustes.add(spTipProblem, gbc_spTipProblem);

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
					ExportarFrame recuperarFrame = new ExportarFrame(new TSP(1), 1);
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
						viajero = new TSP(cad1);
						viajero.execute();
						viajero.setTipoPregunta((int) spTipProblem.getValue());
						Problema.problemasGenerados.add(viajero);
						utiles.Utiles.añadirViajantePanel(textPaneResult, viajero, ruta);

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
		cp.add(panelBotones, BorderLayout.SOUTH);
		pack();
	}

}