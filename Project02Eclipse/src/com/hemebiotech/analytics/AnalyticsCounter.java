package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * class reads a file of symptoms, counts in a map each symptom 
 * and writes the result in a file
 * 
 * @author fabien
 *
 */
public class AnalyticsCounter {

	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		

	/**
	 * file path of source file 
	 */
	String fileSymptoms;

	/**
	 * constructor
	 * @param fileSymptoms filepath a full or partial path to file with symptom 
	 * strings in it, one per line
	 */
	AnalyticsCounter(String fileSymptoms) {
		this.fileSymptoms = fileSymptoms;
	}

	/**
	 * <p>reads source file line per line</p>
	 * <p>counts occurrences for headache, rash and pupils</p>
	 * <p><b>notice:</b> reading stops at the end of file then closes the file</p>
	 * 
	 * @throws Exception if source file doesn't exist
	 */
	public void reading() throws Exception {
		BufferedReader reader = new BufferedReader (new FileReader(fileSymptoms));

		/**
		 * saves a symptom
		 */
		String line = reader.readLine();
		
		while (line != null) {

			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}

		reader.close();
	}

	/**
     * saves the name of each symptom and the result of the symptom's count 
     * in a file
     * 
	 * @throws IOException if error in file name
     * 
     */
	public void saving() throws Exception {
		FileWriter writer = new FileWriter ("results.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

}