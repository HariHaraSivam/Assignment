package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.sukgu.Shadow;

public class Service{
	ChromeDriver driver;
	Shadow shadow;
	@Parameters({"url", "Username", "Password"})
	@BeforeMethod
public void preCondition(String url, String Username, String Password) {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
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
	
}
