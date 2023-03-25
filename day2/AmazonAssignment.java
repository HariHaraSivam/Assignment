package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AmazonAssignment {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://www.amazon.in/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro ", Keys.ENTER);
String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
System.out.println(price);
String review = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
System.out.println(review);
WebElement stars = driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star-small a-star')])[1]"));
Actions action = new Actions(driver);
action.moveToElement(stars).click().perform();
String starpercent = driver.findElement(By.xpath("((//span[@class='a-size-base'])/a)[2]")).getText();
System.out.println(starpercent);
driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
Set<String> windowHandles = driver.getWindowHandles();
List<String> windowList = new ArrayList<String>(windowHandles);
driver.switchTo().window(windowList.get(1));
File source = driver.getScreenshotAs(OutputType.FILE);
File dest = new File("./snap/amazon.png");
FileUtils.copyFile(source, dest);
driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
String subtotal = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
System.out.println(subtotal);
if(price.contains(subtotal)) {
	System.out.println(subtotal);
}
	}

}
