package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchresultPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public SearchresultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtils=new ElementUtils(driver);
	}
	@FindBy(xpath = "//input[@name='search']")
	private WebElement validHPProduct;
	public boolean displayStatusOfValidProduct() {
		return elementUtils.displayStatusOfElement(validHPProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement productWarningMessage;
	public String getNoValidProductMessegeText() {
		return elementUtils.getText(productWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
}
