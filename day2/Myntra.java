package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
ChromeDriver driver= new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://www.myntra.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
WebElement men = driver.findElement(By.xpath("(//a[text()='Men'])[1]"));
Actions act = new Actions(driver);
act.moveToElement(men).perform();
driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
String count = driver.findElement(By.className("title-count")).getText();
System.out.println(count);
driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
driver.findElement(By.className("brand-more")).click();
driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
driver.findElement(By.xpath("(//input[@value='Duke'])/following-sibling::div")).click();
driver.findElement(By.xpath("//span[contains(@class,'-close sprites-remove')]")).click();
List<WebElement> list = driver.findElements(By.xpath("//h3[text()='Duke']"));
System.out.println(list.size());
//for (int i = 0; i < list.size(); i++) {
//	System.out.println(list.get(i));
//}Confirm all the Coats are of brand Duke
WebElement sort = driver.findElement(By.xpath("//span[contains(@class,'-downArrow sprites-downArrow')]"));
act.moveToElement(sort).perform();
driver.findElement(By.xpath("(//label[@class='sort-label '])[4]")).click();
String text = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
System.out.println(text);
driver.findElement(By.xpath("(//div[@class='product-imageSliderContainer'])[1]")).click();
Set<String> windowHandles = driver.getWindowHandles();
List<String> windowList = new ArrayList<String>(windowHandles);
driver.switchTo().window(windowList.get(1));
File source = driver.getScreenshotAs(OutputType.FILE);
File dest = new File("snap/myntra.png");
FileUtils.copyFile(source, dest);
driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-wishlist pdp-button pdp-add-to-wishlist pdp-button pdp-flex pdp-center')]")).click();
driver.close();
	}

}
