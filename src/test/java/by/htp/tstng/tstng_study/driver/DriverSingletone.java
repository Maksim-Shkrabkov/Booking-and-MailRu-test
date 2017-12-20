package by.htp.tstng.tstng_study.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingletone {
	
	private static WebDriver driver;
	private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
	private static final String GECKODRIVER_GECKODRIVER_EXE_PATH = "C:\\driver\\geckodriver.exe";
	
	public static WebDriver getDriver() {
		
		if (null == driver) {
			System.setProperty(WEBDRIVER_GECKO_DRIVER, GECKODRIVER_GECKODRIVER_EXE_PATH);
			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
		}
		
		return driver;
	}
	
	public static void closeDriver() {
		driver.quit();
		driver = null;
	}

}
