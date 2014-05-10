package com.bewareofraj.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bewareofraj.csvfilter.CSVFilter;

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
		btnOpenProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION && fileChooser.getSelectedFile() != null) {
					File csvFile = fileChooser.getSelectedFile();
					if (CSVFilter.isCsvFile(csvFile)) {
						CSVFilter.filterCsvFile(csvFile);
					} else {
						CSVFilter.showErrorDialog("Invalid File", "The file you selected is not a CSV file. Please select a file with the extension '.csv'.");
					}
				}
			}
		});
		btnOpenProcess.setBounds(32, 25, 160, 23);
		contentPane.add(btnOpenProcess);
	}
}
