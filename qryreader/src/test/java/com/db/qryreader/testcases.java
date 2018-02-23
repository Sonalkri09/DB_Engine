package com.db.qryreader;

import org.junit.jupiter.api.AfterEach;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.dbEngine.project.dbEngine.querycl;

import junit.framework.Assert;
@RunWith(JUnitPlatform.class)

import junit.framework.TestCase;

public class testcases extends TestCase {
	queryparameter juint = new queryparameter();
	String name = "select * from ipl.csv where season > 2014 and city = 'Bangalore' order by win_by_runs group by team1";
	String[] spqry= juint.splitquery(name);
	
	@Test
	void Test1(){
	//To check file name
	String results = juint.filename(name);
	assertTrue(results.equals("ipl"));
	}
	
	@Test
	void Test2() {
	//To check before where
	String bfwh = juint.beforewhere(name);
	assertTrue(bfwh.equals("select * from ipl.csv "));
	}
	
	
	@Test
	void Test3() {
	//To check after where 
	String afwh = juint.afterwhere(name);
	assertTrue(afwh.equals("season > 2014 and city = 'Bangalore' order by win_by_runs group by team1"));
	}
	
	@Test
	void Test4() {
	// To check the conditions
	String[] conditions= {"","","",""};
	conditions = juint.restrictions(spqry,name);
	assertTrue(conditions[0].equals("season > 2014"));
	assertTrue(conditions[1].equals("city = 'Bangalore'"));
	}
	
	@Test
	void Test5() {
	//To check logical operator
	String[] logical = {""};
	logical = juint.logop(name, spqry);
	assertTrue(logical[0].equals("and"));
	}
	
	@Test
	void Test6() {
	//To check group fields
	String grp = juint.grpfld(spqry, name);
	assertTrue(grp.equals("team1"));
	}
	
	@Test
	void Test7() {
	
	//To check order fields
	String ord = juint.ordfld(spqry, name);
	assertTrue(ord.equals("win_by_runs"));
	}
}
