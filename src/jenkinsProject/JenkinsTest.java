package jenkinsProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JenkinsTest {
	
	WebDriver driver;
	static ExtentTest test;

	static ExtentReports report;
	@BeforeClass

	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");

	test = report.startTest("ExtentDemo");
	}
	@Test
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe"); 
		 driver = new ChromeDriver();
		 System.out.print("Not Welcome to jenkins ");
		 driver.get("https://www.assignmentprime.com/contact-us.php");
		 System.out.println(driver.getTitle());

		 if(driver.getTitle().equals("Contact Us for AssignmentPrime Related Queries."))
			{

			test.log(LogStatus.PASS, "Test Successfully passed");

			}

			else
			
			{
			
			test.log(LogStatus.FAIL, "Test Failed");
			
			}
		 }
//	
//	@Test(priority=2,groups="Logo")
//	public void GoogleLogoTest()
//	{
//		boolean b = driver.findElement(By.xpath("//img[@class='loaded']")).isDisplayed();
//		System.out.println(b);
//		if(b=true)
//		{
//			test.log(LogStatus.PASS, "Image available");
//		}
//		else {
//			test.log(LogStatus.FAIL, "Image not available");
//		}
//	}
@AfterClass
	public static void endTest()

	{

	report.endTest(test);

	report.flush();
	
}

}
