package com.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class csvfile {
	void mn(){
		String csvFile = "/home/sapient/ipl.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        String col0="";
        String col1="";
        String col9="";
        String col11="";
        String col12="";
      
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                col0 = col0.concat(country[0]+",");
                col1 = col1.concat(country[1]+",");
                col9 = col9.concat(country[9]+",");
                col11 = col11.concat(country[11]+",");
                col12= col12.concat(country[12]+",");
              //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
                
            }System.out.println(col0);
            System.out.println(col1);
            System.out.println(col9);
            System.out.println(col11);
            System.out.println(col12);
            
            int c0[]= psri(col0);
            int c1[]= psri(col1);
            int c9[]= psri(col9);
            int c11[]= psri(col11);
            int c12[]= psri(col12);
            
            String[] id = col0.split(",");
            
            System.out.println(id);
            
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        }
        int[] psri(String str)
        {int x;int strr[]= {};
        	String[] str1 = str.split(" ");
  	      for (String str2 : str1) {
  	         System.out.println(str2);
  	      		}
  	      for(x=1;x<str1.length;x++)
  	    	  strr[x]= Integer.parseInt(str1[x]);
  	      	return strr;
        }
}
