package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002LoginTest  extends BaseClass{
	

	@Test
	public void verify_Login() {
		logger.info("*******starting TC_002***********");
		try
		{
			
		HomePage hp= new HomePage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='My Account']")));
		element.click();
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email1"));
		lp.setPwd(p.getProperty("pwd1"));
		lp.clickLoginbtn();
		
		
		MyAccountPage mcc = new MyAccountPage(driver);
		boolean targetpage = mcc.isMyPageExists();
		
		//Assert.assertEquals(targetpage, true, "Login Faild");
		Assert.assertTrue(targetpage);
		
		logger.info("*******Finished TC_002***********");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	
	}
	
	
}
