package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RowsAndColumnsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://html.com/tags/table/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
List<WebElement> rowcount = driver.findElements(By.xpath("//table//tr"));
System.out.println(rowcount.size());
List<WebElement> columncount = driver.findElements(By.xpath("//table//th"));
System.out.println(columncount.size());
	}

}
