package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 * class creates the map of symptoms with count of occurrences in symptom's list
 * </p>
 * 
 * @see AnalyticsCounter#symptomsList
 * @see AnalyticsCounter#symptomsMap
 *
 * @author fabien
 *
 */

public class SymptomsMap {

	/**
	 * <p>
	 * creates the map of symptoms with count of occurrences in symptom's list
	 * </p>
	 * <p>
	 * uses loop on this list.
	 * </p>
	 * 
	 * <p>
	 * <b>notice:</b> if symptom from list is a map's key, increases count of this
	 * symptom, else, creates the key and initializes it to 1
	 * </p>
	 * 
	 * @param symptomList list of symptoms read in source file
	 * @return sorted Map on keys
	 *         <p>
	 *         <b>key:</b> symptom's name
	 *         </p>
	 *         <p>
	 *         <b>value:</b> symptom's count
	 *         </p>
	 * 
	 */
	public static Map<String, Integer> symptomsMapCreate(List<String> symptomList) {

		Map<String, Integer> symptomsMap = new TreeMap<String, Integer>();

		for (String symptom : symptomList) {

			if (symptomsMap.containsKey(symptom)) {
				symptomsMap.put(symptom, symptomsMap.get(symptom) + 1);

			} else {
				symptomsMap.put(symptom, 1);
			}
		}
		return symptomsMap;
	}
}