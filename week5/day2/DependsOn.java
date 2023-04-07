package week5.day2;

import org.testng.annotations.Test;

public class DependsOn {
	@Test
public void create() {
	System.out.println("create");
	throw new RuntimeException();
}
	@Test(dependsOnMethods = {"create", "delete"}, alwaysRun = true)
public void edit() {
	System.out.println("edit");
}
	@Test(timeOut = 2000)
public void delete() throws InterruptedException {
		Thread.sleep(3000);
	System.out.println("delete");
}
}
