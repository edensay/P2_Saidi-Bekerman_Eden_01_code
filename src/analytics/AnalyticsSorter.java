package analytics;

import java.util.*;

public class AnalyticsSorter {
	
		//Fonction triant par ordre alpabetique
		public static void sortFile(Map<String,Integer> register, TreeMap<String,Integer> sorted)
	    {
	        // Copie registre dans la Treemap sorted qui est naturellement en ordre alphabetique
	        sorted.putAll(register);
	       
	    }//End sortFile

}//End AnalyticsSorter
