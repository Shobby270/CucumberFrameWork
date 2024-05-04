package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils= new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	private WebElement myAccountDropMenu;
	
	public void clickOnMyAccount()
	{
		
		elementUtils.clickOnElement(myAccountDropMenu,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	@FindBy(xpath  = "(//a[contains(text(),'Login')])[1]")
	private WebElement loginOption;
	
	public LoginPage selectLoginOption()
	{
		
		elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	public RegisterAccountPage selectRegisterOption() {
		
		elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterAccountPage(driver);
	}
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBoxField;
	public void enterProductIntoSearchBox(String ProducText) {
		
		elementUtils.typeTextIntoElement(searchBoxField, ProducText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	@FindBy(xpath = "//button[contains(@class,'btn btn-default btn-lg')]")
	private WebElement searchButton;
	public SearchresultPage clickOnSearchButton() {
		
		elementUtils.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchresultPage(driver);
	}
	
}
