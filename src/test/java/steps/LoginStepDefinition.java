package steps;

import org.openqa.selenium.support.PageFactory;



import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.DatabasePage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase {
	  LoginPage loginPage;
	  DatabasePage databasePage;
	  
	  @Before
	  public void beforeRun() {
		  initDriver();
		  loginPage = PageFactory.initElements(driver,LoginPage.class);
		  databasePage = new DatabasePage();
		  }
	@Given ("^User is on techfios login page$")
	public void User_is_on_techfios_login_page(){
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		}
	
	@When ("^User enters username as \"([^\"]*)\"$")
	public void User_enters_username_as(String username) throws Throwable {
		loginPage.enterUserName(username);
		Thread.sleep(3000);
				}
	
	@When ("^User enters password as \"([^\"]*)\"$")
	public void User_enters_password_as(String password)throws Throwable {
		loginPage.enterPassword(password);
		Thread.sleep(3000);
		}
	
	@And ("^User clicks on Signin button$")
	public void User_clicks_on_Signin_button() throws Throwable {
		loginPage.clickSignInButton();
		Thread.sleep(5000);
		}
	
	@And("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_on (String button)throws Throwable {
		switch(button) {
		case "signin":
			loginPage.clickSignInButton();
			Thread.sleep(3000);
			break;
		case "bankCash":
			loginPage.clickSignInButton();
			Thread.sleep(3000);
			break;
		default : 
			System.out.println("unable to click");
			break;
			}
	}
	
	@When("^User enters \"([^\"]*)\" from mysql database$")
	public void user_enters_from_mysql_database(String data) throws Throwable {
		switch(data) {
		case "username":
			System.out.println("Username from DB: "+ databasePage.getData("username") );
			loginPage.enterUserName(databasePage.getData("username"));
			Thread.sleep(5000);
			break;
			
		case "password":
			System.out.println("Password from DB: "+ databasePage.getData("password") );
			loginPage.enterPassword(databasePage.getData("password"));
			Thread.sleep(5000);
			break;
			
		default: System.out.println("Unable to enter data");
		
		}
	    
	}
	
	
	@Then ("^User should land on Dashboard page$")
	public void User_should_land_on_Dashboard_page()throws Throwable {
		String expectedTitle = "Dashboard- iBilling";
		//String expectedTitle = " Dashboard ";
		String actualTitle = loginPage.getPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
		takeScreenshot(driver);
		
		}
	
	@After
	public void tearDown() {
		 driver.close();
		 driver.quit();
		}
	}

