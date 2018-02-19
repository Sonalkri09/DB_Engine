package com.database;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testcase {

	@Test
	public void test() {
		queryParameter juint = new queryParameter();
		String name = "select * from ipl.csv where season > 2014 and city = 'Bangalore'";
		String results = juint.filename(name);
		Assert.assertTrue(results.equals("ipl"));
		
		
		
	}
}
