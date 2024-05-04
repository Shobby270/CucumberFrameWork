package stepdefinations;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pomPages.HomePage;
import pomPages.SearchresultPage;

@SuppressWarnings("deprecation")
public class Search {
	WebDriver driver;
	private HomePage homePage;
	private SearchresultPage searchResultPage;
	
	
	@Given("User opens the Application")
	public void user_opens_the_application() {
		
	   driver= DriverFactory.getDriver();
	   homePage=new HomePage(driver);
	}

	@When("User enteres valid product {string} into search box field")
	public void user_enteres_valid_product_into_search_box_field(String validProductText) {
		//homePage=new HomePage(driver);
		homePage.enterProductIntoSearchBox(validProductText);
	    
	    
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		searchResultPage=homePage.clickOnSearchButton();
	  
	}

	@Then("User should get valid product")
	public void user_should_get_valid_product() {
		
		Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());
	}

	@When("User enteres invalid product {string} into search box field")
	public void user_enteres_invalid_product_into_search_box_field(String invalidProductText) {
		//homePage = new HomePage(driver);
		homePage.enterProductIntoSearchBox(invalidProductText);
	    
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
	    Assert.assertEquals("There is no product that matches the search criteria.", searchResultPage.getNoValidProductMessegeText());
	}

	@When("User dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
	    //Kept blank  intentionally 
		//homePage = new HomePage(driver);
	}

}
