package by.htp.tstng.tstng_study;

import org.testng.annotations.Test;

import by.htp.tstng.tstng_study.steps.Steps;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class MailRuSendEmailAutomatizationTest {
  
	private Steps steps;
	private final String USERNAME = "bulbazavr.bulbazavrovich";
	private final String PASSWORD = "YourMyHeartYourMySoul";
	private final String TO = "tathtp@mail.ru";
	private final String SUBJECT = "Testing test";
	private final String EMAILCONTENT = "Maksim Shkrabkov link to git: https://github.com/Maksim-Shkrabkov";
	
	
    @BeforeMethod(enabled = false)/*(description = "Init browser")*/
    public void setUp() {
    	steps = new Steps();
		steps.initBrowser();
    }
  
  
    @Test(enabled = false)/*(description = "Send mail to Svetlana with github")*/
    public void oneCanSendEmail() {
    	steps.sendEmailWithLoginUser(USERNAME, PASSWORD, TO, SUBJECT, EMAILCONTENT);
    }

    @AfterMethod(enabled = false)
    public void stopBrowser() {
    	steps.closeDriver();
    }

}
