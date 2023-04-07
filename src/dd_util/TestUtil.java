package dd_util;


import java.util.Calendar;
import java.util.GregorianCalendar;




import dd_core.testCore;
import dd_xlreader.Xls_Reader;

//3rd file

public class TestUtil extends testCore{

	
	// Step 3.1
	public static boolean isExecutable(String tcid){
		
		for(int rowNum=2; rowNum<=excel.getRowCount("test_suite"); rowNum++){
			if(excel.getCellData("test_suite","TCID", rowNum).equals(tcid)){
				if(excel.getCellData("test_suite","Runmode", rowNum).equalsIgnoreCase("Y")){
					return true;
				}
				else{
					return false;
				}
					
			}
		}
		return false;
	}

	
	public static Object[][] getData(String sheetName){
		// return test data;
		// read test data from xls
		
		int rows=excel.getRowCount(sheetName)-1;
		if(rows <=0){
			Object[][] testData =new Object[1][0];
			return testData;
			
		}
	    rows = excel.getRowCount(sheetName);  // 3
		int cols = excel.getColumnCount(sheetName);
		//System.out.println("total rows -- "+ rows);
		//System.out.println("total cols -- "+cols);
		Object data[][] = new Object[rows-1][cols];
		
		for( int rowNum = 2 ; rowNum <= rows ; rowNum++){
			
			for(int colNum=0 ; colNum< cols; colNum++){
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
		
		
	}


public static void captureScreenshot(){
	
	  Calendar cal = new GregorianCalendar();
	  int month = cal.get(Calendar.MONTH);
	  int year = cal.get(Calendar.YEAR);
	  int sec =cal.get(Calendar.SECOND);
	  int min =cal.get(Calendar.MINUTE);
	  int date = cal.get(Calendar.DATE);
	  int day =cal.get(Calendar.HOUR_OF_DAY);
    String ImageDest = "C:\\selenium_training_videos_test\\RC_Junit_ddframework\\screenshots\\";
    testCore.selenium.captureEntirePageScreenshot(ImageDest+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+ ".jpeg"," ");
    
   
    	      
}



/*

	public static void screenshots(String filename){
	
		
	testCore.selenium.captureEntirePageScreenshot(System.getProperty("user.dir")+"\\screenshots\\"+filename+".jpg","");
	//testCore.selenium.captureScreenshot(System.getProperty("user.dir")+"\\screenshots\\"+filename+".jpg");
		
	}


*/

	
}
