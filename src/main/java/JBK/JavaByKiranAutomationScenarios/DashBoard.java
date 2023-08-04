package JBK.JavaByKiranAutomationScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {

	@FindBy (id = "email")  private WebElement email;
	@FindBy (id = "password")  private WebElement password;
	@FindBy (xpath = "//button[@type='submit']")  private WebElement login;
	@FindBy (xpath="//*[text()='Kiran']") private WebElement kiran;
	@FindBy (xpath="//section[2]/div") private WebElement courses;
	@FindBy (xpath="//section/ul") private WebElement navigationMenu;
	@FindBy (linkText="LOGOUT")private WebElement LOGOUT;
	
	public DashBoard ( WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void validEmail() {
		email.sendKeys("kiran@gmail.com");
	}
	
	public void correctPassword() {
		password.sendKeys("123456");
	}
	
	public void login() {
		login.click();
	}
	

	public void logout() {
		LOGOUT.click();
	}
	
	public void correctLoginWithKiran() {

		//Check login with Kiran
			
		String text = kiran.getText();
		System.out.println(text);
		if(text.equals("Kiran")) {
			System.out.println("Test Case is passed");
		}else {
			System.out.println("Test Case is failed");
		}
	}
	
	public void allCoursesUnderKiran() {
		//Check all courses appear under kiran 
			
		if(courses.isDisplayed()){
			
			System.out.println("Courses are displayed hence test case is passed");
		}
		else{
			System.out.println("Test Case is failed");
		}
	}
	
	public void checkSeleniuminCourse() {
		
		// Check course name one by one in courses 
			
		String course= courses.getText();
		
		if(course.contains("Selenium")){
			
			System.out.println("Selenium displayed hence test case is passed");
		}
		else{
			System.out.println("Test Case is failed");
		}
	}
	
	public void navigationMenu() {
		//Check all navigation menu appear 		
		
		String navigation=navigationMenu.getText();
		System.out.println(navigation);
		
		if(navigationMenu.isDisplayed()) {
			System.out.println("All Navigation menu options are displayed Hence test case is passed");
		}else {
			System.out.println("Test Case is failed");
		}
	
	}

	public void itemInNavigationMenu() {
		// Check item in navigation menu 
		
		String navigation=navigationMenu.getText();
		System.out.println(navigation);
		
		if(navigation.contains("Operators")) {
			System.out.println("Oprators is displayed in Navigation menu Hence test case is passed");
		}else {
			System.out.println("Test Case is failed");
		}
	}
	}