package MySuvidha.in.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import MySuvidha.in.utilities.TestConfig;
import MySuvidha.in.utilities.monitoringMail;

public class TestHostAdd {

	public static void main(String[] args) throws UnknownHostException, AddressException, MessagingException {
		monitoringMail mail= new monitoringMail();
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		
		String messageBody= "http://"+ InetAddress.getLocalHost().getHostAddress()+ ":8080/job/DataDrivenProject/Extent_20Report/";

		System.out.println(messageBody);
		
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
	}

}
