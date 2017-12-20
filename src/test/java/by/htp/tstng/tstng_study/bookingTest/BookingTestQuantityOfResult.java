package by.htp.tstng.tstng_study.bookingTest;

import org.testng.annotations.Test;

import by.htp.tstng.tstng_study.steps.Steps;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;

public class BookingTestQuantityOfResult {
  
	private Steps steps;
	private static final String PLACE_OF_SEARCH = "Minsk";
	private static final int MINIMAL_QUANTITY_OF_RESULTS = 5;
	private static final String ERROR_MESSAGE_PLACE_OF_PLACEMENT = " Введите направление./nНе знаете, куда поехать? Найдите идеальное место для поездки.";
	private static final String CORRECT_SYMBOLS_FOR_INPUT_SEARCH_PLACE = "Malaga 1234";
	private static final String CORRECT_LINE_OF_US_PRICE = "US$0 - US$59 за ночь";
	private static final int CORRECT_QUANTITY_OF_POPULAR_CHECKBOX = 7;
	
	@BeforeMethod(description = "Init browser")
	public void beforeMethod() {
		steps = new Steps();
		steps.initBrowser();
	}
  
	@Test(enabled = false)/*(description = "Choose Minsk in condition of search on Booking.com and checking results more then 5")*/
	public void testquantityOfResults() {
		steps.selectMinskPlaceOfRestBookingCom(PLACE_OF_SEARCH);
		assertTrue(steps.isMoreThen5Results(MINIMAL_QUANTITY_OF_RESULTS));
	}
	
	@Test(enabled = false)/*(description = "Destination, property name or address' field should accept letters and digits")*/
	public void testinputSeachPlaceOnCorrectChars() {
		steps.correctSymbolsInInputSeach(CORRECT_SYMBOLS_FOR_INPUT_SEARCH_PLACE);
		assertTrue(steps.isCorrectSymbolsInInputSeach(CORRECT_SYMBOLS_FOR_INPUT_SEARCH_PLACE));
	}
	
	@Test(enabled = false)/*(description = "Destination, property name or address' field cannot be empty -> Error is shown")*/
	public void testerrorMessagePlaceOfPlacement() {
		steps.findingResultWithoutPlaceOfPlacement(PLACE_OF_SEARCH);
		assertTrue(steps.isErrorMessagePlaceOfPlacement(ERROR_MESSAGE_PLACE_OF_PLACEMENT));
	}
	
	@Test(enabled = false)/*(description = "Currency icon (in the header) should be clickable and user can change currency to the required one")*/
	public void testClickablCurrencyIcon() {
		steps.currencyIconClickable(PLACE_OF_SEARCH);
		assertTrue(steps.isCurrencyIconClickable(CORRECT_LINE_OF_US_PRICE));
	}
	
	@Test(enabled = false)/*(description = "'Popular' optional filter should contain 7 checkboxes")*/
	public void testQuantityOfPopular() {
		steps.quantityOfPopularCheckbox(PLACE_OF_SEARCH);
		assertTrue(steps.isquantityOfPopularCheckboxEnought(CORRECT_QUANTITY_OF_POPULAR_CHECKBOX));
	}

	@AfterMethod
	public void afterMethod() {
		steps.closeDriver();
	}

}
