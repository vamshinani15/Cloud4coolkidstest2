package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy (xpath="//input[@id='email']")
	WebElement txt_email;
	
	@FindBy (xpath="//input[@id='password']")
	WebElement txt_password;
	
	@FindBy (xpath="//button[@id='btn-login']")
	WebElement btn_login;
	
	@FindBy (xpath="//header[@id='header']//i[@class='fa fa-sign-out']")
	WebElement btn_logout;
	
	public void set_Email(String mail) {
		txt_email.sendKeys(mail);
	}
	
	public void set_Password(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void click_Login() {
		btn_login.click();
	}
	
	public void click_logout() {
		btn_logout.click();
	}

}
