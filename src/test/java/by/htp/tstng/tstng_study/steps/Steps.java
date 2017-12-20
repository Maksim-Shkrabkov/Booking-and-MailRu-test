package by.htp.tstng.tstng_study.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.htp.tstng.tstng_study.driver.DriverSingletone;
import by.htp.tstng.tstng_study.pages.MailRuMainPage;
import by.htp.tstng.tstng_study.pages.BookingMainPage;
import by.htp.tstng.tstng_study.pages.BookingResultPage;
import by.htp.tstng.tstng_study.pages.MailRuInboxMessagesPage;
import by.htp.tstng.tstng_study.pages.MailRuWriteEmailPage;

public class Steps {
	
	private WebDriver driver;
	
	public void initBrowser() {
		driver = DriverSingletone.getDriver();
	}
	
	public void closeDriver() {
		DriverSingletone.closeDriver();
	}
	
	public void sendEmailWithLoginUser(String username, String password, String to, String subject, String emailContent) {
		
		MailRuMainPage loginMailRu = new MailRuMainPage(driver);
		loginMailRu.openPage();
		loginMailRu.login(username, password);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MailRuInboxMessagesPage InboxEmailsMailRu = new MailRuInboxMessagesPage(driver);
		InboxEmailsMailRu.composeEmail();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MailRuWriteEmailPage WriteEmailPageMailRu = new MailRuWriteEmailPage(driver);
		WriteEmailPageMailRu.writeAndSendEmail(to, subject, emailContent);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectMinskPlaceOfRestBookingCom(String place) {
		BookingMainPage bookingMainPage = new BookingMainPage(driver);
		bookingMainPage.openPage();
		BookingResultPage bookingResultPage = bookingMainPage.inputTheSearchCondition(driver, place);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bookingResultPage.chooseAdditionalCriterias();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		bookingResultPage.chooseUSCurrency();
		System.out.println(bookingResultPage.getQuantityOfResult());
		
		
		
	}
	
	public boolean isMoreThen5Results(int minimalQuantity) {
		BookingResultPage bookingResultPage = new BookingResultPage(driver);
		int result = bookingResultPage.getQuantityOfResult();
		return result >= minimalQuantity;
	}
	
	public void findingResultWithoutPlaceOfPlacement(String place) {
		BookingMainPage bookingMainPage = new BookingMainPage(driver);
		bookingMainPage.openPage();
		bookingMainPage.inputTheSearchConditionWithoutPlaceOfPlacement(place);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isErrorMessagePlaceOfPlacement(String errorMessagePlaceOfPlacement) {
		BookingMainPage bookingMainPage = new BookingMainPage(driver);
		String errorMessage = bookingMainPage.errorMessagePlaceOfPlacement();
		System.out.println(errorMessage);
		return errorMessage.equals(errorMessagePlaceOfPlacement);
	}
	
	public void correctSymbolsInInputSeach(String symbols) {
		BookingMainPage bookingMainPage = new BookingMainPage(driver);
		bookingMainPage.openPage();
		bookingMainPage.inputCorrectSymbolsInInputSearchPlace(symbols);
	}
	
	public boolean isCorrectSymbolsInInputSeach(String correctSymbols) {
		BookingMainPage bookingMainPage = new BookingMainPage(driver);
		String result = bookingMainPage.getCorrectSymbolsFromInputSearchPlace();
		System.out.println(result);
		return result.equals(correctSymbols);
	}
	
	public void currencyIconClickable(String place) {
		BookingMainPage bookingMainPage = new BookingMainPage(driver);
		bookingMainPage.openPage();
		BookingResultPage bookingResultPage = bookingMainPage.inputTheSearchCondition(driver, place);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookingResultPage.chooseUSCurrency();
	}
	
	public boolean isCurrencyIconClickable(String correctUSlineOfPrice) {
		BookingResultPage bookingResultPage = new BookingResultPage(driver);
		String lineOfUSPrice = bookingResultPage.getLineOfUSPrice();
		System.out.println(lineOfUSPrice);
		return lineOfUSPrice.equals(correctUSlineOfPrice);
	}
	
	public void quantityOfPopularCheckbox(String place) {
		BookingMainPage bookingMainPage = new BookingMainPage(driver);
		bookingMainPage.openPage();
		BookingResultPage bookingResultPage = bookingMainPage.inputTheSearchCondition(driver, place);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isquantityOfPopularCheckboxEnought(int correctQuantityOfPopularCheckBoxs) {
		BookingResultPage bookingResultPage = new BookingResultPage(driver);
		List<WebElement> listOfPopularCheckBoxs = bookingResultPage.getListOfPopularCheckbox();
		int quantityOfPopularCheckBoxs = listOfPopularCheckBoxs.size();
		System.out.println(quantityOfPopularCheckBoxs);
		return quantityOfPopularCheckBoxs == correctQuantityOfPopularCheckBoxs;
	}
	
	
}
