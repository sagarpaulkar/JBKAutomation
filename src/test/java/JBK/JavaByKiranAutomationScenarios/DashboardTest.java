package JBK.JavaByKiranAutomationScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DashboardTest extends Base {

	@BeforeTest
	public void loginToDashboard1() throws Exception {
		Base.initializeBrowser();
		WebElement email_element= driver.findElement(By.xpath("//input[@id= 'email']"));
		email_element.sendKeys("kiran@gmail.com");

		WebElement pwd_element= driver.findElement(By.xpath("//input[@id= 'password']"));
		pwd_element.sendKeys("123456");

		WebElement login_element=driver.findElement(By.xpath("//button[starts-with(text(),\"Sign In\")]"));
		login_element.click();
	}
	@Test
	public void dashboardTextFetch() {
		String dashboard_str =driver.findElement(By.xpath("/html/body/div/div[1]/section[1]/h1")).getText();
		System.out.println(dashboard_str);
	}
	@Test (priority = 1)
	public void seleniumCourse() {
		WebElement sel_Course = driver.findElement(By.xpath("//section[2]/div/div[1]/div/a"));
		sel_Course.click();
	}
	@Test (priority = 2)
	public void JavaJ2EECourse() {
		WebElement javaJ2ee_Course = driver.findElement(By.xpath("//section[2]/div/div[2]/div/a"));
		javaJ2ee_Course.click();
	}
	@Test (priority = 3)
	public void PythonCourse() {
		WebElement Pyth_Course = driver.findElement(By.xpath("//section[2]/div/div[3]/div/a"));
		Pyth_Course.click();
	}
	@Test (priority = 4)
	public void PhpCourse() {
		WebElement php_Course = driver.findElement(By.xpath("//section[2]/div/div[4]/div/a"));
		php_Course.click();
	}
}