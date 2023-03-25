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

import io.github.sukgu.Shadow;

public class AdministrationCertifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		Shadow dom =new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		WebElement learning = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder = new Actions(driver);
		builder.moveToElement(learning).perform();
		dom.findElementByXPath("//a[text()='Salesforce Certification']").click();
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		System.out.println(driver.getTitle());
		WebElement scroll = driver.findElement(By.xpath("(//div[text()='Superbadge'])[1]"));
		builder.scrollToElement(scroll).perform();
		List<WebElement> certificates = driver.findElements(By.xpath("(//div[text()='Certification'])/following-sibling::div[1]"));
		//System.out.println(certificates);
		System.out.println(certificates.size());
		//for (int i = 0; i < certificates.size(); i++) {
			//System.out.println(certificates.get(i));
			
		//}
		for (WebElement certi : certificates) {
			System.out.println(certi.getText());
		}
	}

}
