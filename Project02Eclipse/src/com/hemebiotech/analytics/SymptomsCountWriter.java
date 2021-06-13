package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

/**
 * <p>class writes the result of treatment in a file</p>
 * <p>one symptom and his count per line</p>
 *
 * @author fabien
 *
 */

public class SymptomsCountWriter {

	/**
	 * 
	 * @param SymptomsMap sorted map with symptoms and their count
	 * @see SymptomsMap#symptomsMapCreate(java.util.List)
	 * 
	 * @throws Exception if error in file name 
	 */
    public void fileWriter(Map<String, Integer> SymptomsMap) throws Exception {

        FileWriter writer = new FileWriter("results.out");
        for (String symptom : SymptomsMap.keySet()) {
            writer.write(symptom + " : " + SymptomsMap.get(symptom) + "\n");
        }
        writer.close();
    }
}