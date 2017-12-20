package by.htp.tstng.tstng_study.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailRuMainPage extends AbstractPage {
	
	private final String BASE_URL = "https://mail.ru/";
	
	@FindBy(id = "mailbox:login")
	private WebElement inputLogin;
	
	@FindBy(id = "mailbox:password")
	private WebElement inputPassword;
	
	@FindBy(xpath = "//input[@value=\"Войти\"]")
	private WebElement buttonSubmit;
	
	@FindBy(xpath = "//input[@name=\"saveauth\"]")
	private WebElement inputSaveAuthorization;

	public MailRuMainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void login(String username, String password) {
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		
		if (inputSaveAuthorization.isSelected()) {
			inputSaveAuthorization.click();
		}
		
		buttonSubmit.click();
	}
	
	@Override
	public void openPage() {
		
		driver.navigate().to(BASE_URL);
		
	}

}
