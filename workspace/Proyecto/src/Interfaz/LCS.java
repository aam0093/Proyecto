package Interfaz;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class LCS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LCS frame = new LCS();
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
	public LCS() {
		final ExportFrame exportWindow= new ExportFrame("LCS");
		setTitle("LCS");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Subsecuencia Común");
		lblNewLabel.setBounds(35, 21, 371, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		getContentPane().add(lblNewLabel);
		
		JLabel lbl_NumProb = new JLabel("N\u00FAmero de Problemas: ");
		lbl_NumProb.setBounds(35, 92, 119, 14);
		getContentPane().add(lbl_NumProb);
		
		JLabel lblNewLabel_1 = new JLabel("Longitud Maxima de Cadenas");
		lblNewLabel_1.setBounds(35, 134, 145, 14);
		getContentPane().add(lblNewLabel_1);
		
		JSpinner spNumProb = new JSpinner();
		spNumProb.setBounds(162, 89, 29, 20);
		getContentPane().add(spNumProb);
				
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(217, 215, 89, 23);
		getContentPane().add(btnCancelar);
		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exportWindow.setVisible(true);
				dispose();
			}
		});
		btnExportar.setBounds(316, 215, 89, 24);
		getContentPane().add(btnExportar);
		
		textField = new JTextField();
		textField.setToolTipText("Valor que establece el tama\u00F1o de las cadenas,si es nulo ser\u00E1 aleatorio.");
		textField.setBounds(200, 131, 29, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
	}
	
}