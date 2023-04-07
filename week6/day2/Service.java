package week6.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.sukgu.Shadow;

public class Service{
	RemoteWebDriver driver;
	Shadow shadow;
	public String excelFile;
	@Parameters({"browser", "url", "Username", "Password"})
	@BeforeMethod
public void preCondition(String browser, String url, String Username, String Password) {
		switch(browser) {
		case "Chrome" :
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		case "Edge" :
		{
			driver = new EdgeDriver();
		}
		}
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(Username);
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(Password);
	driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
	shadow = new Shadow(driver);
	shadow.setImplicitWait(20);
	shadow.findElementByXPath("//div[text()='All']").click();
	shadow.setImplicitWait(20);

}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	@DataProvider(name= "datas")
	public String[][] getdata() throws IOException {
		String[][] inputData = ExcelInputs.inputData(excelFile);
		return inputData; 
		
	}
	
}
