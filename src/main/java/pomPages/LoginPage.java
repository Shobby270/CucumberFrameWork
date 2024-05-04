package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailField;
	
	public void enterEmailAddress(String emailText)
	{
		
		elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;
	
	public void enterPassword(String passwordText)
	{
		
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	public AccountPage clickOnLoginButton() {
		
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
	private WebElement warningMessage;
	public String getWrningMessageText()
	{
		return elementUtils.getText(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
}
