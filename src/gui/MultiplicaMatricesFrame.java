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

public class MultiplicaMatricesFrame extends JFrame{

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

		// content pane
		Container cp = getContentPane();
		cp.setPreferredSize(new Dimension(600, 400));
		
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
		gbl_panelAjustes.rowHeights = new int[] {20,50,20,50,20,50};
		panelAjustes.setLayout(gbl_panelAjustes);
		
		JLabel lblNumProblemas = new JLabel("Numero de Problemas:");
		lblNumProblemas.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		GridBagConstraints gbc_lblNumProblemas = new GridBagConstraints();
	//	gbc_lblNumProblemas.fill = GridBagConstraints.BOTH;
		gbc_lblNumProblemas.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumProblemas.gridx = 0;
		gbc_lblNumProblemas.gridy = 1;
		panelAjustes.add(lblNumProblemas, gbc_lblNumProblemas);
		
		
		final JSpinner spNumProb = new JSpinner();
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
		textPaneResult.setEditable(true);
		textPaneResult.setEnabled(false);
		textPaneResult.setContentType("text/html");
		textPaneResult.setEditorKit(utiles.Utiles.getEstilo());

		utiles.Utiles.cargarTextPane(textPaneResult, "http://www.marca.com/");

		JScrollPane scrollLista = new JScrollPane(textPaneResult);
		scrollLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollLista.setBounds(243, 75, 331, 227);
		panelVista.setLayout(new BorderLayout());
		panelVista.add(scrollLista, BorderLayout.CENTER);

		//** Añadir panel Botones **
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
						matrices.setTipoPregunta((int) spTipProblem.getValue());
						Problema.problemasGenerados.add(matrices);
						utiles.Utiles.añadirMatricesPanel(textPaneResult, matrices, ruta);

					}
					utiles.Utiles.cargarTextPane(textPaneResult, ruta);
					textPaneResult.update(textPaneResult.getGraphics());

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
		panelBotones.add(btnCancelar);

		JButton btnExportar = new JButton("Exportar");
		btnExportar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExportarFrame recuperarFrame = new ExportarFrame(new MultiplicaMatrices(1), 1);
				recuperarFrame.setVisible(true);
			}
		});
		panelBotones.add(btnExportar);
		
		cp.setLayout(new BorderLayout());
		cp.add(panelTitulo, BorderLayout.NORTH);
		cp.add(panelAjustes, BorderLayout.WEST);
		cp.add(panelVista, BorderLayout.CENTER);
		cp.add(panelBotones, BorderLayout.SOUTH);
		pack();
	}

}

