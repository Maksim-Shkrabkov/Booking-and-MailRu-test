package by.htp.tstng.tstng_study;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AppTest {
	
	private static final String DRIVER_FIREFOX = "webdriver.gecko.driver";
	private static final String DRIVER_PATH = "C:\\driver\\geckodriver.exe";
	
	private static final String TO_GOOGLE = "//div[@id=\"gs_lc0\"]/input";
	private static final String SEARCH_IN_GOOGLE_BUTTON = "//form[@id=\"tsf\"]/div[2]/div[3]/center/input[@type=\"submit\"][1]";
	
	private static final String TITLE_OF_THE_MAIN_NEWS_ON_TUTBY ="//div[@id=\"title_news_block\"]/div/h3/a/span[1]";
	private static final String IMG_OF_THE_MAIN_NEWS_ON_TUTBY = "//div[@id=\"title_news_block\"]/div/h3/a/img";
	private static final String PARAGRAPHS_IN_MAIN_NEWS_ON_TUT_BY = "//div[@id=\"article_body\"]/p";
	
	private static final String SVG_MENU_GAMBURGER_IT_ACADEMY = "//div[@class=\"asside-buttons\"]/a[2]/*[local-name()='svg']/*[local-name()='use']";
	private static final String LINK_ON_WHOM_TO_STUDY_IT_ACADEMY = "//div[@class=\"fix-section-block \"][4]/div/ul[2]/li/a";
	private static final String LIST_OF_MENU_NAMES = "//div[@class=\"white-block\"]/p/b";
	private static final String LINK_ON_ASP_NET_PAGE_IT_ACADEMY = "//div[@class=\"white-block\"]/p[8]/a";
	
	private static final String LOGIN_ON_REGISTRATION_PAGE_QUIZFUL = "//div[@class=\"content\"]/form/label[1]/input[@id=\"login\"]";
	private static final String PASSWORD_ON_REGISTRATION_PAGE_QUIZFUL = "//div[@class=\"content\"]/form/label[2]/input[@type=\"password\"]";
	private static final String REPASSWORD_ON_REGISTRATION_PAGE_QUIZFUL = "//div[@class=\"content\"]/form/label[3]/input[@name=\"registrationForm.repassword\"]";
	private static final String EMAIL_ON_REGISTRATION_PAGE_QUIZFUL = "//div[@class=\"content\"]/form/label[4]/input[@name=\"registrationForm.email\"]";
	private static final String CONFIRM_INFORMATION_BUTTON_IN_REGISTATION_FORM_ON_REGISTRATION_PAGE_QUIZFUL = "//div[@class=\"content\"]/form/p[@class=\"buttons\"]/input[@value=\"Завершить\"]";
	private static final String ERRORS_MESSAGE_ON_REGISTRATION_PAGE_QUIZFUL = "//div[@class=\"errors\"]";
	
	
	
	private static final String BUTTON_SIGN_IN_IN_ACCOUNT_ON_MAIN_PAGE_QUIZFUL = "//div[@id=\"header\"]/ul[@id=\"user-panel\"]/li[1]/a";
	
	private static final String LOGIN_ON_LOGIN_ACTION_LOGIN_FORM_PAGE = "//div[@id=\"login-form\"]/div[3]/form/label[1]/input[@id=\"login\"]";
	private static final String PASSWORD_ON_LOGIN_ACTION_LOGIN_FORM_PAGE = "//div[@id=\"login-form\"]/div[3]/form/label[2]/input[@type=\"password\"]";
	private static final String CHECKBOX_REMEMBER_ME_ON_LOGIN_ACTION_LOGIN_FORM_PAGE = "//div[@id=\"login-form\"]/div[3]/form/label[3]/input[@type=\"checkbox\"]";
	private static final String SIGN_IN_BUTTON_ON_LOGIN_ACTION_LOGIN_FORM_PAGE = "//div[@id=\"login-form\"]/div[3]/form/p/input[@type=\"submit\"]";
	
	private static final String NAME_OF_ACCOUNT_ON_TEST_PAGE = "//ul[@id=\"user-panel\"]/li[1]/b/a";
	private static final String EDIT_PROFILE_BUTTON_ON_USER_SETTINGS_PAGE = "//div[@id=\"middle\"]/div[2]/div[1]/div[2]/div[1]/a";
	
	private static final String IMG_PERSONAL_DATA_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-personal-form\"]/div[2]/img[@class=\"arrow \"]";
	private static final String NAME_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-personal-form\"]/div[3]/form/table/tbody/tr[1]/td[2]/input[@name=\"personalForm.name\"]";
	private static final String SURNAME_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-personal-form\"]/div[3]/form/table/tbody/tr[2]/td[2]/input[@name=\"personalForm.surname\"]";
	private static final String DATE_OF_BIRTHDAY_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-personal-form\"]/div[3]/form/table/tbody/tr[3]/td[2]/input[@name=\"personalForm.birthyear\"]";
	private static final String SITE_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-personal-form\"]/div[3]/form/table/tbody/tr[4]/td[2]/input[@name=\"personalForm.site\"]";
	private static final String COMPANY_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-personal-form\"]/div[3]/form/table/tbody/tr[5]/td[2]/input[@name=\"personalForm.company\"]";
	private static final String ABOUT_YOURSELF_TEXTAREA_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-personal-form\"]/div[3]/form/table/tbody/tr[6]/td[1]/textarea[@name=\"personalForm.about\"]";
	private static final String SELECT_COUNTRY_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-personal-form\"]/div[3]/form/table/tbody/tr[1]/td[4]/select[@name=\"personalForm.countryId\"]";
	private static final String SAVE_PERSONAL_DATA_CHANGES_BUTTON_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-personal-form\"]/div[3]/form/div[1]/input[@name=\"personalForm.save\"]";
	
	private static final String IMG_NOTICE_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"edit-profile-page\"]/div[5]/div[1]/img";
	private static final String ENABLE_NOTIFICATION_ON_PROFILE_ACTON_SETTINGS_PAGE = "//div[@id=\"edit-profile-page\"]/div[5]/div[2]/form/label/input[@name=\"notificationsForm.notificationsEnabled\"]";
	private static final String GET_EMAIL_DISTRIBUTION_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"edit-profile-page\"]/div[5]/div[2]/form/label[2]/input[@name=\"notificationsForm.deliveryEnabled\"]";
	private static final String SAVE_NOTIFICATIONS_CHANGES_BUTTON_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"edit-profile-page\"]/div[5]/div[2]/form/div[@class=\"buttons\"]/input[@name=\"notificationsForm.save\"]";
	
	private static final String IMG_CONFIDENTIALITY_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-privacy-form\"]/div[1]/img";
	private static final String ONLY_I_CHECKBOX_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-privacy-form\"]/div[2]/form/table/tbody/tr[4]/td/label/input[@name=\"privacyForm.profileVisibility\"]";
	private static final String SAVE_CONFIDENTIALITY_ON_PROFILE_ACTION_SETTINGS_PAGE = "//div[@id=\"profile-privacy-form\"]/div[2]/form/div/input[@name=\"privacyForm.save\"]";
	
	private WebDriver driver;
    
	@BeforeSuite(enabled = false)
	public void beforeSuite() {
		System.out.println("Before suite");
	}
	
	@BeforeClass(enabled = false)
	public void beforeClass() {
		System.out.println("Before class");
		System.setProperty(DRIVER_FIREFOX, DRIVER_PATH);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://www.google.com");
	}
	
	@BeforeMethod(enabled = false)
	public void beforeMethod() {
		System.out.println("Before method");
	}
	
	@BeforeTest(enabled = false)
	public void beforeTest() {
		System.out.println("Before test");
	}
	
	@Test(enabled = false)
	public void test1() {
		System.out.println("test1");
		
//		driver.get("https://www.tut.by");
//		String title = driver.getTitle();
//		assertEquals(title, "Белорусский портал TUT.BY. Новости Беларуси и мира");
		
		//Task1
		driver.get("https://www.google.by");
		WebElement element = driver.findElement(By.xpath(TO_GOOGLE));
		element.sendKeys("java");
		WebElement elementFind = driver.findElement(By.xpath(SEARCH_IN_GOOGLE_BUTTON));
		elementFind.click();
		String title = driver.getTitle();
		assertEquals(title, "java - Поиск в Google");
	}
	
	@Test(enabled = false)
	public void test2() {
		System.out.println("test2");
		
		//Task2
		driver.get("https://www.tut.by");
		WebElement element = driver.findElement(By.xpath(TITLE_OF_THE_MAIN_NEWS_ON_TUTBY));
		String nameOfnews = element.getText();
		System.out.println(nameOfnews);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement imgMainNew = driver.findElement(By.xpath(IMG_OF_THE_MAIN_NEWS_ON_TUTBY));
		imgMainNew.click();
		
		List<WebElement> pElementsInMainNews = driver.findElements(By.xpath(PARAGRAPHS_IN_MAIN_NEWS_ON_TUT_BY));
		int quantityOfPElemnetsInMainNew = pElementsInMainNews.size();
		System.out.println("Quantity of p elements in main news: " + quantityOfPElemnetsInMainNew);
		
	}
	
	@Test(enabled = false)
	public void test4() {
		//Task4
		driver.get("https://www.it-academy.by");
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement gamburger = driver.findElement(By.xpath(SVG_MENU_GAMBURGER_IT_ACADEMY));
		gamburger.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement lionWhomToStudy = driver.findElement(By.xpath(LINK_ON_WHOM_TO_STUDY_IT_ACADEMY));
		lionWhomToStudy.click();
		
		List<WebElement> bElements = driver.findElements(By.xpath(LIST_OF_MENU_NAMES));
		for(WebElement webElement: bElements) {
			System.out.println(webElement.getText());
		}
		System.out.println("Quantity of b elements: " + bElements.size());
		
		WebElement aspNet = driver.findElement(By.xpath(LINK_ON_ASP_NET_PAGE_IT_ACADEMY));
		aspNet.click();
		String title = driver.getTitle();
		assertEquals(title, "Курсы разработки ПО на ASP.NET в Минске, цены | ОЦ ПВТ");
		
	}
	
	@Test(enabled = false)
	public void test5() {
		//Task5
		driver.get("http://www.quizful.net/LoginAction.registration");
		String title = driver.getTitle();
		assertEquals(title, "Quizful - тесты онлайн");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement login = driver.findElement(By.xpath(LOGIN_ON_REGISTRATION_PAGE_QUIZFUL));
		login.sendKeys("Java_Megazord99");
		
		WebElement password = driver.findElement(By.xpath(PASSWORD_ON_REGISTRATION_PAGE_QUIZFUL));
		password.sendKeys("megazord99");
		
		WebElement repassword = driver.findElement(By.xpath(REPASSWORD_ON_REGISTRATION_PAGE_QUIZFUL));
		repassword.sendKeys("megazord99");
		
		WebElement email = driver.findElement(By.xpath(EMAIL_ON_REGISTRATION_PAGE_QUIZFUL));
		email.sendKeys("run@gmail.com");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		WebElement endRegistration = driver.findElement(By.xpath(CONFIRM_INFORMATION_BUTTON_IN_REGISTATION_FORM_ON_REGISTRATION_PAGE_QUIZFUL));
//		endRegistration.click();
		
		
	}
	
	@Test(enabled = false)
	public void test5Negative() {
		
		// Task5
		driver.get("http://www.quizful.net/LoginAction.registration");
		String title = driver.getTitle();
		assertEquals(title, "Quizful - тесты онлайн");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement login = driver.findElement(By.xpath(LOGIN_ON_REGISTRATION_PAGE_QUIZFUL));
		login.sendKeys("Java_Megazord99");

		WebElement password = driver.findElement(By.xpath(PASSWORD_ON_REGISTRATION_PAGE_QUIZFUL));
		password.sendKeys("megazord99");

		WebElement repassword = driver.findElement(By.xpath(REPASSWORD_ON_REGISTRATION_PAGE_QUIZFUL));
		repassword.sendKeys("megazord99");

		WebElement email = driver.findElement(By.xpath(EMAIL_ON_REGISTRATION_PAGE_QUIZFUL));
		email.sendKeys("megazord99@tut.by");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement endRegistration = driver.findElement(By.xpath(CONFIRM_INFORMATION_BUTTON_IN_REGISTATION_FORM_ON_REGISTRATION_PAGE_QUIZFUL));
		endRegistration.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement errorMessage = driver.findElement(By.xpath(ERRORS_MESSAGE_ON_REGISTRATION_PAGE_QUIZFUL));
		String error = errorMessage.getText();
		System.out.println("Текст ошибки: " + error);
		assertEquals(error, "Неправильное число");
		
	}
	
	@Test(enabled = false)
	public void test6() {
		//Task6
		driver.get("http://www.quizful.net/test");
		String title = driver.getTitle();
		assertEquals(title, "Quizful - тесты онлайн");
		
		WebElement signIn = driver.findElement(By.xpath(BUTTON_SIGN_IN_IN_ACCOUNT_ON_MAIN_PAGE_QUIZFUL));
		signIn.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Sign in to your account
		
		quizfulSignInToYourAccount();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Sign in to your account settings
		
		quizfulSignInToYourAccountSettings();
		
		//PersonalData
		
		quizfulSetPersonalData();
		
		//Notice
		
		quizfulSetNotice();
		
		//Сonfidentiality
		
		quizfulSetConfidentiality();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void quizfulSignInToYourAccount () {
		
		WebElement login = driver.findElement(By.xpath(LOGIN_ON_LOGIN_ACTION_LOGIN_FORM_PAGE));
		login.sendKeys("shkrab");
		
		WebElement password = driver.findElement(By.xpath(PASSWORD_ON_LOGIN_ACTION_LOGIN_FORM_PAGE));
		password.sendKeys("123maksim");
		
		WebElement checkbox = driver.findElement(By.xpath(CHECKBOX_REMEMBER_ME_ON_LOGIN_ACTION_LOGIN_FORM_PAGE));
		checkbox.click();
		
		WebElement signInAccount = driver.findElement(By.xpath(SIGN_IN_BUTTON_ON_LOGIN_ACTION_LOGIN_FORM_PAGE));
		signInAccount.click();
		
	}
	
	private void quizfulSignInToYourAccountSettings() {
		
		WebElement nameOfAccount = driver.findElement(By.xpath(NAME_OF_ACCOUNT_ON_TEST_PAGE));
		nameOfAccount.click();
		
		String titleOfAccount = driver.getTitle();
		assertEquals(titleOfAccount, "Профиль пользователя shkrab");
		
		WebElement editProfile = driver.findElement(By.xpath(EDIT_PROFILE_BUTTON_ON_USER_SETTINGS_PAGE));
		editProfile.click();
		
	}
	
	
	private void quizfulSetPersonalData() {
		
		WebElement imgPersonalData = driver.findElement(By.xpath(IMG_PERSONAL_DATA_ON_PROFILE_ACTION_SETTINGS_PAGE));
		imgPersonalData.click();
		
		WebElement nameOfUser = driver.findElement(By.xpath(NAME_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE));
		nameOfUser.sendKeys("Maksimio");
		
		WebElement surnameOfUser = driver.findElement(By.xpath(SURNAME_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE));
		surnameOfUser.sendKeys("DeShkrabinio");
		
		WebElement dateOfBirthdayUser = driver.findElement(By.xpath(DATE_OF_BIRTHDAY_ON_PROFILE_ACTION_SETTINGS_PAGE));
		dateOfBirthdayUser.sendKeys("1995");
		
		WebElement siteOfUser = driver.findElement(By.xpath(SITE_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE));
		siteOfUser.sendKeys("DeShkrabinoi.com");
		
		WebElement companyOfUser = driver.findElement(By.xpath(COMPANY_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE));
		companyOfUser.sendKeys("DeCompanyOfIt-Academy");
		
		WebElement aboutYuorself = driver.findElement(By.xpath(ABOUT_YOURSELF_TEXTAREA_ON_PROFILE_ACTION_SETTINGS_PAGE));
		aboutYuorself.sendKeys("Love is a lie and\r\n" + 
				"Love is a mess\r\n" + 
				"Telling the secrets of loneliness\r\n" + 
				"Our love survive\r\n" + 
				"How does love survive?\r\n" + 
				"Letters are written\r\n" + 
				"Words are spoken\r\n" + 
				"Some hearts are better left unbroken\r\n" + 
				"How will love survive\r\n" + 
				"How will love survive\r\n" + 
				"Little by little, step by step\r\n" + 
				"We were called the dirty pets\r\n" + 
				"Heart to heart and side by side\r\n" + 
				"Love will never hide");
		
		Select selCountryOfUser = new Select(driver.findElements(By.xpath(SELECT_COUNTRY_OF_USER_ON_PROFILE_ACTION_SETTINGS_PAGE)).get(0));
		selCountryOfUser.selectByVisibleText("Беларусь");
		
//		WebElement savePersonalDataChanges = driver.findElement(By.xpath(SAVE_PERSONAL_DATA_CHANGES_BUTTON_ON_PROFILE_ACTION_SETTINGS_PAGE));
//		savePersonalDataChanges.click();
		
		
	}
	
	private void quizfulSetNotice () {
		
//		WebElement editProfile = driver.findElement(By.xpath(EDIT_PROFILE_BUTTON_ON_USER_SETTINGS_PAGE));
//		editProfile.click();
		
		WebElement imgNotice = driver.findElement(By.xpath(IMG_NOTICE_ON_PROFILE_ACTION_SETTINGS_PAGE));
		imgNotice.click();
		
		if(driver.findElement(By.xpath(ENABLE_NOTIFICATION_ON_PROFILE_ACTON_SETTINGS_PAGE)).isSelected() && driver.findElement(By.xpath(GET_EMAIL_DISTRIBUTION_ON_PROFILE_ACTION_SETTINGS_PAGE)).isSelected()) {
			
			driver.findElement(By.xpath(ENABLE_NOTIFICATION_ON_PROFILE_ACTON_SETTINGS_PAGE)).click();
			driver.findElement(By.xpath(GET_EMAIL_DISTRIBUTION_ON_PROFILE_ACTION_SETTINGS_PAGE)).click();
			
//			driver.findElement(By.xpath(SAVE_NOTIFICATIONS_CHANGES_BUTTON_ON_PROFILE_ACTION_SETTINGS_PAGE)).click();
			
		}
		
	}
	
	private void quizfulSetConfidentiality () {
		
//		WebElement editProfile = driver.findElement(By.xpath(EDIT_PROFILE_BUTTON_ON_USER_SETTINGS_PAGE));
//		editProfile.click();
		
		WebElement imgPrivacy = driver.findElement(By.xpath(IMG_CONFIDENTIALITY_ON_PROFILE_ACTION_SETTINGS_PAGE));
		imgPrivacy.click();
		
		WebElement onlyICheckBox = driver.findElement(By.xpath(ONLY_I_CHECKBOX_ON_PROFILE_ACTION_SETTINGS_PAGE));
		onlyICheckBox.click();
		
//		driver.findElement(By.xpath(SAVE_CONFIDENTIALITY_ON_PROFILE_ACTION_SETTINGS_PAGE)).click();
		
	}
	
	
	@AfterSuite(enabled = false)
	public void afterSuite() {
		System.out.println("After suite");
	}
	
	@AfterClass(enabled = false)
	public void afterClass() {
		System.out.println("After class");
		
		driver.close();
		driver = null;
	}
	
	@AfterMethod(enabled = false)
	public void AfterMethod() {
	  System.out.println("After method");
	}
	
	@AfterTest(enabled = false)
	public void afterTest() {
		System.out.println("After test");
	}
	
	
	
}
