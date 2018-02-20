package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class csvfile {

	public static void main(String[] args) {

	        String csvFile = "C:\\Users\\User\\workspace\\database\\src\\database\\ipl.csv";
	        String line = "";
	        String cvsSplitBy = ",";
	        
	        String c1=""; 

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {
	            	
	                // use comma as separator
	                String[] country = line.split(cvsSplitBy);
	                
	                
	                c1= c1.concat(country[0]+",");
	               

	                System.out.println("Country [code= " + country[0] + " , name=" + country[5] + "]");

	            }
	            
	            
	            System.out.println(c1);
	            String[] id=c1.split(",");
	            
	            for(int i=0; i<id.length; i++)
	            {
	            	System.out.println(id[i]);
	            }
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
