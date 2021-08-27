package com.systest.nmsTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.nms.Util.TestUtil;

public class ReadingDataTest {
	
	String sheetName="Request_Data";
	
	@DataProvider
	public Object[][] getNMSData() {
		Object data[][]=TestUtil.getTestData1(sheetName);
		return 	data;
	}

	
	@Test(dataProvider="getNMSData")
	public void VaidateData(String appId,String usId,String transId) {
		System.out.println("Application Id is"+appId);
		System.out.println("Application Id is"+usId);
		System.out.println("Application Id is"+transId);
		
	}
}
