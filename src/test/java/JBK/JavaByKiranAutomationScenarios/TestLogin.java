package JBK.JavaByKiranAutomationScenarios;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin extends Base{

	@BeforeClass
	public void browser() throws Exception {
		Base.initializeBrowser();
	}
	
	@Test(priority=1)	
	public void validLogin() {
		//checking login with valid credentials 
		JBKLogin jbkL= new JBKLogin(driver);
		jbkL.validEmail();
		jbkL.correctPassword();
		jbkL.login();
		jbkL.validLoginKiran();
		jbkL.logout();
	}
	
	@Test (priority=2)		
	public void invalidLogin() {
		//Checking login with invalid email
		JBKLogin jbkL= new JBKLogin(driver);
		jbkL.inValilEmail();
		jbkL.correctPassword();
		jbkL.login();
		driver.navigate().refresh();
	}
	
	@Test (priority=3)		
	public void inCorrectPassword() {
		//Checking login with incorrect password
		JBKLogin jbkL= new JBKLogin(driver);
		jbkL.validEmail();
		jbkL.incorrectPassword();
		jbkL.login();
	}
	
	@Test (priority=4)		
	public void jbkTitle() {
		//Checking JBK title is correct or not
		JBKLogin jbkL= new JBKLogin(driver);
		jbkL.jbkTitleCheck();
	}
	
	@Test (priority=5)		
	public void jbkCourses() {
		//Checking JBK courses are correct or not
		JBKLogin jbkL= new JBKLogin(driver);
		jbkL.jbkCoursesCheck();
	}
}
