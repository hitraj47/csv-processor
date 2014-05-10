/**
 * 
 */
package com.bewareofraj.csvfilter;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
	
	/**
	 * This method shows an information dialog.
	 * @param _title The title of the dialog.
	 * @param _message The message to be displayed.
	 */
	private static void showSuccessDialog(String _title, String _message) {
		JOptionPane.showMessageDialog(frame, _message, _title, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * This method creates the new file path/save location for the filtered file.
	 * @param _file The old file that is being filtered
	 * @return
	 */
	private static String createNewFileName(File _file) {
		String oldPath = _file.getAbsolutePath();
		String newPath = oldPath.substring(0, oldPath.length()-4);
		newPath = newPath + "_filtered.csv";
		return newPath;
	}
	
	/**
	 * This method filters the array list and removes all non-unique records, unless there is a business name
	 * @param _records The list of all records
	 * @return
	 */
	private static ArrayList<String[]> filterRecords(ArrayList<String[]> _records) {
		ArrayList<String[]> filteredRecords = _records;
		// the location of the post code
		int postCodeLocation = 0;
		
		// the location of the business name (cell K)
		int businessNameLocation = 10;
		
		// array list to keep track of unique post codes
		ArrayList<String> uniquePostCodes = new ArrayList<String>();
		
		Iterator<String[]> it = filteredRecords.iterator();
		while (it.hasNext()) {
			String[] record = it.next();
			if ( !uniquePostCodes.contains(record[postCodeLocation]) ) {
				uniquePostCodes.add(record[postCodeLocation]);
			} else {
				if ( record[businessNameLocation].equals("")) {
					it.remove();
				}
			}
		}
		
		return filteredRecords;
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
