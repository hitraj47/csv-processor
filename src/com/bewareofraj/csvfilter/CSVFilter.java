/**
 * 
 */
package com.bewareofraj.csvfilter;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.bewareofraj.gui.CSVProcessorFrame;
import com.bewareofraj.util.CSVFile;

/**
 * @author Raj
 *
 */
public class CSVFilter {
	
	private static CSVProcessorFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CSVProcessorFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * This method opens the CSV file and filters the file data.
	 * @param _file
	 */
	public static void filterCsvFile(File _file) {
		try {
			CSVFile csvFile = new CSVFile(_file);
			csvFile.setRecords(filterRecords(csvFile.getRecords()));
			String newFileName = createNewFileName(_file);
			File filteredFile = new File(newFileName);
			csvFile.saveFile(filteredFile);
			showSuccessDialog("File Saved", "The file was successuflly filtered and saved to: \n" + filteredFile.getAbsolutePath());
		} catch (FileNotFoundException e) {
			showErrorDialog("File Not Found", "Could not find the file you specified.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void showSuccessDialog(String _title, String _message) {
		JOptionPane.showMessageDialog(frame, _message, _title, JOptionPane.INFORMATION_MESSAGE);
	}

	private static String createNewFileName(File _file) {
		// TODO Auto-generated method stub
		return null;
	}

	private static ArrayList<String[]> filterRecords(ArrayList<String[]> records) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Show an error message pop up
	 * @param _title The dialog title
	 * @param _message The message to be displayed
	 * @param _buttonTitle The title for the dismiss button
	 */
	private static void showErrorDialog(String _title, String _message) {
		JOptionPane.showMessageDialog(frame, _message, _title, JOptionPane.ERROR_MESSAGE);
	}
}
