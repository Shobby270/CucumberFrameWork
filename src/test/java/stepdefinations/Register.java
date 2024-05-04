package stepdefinations;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pomPages.AccountSuccessPage;
import pomPages.HomePage;
import pomPages.RegisterAccountPage;
import utils.CommonUtils;

@SuppressWarnings("deprecation")
public class Register {
	
	WebDriver driver;
	private RegisterAccountPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	
	

@Given("User navigates to register Account page")
public void user_navigates_to_register_account_page() {

   driver=DriverFactory.getDriver();
   HomePage homePage= new HomePage(driver);
   homePage.clickOnMyAccount();
   registerPage = homePage.selectRegisterOption();
  
}

@When("User enters the details into below fields")
public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	
	Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	commonUtils = new CommonUtils();
	registerPage.enterFirstName(dataMap.get("firstName"));
	registerPage.enterLirstName(dataMap.get("lastname"));
	registerPage.enterEmailAddress(commonUtils.getEmailWithtimeStamp());
	registerPage.enterTelephoneField(dataMap.get("telephone"));
	registerPage.enterPasswordField(dataMap.get("password"));
	registerPage.enterConfirmPasswordField(dataMap.get("password"));
	
    
}

@When("User enters the details into below fields with duplicate email")
public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
	
	Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	
	registerPage.enterFirstName(dataMap.get("firstName"));
	registerPage.enterLirstName(dataMap.get("lastname"));
	registerPage.enterEmailAddress(dataMap.get("email"));
	registerPage.enterTelephoneField(dataMap.get("telephone"));
	registerPage.enterPasswordField(dataMap.get("password"));
	registerPage.enterConfirmPasswordField(dataMap.get("password"));
	
    
}

@When("User selects Privacy Policy")
public void user_selects_privacy_policy() {
	
	registerPage.selectPrivacyPolicy();
    
}


@When("User clicks on Continue button")
public void user_clicks_on_continue_button() {
	
	accountSuccessPage=registerPage.clickOncontinueButton();
  
}


@Then("User account should get created successfully")
public void user_account_should_get_created_successfully() {
	
	
	Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageHeading());
}
@When("User selects Yes for Newsletter")
public void user_selects_yes_for_newsletter() {
	
	registerPage.selectYesNewsLetteroption();
    
}





@Then("User should get propper wrning about duplicate email")
public void user_should_get_propper_wrning_about_duplicate_email() {
    Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
}

@When("User dont enter any details into fields")
public void user_dont_enter_any_details_into_fields() {
    // no need to write any code here intentionally left
	//registerPage = new RegisterAccountPage(driver);
}

@Then("User should get propper wrning messages for mandatory fields")
public void user_should_get_propper_wrning_messages_for_mandatory_fields() {
	 Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
	 
	 Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarningMessage());
	 Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarningMessage());
	 Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailFieldWarningMessage());
	 Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarningMessage());
	 Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarningMessage());
}


}
