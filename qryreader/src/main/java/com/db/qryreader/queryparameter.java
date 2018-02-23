package com.db.qryreader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class queryparameter {
	//Split the query
		String[] splitquery(String qry)
		{
			String[] sepqry = qry.split(" ");
		      for (String eaqry : sepqry) {
		         System.out.println(eaqry);
		      } 
		      return sepqry;
		}
		
		//Give the file name
		String filename(String spl_qry) 
		{
			String codeGroup="";
		      Pattern p = Pattern.compile("(\\S+).csv");
			    Matcher m = p.matcher(spl_qry);
			    if (m.find()) 
			    {
			    	// get the matching group
				      codeGroup = m.group(1);
			    }
			    
				return codeGroup;
		}
		
		//Before where part
		String beforewhere(String qry)
		{
			String bw="";
		    if(qry.contains("where"))
		    {
		    	bw = qry.substring(0,qry.indexOf("where"));
		    	
		    }
		    return bw;
		}
	    
		//After where part
	    String afterwhere(String qry)
	    {
	    	String aw="";
	    	if(qry.contains("where")) 
	    	{
	    		aw =qry.substring(qry.indexOf("where") + 6,qry.length());
		     }
	    	return aw;
	    }
	    
	    //Conditional Part
	    String[] restrictions(String[] sepqry, String qry)
		{
			String []new_arr=sepqry;
			String []conditions={"",""};
			int i=0;
			for(int k=0;k<new_arr.length;)
			{   
				if((new_arr[k].matches("<"))||(new_arr[k].matches(">"))||(new_arr[k].matches("="))||(new_arr[k].matches("!")))
					{       
					conditions[i]=new_arr[k-1]+" "+new_arr[k]+" "+new_arr[k+1];
					if(new_arr[k+1].matches("="))
					{
						conditions[i]=conditions[i]+" "+new_arr[k+2];
						k++;
					}
					i++;
					}
				k++;
			}
		
			for(i=0; i<conditions.length; i++)
			    System.out.println(conditions[i]);
			return conditions;
		}

	    //Logical operator
		String[] logop(String qry, String[] sepqry)
		{
			String []new_arr=sepqry;
			String []operator={"","","",""};
			int i=0;
			for(int k=0;k<new_arr.length;)
			{   
				if((new_arr[k].matches("and"))||(new_arr[k].matches("or"))||(new_arr[k].matches("not")))
					{       
					operator[i]=new_arr[k];
					i++;
					}
				k++;
			}
		
			System.out.println("logical operator:");
			for(i=0; i<operator.length; i++)
			    System.out.println(operator[i]);
			return operator;
		}
		
		//Group field
		String grpfld (String[] sepqry,String qry)
		{
			int j;
			String gf = "";
			if(qry.contains("group"))
			    {
					
			        for (j=0;j< sepqry.length;j++) 
			        {
				 		 if (sepqry[j].equals("group"))
				 		 {
				 			 gf = sepqry[j+2];
				 		 }
			 	    }
			    }
			return gf;
		}
		
		//Order field
		String ordfld(String[] sepqry,String qry)
		{
				int j;
				String of = "";
			    if(qry.contains("order"))
		    	{
			    	
			      
			    	for (j=0;j< sepqry.length;j++) 
			    	{
				 		 if (sepqry[j].equals("order"))
				 		 {
				 			 of = sepqry[j+2];
				 		 }
			 	   }
			    }
			    return of;
		}	     
		
		//Selected fields
		String[] aggselp(String[] sepqry)
		{
		      String qry1= sepqry[1];
		      System.out.println("Selected Parts/aggregate fileds:");
		      String[] sepqry1 = qry1.split(",");
		      for (String eaqry1 : sepqry1) 
		      {
		         System.out.println(eaqry1);
		      } 
		      return sepqry1;
		}
}
