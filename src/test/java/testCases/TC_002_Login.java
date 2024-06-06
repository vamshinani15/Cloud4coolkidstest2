package testCases;

import java.io.IOException;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.Utils;

public class TC_002_Login extends BaseClass{

	@Test
	public void account_Login() throws IOException, InterruptedException {
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		DashboardPage dp=new DashboardPage(driver);
		hp.clcik_Login();
		hp.click_Login_Student();
		String file=System.getProperty("user.dir")+"/TestData/LoginData.xlsx";
		logger.info("***********Goto Excel Sheet**********");
		int rows=Utils.getRowCount(file, "Sheet1");
		logger.info("***********Read number of rows**********");
		for(int r=1;r<=rows;r++) {
			String mail=Utils.getCellData(file, "Sheet1", r, 0);
			String pwd=Utils.getCellData(file, "Sheet1", r, 1);
			lp.set_Email(mail);
			logger.info("***********Entered Email address**********");
			lp.set_Password(pwd);
			logger.info("***********Entered Password**********");
			lp.click_Login();
			logger.info("***********Login Successfull**********");
			dp.click_Mylearning();
			logger.info("***********Clicked on My Learning**********");
			dp.click_Course();
			logger.info("***********Clicked on Course**********");
			dp.click_Loginvdc();
			logger.info("***********Clicked on loginvdc**********");
			dp.click_sso();
			logger.info("***********Clicked on sso**********");
			lp.click_logout();
			logger.info("***********Logout Successfull**********");
			hp.clcik_Login();
			hp.click_Login_Student();
		}
	}
}
