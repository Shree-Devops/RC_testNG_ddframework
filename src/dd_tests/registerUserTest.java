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


public class registerUserTest extends testCore {
	
	
	@BeforeTest
	public void isSkip(){
		if(! TestUtil.isExecutable("registerUserTest")){
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	@Test(dataProvider="getData")
	public static void userRegisteration(String name,
			String day,
			String month,
			String year,
			String registerusername,
			String password,
			String repassword,
			String email,
			String mobileno){
		try{
		
			Thread.sleep(5000L);
			
			selenium.type("//*[@id='fname']", "Raman");
			
		
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
		return TestUtil.getData("registerUserTest");
	}
}
