package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewProposal extends Service {
	@BeforeTest
	public void setup() {
		excelFile= "CreateNewProposal";
	}
@Test(dataProvider = "datas")
	public void newProposal(String desc) throws InterruptedException {
		// TODO Auto-generated method stub
WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
shadow.setImplicitWait(20);
filter.sendKeys("My Proposals");
shadow.setImplicitWait(20);
shadow.findElementByXPath("//div[text()='All']").click();
shadow.setImplicitWait(20);
shadow.findElementByXPath("//mark[text()='My Proposals']").click();
Thread.sleep(3000);
WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
driver.switchTo().frame(element);
driver.findElement(By.xpath("//button[text()='New']")).click();
driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys(desc);
Thread.sleep(5000);
driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
 String text = driver.findElement(By.xpath("//table//tr[1]/td[4]")).getText();
 
if(text.equalsIgnoreCase("Template Description")) {
	System.out.println("created");
}



//WebElement eleFrame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
//driver.switchTo().frame(eleFrame);
//driver.findElement(By.xpath("//button[text()='New']")).click();
//Thread.sleep(3000);
//driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Created My New");
//Thread.sleep(10);
//driver.findElement(By.xpath("//span[@class='ui_action_container_primary']//button[text()='Submit']")).click();


	}
//@DataProvider(name = "datas")
//public String[][] getdata() {
//	String[][] data = new String[2][1];
	//1st set
	//data[0][0]= "Template Description";
	//2nd set
	//data[1][0]= "Description";
	//return data;
//}

}
