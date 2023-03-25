package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragandDropAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
ChromeDriver driver = new ChromeDriver(options);
driver.manage().window().maximize();
driver.get("https://www.leafground.com/drag.xhtml");
WebElement drag = driver.findElement(By.xpath("//span[text()='Drag me around']"));
Actions builder = new Actions(driver);
Point location = drag.getLocation();
int x = location.getX();
int y = location.getY();
System.out.println(x);
System.out.println(y);
builder.dragAndDropBy(drag, 100, 50).perform();
System.out.println(drag.getLocation().getX());
WebElement source = driver.findElement(By.xpath("(//span[text()='Name'])[1]"));
WebElement destination = driver.findElement(By.xpath("(//span[text()='Quantity'])[1]"));
//WebElement name = driver.findElement(By.xpath("(//table[@role='grid'])[1]//th[1]"));
//WebElement category = driver.findElement(By.xpath("(//table[@role='grid'])[1]//th[2]"));
builder.dragAndDrop(source, destination).perform();
//WebElement src = driver.findElement(By.xpath("//img[@id='form:logo']"));
//builder.dragAndDropBy(src, 50, 70).click().perform();
WebElement src = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
WebElement dest = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
builder.dragAndDrop(src, dest).perform();
WebElement row1 = driver.findElement(By.xpath("(//td[text()='Bamboo Watch'])[2]"));
WebElement row2 = driver.findElement(By.xpath("(//td[text()='Blue Band'])[2]"));
builder.dragAndDrop(row1, row2).perform();
WebElement slide = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
WebElement slideto = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
builder.dragAndDrop(slide, slideto).click().perform();
}

}
