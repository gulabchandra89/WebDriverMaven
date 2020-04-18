package MySuvidha.in.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import MySuvidha.in.base.TestBase;
import MySuvidha.in.utilities.TestUtil;

public class SignUpTest extends TestBase{
	
	@Test(dataProviderClass = TestUtil.class, dataProvider="CommonDP")
	public void signUpTest(String firstName, String LastName, String MobileNumber, String Password) throws IOException	
	{		
		type("firstname_xpath",firstName);
		type("lastname_xpath",LastName);
		type("mobilenumber_xpath",MobileNumber);
		type("pass_xpath",Password);
		Reporter.log("Sign Up Test executed successfully");
		 
		  try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  		 
		  TestBase.VerifyEquals("Actual", "Expected");	  
	}

	
	
	
}
