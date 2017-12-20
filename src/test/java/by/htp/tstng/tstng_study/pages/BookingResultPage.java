package by.htp.tstng.tstng_study.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingResultPage extends AbstractPage {
	
	private final String BASE_URL = " ";
	
	@FindBy(xpath = "//a[@data-title=\"Выберите валюту\"]")
	private WebElement aChooseCurrency;
	
	@FindBy(xpath = "//*[@id=\"currency_dropdown_top\"]/ul[1]/li[2]/a")
	private WebElement aUSCurrency;
	
	@FindBy(xpath = "//*[@id=\"filter_price\"]/div[2]/a[1]")
	private WebElement aBudgetUnder58$;
	
	@FindBy(xpath = "//*[@id=\"filterbox_options\"]/div/div[3]/div[2]/a[1]")
	private WebElement aPopularHotels;
	
	@FindBy(xpath = "//img[@alt=\"На русском\"]")
	private WebElement imgRussianLaguage;
	
	@FindBy(xpath = " //div[@id=\"current_language_foldout\"]/div[1]/ul[2]/li[1]/a")
	private WebElement aEnglishLanguage;
	
	@FindBy(xpath = "//div[@role=\"heading\"]/h1")
	private WebElement h1StringResult;
	
	@FindBy(xpath = "//*[@id=\"filter_price\"]/div[2]/a[1]/div/span[1]")
	private WebElement spanBudgetUnder58$;
	
	public BookingResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void chooseUSCurrency() {
		aChooseCurrency.click();
		aUSCurrency.click();
	}
	
	public void chooseAdditionalCriterias() {
		aBudgetUnder58$.click();
		aPopularHotels.click();
	}
	
	public void chooseUSLanguage() {
		imgRussianLaguage.click();
		aEnglishLanguage.click();
	}
	
	public int getQuantityOfResult() {
		String result = h1StringResult.getText().trim();
		int quantityOfResults = Integer.parseInt(result.replaceAll("[\\D]", ""));
		return quantityOfResults;
	}
	
	public String getLineOfUSPrice() {
		String lineOfUSPrice = spanBudgetUnder58$.getText();
		return lineOfUSPrice;
	}
	
	public List<WebElement> getListOfPopularCheckbox() {
		List<WebElement> listOfPopularCheckbox = driver.findElements(By.cssSelector("#filterbox_options > div > div:nth-child(3) > div.filteroptions > a"));
		return listOfPopularCheckbox;
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
