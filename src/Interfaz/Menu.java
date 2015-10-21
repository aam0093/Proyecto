package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnEdit.add(mntmCut);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnEdit.add(mntmPaste);
		
		JMenu mnProblem = new JMenu("Problem");
		menuBar.add(mnProblem);
		
		JMenuItem mntmLcs = new JMenuItem("LCS");
		mnProblem.add(mntmLcs);
		
		JMenuItem mntmKnaspack = new JMenuItem("Knaspack");
		mnProblem.add(mntmKnaspack);
		
		JMenuItem mntmTsp = new JMenuItem("TSP");
		mnProblem.add(mntmTsp);
		
		JMenu mnExport = new JMenu("Export");
		menuBar.add(mnExport);
		
		JMenuItem mntmXml = new JMenuItem("XML");
		mnExport.add(mntmXml);
		
		JMenuItem mntmPdf = new JMenuItem("PDF");
		mnExport.add(mntmPdf);
		
		JMenuItem mntmJson = new JMenuItem("JSON");
		mnExport.add(mntmJson);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
	}

}
