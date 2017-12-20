package by.htp.tstng.tstng_study.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailRuWriteEmailPage extends AbstractPage {
	
	private final String BASE_URL = " ";
	
	@FindBy(xpath = "//textarea[2]")
	private WebElement textareaTo;
	
	@FindBy(xpath = "//input[@name=\"Subject\"]")
	private WebElement inputSubjet;
	
	@FindBy(xpath = "//body[@id=\"tinymce\"]")
	private WebElement bodyEmailContent;
	
	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[3]/div/div[2]/div[1]/div/span")
	private WebElement buttonSend;
	
	@FindBy(xpath = "//*[@id=\"toolkit-151352026008142composeEditor_ifr\"]")
	private WebElement iframeTextContent;

	public MailRuWriteEmailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void writeAndSendEmail(String to, String subject, String emailContent) {
		textareaTo.sendKeys(to);
		inputSubjet.sendKeys(subject);
		
		numberOfIframes();

		driver.switchTo().frame(1);
		WebElement body = driver.findElement(By.tagName("body"));
		body.sendKeys(emailContent);
		driver.switchTo().defaultContent();

		buttonSend.click();
	}
	
	private void numberOfIframes () {
		
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);
		
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
