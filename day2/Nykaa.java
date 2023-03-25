package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
	ChromeDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.get("https://www.nykaa.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
	Actions act = new Actions(driver);
	act.moveToElement(brands).perform();
	driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
	driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();
	String title = driver.getTitle();
	System.out.println(title);
	driver.findElement(By.className("sort-name")).click();
	driver.findElement(By.xpath("((//div[@class='control-value'])[4])/following-sibling::div")).click();
	driver.findElement(By.id("first-filter")).click();
	driver.findElement(By.xpath("//span[@class='side-count']")).click();
	driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
	driver.findElement(By.xpath("(//div[@class='control-value'])[2]/following-sibling::div")).click();
	driver.findElement(By.xpath("//span[text()='Concern']")).click();
	driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
	String text = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();
	System.out.println(text);
	//String text2 = driver.findElement(By.xpath("(//span[@class='filter-value'])[2]")).getText();
	//want to verify here
	driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> windowList = new ArrayList<String>(windowHandles);
	driver.switchTo().window(windowList.get(1));
	driver.findElement(By.xpath("//span[text()='180ml']")).click();
	String price = driver.findElement(By.xpath("(//span[text()='₹209'])[1]")).getText();
	System.out.println(price);
	driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
	driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
	driver.switchTo().frame(0);
	String grandtotal = driver.findElement(By.xpath("//span[text()='₹279']")).getText();
	System.out.println(grandtotal);
	driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
	String details = driver.findElement(By.xpath("//p[text()='₹279']")).getText();
	if (grandtotal.equals(details)) {
		System.out.println(details);
	}
	driver.quit();
	
	
	
	}

}
