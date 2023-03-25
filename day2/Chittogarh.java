package week4.day2;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chittogarh {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://www.chittorgarh.com/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.findElement(By.id("navbtn_stockmarket")).click();
driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
List<WebElement> tablelist = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']//tr"));
System.out.println(tablelist.size());
//table[@class='table table-bordered table-striped table-hover w-auto']//tr/td[1]
for (int i = 1; i < tablelist.size(); i++) {	
	String text = driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']//tr["+i+"]/td[1]")).getText();
    System.out.println(text);
}

	}

}
