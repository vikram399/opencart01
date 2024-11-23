package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger;
    public Properties p;
    
    
    @BeforeTest
    @Parameters({"os","browser"})
  	public void setup(String os, String br) throws IOException
  	{
  	  FileReader file = new FileReader(".//src/test/resources/config.Properties");
  	    p=new Properties();
  	    p.load(file);
  
  	  	logger=LogManager.getLogger(this.getClass());
  	  
  	  	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
  	  	{
  	  		DesiredCapabilities cap = new DesiredCapabilities();
//  	  		cap.setPlatform(Platform.WIN11);
//  	  		cap.setBrowserName("chrome"); 
  	  		if(os.equalsIgnoreCase("windows"))
  	  		{
  	  			cap.setPlatform(Platform.WIN11);
  	  		}
  	  		else if(os.equalsIgnoreCase("mac"))
  	  		{
  	  			cap.setPlatform(Platform.MAC);
  	  		}
  	  		else if(os.equalsIgnoreCase("Linux"))
	  		{
	  			cap.setPlatform(Platform.LINUX);
	  		}
  	  		else
  	  		{
  	  			System.out.println("no matching os");
  	  			return;  
  	  		}
  	  		switch(br.toLowerCase())
  	  		{
  	  		case "chrome" : cap.setBrowserName("chrome"); break;
  	  		case "edge" : cap.setBrowserName("MicrosoftEdge"); break;
  	  		case "firefox" : cap.setBrowserName("firefox"); break;
  	  		default : System.out.println("no matching browser"); return;
  	  		}
  	  		
  	  		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
  	  	}
  	  	
  	  	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
  	  	
  	  	
  	  	
  	  	switch(br.toLowerCase())
  	  	{
  	  	case "chrome": driver= new ChromeDriver(); break;
  	  	case "edge": driver= new EdgeDriver(); break;
  	  	case "firefox": driver= new FirefoxDriver(); break;
  	  	default : 
  	  	return;
  	  	}
  		
  		driver.manage().deleteAllCookies();
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  		driver.get(p.getProperty("url1"));
  		driver.manage().window().maximize();
  		
  		
  			
  	}
  	@AfterTest
  	public void tearDown()
  	{
  		driver.quit();
  	}
}


