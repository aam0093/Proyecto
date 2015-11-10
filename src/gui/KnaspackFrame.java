package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class KnaspackFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtManual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KnaspackFrame frame = new KnaspackFrame();
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
	public KnaspackFrame() {
		final ExportFrame exportWindow= new ExportFrame("Knaspack Problem");
		setTitle("Mochila");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Problema de La Mochila");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel.setBounds(35, 21, 243, 24);
		getContentPane().add(lblNewLabel);
		
		JLabel lbl_NumProb = new JLabel("N\u00FAmero de Problemas: ");
		lbl_NumProb.setBounds(10, 92, 119, 14);
		getContentPane().add(lbl_NumProb);
		
		JLabel lblNewLabel_1 = new JLabel("Num. Elementos Mochila");
		lblNewLabel_1.setBounds(217, 92, 119, 14);
		getContentPane().add(lblNewLabel_1);
		
		JSpinner spNumProb = new JSpinner();
		spNumProb.setBounds(126, 89, 29, 20);
		getContentPane().add(spNumProb);
		
		JLabel lblPeso = new JLabel("Peso Maximo/Elemento");
		lblPeso.setBounds(10, 136, 119, 14);
		getContentPane().add(lblPeso);
		
		txtManual = new JTextField();
		txtManual.setBounds(126, 133, 29, 20);
		getContentPane().add(txtManual);
		txtManual.setColumns(10);
				
		JButton btnCancelar = new JButton("Cancelar");
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(335, 89, 19, 20);
		getContentPane().add(formattedTextField);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	}
	
	}