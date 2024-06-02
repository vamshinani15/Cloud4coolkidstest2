package testCases;

import java.io.IOException;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.Utils;

public class TC_002_Login extends BaseClass{

	@Test
	public void account_Login() throws IOException {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		hp.clcik_Login();
		hp.click_Login_Student();
		String file=System.getProperty("user.dir")+"/TestData/DemoLogin.xlsx";
		logger.info("***********Goto Excel Sheet**********");
		int rows=Utils.getRowCount(file, "Sheet1");
		logger.info("***********Read number of rows**********");
		for(int r=1;r<rows;r++) {
			String mail=Utils.getCellData(file, "Sheet1", r, 0);
			String pwd=Utils.getCellData(file, "Sheet1", r, 1);
			lp.set_Email(mail);
			logger.info("***********Entered Email address**********");
			lp.set_Password(pwd);
			logger.info("***********Entered Password**********");
			lp.click_Login();
			logger.info("***********Login Successfull**********");
			lp.click_logout();
			logger.info("***********Logout Successfull**********");
		}
	}
}
