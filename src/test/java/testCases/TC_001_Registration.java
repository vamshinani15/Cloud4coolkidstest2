package testCases;

import java.io.IOException;

import org.testng.annotations.*;


import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;
import utilities.Utils;

public class TC_001_Registration extends BaseClass{
	
	@Test
	public void Registration() throws IOException {
		HomePage hp=new HomePage(driver);
		RegistrationPage rp=new RegistrationPage(driver);
		hp.click_Registration();
		logger.info("***********Clicked on Registration**********");
		hp.click_Student();
		logger.info("***********Selected Student**********");
		String file=System.getProperty("user.dir")+"/TestData/RegistrationData.xlsx";
		logger.info("***********Goto Excel sheet**********");
		int rows=Utils.getRowCount(file, "Sheet1");
		logger.info("**********Read numer of rows in excel sheet**********");
		for(int r=1;r<12;r++) {
			//read
			String fname=Utils.getCellData(file, "Sheet1", r, 0);
			String lastname=Utils.getCellData(file, "Sheet1", r, 1);
			String email=Utils.getCellData(file, "Sheet1", r, 2);
			String mobilenumber=Utils.getCellData(file, "Sheet1", r, 3);
			String address=Utils.getCellData(file, "Sheet1", r, 4);
			String country=Utils.getCellData(file, "Sheet1", r, 5);
			String state=Utils.getCellData(file, "Sheet1", r, 6);
			String city=Utils.getCellData(file, "Sheet1", r, 7);
			String pwd=Utils.getCellData(file, "Sheet1", r, 8);
			String cnfpwd=Utils.getCellData(file, "Sheet1", r, 9);

		rp.set_Firstname(fname);
		logger.info("***********Entered firstname**********");
		rp.set_Lastname(lastname);
		logger.info("**********Entered lastname***********");
		rp.set_Email(email);
		logger.info("***********Entered email**********");
		rp.set_Mobilenumber(mobilenumber);
		logger.info("***********Entered mobilenumber**********");
		rp.set_Address(address);
		logger.info("***********Entered address**********");
		rp.select_Country(country);
		logger.info("***********selected country**********");
		rp.select_State(state);
		logger.info("***********selected state**********");
		rp.select_City(city);
		logger.info("***********selected City**********");
		rp.set_Password(pwd);
		logger.info("***********Entered Password**********");
		rp.set_ConfirmPassword(cnfpwd);
		logger.info("***********Entered Confirm Password**********");
		rp.select_TermsConditions();
		logger.info("***********Terms & Conditions selected**********");
		rp.click_Registration();
		logger.info("**********Registration Completed**********");
		driver.navigate().to("https://cloud4coolkids.com/");
		hp.click_Registration();
		logger.info("***********Clicked on Registration**********");
		hp.click_Student();
		logger.info("***********Selected Student**********");
		}
	}

}
