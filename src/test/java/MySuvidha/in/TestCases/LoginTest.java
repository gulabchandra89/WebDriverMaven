package MySuvidha.in.TestCases;

import java.applet.Applet;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import MySuvidha.in.base.TestBase;
import MySuvidha.in.utilities.TestUtil;

public class LoginTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider="CommonDP")
	public void loginTest(String username, String password) throws IOException {
		
				
		  type("loginid_xpath",username);
		  type("password_xpath",password);
		  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           // Assert.fail();
		   TestBase.VerifyEquals("Actual", "Expected");
		  
		  
		  
		// driver.findElement(By.xpath(orProperties.getProperty("loginbutton"))).click();

		// Assert.assertTrue(IsElementPresent(By.xpath(orProperties.getProperty("homebutton"))));
	}


}
