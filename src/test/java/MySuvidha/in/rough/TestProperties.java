package MySuvidha.in.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.sun.jna.platform.win32.Netapi32Util.User;

public class TestProperties {
	
	public static void main(String[] args) throws IOException {
		
		
		Properties prop= new Properties();
		Properties oRProperties= new Properties();
		
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
	
	prop.load(fis);
	
	
fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
	
oRProperties.load(fis);

   System.out.println(prop.getProperty("browser"));
   System.out.println(oRProperties.getProperty("loginid"));
		
	}
	

}

