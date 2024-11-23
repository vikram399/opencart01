package pageObjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration  extends BasePage{

	
	 public AccountRegistration(WebDriver driver)
	 {
		 super (driver);
	 }
	 
	 
	 

	 
@FindBy(xpath="//input[@id='input-firstname']")
WebElement firstName;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement lastName;
@FindBy(xpath="//input[@id='input-email']")
WebElement eMail;
@FindBy(xpath="//input[@id='input-password']") 
WebElement password;
@FindBy(xpath="//input[@name='agree']")
WebElement agree;
@FindBy(xpath="//button[normalize-space()='Continue']")
WebElement continu;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement yourAccountHasBeenCreated;

public void setFirstName(String fname)
{
	firstName.sendKeys(fname);									
}
public void setLastName(String lname)
{
	lastName.sendKeys(lname);
}
public void setEmail(String eMal)
{
	eMail.sendKeys(eMal);
}
public void setPassword(String pAssword)
{
	password.sendKeys(pAssword);
}
public void clickAgreeButton()
{
	agree.click();
}
public void clickcontinueButton()
{
	continu.click();
}


public String getConformesg()
{
try {
	return (yourAccountHasBeenCreated.getText());
}
   catch(Exception e) {
	  return(e.getMessage());
}
}

	public  String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
}
}
