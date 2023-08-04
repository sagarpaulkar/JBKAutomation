package JBK.JavaByKiranAutomationScenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestOperators {

	public class TestUsers {
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
		@Test(priority=2)
		public void goToOperatorsPage() {
			//To verify that Operators section is open 
					driver.findElement(By.xpath("//*[text()='Operators']")).click();
					WebElement operatorsList= driver.findElement(By.xpath("//section[2]/div/div/div/div[1]/h3"));
					Assert.assertTrue(operatorsList.isDisplayed());
			
		}
		
		@Test (enabled = false)
		
		public void opratorsAccess() {
			WebElement tableElement = driver.findElement(By.xpath("//section[2]/div/div/div/div[2]/table"));
			
			int personNameColumnIndex = 1;
	        int accessListColumnIndex = 3;
	        
	        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
	        
	        for(int i=1;i<rows.size();i++) {
	        	WebElement row= rows.get(i);
	        	
	        	List<WebElement> cells = row.findElements(By.tagName("td"));
	        	
	        	if (cells.size() > personNameColumnIndex && cells.size() > accessListColumnIndex) {
	        		
	        		String personName = cells.get(personNameColumnIndex).getText();
	               
	                String accessList = cells.get(accessListColumnIndex).getText();
	                
	                if (accessList.contains("Whats App")&& accessList.contains("Phone Call")||accessList.contains("SMS") && accessList.contains("eMail")) {
	                 // if(accessList.contains("Whats App Only")) {	                
	                System.out.println("Detail Access List for" + personName + ": " + accessList);
	                } else {
	                    System.out.println("Access List for" + personName + ": " + accessList);
	                }
	        	}
	        }
		}
	
	@ Test (priority=3)	
	public void operatorsWorkingDays() {
		WebElement tableElement = driver.findElement(By.xpath("//section[2]/div/div/div/div[2]/table"));
		
		int personNameColumnIndex = 1;
        int timingsColumnIndex = 5;
        
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
        
        for(int i=1;i<rows.size();i++) {
        	WebElement row= rows.get(i);
        	
        	List<WebElement> cells = row.findElements(By.tagName("td"));
        	
        	if (cells.size() > personNameColumnIndex && cells.size() > timingsColumnIndex) {
        		
        		String personName = cells.get(personNameColumnIndex).getText();
               
                String workTime = cells.get(timingsColumnIndex).getText();
                
                if (workTime.contains("07:00 AM to 10:00 PM Monday-Sunday")) {                   
                System.out.println("Working day & time for " + personName + ": " + workTime);
                } 
                else if (workTime.contains("09:00 AM to 06:00 PM Monday-Saturday"))
                {
                    System.out.println("Working day & time for " + personName + ": " + workTime);
                }
                else if (workTime.contains("09:00 AM to 06:00 PM Monday to Friday and Sunday"))
                {
                    System.out.println("Working day & time for " + personName + ": " + workTime);
                }
                else 
                {
                    System.out.println("Working day & time for " + personName + ": " + workTime);
                }
        	}
        }
	}
}
}