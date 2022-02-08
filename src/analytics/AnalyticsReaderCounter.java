package analytics;

import java.io.*;
import java.util.*;

public class AnalyticsReaderCounter {
	
	//Fonction remplissant dans le registre le nom et nombre d'occurences des maladies du fichier symptomss
		public static void loadFile(Map<String,Integer> register) {
			
			String line= "";
			File file = new File("Symptoms.txt");
			BufferedReader reader = null;
			
					
			 try { 
				 FileReader filereader = new java.io.FileReader(file);
				 reader = new BufferedReader (filereader);

			      line = reader.readLine();

			      while(line != null) {
			    	  
			    	  //Si symptoms deja present dans le registre, ajoute 1 occurence
			    	  if(register.containsKey(line)) {  
			    		  register.put(line, register.get(line)+1); 
			    	  }
			    	  //Symptons non present dans le registe, l'ajoute et initialise a  1 occurence
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

}//End AnalyticsReaderCounter
