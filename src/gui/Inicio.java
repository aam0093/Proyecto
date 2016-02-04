package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import problemas.Knapsack;
import problemas.Problema;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.Box;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.SystemColor;
import java.awt.Label;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.TextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JPasswordField;

public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String sistemaOperativo = null;
	String ruta = utiles.Utiles.getRuta();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if (sistemaOperativo == null) {
			utiles.Utiles.setSistemaOperativo(System.getProperty("os.name"));
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setTitle("ProgDin Quiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setToolTipText("Mochila");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				KnapsackFrame mochila = new KnapsackFrame();
				mochila.setVisible(true);
			}
		});
		contentPane.setLayout(new GridLayout(0, 4, 20, 20));
		btnNewButton.setIcon(new ImageIcon(Inicio.class.getResource("/images/mochila-002 (1).jpg")));
		btnNewButton.setBounds(44, 77, 175, 175);
		contentPane.add(btnNewButton);

		JButton btn_LCS = new JButton("");
		btn_LCS.setToolTipText("Subsecuencia Comun Mas Larga");
		btn_LCS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LCS subsecuencia = new LCS();
				subsecuencia.setVisible(true);
			}
		});
		btn_LCS.setIcon(new ImageIcon(Inicio.class.getResource("/images/subsecuencia.jpg")));
		btn_LCS.setBounds(44, 289, 175, 175);
		contentPane.add(btn_LCS);

		JButton btn_viajero = new JButton("");
		btn_viajero.setToolTipText("Floyd");
		btn_viajero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FloydFrame viajeroFrame = new FloydFrame();
				viajeroFrame.setVisible(true);
			}
		});

		JButton btn_RecuperarProblema = new JButton("Recuperar Problema");
		btn_RecuperarProblema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Knapsack proble = new Knapsack(3, 4);
				ExportarFrame recuperarFrame = new ExportarFrame(proble, 1);
				recuperarFrame.setVisible(true);
			}
		});
		btn_RecuperarProblema.setBounds(445, 77, 175, 175);
		contentPane.add(btn_RecuperarProblema);
		
		JButton btnAcercaDe = new JButton("");
		btnAcercaDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String acercaDe = " Alumno: Asier Alonso Morante \n\n e-mail: aam0093@alu.ubu.es\n ProgDinQuiz "
						+ "TFG 2016 \n Universidad de Burgos ";
						
				JOptionPane.showMessageDialog(new JFrame(), acercaDe , "Acerca De",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAcercaDe.setToolTipText("Acerca de ");
		btnAcercaDe.setIcon(new ImageIcon(Inicio.class.getResource("/images/escudo_COLOR_2L_ABAJO.png")));
		contentPane.add(btnAcercaDe);

		btn_viajero.setIcon(new ImageIcon(Inicio.class.getResource("/images/viajero.jpg")));
		btn_viajero.setBounds(250, 77, 175, 175);
		contentPane.add(btn_viajero);

		JButton btnMatrices = new JButton("");
		btnMatrices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MultiplicaMatricesFrame proble = new MultiplicaMatricesFrame();
				proble.setVisible(true);
			}
		});
		btnMatrices.setIcon(new ImageIcon(Inicio.class.getResource("/images/Icono-216.png")));
		btnMatrices.setToolTipText("Matrices Encadenadas");
		btnMatrices.setBounds(250, 289, 175, 175);
		contentPane.add(btnMatrices);

		JButton btn_Salir = new JButton("");
		btn_Salir.setToolTipText("Bot\u00F3n Salir");
		btn_Salir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				utiles.Utiles.borrarPanel(ruta);
				dispose();
			}

		});
		btn_Salir.setIcon(new ImageIcon(Inicio.class.getResource("/images/salida.gif")));
		btn_Salir.setBounds(445, 289, 175, 175);
		contentPane.add(btn_Salir);

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { contentPane, btnNewButton, btn_LCS,
				btn_RecuperarProblema, btn_viajero, btnMatrices, btn_Salir }));

	}
}
