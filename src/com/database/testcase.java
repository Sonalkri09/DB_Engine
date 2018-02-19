package com.database;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testcase {

	@Test
	public void test() {
		queryParameter juint = new queryParameter();
		String name = "select * from ipl.csv where season > 2014 and city = 'Bangalore'";
		String[] spqry= juint.splitquery(name);
		
		//To check file name
		String results = juint.filename(name);
		Assert.assertTrue(results.equals("ipl"));
		
		//To check before where
		String bfwh = juint.beforewhere(name);
		Assert.assertTrue(bfwh.equals("select * from ipl.csv "));
		
		//To check after where 
		String afwh = juint.afterwhere(name);
		Assert.assertTrue(afwh.equals("season > 2014 and city = 'Bangalore'"));
		
		// To check the conditions
    	String[] conditions= {"","","",""};
    	conditions = juint.restrictions(spqry,name);
    	Assert.assertTrue(conditions[0].equals("season>2014"));
    	Assert.assertTrue(conditions[1].equals("city='Bangalore'"));
  
		
		
		
		
	}
}
