package com.kony.ktas.suites;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.UUID;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.kony.ktas.pages.SetupProfileScreen;
import com.kony.ktas.pages.WelComeScreen;
import com.kony.ktas.reports.KReports.ExtentReportListener;

import io.appium.java_client.AppiumDriver;



public class SampleSuite extends BaseTest{
	
	SoftAssert s_assert;
	WelComeScreen welcome;
	SetupProfileScreen setpProfile;
	
	
	@BeforeClass(alwaysRun=true)
	public void startApp() throws MalformedURLException {
	    
		s_assert=new SoftAssert();
		//welcome=new WelComeScreen(driver);
		//setpProfile=new SetupProfileScreen(driver);
	}
	
	 @Test(groups = { "Sanity"},description="To Verify Home screen",priority = 1,dataProvider = "hardCodedBrowsers")
	    public void verifyTest1_TC_001(String os,String devicename, String version,Method method)
	            throws Exception {
		 
		    System.out.println("My Test1..........");
	        this.createDriver(os, devicename, version, method.getName());
	        AppiumDriver driver = this.getWebDriver();
	        
	        welcome=new WelComeScreen(driver);
	        s_assert.assertEquals(welcome.verifyWelcomeScreen(), true, "Home screen is not as expected....");
			welcome.clickonNobtn();
			s_assert.assertAll();

	    }


}
