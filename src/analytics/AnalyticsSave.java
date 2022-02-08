package analytics;

import java.io.*;
import java.util.*;

public class AnalyticsSave {
	
	//Fonction ecrivant sorted dans un fichier texte
		public static void saveFile(TreeMap<String,Integer> sorted) {
			
			File file = new File("Result.out");
			
			try {
				if(!file.exists()) {
					file.createNewFile();
				}
				FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
				BufferedWriter writer = new BufferedWriter (fileWriter);
				
				for(Map.Entry<String, Integer> entry : sorted.entrySet() ) {
					writer.write(entry.getKey() + " = " + entry.getValue());
					
					writer.newLine();
					
				}
				writer.flush();
				writer.close();  
				
			}
			//Exception
			catch (IOException a) {
				a.printStackTrace();
			}
		}//End saveFile
		
}//End AnalyticsSave
