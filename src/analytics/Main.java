package analytics;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		//Declaration Variable
		Map<String,Integer> register = new HashMap<String,Integer>();
	    TreeMap<String, Integer> sorted = new TreeMap<>();
		
	    //Appel methodes
		AnalyticsReaderCounter.loadFile(register);
		AnalyticsSorter.sortFile(register, sorted);
		AnalyticsSave.saveFile(sorted);
	}
}

