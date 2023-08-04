package JBK.JavaByKiranAutomationScenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PlanTestNGTestCaseDashBoard {

	WebDriver driver;
	@BeforeTest	
	public void browserInvoking() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();		
		driver.get("C:\\Users\\Sagar Paulkar\\Desktop\\Selenium Workspace\\Selenium Softwares\\Selenium Softwares\\Offline Website\\index.html");
		driver.manage().window().maximize();
	}

	@Test (priority=1)
	public void correctLoginWithKiran() {

		//To verify login with correct credentials on JBK website. 
				driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
				driver.findElement(By.id("password")).sendKeys("123456");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				WebElement loginWithKiran = driver.findElement(By.xpath("//*[text()='Kiran']"));
				System.out.println(loginWithKiran.getText());
				Assert.assertTrue(loginWithKiran.isDisplayed());
			}
	
	@Test (priority = 2)
	public void seleniumCourse() {
				WebElement sel=driver.findElement(By.xpath("//section[2]/div/div[1]/div/a"));
				Assert.assertTrue(sel.isSelected());
			}
	@Test (priority = 3)
	public void JavaJ2EECourse() {
				WebElement java= driver.findElement(By.xpath("//section[2]/div/div[2]/div/a"));
				Assert.assertTrue(java.isEnabled());
			}
	@Test (priority = 4)
	public void PythonCourse() {
				WebElement python=driver.findElement(By.xpath("//section[2]/div/div[3]/div/a"));
				Assert.assertTrue(python.isDisplayed());
			}
	@Test (priority = 5)
	public void PhpCourse() {
				WebElement php=driver.findElement(By.xpath("//section[2]/div/div[4]/div/a"));
				Assert.assertTrue(php.isDisplayed());
			}
	
	@Test (priority=6)
	public void navigationMenu() {
				//Check all navigation menu appear 		
				WebElement navigationMenu=driver.findElement(By.xpath("//section/ul"));
				String navigation=navigationMenu.getText();
				System.out.println(navigation);
				Assert.assertTrue(navigationMenu.isDisplayed());		
			}
	
	@Test (priority=7)	
	public void itemInNavigationMenu() {
		// Check item in navigation menu 
				WebElement navigationMenu=driver.findElement(By.xpath("//section/ul"));
				String navigation=navigationMenu.getText();
				Assert.assertTrue(navigation.contains("Operators"));
			
			}
}
