package by.htp.tstng.tstng_study.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingMainPage extends AbstractPage {
	
	private final String BASE_URL = "https://www.booking.com/";
	
	@FindBy(xpath = "//form[@id=\"frm\"]/div[@class=\"sb-searchbox__row u-clearfix \"]/div[1]/div[1]/input[1]")
	private WebElement inputSeachPlace;
	
	@FindBy(xpath = "//li[@data-i=\"0\"]")
	private WebElement liMinskRegion;
	
	@FindBy(xpath = "//div[@class=\\\"sb-dates__col --checkin-field\\\"]/div[@class=\\\"sb-date-field__display\\\"]")
	private WebElement divcheckIn;
	
	@FindBy(xpath = "//div[@class=\\\"sb-dates__col --checkout-field\\\"]/div[@class=\\\"sb-date-field__display\\\"]")
	private WebElement divcheckOut;
	
	@FindBy(xpath = "//td[@data-id=\"1514678400000\"]")
	private WebElement span31InCheckInCalendar;
	
	@FindBy(xpath= "//td[@data-id=\\\"1514764800000\\\"]/span")
	private WebElement span1InCheckOutCalendar;
	
	@FindBy(xpath = "//button[@class=\"sb-searchbox__button   \"]/span[text()=\"Проверить цены\"]")
	private WebElement buttonSearch;
	
	@FindBy(xpath = "//form[@id=\"frm\"]/div[2]/div/div[2]/div")
	private WebElement divErrorMessage;
	
	public BookingMainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public BookingResultPage inputTheSearchCondition(WebDriver driver, String place) {
		inputSeachPlace.sendKeys(place);
		liMinskRegion.click();
		span31InCheckInCalendar.click();
		buttonSearch.click();
		BookingResultPage bookingResultPage = new BookingResultPage(driver);
		return bookingResultPage;
	}
	
	public void inputTheSearchConditionWithoutPlaceOfPlacement(String place) {
		inputSeachPlace.sendKeys(place);
		liMinskRegion.click();
		span31InCheckInCalendar.click();
		inputSeachPlace.clear();
		buttonSearch.click();
	}
	
	public void inputCorrectSymbolsInInputSearchPlace(String place) {
		inputSeachPlace.sendKeys(place);
	}
	
	public String getCorrectSymbolsFromInputSearchPlace() {
		String correctSymbolsInInputSearchPlace = inputSeachPlace.getAttribute("value");
		return correctSymbolsInInputSearchPlace;
	}
	
	public String errorMessagePlaceOfPlacement() {
		String errorMessagePlaceOfPlacement = divErrorMessage.getText();
		return errorMessagePlaceOfPlacement;
	}
	
	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
