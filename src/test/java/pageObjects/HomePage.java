package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (xpath="//a[@class='theme-button-bg']")
	WebElement btn_Registration;
	
	@FindBy (xpath="//div[@id='registermodal']//p[text()='As Student']")
	WebElement btn_Student;
	
	@FindBy (xpath="//a[text()='Login']")
	WebElement btn_Login;
	
	@FindBy (xpath="//div[@id='loginmodal']//p[text()='As Student']")
	WebElement btn_Login_Student;
	
	public void click_Registration() {
		btn_Registration.click();
	}
	
	public void click_Student() {
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		btn_Student.click();
	}
	
	public void clcik_Login() {
		btn_Login.click();
	}
	
	public void click_Login_Student() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		btn_Login_Student.click();
	}

}
