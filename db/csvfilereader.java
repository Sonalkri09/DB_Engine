package com.database;

import java.io.BufferedReader;
//import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Scanner;

public class csvfilereader{ 
public static void main(String[] args){
	

	
	 String csvFile = "/home/sapient/ipl.csv";
     String line = "";
     //String cvsSplitBy = ",";

     try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
     {

         while ((line = br.readLine()) != null) 
         {

             // use comma as separator
             String[] country = line.split(",");
             
            // Integer id = Integer.parseInt(country[0]);
             //System.out.println(id);
             
             //System.out.println(country);

             System.out.println("Country [code= " + country[0] + " , name=" + country[5] + "]");

         }

     } catch (IOException e)
     	{
         e.printStackTrace();
     	}
}
}

