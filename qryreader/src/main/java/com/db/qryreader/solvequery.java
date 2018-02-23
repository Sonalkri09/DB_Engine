package com.db.qryreader;

public class solvequery 
{
	int f=0, cwf = 0;
	void execute(String[] header,String field,String[][] arr,String condone,String condtwo,String condthree)
	{
		for(int i=0;i<17;i++)
		{
			if(header[i].equals(field))
			{
				f=i;
			}
			
			if(header[i].equals(condone))
			{
				cwf=i;
			}
			
		}
		
		
	    for(int i=1;i<570;i++)
	    {
	    	if(condtwo.equals("=")) {
	    		if(arr[i][cwf].equals(condthree))
	    		{
	    			System.out.println(arr[i][f]);
	    		}
	    	}
	    	if(condtwo.equals("!=")) {
	    		if(!(arr[i][cwf].equals(condthree)))
	    		{
	    			System.out.println(arr[i][f]);
	    		}
	    	}
	    	if(condtwo.equals(">")) {
	    		if(Integer.parseInt(arr[i][cwf])>(Integer.parseInt(condthree)))
	    		{
	    			System.out.println(arr[i][f]);
	    		}
	    	}
	    	if(condtwo.equals("<")) {
	    		if(Integer.parseInt(arr[i][cwf])<(Integer.parseInt(condthree)))
	    		{
	    			System.out.println(arr[i][f]);
	    		}
	    	}
	    }
	    
	}

}