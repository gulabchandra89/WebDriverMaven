package MySuvidha.in.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import MySuvidha.in.base.TestBase;

public class TestUtil extends TestBase{
	public static String screenshotPath;
	public static String screenshotName;
	public static void captureScreenshot() throws IOException
	{
		File filesrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime d = LocalDateTime.now(); 
		screenshotName=d.toString().replace('/', '_').replace(':', '_').replace(' ', '_')+".jpg";;
		FileUtils.copyFile(filesrcFile, new File(System.getProperty("user.dir")+"\\target\\"+screenshotName));
		
	}

	@DataProvider(name="CommonDP")
	public Object[][] getDataExcel(Method m) {
		String sheetNameString = m.getName();
		int rows = excelReader.getRowCount(sheetNameString);
		int cols = excelReader.getColCount(sheetNameString);

		Object[][] data = new Object[rows][cols];
		for (int rowNum = 1; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 1][colNum] = excelReader.getCellData(sheetNameString, rowNum, colNum);
				System.out.println(data[rowNum - 1][colNum]);
			}

		}

		return data;

	}

	public static boolean isSuiteRunnable(String testName, ExcelReader reader)
	{
		String sheetName= "test_suite";
		int rows= reader.getRowCount("test_suite");
		for(int rNum=2;rNum<=rows;rNum++)
		{int i=1;
		String testcase= (String) reader.getCellData(sheetName, i, rNum);
		if(testcase.equalsIgnoreCase(testName))
		{
			++i;
			String runmode= (String) reader.getCellData(sheetName, i, rNum);
			
			if(runmode.equalsIgnoreCase("Y"))
			{
				return true;
				
				
			}else return false;
			
		}
			
			
		}
		
		return false;	
	}
	
	
}
