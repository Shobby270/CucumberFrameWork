package stepdefinations;

import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pomPages.AccountPage;
import pomPages.HomePage;
import pomPages.LoginPage;
import utils.CommonUtils;

@SuppressWarnings("deprecation")
public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	
	@Given("User has navigate to login page")
	public void user_has_navigate_to_login_page() {
		
	    driver=DriverFactory.getDriver();
	    HomePage homePage = new HomePage(driver);
	    homePage.clickOnMyAccount();
	    loginPage=homePage.selectLoginOption();
		
		
		
	}

	@When("^User has enteres valid email address (.+) into email field$")
	public void user_has_enteres_valid_email_address_into_email_field(String emailText) {
		
		loginPage.enterEmailAddress(emailText);
	}

	@And("^User has enteres valid password (.+) into password field$")
	public void user_has_enteres_valid_password_into_password_field(String passwordText) {
		loginPage.enterPassword(passwordText);
	    
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		accountPage=loginPage.clickOnLoginButton();
		
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {

		
	    Assert.assertTrue(accountPage.accountOptionDisplay());
	}

	@When("User has enteres invalid email address into email field")
	public void user_has_enteres_invalid_email_address_into_email_field() {
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithtimeStamp());
	}

	@When("User has enteres invalid password {string} into password field")
	public void user_has_enteres_invalid_password_into_password_field(String invalidPasswordText) {
		loginPage.enterPassword(invalidPasswordText);
	}

	@Then("User should get propper warning message")
	public void user_should_get_propper_warning_message() {
		
		Assert.assertTrue(loginPage.getWrningMessageText().contains("Warning: No match for E-Mail Address and/or Password"));
	}

	
	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		loginPage.enterEmailAddress("");
		
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		
		loginPage.enterPassword("");
		
	}
	
}
