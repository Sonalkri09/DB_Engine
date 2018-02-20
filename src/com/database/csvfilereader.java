package com.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
public class csvfilereader 
{

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		String csvFile = "ipl.csv";
        BufferedReader br = null;
        int p=0;
        String[] ippi= {""};
        String line = "";
        String[][] arr= {{""}};
        String[] arstr1= {""};
        try {
		HashMap<String,ArrayList<String[]>> hm=new HashMap<String,ArrayList<String[]>>(); 
		ArrayList<String[]> arrli = new ArrayList<String[]>();
		 br = new BufferedReader(new FileReader(csvFile));
		 hm.put(br.readLine(),arrli);
		 
		 for(Entry<String, ArrayList<String[]>> m:hm.entrySet())
		 {  
		   System.out.println(m.getKey()+" "+m.getValue()); 
		 }  
	        
	        	while ((line = br.readLine()) != null) 
	        	{
	        		 String[] arstr=line.split(",");
	        		arrli.add(p,arstr);
	            	p++;
	            }
	        	for (String[] strArr : arrli) 
	        	{
	    			System.out.println(Arrays.toString(strArr));
	    		}
	        	
	        	} 
        	catch (FileNotFoundException e) 
        	{
	            e.printStackTrace();
	        } 
        	catch (IOException e) 
        	{
	            e.printStackTrace();
	        }
        	catch(ArrayIndexOutOfBoundsException e)
			        {
				        	e.printStackTrace();   	
			        }
	        	finally 
	        	{
        
		            if (br != null) 
		            {
		                try 
		                {
		                    br.close();
		                } catch (IOException e) 
		                {
		                    e.printStackTrace();
		                }
		            }
	        	}
        
	} 
			String[] splqry(String qry)
			{
				String[] sepqry = qry.split(",");
			      for (String eaqry : sepqry) 
			      {
			         System.out.println(eaqry);
			      } 
			      return sepqry;
			}
		

    
  
   
}

