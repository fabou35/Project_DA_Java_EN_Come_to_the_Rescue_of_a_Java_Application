package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0; 
	private static int rashCount = 0; 
	private static int pupilCount = 0; 
	
	public static void main(String args[]) throws Exception {
		
		// correction: path of file source
		String fileSymptom = "Project02Eclipse/symptoms.txt";
		
		// first get input
		BufferedReader reader = new BufferedReader(new FileReader(fileSymptom));
		String line = reader.readLine();

		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++; // correction: headache counter
				System.out.println("number of headaches: " + headacheCount);
			} else if (line.equals("rash")) { // correction: symptom's name 
				rashCount++;
			} else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine(); // get another symptom
		}
		
		reader.close(); // correction: close file source
		
		// correction: changes file's name by results.out
		FileWriter writer = new FileWriter("results.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}