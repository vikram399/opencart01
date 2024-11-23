package testCases;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;


public class TC_001AccountRegistrationTest  extends BaseClass{

	@Test
	public void verify_account_registratoin() throws InterruptedException 
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='My Account']")));
		element.click();
			
		HomePage hp=new HomePage(driver);
		//Thread.sleep(3000);
		
		hp.clickMyAccount();
		hp.clickRegister();
	
		logger.info("****starting TC_001AccountRegistration****");
		
		AccountRegistration ap=new AccountRegistration(driver);
		
		ap.setFirstName("vikram");
		ap.setLastName("kadari");
		
		logger.info("****providing details****");
		
		
		String ird =ap.generateRandomString(10); 
		ap.setEmail(ird+"@gmail.com");
		ap.setPassword("123474658");
		
		logger.info("****waiting****");
		Thread.sleep(3000);

		ap.clickAgreeButton();
		ap.clickcontinueButton();
		
		logger.info("****validating exp message****");
		String conformesg=ap.getConformesg();
		try
		{
		if(conformesg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		Assert.assertEquals(conformesg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		
		logger.info("Finished TC_001");
	}
		    

}

    

   
    


	
	
	
	
	

