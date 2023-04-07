package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FillMandatory extends Service {
	@BeforeTest
	public void setup() {
		excelFile= "FillMandatory";
	}
@Test(dataProvider = "datas")
	public void mandatory(String knowBase, String category, String desc) throws InterruptedException {
		// TODO Auto-generated method stub
	   // filter = shadow.findElementByXPath("//input[@id='filter']");
	   // shadow.setImplicitWait(20);
		shadow.findElementByXPath("//span[text()='Knowledge']").click();
		Thread.sleep(3000);
		WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		//driver.findElement(By.xpath("//span[text()='IT']")).click();
		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']")).sendKeys(knowBase, Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']")).sendKeys(category, Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys(desc);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();
		
		
		
	}
//@DataProvider(name="datas")
//public String[][] getdata() {
//	String[][] data = new String[1][3];
	//datas
	//data[0][0]= "IT";
	//data[0][1]= "Java";
	//data[0][2]= "Description";
	//return data;
	
//}

}
