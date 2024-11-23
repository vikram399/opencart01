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
import utilities.DataProviders;

public class TC_003LoginDDT  extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("***started TC_003******");
		
		
		HomePage hp= new HomePage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='My Account']")));
		element.click();
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPwd(pwd);
		lp.clickLoginbtn();
		
		
		MyAccountPage mcc = new MyAccountPage(driver);
		boolean targetpage = mcc.isMyPageExists();
		
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				mcc.clkLogout();
				Thread.sleep(3000);
				mcc.conLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}	
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				mcc.clkLogout();
				mcc.conLogout();
				Assert.assertTrue(false);
			}	
		}
		else
		{
			Assert.assertTrue(true);
			
		}
		
		
			Assert.fail();
		
		logger.info("***started TC_003******");
	}
}
