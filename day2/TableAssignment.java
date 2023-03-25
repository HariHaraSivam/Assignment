package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TableAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://leafground.com/table.xhtml");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
WebElement table = driver.findElement(By.xpath("(//table[@role='grid'])[2]"));
List<WebElement> row = table.findElements(By.tagName("tr"));
System.out.println(row.size());
for (int i = 1; i < row.size(); i++) {
	String table2 = driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr["+i+"]/td[1]")).getText();
	System.out.println(table2);
}
 List<WebElement> column = table.findElements(By.tagName("th"));
for (int i = 1; i < row.size() ; i++) {
	for (int j = 1; j < column.size(); j++) {
		String all = driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr["+i+"]/td["+j+"]")).getText();
		System.out.println(all);
	}
	
}


	}

}
