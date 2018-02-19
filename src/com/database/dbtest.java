package com.database;

import java.util.Scanner;

public class dbtest 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter the query:");
	   	Scanner scanner = new Scanner(System.in);
		String qry = scanner.nextLine();
	    queryParameter obj=new queryParameter();
	    String[] spqry= obj.splitquery(qry);
		
	    String file = obj.filename(qry);
		System.out.println("File Name:");
	    System.out.format("%s.csv\n", file);
	
	    String beforewh = obj.beforewhere(qry);
	    System.out.println(beforewh);
	    
	    
	    String afterwh = obj.afterwhere(qry, spqry);
	    System.out.println(afterwh);
	    
	    obj.conditionalpart(qry, spqry);
		obj.restrictions(spqry,qry);
		obj.grpfld(spqry,qry);
		obj.ordfld(spqry,qry);
		obj.aggselp(spqry);
		scanner.close();
		csvfile obj1=new csvfile();
		obj1.mn();

	}

}
