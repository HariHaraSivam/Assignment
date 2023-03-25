package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MenuAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.findElement(By.xpath("(//span[text()='Customers'])[1]")).click();
		WebElement web = driver.findElement(By.xpath("(//a[@class='ui-menuitem-link ui-submenu-link ui-corner-all'])[1]"));
		Actions builder = new Actions(driver);
		//builder.moveToElement(customers).perform();
		builder.moveToElement(web).perform();
	    driver.findElement(By.xpath("(//span[text()='Customer'])[1]")).click();
	    driver.findElement(By.xpath("//span[text()='Members']")).click();
	    driver.findElement(By.xpath("//a[text()='Customers']")).click();
	    driver.findElement(By.xpath("(//span[text()='New'])[2]")).click();
	    driver.findElement(By.xpath("(//span[text()='Duplicate'])[2]")).click();
		driver.findElement(By.xpath("(//span[text()='Customers'])[2]")).click();
		driver.findElement(By.xpath("(//span[text()='New'])[3]")).click();
		driver.findElement(By.xpath("(//span[text()='Customer'])[3]")).click();
		driver.findElement(By.xpath("(//span[text()='Options'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[1]")).click();
		WebElement rightclick = driver.findElement(By.xpath("//h5[text()='Context Menu']"));
		builder.contextClick(rightclick).perform();
		driver.findElement(By.xpath("(//span[text()='Delete'])[2]")).click();
		
		
	}

}
