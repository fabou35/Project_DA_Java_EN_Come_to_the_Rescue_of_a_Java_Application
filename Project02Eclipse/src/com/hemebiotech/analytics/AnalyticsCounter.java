package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * class reads a file of symptoms, counts in a map each symptom and writes the
 * result in a file
 * 
 * @author fabien
 *
 */
public class AnalyticsCounter {

	/**
	 * file path of file source
	 */
	String fileSymptoms;

	/**
	 * <p>
	 * list of all symptoms in file source
	 * </p>
	 * 
	 * can have redundancies of symptom's name
	 * 
	 */
	List<String> symptomsList = new ArrayList<String>();

	/**
	 * map of all symptoms in file source and their count
	 * 
	 * <p>
	 * <b>key:</b> symptom's name
	 * </p>
	 * <p>
	 * <b>value:</b> symptom's count
	 * </p>
	 */
	Map<String, Integer> symptomsMap = new TreeMap<String, Integer>();

	/**
	 * constructor
	 * 
	 * @param fileSymptoms filepath a full or partial path to file with symptom
	 *                     strings in it, one per line
	 */
	AnalyticsCounter(String fileSymptoms) {
		this.fileSymptoms = fileSymptoms;
	}

	/**
	 * recovers a list of symptoms returned by the class ReadSymptomDataFromFile in
	 * the variable symptomsList
	 * 
	 * @see ReadSymptomDataFromFile
	 * @see ReadSymptomDataFromFile#getSymptoms()
	 */
	public void reading() {
		ReadSymptomDataFromFile data = new ReadSymptomDataFromFile(fileSymptoms);
		symptomsList = data.getSymptoms();
	}

	/**
	 * <p>
	 * creates the map of symptoms with count of occurrences in file source
	 * </p>
	 * <p>
	 * uses loop on a list.
	 * </p>
	 * 
	 * @see AnalyticsCounter#symptomsList
	 * @see SymptomsMap#symptomsMap
	 */
	public void counting() {
		symptomsMap = SymptomsMap.symptomsMapCreate(symptomsList);
	}

	/**
	 * saves the name of each symptom and the result of the symptom's count in a
	 * file
	 * 
	 * @throws Exception if error in file name
	 * 
	 * @see SymptomsCountWriter#fileWriter(Map)
	 * 
	 */
	public void saving() throws Exception {
		SymptomsCountWriter symptomCountWrite = new SymptomsCountWriter();
		symptomCountWrite.fileWriter(symptomsMap);
	}

}