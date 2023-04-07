package week6.day2;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethod{
@BeforeTest
public void setup() {
	excelFile = "CreateLead";
}
	
	@Test(dataProvider = "datas")
	public void creLead(String cname, String fname, String lname, String num) {
	
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(num);
		driver.findElement(By.name("submitButton")).click();
}

}






