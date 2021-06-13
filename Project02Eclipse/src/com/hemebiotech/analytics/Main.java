package com.hemebiotech.analytics;

public class Main {

	/**
	 * <p>simple main creates an AnalyticsCounter object</p>
	 * <p>fileSymptoms is a full or partial path to file with symptom 
	 * strings in it, one per line</p>
	 * 
	 * @throws Exception if source file doesn't exist
	 * 
	 * @see AnalyticsCounter#AnalyticsCounter(String)
	 * @see AnalyticsCounter#reading()
	 * @see AnalyticsCounter#saving()
	 */
	public static void main(String[] args) throws Exception {
		String fileSymptoms = "Project02Eclipse/symptoms.txt";
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(fileSymptoms);
		analyticsCounter.reading();
		analyticsCounter.counting();
		analyticsCounter.saving();
	}

}
