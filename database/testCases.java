package database;


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testCases 
{

	@Test
	public void test() 
	{
		QueryParameter juint = new QueryParameter();
		String name = "select * from ipl.csv where season > 2014 and city = 'Bangalore' order by win_by_runs group by team1";
		String[] spqry= juint.splitquery(name);
		
		//To check file name
		String results = juint.filename(name);
		Assert.assertTrue(results.equals("ipl"));
		
		//To check before where
		String bfwh = juint.beforewhere(name);
		Assert.assertTrue(bfwh.equals("select * from ipl.csv "));
		
		//To check after where 
		String afwh = juint.afterwhere(name);
		Assert.assertTrue(afwh.equals("season > 2014 and city = 'Bangalore' order by win_by_runs group by team1"));
		
		// To check the conditions
    	String[] conditions= {"","","",""};
    	conditions = juint.restrictions(spqry,name);
    	Assert.assertTrue(conditions[0].equals("season>2014"));
    	Assert.assertTrue(conditions[1].equals("city='Bangalore'"));
    	
    	//To check logical operator
    	String[] logical = {""};
    	logical = juint.logop(name, spqry);
    	Assert.assertTrue(logical[0].equals("and"));
    	
    	//To check group fields
    	String grp = juint.grpfld(spqry, name);
    	Assert.assertTrue(grp.equals("team1"));
    	
    	//To check order fields
    	String ord = juint.ordfld(spqry, name);
    	Assert.assertTrue(ord.equals("win_by_runs"));
    	
	}
}
