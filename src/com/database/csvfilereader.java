package com.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;

public class csvfilereader
{ 
public static void main(String[] args)
{
	try {
		BufferedReader br = new BufferedReader(new FileReader("/home/sapient/ipl.csv"));
		String line =  null;
	    HashMap<String, ArrayList> map = new HashMap<String, ArrayList>();
	    
	    line = br.readLine();
	    
	    while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] country = line.split(",");
            
        }
	    
	    map.put(line, ArrayList country);
	    
	    
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    
    
	
	
	 
}
}

