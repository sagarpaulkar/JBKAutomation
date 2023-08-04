package JBK.JavaByKiranAutomationScenarios;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDashBoard extends Base{

	@BeforeClass
	public void browser() throws Exception {
		Base.initializeBrowser();
	}
	
	@Test
	public void loginWithKiran() {
		DashBoard db=new DashBoard(driver);
		db.validEmail();
		db.correctPassword();
		db.login();
		db.correctLoginWithKiran();
		db.logout();
	}
	@Test
	public void allCourses() {
		DashBoard db=new DashBoard(driver);
		db.validEmail();
		db.correctPassword();
		db.login();
		db.allCoursesUnderKiran();
		db.logout();
	}
	@Test
	public void seleniumInCourse() {
		DashBoard db=new DashBoard(driver);
		db.validEmail();
		db.correctPassword();
		db.login();
		db.checkSeleniuminCourse();
		db.logout();
	}
	
	@Test	
	public void navigationMenu() {
		DashBoard db=new DashBoard(driver);
		db.validEmail();
		db.correctPassword();
		db.login();
		db.navigationMenu();
		db.logout();
	}
	
	@Test
	public void iteminNavigationMenu() {
		DashBoard db=new DashBoard(driver);
		db.validEmail();
		db.correctPassword();
		db.login();
		db.itemInNavigationMenu();
		db.logout();
	}
	
}
