package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage  extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath ="//h2[normalize-space()='My Account']")
WebElement msgHeading;

@FindBy(xpath ="//a[@class='list-group-item'][normalize-space()='Logout']")
WebElement lnkLogout;


@FindBy(xpath ="//a[normalize-space()='Continue']")
WebElement contLogout;

public boolean isMyPageExists()
{
	try
	{
	return (msgHeading.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
}

public void clkLogout()
{
	lnkLogout.click();
}
public void conLogout()
{
	contLogout.click();
}

}
