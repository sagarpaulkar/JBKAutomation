package JBK.JavaByKiranAutomationScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PlanTestNGTestCaseLogin {

	WebDriver driver;
	@BeforeTest	
	public void browserInvoking() {
		
		// Browser invoking 
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();		
		driver.get("C:\\Users\\Sagar Paulkar\\Desktop\\Selenium Workspace\\Selenium Softwares\\Selenium Softwares\\Offline Website\\index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@Test (priority=1)
	public void correctLogin() {
		//To verify login with correct credentials on JBK website. 
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement loginWithKiran = driver.findElement(By.xpath("//*[text()='Kiran']"));
		System.out.println(loginWithKiran.getText());
		Assert.assertTrue(loginWithKiran.isDisplayed());
		driver.findElement(By.linkText("LOGOUT")).click();
		
	}
	
	@Test (priority=2)	
	public void invalidEmail() throws InterruptedException {
		//To verify correct email address should be taken on JBK website. 
		driver.findElement(By.id("email")).sendKeys("kiran@gmail");
		driver.findElement(By.id("password")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement errorEmail = driver.findElement(By.id("email_error"));
		System.out.println(errorEmail.getText());
		Assert.assertTrue(errorEmail.isDisplayed());	
		driver.navigate().refresh();
	}
	
	@Test (priority=3)
	
	public void incorrectPassword() {
		// To verify correct password should be taken on jbk website 
	
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement passwordError = driver.findElement(By.id("password_error"));
		Assert.assertTrue(passwordError.isDisplayed());
	}
	
	@Test (priority=4)
	public void jbkTitle() {
		//To verify "The Kiran Academy" on jbk website 
		WebElement jbkTitle = driver.findElement(By.xpath("/html/body/div/div[1]/a/b"));
		String jbk = jbkTitle.getText();
		System.out.println(jbk);
		Assert.assertEquals(jbk, "TheKiranAcademy");
	}
	
	@Test (priority=5)	
	public void jbkCourse() {
		//To verify "JAVA | SELENIUM | PYTHON | AWS | SALESFORCE" on jbk website 
		WebElement jbkCourses= driver.findElement(By.xpath("/html/body/div/div[1]/a/h4"));
		String jbkCourse = jbkCourses.getText();
		System.out.println(jbkCourse);
		Assert.assertEquals(jbkCourse, "JAVA | SELENIUM | PYTHON | AWS | SALESFORCE");
	}
	
	
}
