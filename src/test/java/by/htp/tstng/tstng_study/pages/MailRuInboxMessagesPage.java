package by.htp.tstng.tstng_study.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailRuInboxMessagesPage extends AbstractPage {
	
	private final String BASE_URL = "https://e.mail.ru/messages/inbox/?back=1";
	
	@FindBy(xpath = "//div[@class=\"b-toolbar__item\"]/a")
	private WebElement buttonCompose;
	
	public MailRuInboxMessagesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void composeEmail() {
		buttonCompose.click();
	}

	@Override
	public void openPage() {
		
		driver.navigate().to(BASE_URL);
		
	}

}
