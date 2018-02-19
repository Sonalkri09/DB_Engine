package com.database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class queryParameter {
	String[] splitquery(String qry)
	{
		String[] sepqry = qry.split(" ");
	      for (String eaqry : sepqry) {
	         System.out.println(eaqry);
	      } 
	      return sepqry;
	}
	String filename(String qry) {
		String codeGroup="";
	      Pattern p = Pattern.compile("(\\S+).csv");
		    Matcher m = p.matcher(qry);
		    if (m.find()) {// get the matching group
			      codeGroup = m.group(1);
			    }
		    
			return codeGroup;
	}
	String beforewhere(String qry)
	{
		String bw="";
	    if(qry.contains("where"))
	    {
	    	bw = qry.substring(0,qry.indexOf("where"));
	    	
	    }
	    return bw;
	}
		    
    String afterwhere(String qry)
    {
    	String aw="";
    	if(qry.contains("where")) 
    	{
    		aw =qry.substring(qry.indexOf("where") + 6,qry.length());
	     }
    	return aw;
    }
    
    String[] restrictions(String[] sepqry, String qry)
	{
		String []new_arr=sepqry;
		String []conditions={"","","",""};
	int i=0;
	for(int k=0;k<new_arr.length;)
	{   
		if((new_arr[k].matches("<"))||(new_arr[k].matches(">"))||(new_arr[k].matches("="))||(new_arr[k].matches("!")))
	{       
			conditions[i]=new_arr[k-1]+new_arr[k]+new_arr[k+1];
			if(new_arr[k+1].matches("="))
			{conditions[i]=conditions[i]+new_arr[k+2];
					k++;
			}
			i++;}
		k++;
	}

	System.out.println("conditions");
	for(  i=0;i<conditions.length;i++)
	    System.out.println(conditions[i]);
	return conditions;
	}


	
//	    for (i=0;i<sepqry.length;i++)
//		  {
//			  if (sepqry[i].equals("and"))
//				  System.out.println(sepqry[i]);
//			  else if (sepqry[i].equals("or"))
//				  System.out.println(sepqry[i]);
//			  else if (sepqry[i].equals("not"))
//				  System.out.println(sepqry[i]);
//		  }
//	}
	void grpfld (String[] sepqry,String qry)
	{
		int j;
		if(qry.contains("groupby"))
		    {
				System.out.println("GroupBy field:");
		        for (j=0;j< sepqry.length;j++) 
		        {
			 		 if (sepqry[j].equals("groupby"))
			 		 {
			 			 System.out.println(sepqry[j+1]);
			 		 }
		 	    }
		    }
	}
	void ordfld(String[] sepqry,String qry)
	{
			int j;
		    if(qry.contains("orderby"))
	    	{
		    	System.out.println("OrderBy field:");
		      
		    	for (j=0;j< sepqry.length;j++) 
		    	{
			 		 if (sepqry[j].equals("orderby"))
			 		 {
			 			 System.out.println(sepqry[j+1]);
			 		 }
		 	   }
		    }
	}	     
	void aggselp(String[] sepqry)
	{
	      String qry1= sepqry[1];
	      System.out.println("Selected Parts/aggregate fileds:");
	      String[] sepqry1 = qry1.split(",");
	      for (String eaqry1 : sepqry1) 
	      {
	         System.out.println(eaqry1);
	      } 
	}

}
