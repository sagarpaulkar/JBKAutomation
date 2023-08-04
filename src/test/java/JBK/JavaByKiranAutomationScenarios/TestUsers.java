package JBK.JavaByKiranAutomationScenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
	public void goToUsersPage() {
		//To verify that Users section is open 
				driver.findElement(By.xpath("//*[text()='Users']")).click();
				WebElement UsersList= driver.findElement(By.xpath("//section[2]/div/div/div/div[1]/h3"));
				Assert.assertTrue(UsersList.isDisplayed());
		
	}
	
	@Test(priority=3)
	
	public void validationMobileNumberforPersons() {		
		WebElement tableElement = driver.findElement(By.xpath("//section[2]/div/div/div/div[2]/table"));
        // Assuming the person's name is in the 1st column and the mobile number is in the 2nd column,
        // adjust these indices accordingly
        int personNameColumnIndex = 1;
        int mobileNumberColumnIndex = 3;
        // Find all rows of the table
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
        // Iterate through each row (starting from the 2nd row to skip the header row)
        for (int i = 1; i < rows.size(); i++) {        	
            WebElement row = rows.get(i);
            // Find all cells in the current row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Check if the row contains the required number of cells
            if (cells.size() > personNameColumnIndex && cells.size() > mobileNumberColumnIndex) {
                // Extract the person's name from the specified column
                String personName = cells.get(personNameColumnIndex).getText();

                // Extract the mobile number from the specified column
                String mobileNumber = cells.get(mobileNumberColumnIndex).getText();

                // Remove any non-digit characters from the mobile number
                String digitsOnly = mobileNumber.replaceAll("[^0-9]", "");

                // Validate if the mobile number contains exactly 10 digits
                if (digitsOnly.length() == 10) {
                    System.out.println("Valid mobile number for " + personName + ": " + mobileNumber);
                } else {
                    System.out.println("Invalid mobile number for " + personName + ": " + mobileNumber);
                }
             }
            
        }
        System.out.println("*******************************************************************************************");
	}
	
	@Test(priority=4)
	public void validationEmailAddressforPersons() {
	
		 WebElement tableElement = driver.findElement(By.xpath("//section[2]/div/div/div/div[2]/table"));

	        // Assuming the person's name is in the 1st column and the email address is in the 3rd column,
	        // adjust these indices accordingly
	        int personNameColumnIndex = 1;
	        int emailAddressColumnIndex = 2;

	        // Find all rows of the table
	        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

	        // Iterate through each row (starting from the 2nd row to skip the header row)
	        for (int i = 1; i < rows.size(); i++) {
	            WebElement row = rows.get(i);

	            // Find all cells in the current row
	            List<WebElement> cells = row.findElements(By.tagName("td"));

	            // Check if the row contains the required number of cells
	            if (cells.size() > personNameColumnIndex && cells.size() > emailAddressColumnIndex) {
	                // Extract the person's name from the specified column
	                String personName = cells.get(personNameColumnIndex).getText();
	                // Extract the email address from the specified column
	                String emailAddress = cells.get(emailAddressColumnIndex).getText();

	                // Validate if the email address contains "gmail"
	                if (emailAddress.toLowerCase().contains("gmail")) {
	                    System.out.println("Valid Gmail address for " + personName + ": " + emailAddress);
	                } else {
	                    System.out.println("Invalid Gmail address for " + personName + ": " + emailAddress);
	                }
	            }
	
	}
	        System.out.println("*******************************************************************************************");
	   }
	@Test(priority=5)
	
	public void validationGenderforPersons() {
		
		WebElement tableElement = driver.findElement(By.xpath("//section[2]/div/div/div/div[2]/table"));

        // Assuming the person's name is in the 1st column and the gender is in the 4th column,
        // adjust these indices accordingly
        int personNameColumnIndex = 1;
        int genderColumnIndex = 5;

        // Find all rows of the table
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

        // Iterate through each row (starting from the 2nd row to skip the header row)
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);

            // Find all cells in the current row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Check if the row contains the required number of cells
            if (cells.size() > personNameColumnIndex && cells.size() > genderColumnIndex) {
                // Extract the person's name from the specified column
                String personName = cells.get(personNameColumnIndex).getText();

                // Extract the gender from the specified column
                String gender = cells.get(genderColumnIndex).getText();

                // Validate if the gender is either "male" or "female" (case-insensitive)
                if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                    System.out.println("Valid gender for " + personName + ": " + gender);
                } else {
                    System.out.println("Invalid gender for " + personName + ": " + gender);
                }
            }
        }
	}
	
	@Test (priority=6)
	
	public void validationMobileNumberforKiran() {
		
		WebElement personName = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
		
		String person=personName.getText();
		
		WebElement mobileNumber= driver.findElement(By.xpath("//table/tbody/tr[2]/td[4]"));
		
		String mobile=mobileNumber.getText();
		
		String digitsOnly = mobile.replaceAll("[^0-9]", "");
		
		Assert.assertTrue((digitsOnly.length()==10) && (person.contains("Kiran")));
		
    }
		
	
}



