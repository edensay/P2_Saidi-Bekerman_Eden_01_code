package analytics;

import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) {
	
		Fichier sickness = new Fichier();
		
		sickness.loadFile(sickness.register);
		sickness.sortFile(sickness.register, sickness.sorted);
		sickness.saveFile(sickness.sorted);
	}
}


class Fichier{
	
	Map<String,Integer> register = new HashMap<String,Integer>();
    TreeMap<String, Integer> sorted = new TreeMap<>();
	
	//Fonction remplissant dans le registre le nom et nombre d'occurences des maladies du fichier symptomss
	void loadFile(Map<String,Integer> register) {
		
		String line= "";
		File file = new File("Symptoms.txt");
		BufferedReader reader = null;
		
				
		 try { 
			 FileReader filereader = new java.io.FileReader(file);
			 reader = new BufferedReader (filereader);

		      line = reader.readLine();

		      while(line != null) {
		    	  
		    	  if(register.containsKey(line)) {  
		    		  register.put(line, register.get(line)+1); 
		    	  }
		    	  else {
		    		  register.put(line, 1);  
		    	  }
		          line = reader.readLine();  
		      }
		 }
		 //Exception multiple
		 catch (FileNotFoundException a) {
	            System.out.println("Fichier non trouve: " + file.toString());
	        }
		catch (IOException b) {
		    b.printStackTrace();
		}
		finally {
			try {
				reader.close();
			}
			catch (IOException c) {
	            System.out.println("Impossible de fermer fichier: " + file.toString());
	        }
		}	
	} //End loadFile
	
	//Fonction triant par ordre alpabetique
	 void sortFile(Map<String,Integer> register, TreeMap<String,Integer> sorted)
    {
        // Copie registre dans la Treemap sorted qui est naturellement en ordre alphabetique
        sorted.putAll(register);
       
    }//End sortFile
	
	//Fonction ecrivant sorted dans un fichier texte
	void saveFile(TreeMap<String,Integer> sorted) {
		
		File file = new File("Result.txt");
		
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
		catch (IOException a) {
			a.printStackTrace();
		}
	}//End saveFile
	
}//End class Fichier