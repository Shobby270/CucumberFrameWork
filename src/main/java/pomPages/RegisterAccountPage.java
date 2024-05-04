package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterAccountPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterAccountPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	public void enterFirstName(String firstName) {
		elementUtils.typeTextIntoElement(firstNameField, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	public void enterLirstName(String lastName) {
		elementUtils.typeTextIntoElement(lastNameField, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		
	}
	@FindBy(id = "input-email")
	private WebElement emailField;
	public void enterEmailAddress(String emailAddres) {
		elementUtils.typeTextIntoElement(emailField, emailAddres, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(id = "input-telephone")
	private WebElement telephonField;
	public void enterTelephoneField(String telephoneText) {
		elementUtils.typeTextIntoElement(telephonField, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	@FindBy(id = "input-password")
	private WebElement passwordField;
	public void enterPasswordField(String passowrsText) {
		elementUtils.typeTextIntoElement(passwordField, passowrsText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(id = "input-confirm")
	private WebElement confirmpasswordField;
	public void enterConfirmPasswordField(String confirmpassowrsText) {
		elementUtils.typeTextIntoElement(confirmpasswordField, confirmpassowrsText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyOption;
	public void selectPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	public AccountSuccessPage clickOncontinueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
		return new AccountSuccessPage(driver);
	}
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesToNewsLetterOption;
	public void selectYesNewsLetteroption() {
		elementUtils.clickOnElement(yesToNewsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	public String getWarningMessageText() {
		return elementUtils.getText(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	public String getFirstNameWarningMessage() {
		return elementUtils.getText(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	public String getLastNameWarningMessage() {
		return elementUtils.getText(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailFieldWarning;
	public String getEmailFieldWarningMessage() {
		return elementUtils.getText(emailFieldWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 
	}
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	public String getTelephoneWarningMessage() {
		return elementUtils.getText(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	public String getPasswordWarningMessage() {
		return elementUtils.getText(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 
	}
	
}
