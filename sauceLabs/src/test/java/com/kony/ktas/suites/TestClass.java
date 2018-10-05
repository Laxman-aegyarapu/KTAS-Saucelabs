package com.kony.ktas.suites;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kony.ktas.pages.SetupProfileScreen;
import com.kony.ktas.pages.WelComeScreen;

import io.appium.java_client.AppiumDriver;

public class TestClass extends BaseTest{
	
	SoftAssert s_assert;
	WelComeScreen welcome;
	SetupProfileScreen setpProfile;
	
	
	@BeforeClass(alwaysRun=true)
	public void startApp() throws MalformedURLException {
	    
		s_assert=new SoftAssert();
		//welcome=new WelComeScreen(driver);
		//setpProfile=new SetupProfileScreen(driver);
	}
	
	 @Test(groups = { "Sanity"},description="To Verify Home screen",priority = 3,dataProvider = "hardCodedBrowsers")
	    public void verifyTest2_TC_002(String os,String devicename, String version,Method method)
	            throws Exception {
		 
		    System.out.println("My Test2..........");
	        this.createDriver(os, devicename, version, method.getName());
	        AppiumDriver driver = this.getWebDriver();
	        
	        welcome=new WelComeScreen(driver);
	        s_assert.assertEquals(welcome.verifyWelcomeScreen(), true, "Home screen is not as expected....");
			welcome.clickonNobtn();

	    }
	 
	

}
