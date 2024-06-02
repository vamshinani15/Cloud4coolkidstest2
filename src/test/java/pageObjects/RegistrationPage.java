package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	public static Select Drpdwn;
	@FindBy (xpath="//input[@id='firstname']")
	WebElement txt_Firstname;
	
	@FindBy (xpath="//input[@id='lastname']")
	WebElement txt_Lastname;
	
	@FindBy (xpath="//input[@id='emailaddress']")
	WebElement txt_Email;
	
	@FindBy (xpath="//input[@id='mobilenumber']")
	WebElement txt_Mobile;
	
	@FindBy (xpath="//input[@id='address']")
	WebElement txt_Address;
	
	@FindBy (xpath="//select[@id='country']")
	WebElement btn_Country;
	
	@FindBy (xpath="//select[@id='state']")
	WebElement btn_State;
	
	@FindBy (xpath="//select[@id='city']")
	WebElement btn_City;
	
	@FindBy (xpath="//input[@id='password']")
	WebElement txt_Password;
	
	@FindBy (xpath="//input[@id='confirmpassword']")
	WebElement txt_ConfirmPassword;
	
	@FindBy (xpath="//label[@for='terms']")
	WebElement btn_TermsConditions;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement btn_Registration;
	
	public void set_Firstname(String firstname) {
		txt_Firstname.sendKeys(firstname);
	}
	
	public void set_Lastname(String lastname) {
		txt_Lastname.sendKeys(lastname);
	}
	
	public void set_Email(String email) {
		txt_Email.sendKeys(email);
	}
	
	public void set_Mobilenumber(String mobile) {
		txt_Mobile.sendKeys(mobile);
	}
	
	public void set_Address(String address) {
		txt_Address.sendKeys(address);
	}
	
	public void select_Country(String country) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", btn_Country);
		Drpdwn=new Select(btn_Country);
		Drpdwn.selectByVisibleText(country);
	}
	
	public void select_State(String state) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(btn_State));
		btn_State.click();
		Drpdwn=new Select(btn_State);
		Drpdwn.selectByVisibleText(state);
	}
	
	public void select_City(String city) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(btn_City));
		btn_City.click();
		Drpdwn=new Select(btn_City);
		Drpdwn.selectByVisibleText(city);
	}
	
	public void set_Password(String pwd) {
		txt_Password.sendKeys(pwd);
	}
	
	public void set_ConfirmPassword(String cnfpwd) {
		txt_ConfirmPassword.sendKeys(cnfpwd);
	}
	
	public void select_TermsConditions() {
		btn_TermsConditions.click();
	}
	
	public void click_Registration() {
		btn_Registration.click();
	}

}
