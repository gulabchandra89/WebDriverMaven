package MySuvidha.in.utilities;

import java.io.File;

import com.google.common.collect.Ordering;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		
		if(extent==null)
		{
			extent = new ExtentReports(System.getProperty("user.dir")+"\\test-output\\html\\extentReport.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\ExtentConfig.properties"));
		}
		
		return extent;
	}

}
