package dd_core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;

import org.openqa.selenium.server.SeleniumServer;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dd_util.SendMailUsingAuthentication;



import com.thoughtworks.selenium.DefaultSelenium;

import dd_xlreader.Xls_Reader;

public class testCore {

/*
 * init methods will be responsible for Initilizing the Selenium server, Load properties, logs 
 * and other files
 * 
 */
	
	
	//1st step
	public static DefaultSelenium selenium=null;
	
	//2nd step
	public static Properties config = new Properties();
	
	//3rd step
	public static Properties object = new Properties();
	
	//4th step
	public static Xls_Reader excel = null; 
	
	//5th step
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	//Selenium server
	public static SeleniumServer server = null;
	

	
	@BeforeSuite
	public static void init() throws Exception{
		
		
		//1st step
		if(selenium == null){
			
			//Start Selenium server through Code
			SeleniumServer server = new SeleniumServer();
			server.boot();
			server.start();
			
			//2nd step - Load config.properties
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//dd_properties//config.properties");
			config.load(fis);
			app_logs.debug("Loading config properties file");
			//3rd step - Load Object.properties
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//dd_properties//objects.properties");
			object.load(fis);
			
			
			//4th Step - load excel file
			excel = new Xls_Reader(System.getProperty("user.dir")+"//src//dd_properties//testData.xlsx");
			
			
			//1st step Create object of Default selenium
			selenium = new DefaultSelenium("localhost",4444,config.getProperty("browser"),config.getProperty("testsite"));
			selenium.start();
			selenium.windowFocus();
			selenium.windowMaximize();
			
			
			
		}
		
		
		
		
		
		
	}
	
	@AfterSuite
	//use this method after finishing the test execution
	public static void stopServer() throws AddressException, MessagingException{
		
		//sending mail
		System.out.println("Sending mail");
		SendMailUsingAuthentication mail = new SendMailUsingAuthentication();
		mail.postMail(SendMailUsingAuthentication.emailList, SendMailUsingAuthentication.emailSubjectTxt, SendMailUsingAuthentication.emailMsgTxt, SendMailUsingAuthentication.emailFromAddress);
		
		
		System.out.println("Stopping Selenium server");
		selenium.stop();
	//	server.stop();
		
	}
	
	
}
