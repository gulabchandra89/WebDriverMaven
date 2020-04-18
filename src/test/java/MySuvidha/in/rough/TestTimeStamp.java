package MySuvidha.in.rough;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.SkipException;

import MySuvidha.in.utilities.TestUtil;

public class TestTimeStamp {
	
	public static void main(String[] args)
	
	{		
		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime d = LocalDateTime.now();  
		   String screenshotName; //dtf.format(now);
		   System.out.println(d);
		   screenshotName= d.toString().replace('/', '_').replace(':', '_').replace(' ', '_')+".jpg";
		   System.out.println(screenshotName);
	
	
		  /* 
		   
		   if(!TestUtil.isSuiteRunnable("LoginTest", excelReader))
			{ System.out.println(TestUtil.isSuiteRunnable("LoginTest", excelReader));
				throw new SkipException("Skipping the test " +"LoginTest".toUpperCase() +" as the run mode is NO");
			}
			
			
				if(!TestUtil.isSuiteRunnable("signUpTest", excelReader))
		{ System.out.println(TestUtil.isSuiteRunnable("LoginTest", excelReader));
			throw new SkipException("Skipping the test " +"signUpTest".toUpperCase() +" as the run mode is NO");
		}
			
			*/
	}
	

}
