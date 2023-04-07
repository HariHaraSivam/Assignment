package week5.day2;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Attributes {

	@Test(invocationCount = 3, invocationTimeOut = 2000, threadPoolSize = 2)
	public void createLead() {
		System.out.println("create Lead");
		
	}
	@Test(enabled=false)
	public void editLead() {
		System.out.println("Edit Lead");
	}
	@Ignore
	@Test
	public void deleteLead() {
		System.out.println("Delete Lead");
	}
	@Test(priority=-1)
	public void duplicateLead() {
		System.out.println("Duplicate Lead");
	}
	
}
