package pageObjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.google.common.io.Files;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy (xpath="//ul[@class='list-unstyled dashboard-left-menu']//a[text()='My Learning']")
	WebElement btn_learning;
	
	@FindBy (xpath="//h4[@class='inner-heading pb-2 mb-0']//a[text()='The Complete Web Developer Course 3.0']")
	WebElement btn_course;
	
	@FindBy (xpath="//a[text()='Login to VDC']")
	WebElement btn_loginvdc;
	//id="button-1066-btnInnerEl"
	@FindBy (xpath="//div[@id='visys_user_login-bodyWrap']//span[text()='Login SSO']")
	WebElement btn_realm;
	
	@FindBy (xpath="//input[@id='pveloginrealm-inputEl']")
	WebElement Drpdwn_tutor;
	
	@FindBy (xpath="//div[@id='pveloginrealm-picker']//li[text()='online-tutoring']")
	WebElement select_Tutor;
	
	//li[text()='online-tutoring']
	//table[@id='treeview-1013-record-494']//tbody//tr//td//div//div[2]
	// x-grid-item-selected
	@FindBy (xpath="//table[@class='x-grid-item']//tbody//tr//td//div//div[2]")
	WebElement select_vqin;
	//span[text()='vqindhdc1']
	@FindBy (xpath="//div[@id='ext-comp-1124-innerCt']//span[text()='Start']")
	WebElement btn_start;
	//table[@id='treeview-1013-record-505']//span[text()='131400 (Student-131400-131399)']
	@FindBy (xpath="//table[@id='treeview-1013-record-505']//span[text()='131400 (Student-131400-131399)']")
	WebElement select_id;
	
	@FindBy (id="userinfo-btnIconEl")
	WebElement btn_profile;
	
	@FindBy (xpath="//span[@id='menuitem-1035-textEl']")
	WebElement btn_vqin_logout;
	
	public void click_Mylearning() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		btn_learning.click();
		//btn_learning.click();
	}
	
	public void click_Course() {
		btn_course.click();
	}
	
	public void click_Loginvdc() {
		btn_loginvdc.click();
	}
	
	public void click_sso() throws InterruptedException, IOException {
		Set<String>tabs=driver.getWindowHandles();
		Iterator<String>ids=tabs.iterator();
		String parent=ids.next();
		String child=ids.next();
		Thread.sleep(5000);
		driver.switchTo().window(child);
		
		Drpdwn_tutor.click();
		select_Tutor.click();
		btn_realm.click();
		Thread.sleep(5000);
		select_vqin.click();
		//screenshot
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		String desti=System.getProperty("user.dir")+"\\screenshots\\"+timestamp+".png";
		Files.copy(source,new File(desti));
		Thread.sleep(5000);
		btn_profile.click();
		btn_vqin_logout.click();
		driver.switchTo().window(parent);
		
	}
	/*public void click_vqhdc() throws InterruptedException {
		Thread.sleep(5000);
		select_vqin.click();
		
	}
	
	public void click_logout() throws InterruptedException {
		Thread.sleep(5000);
		btn_profile.click();
		btn_vqin_logout.click();
		driver.switchTo().window(parent);
	}*/

}
