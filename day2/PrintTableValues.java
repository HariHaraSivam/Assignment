package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PrintTableValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://html.com/tags/table/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
List<WebElement> tableList = driver.findElements(By.xpath("(//caption[text()='The Three Most Popular JavaScript Libraries']/parent::table)//tr"));
System.out.println(tableList.size());
for (int i = 1; i < tableList.size()-1; i++) {
	String text = driver.findElement(By.xpath("(//caption[text()='The Three Most Popular JavaScript Libraries']/parent::table)//tr["+i+"]")).getText();

	System.out.println(text);
	
}
List<WebElement> tableList2 = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
System.out.println(tableList2.size());
for (int i = 2; i < tableList2.size(); i++) {
	String text2 = driver.findElement(By.xpath("//table[@class='attributes-list']//tr["+i+"]/td[1]")).getText();
	System.out.println(text2);
	
	
}
for (int i = 2; i < tableList2.size(); i++) {
	String text3 = driver.findElement(By.xpath("//table[@class='attributes-list']//tr["+i+"]/td[3]")).getText();
	System.out.println(text3);
}
	}

}
