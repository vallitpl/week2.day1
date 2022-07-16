package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
public static void main(String[] args) {
	
		//call WDM for the browser driver
		WebDriverManager.chromedriver().setup();
		
		//Launch the browser chrome
		ChromeDriver driver =new ChromeDriver();
		
		//Load the URL
		driver.get("http://leaftaps.com/opentaps");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Close browser
		//driver.close();
		
		//Find username and enter the username value (demosalesmanager)
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		//Find the password field and enter the password (crmsfa)
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click the login button
		driver.findElement(By.className("decorativeSubmit")).click();

		//Finally we need to check whether we are in correct page
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attribute =logout.getAttribute("value");
		System.out.println(attribute);
		if(attribute.equals("LOGOUT"))
		{
			System.out.println("Successfully logged IN");
		}
		
		//click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//click Leads tab
		driver.findElement(By.linkText("Leads")).click();
		
		//click Create Lead link
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter Company Name,First name,Last name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CompanyTest");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("valli");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("tpl");
		
		//Choose Source dropdown 
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select = new Select(source);
		select.selectByVisibleText("Employee");	
		
		//Enter Firstname(local),Department,Description
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Vals");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("abcdefegh");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vallitpl@gmail.com");
		
		//Select StateProvince using Visible text
		WebElement source1 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select select1 = new Select(source1);
		select1.selectByVisibleText("New York");
		
		//Submitting by clicking create button
		driver.findElement(By.className("smallSubmit")).click();
		
		//Verify the Verify lead page title
		String title = driver.getTitle();
		if(title.equalsIgnoreCase("View Lead | opentaps CRM"))
		{
			System.out.println("Verified Title");
		}
		else
		{
			System.out.println("Title not verified");
		}
		//Click on Duplicate Button
		driver.findElement(By.className("subMenuButton")).click();
		
		//Clear company name field and enter new company name
		WebElement companyName = driver.findElement(By.id("createLeadForm_companyName"));
		companyName.clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CompanyTestNew");
		
		//Clear first name field and enter new first name
		WebElement firstName = driver.findElement(By.id("createLeadForm_firstName"));
		firstName.clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("FirstNameNew");
		
		//Submitting by clicking create button
		driver.findElement(By.className("smallSubmit")).click();
				
		//Verify the Verify lead page title
				String title1 = driver.getTitle();
				if(title1.equalsIgnoreCase("View Lead | opentaps CRM"))
				{
					System.out.println("Verified Title");
				}
				else
				{
					System.out.println("Title not verified");
				}

}
}
