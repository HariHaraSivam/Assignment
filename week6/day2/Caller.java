package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Caller extends Service {
	@BeforeTest
	public void setup() {
		excelFile= "Caller";
	}
@Test(dataProvider = "datas")
	public void serviceCaller(String id, String fname, String lname) throws InterruptedException {
		// TODO Auto-generated method stub
WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
shadow.setImplicitWait(20);
filter.sendKeys("Callers");
shadow.setImplicitWait(20);
shadow.findElementByXPath("//div[@id='all']").click();
shadow.setImplicitWait(20);
shadow.findElementByXPath("//mark[text()='Callers']").click();
Thread.sleep(3000);
WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
driver.switchTo().frame(element);
driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
driver.findElement(By.xpath("//input[@id='sys_user.user_name']")).sendKeys(id);
driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys(fname);
driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys(lname);
WebElement lang = driver.findElement(By.xpath("//select[@id='sys_user.preferred_language']"));
Select select = new Select(lang);
select.selectByVisibleText("English");
WebElement time = driver.findElement(By.xpath("//select[@id='sys_user.time_zone']"));
Select select1 = new Select(time);
select1.selectByIndex(6);

Thread.sleep(5000);
driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@id='sys_user_table_header_search_control']")).sendKeys(id,Keys.ENTER);
String text = driver.findElement(By.xpath("(//table//tr/td[4])[2]")).getText();
System.out.println(text);
//(//table//tr)[3]/td[3]

}
//@DataProvider(name="datas")
//public String[][] getdata() {
	//String[][] data = new String[2][3];
	//1st set
//	data[0][0]= "1120";
//	data[0][1]= "Hari";
//	data[0][2]= "Hara";
	//2nd set
//	data[1][0]= "1121";
//	data[1][1]= "Hara";
//	data[1][2]= "Sivam";
//	return data;
	
			
//}

}
//button[@id='sysverb_new']