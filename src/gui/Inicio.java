package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import problemas.Knapsack;

public class Inicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String sistemaOperativo = null;
	String ruta = utiles.Utiles.getRuta();
	JButton btnAyuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if (sistemaOperativo == null) {
			utiles.Utiles.setSistemaOperativo(System.getProperty("os.name"));
			
		}
		utiles.Utiles.setEstilo();
		
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
		btnNewButton.setIcon(new ImageIcon(Inicio.class.getResource("/images/MOCHILA (3).jpg")));
		btnNewButton.setBounds(44, 77, 175, 175);
		contentPane.add(btnNewButton);

		JButton btnLCS = new JButton("");
		btnLCS.setToolTipText("Subsecuencia Comun Mas Larga");
		btnLCS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LCS subsecuencia = new LCS();
				subsecuencia.setVisible(true);
			}
		});
		btnLCS.setIcon(new ImageIcon(Inicio.class.getResource("/images/subsec (1).jpg")));
		btnLCS.setBounds(44, 289, 175, 175);
		contentPane.add(btnLCS);

		JButton btnViajero = new JButton("");
		btnViajero.setToolTipText("Floyd");
		btnViajero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FloydFrame viajeroFrame = new FloydFrame();
				viajeroFrame.setVisible(true);
			}
		});

		JButton btnRecuperarProblema = new JButton("");
		btnRecuperarProblema.setToolTipText("Recuperar Problema");
		btnRecuperarProblema.setIcon(new ImageIcon(Inicio.class.getResource("/images/pesca-pescador_318-54093.jpg")));
		btnRecuperarProblema.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Knapsack proble = new Knapsack(3, 4);
				ExportarFrame recuperarFrame = new ExportarFrame(proble, 1);
				recuperarFrame.setVisible(true);
			}
		});
		btnRecuperarProblema.setBounds(445, 77, 175, 175);
		contentPane.add(btnRecuperarProblema);
		
		 btnAyuda = new JButton("");
		 btnAyuda.setToolTipText("Ayuda");
		 btnAyuda.setIcon(new ImageIcon(Inicio.class.getResource("/images/ayudaFin (4).jpg")));
		 init();
		 btnAyuda.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				//	init();
				}
			});
		 contentPane.add(btnAyuda);

		btnViajero.setIcon(new ImageIcon(Inicio.class.getResource("/images/viajero.jpg")));
		btnViajero.setBounds(250, 77, 175, 175);
		contentPane.add(btnViajero);

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
		
				JButton btnAcercaDe = new JButton("");
				btnAcercaDe.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						String acercaDe = " Alumno: Asier Alonso Morante \n\n e-mail: aam0093@alu.ubu.es\n ProgDinQuiz "
								+ "TFG 2016 \n Universidad de Burgos ";
						JOptionPane.showMessageDialog(new JFrame(), acercaDe, "Acerca De", JOptionPane.INFORMATION_MESSAGE);
					}
				});	
				btnAcercaDe.setToolTipText("Acerca de ");
				btnAcercaDe.setIcon(new ImageIcon(Inicio.class.getResource("/images/escudo_COLOR_2L_ABAJO.png")));
				contentPane.add(btnAcercaDe);
		
				JButton btnSalir = new JButton("");
				btnSalir.setToolTipText("Bot\u00F3n Salir");
				btnSalir.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						utiles.Utiles.borrarPanel(ruta);
						System.exit(0);
					}

				});
				btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/images/44516590-Icono-Salir-Foto-de-archivo (3).jpg")));
				btnSalir.setBounds(445, 289, 175, 175);
				contentPane.add(btnSalir);

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { contentPane, btnNewButton, btnLCS,
				btnRecuperarProblema, btnViajero, btnMatrices, btnSalir }));
	}




	private void init() {
		// Carga el fichero de ayuda
		File fichero = new File("./help/help_set.hs");
		try {
			URL hsURL = fichero.toURI().toURL();
			//Obtenemos el class Loader
			ClassLoader classLoader = getClass().getClassLoader();
			// Crea el HelpSet y el HelpBroker
						HelpSet helpset = new HelpSet(classLoader, classLoader.getResource("help/help_set.hs"));
						HelpBroker hb = helpset.createHelpBroker();
						
			//añadimos la ayuda a los botones
			//Al pulsar sobre el boton del menu ayuda se muestra la ayuda
						hb.enableHelpOnButton(btnAyuda, "aplicacion", helpset);
		
			//Al presionar F1 sobre la ventana se muestra la ayuda
						hb.enableHelpKey(this.getContentPane(), "aplicacion", helpset);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
}
