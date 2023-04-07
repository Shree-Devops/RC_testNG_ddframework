package dd_tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import dd_core.testCore;
import dd_util.TestUtil;


public class loginTest extends testCore {
	
	
	@BeforeTest
	public void isSkip(){
		if(! TestUtil.isExecutable("loginTest")){
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	@Test(dataProvider="getData")
	public static void doLogin(String username, String password){
		try{
		selenium.open("/");
		selenium.click("//*[@id='header']/div[1]/div[2]/div[1]/a[1]");
		/*
		selenium.type(object.getProperty("username"), username);
		selenium.type(object.getProperty("password"), password);
		selenium.click(object.getProperty("signin_button"));
		*/
		//APPLICATION_LOGS.debug("User Successfully logged in:"+username);
		
		Thread.sleep(5000);
		
	
		//Check Text Present
		
		//TestUtil.checkText("Password1", "Text not present");
		
		//Check Element Present from Xpath.properties file
		
	    //TestUtil.checkElement(XPATH_MAP.getProperty("username"), "Error");
		
	     
	     //APPLICATION_LOGS.debug(TestUtil.checkElement("//input[@id='username']", "Error"));
		}catch(Throwable t){
			TestUtil.captureScreenshot();
		}
	    
	}
		
	
	@DataProvider
	public Object [][] getData(){
		//return test data from the sheetname provided
		return TestUtil.getData("loginTest");
	}
}
