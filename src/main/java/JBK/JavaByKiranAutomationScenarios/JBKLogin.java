package JBK.JavaByKiranAutomationScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JBKLogin {

	@FindBy (xpath = "/html/body/div/div[1]/a/b")  private WebElement jbkTitle;
	@FindBy (xpath = "/html/body/div/div[1]/a/h4")  private WebElement jbkCourses;
	@FindBy (id = "email")  private WebElement email;
	@FindBy (id = "password")  private WebElement password;
	@FindBy (xpath = "//button[@type='submit']")  private WebElement login;
	@FindBy (xpath = "//*[text()='Kiran']")  private WebElement kiran;
	@FindBy (linkText="LOGOUT")private WebElement LOGOUT;
	
	public JBKLogin ( WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	public void validEmail() {
		email.sendKeys("kiran@gmail.com");
	}
	public void inValilEmail() {
		email.sendKeys("kiran@gmail");
	}
	public void correctPassword() {
		password.sendKeys("123456");
	}
	public void incorrectPassword() {
		password.sendKeys("12345678");
	}
	public void login() {
		login.click();
	}
	
	public void logout() {
		LOGOUT.click();
	}
	public void jbkTitleCheck() {
		String jbk = jbkTitle.getText();
		System.out.println(jbkTitle.getText());
		
		if(jbk.equalsIgnoreCase("TheKiranAcademy")) {
			System.out.println("Test Case is passed");
		}else {
			System.out.println("Test Case is failed");
		}
	}
	public void jbkCoursesCheck() {
		String jbkCourse = jbkCourses.getText();
		System.out.println(jbkCourses.getText());
		
		if(jbkCourse.equalsIgnoreCase("JAVA | SELENIUM | PYTHON | AWS | SALESFORCE")) {
			System.out.println("Test Case is passed");
		}else {
			System.out.println("Test Case is failed");
		}
	}
	public void validLoginKiran() {
		String text = kiran.getText();
		if(text.equals("Kiran")) {
			System.out.println("Test Case is passed");
		}else {
			System.out.println("Test Case is failed");
		}
	}
	
}
