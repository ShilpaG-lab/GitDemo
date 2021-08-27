package com.systest.nmsTest;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.nms.Util.TestUtil;

public class ReadingDataFromExcel {

	
	@Test(dataProvider="getTestData")
	public void dataValidation(String appId,String usId,String transId ) {
		
		System.out.println("Application Id is"+appId);
		System.out.println("Application Id is"+usId);
		System.out.println("Application Id is"+transId);
	}
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData=TestUtil.getDataFromExcel();
		return testData.iterator();
	}
		

	
}
