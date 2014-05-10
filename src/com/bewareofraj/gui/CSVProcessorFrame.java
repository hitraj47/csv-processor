package com.bewareofraj.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CSVProcessorFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CSVProcessorFrame() {
		setTitle("CSV Processor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(240, 100);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOpenProcess = new JButton("Open & Process File");
		btnOpenProcess.setBounds(32, 25, 160, 23);
		contentPane.add(btnOpenProcess);
	}
}
