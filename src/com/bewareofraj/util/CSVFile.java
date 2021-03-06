/**
 * This class is responsible for opening and parsing a CSV File.
 */
package com.bewareofraj.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Raj
 * @version 1.0
 */
/**
 * @author Raj
 *
 */
public class CSVFile {
	
	private File sourceFile;
	private String separator;
	private ArrayList<String[]> records;
	
	/**
	 * Default constructor. Sets the default separator to a comma
	 */
	public CSVFile() {
		// Use comma as default separator
		this.separator = ",";
	}
	
	/**
	 * Constructor that takes a file argument.
	 * @param _file The CSV file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public CSVFile(File _file) throws IOException {
		this();
		this.sourceFile = _file;
		open();
	}

	/**
	 * @return the sourceFile
	 */
	public File getSourceFile() {
		return sourceFile;
	}

	/**
	 * @param _sourceFile the sourceFile to set
	 */
	public void setSourceFile(File _sourceFile) {
		this.sourceFile = _sourceFile;
	}

	/**
	 * @return the separator
	 */
	public String getSeparator() {
		return separator;
	}

	/**
	 * @param _separator the separator to set
	 */
	public void setSeparator(String _separator) {
		this.separator = _separator;
	}

	/**
	 * @return the records
	 */
	public ArrayList<String[]> getRecords() {
		return records;
	}

	/**
	 * @param _records the records to set
	 */
	public void setRecords(ArrayList<String[]> _records) {
		this.records = _records;
	}
	
	/**
	 * Open the file on disk and set the records ArrayList.
	 * Make sure sourceFile is set.
	 * @throws IOException
	 */
	private void open() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.sourceFile));
		
		String line;
		this.records = new ArrayList<String[]>();
		while ( (line = reader.readLine()) != null) {
			String[] record = line.split(this.separator);
			this.records.add(record);
		}
		
		// close resource
		reader.close();
	}
	
	/**
	 * This method writes the records to the specified file. Overwrites if file already exists.
	 * @param _file
	 * @throws FileNotFoundException 
	 */
	public void saveFile(File _file) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(_file);
		
		for (String[] record : this.records) {
			for (String r : record) {
				writer.print(r);
				writer.print(this.separator);
			}
			writer.println("");
		}
		
		// close resource
		writer.close();
	}

}
