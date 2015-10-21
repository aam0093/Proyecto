package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class ExportFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ButtonGroup expType = new ButtonGroup();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExportFrame frame = new ExportFrame("Default");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}     */

	/**
	 * Create the frame.
	 */
	public ExportFrame(String tittle) {
		setResizable(false);
		setTitle("Exportar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBrowse = new JButton("Browse..");
		btnBrowse.setBounds(276, 135, 75, 23);
		btnBrowse.setBackground(Color.WHITE);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 94, 1, 2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(5, 88, 0, 2);
		
		textField = new JTextField();
		textField.setBounds(82, 105, 184, 20);
		textField.setColumns(10);
		
		JLabel lb_fileName = new JLabel("Nombre:");
		lb_fileName.setBounds(31, 108, 41, 14);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(97, 136, 1, 2);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(339, 258, 71, 23);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(238, 258, 75, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JLabel lblNombreDeProblema = new JLabel("Exportar " + tittle);
		lblNombreDeProblema.setBounds(15, 61, 381, 25);
		lblNombreDeProblema.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JRadioButton rb_Moodle = new JRadioButton("Moodle");
		rb_Moodle.setBounds(160, 190, 68, 23);
		
		JRadioButton rb_XML = new JRadioButton("XML");
		rb_XML.setBounds(90, 190, 68, 23);
		
		JRadioButton rb_JSON = new JRadioButton("JSON");
		rb_JSON.setBounds(230, 190, 67, 23);
		
		expType.add(rb_XML);
		expType.add(rb_Moodle);
		expType.add(rb_JSON);
		
		JLabel lb_SaveIn = new JLabel("Guardar en: ");
		lb_SaveIn.setBounds(15, 139, 67, 14);
		contentPane.setLayout(null);
		contentPane.add(rb_Moodle);
		contentPane.add(rb_XML);
		contentPane.add(rb_JSON);
		contentPane.add(lb_SaveIn);
		contentPane.add(separator);
		contentPane.add(separator_1);
		contentPane.add(separator_2);
		contentPane.add(lb_fileName);
		contentPane.add(textField);
		contentPane.add(btnBrowse);
		contentPane.add(btnCancelar);
		contentPane.add(btnNewButton);
		contentPane.add(lblNombreDeProblema);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 135, 184, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(32, 194, 33, 14);
		contentPane.add(lblTipo);
	}
}
