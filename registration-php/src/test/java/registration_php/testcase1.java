package registration_php;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class testcase1 {

	WebDriver driver; 
		 

	@AfterMethod
	public void failed_screenshot(ITestResult Testcase_result ) throws IOException {
		
		if(Testcase_result.getStatus()==ITestResult.FAILURE) {
			
			screenshots_failedcases.take_screenshot(driver,".\\screen_shots\\"+Testcase_result.getName()+".png");
			System.out.println("ITestResult.FAILURE is "+ITestResult.FAILURE );
			System.out.println("Testcase_result.getStatus() is "+Testcase_result.getStatus());
		}
		
           if(Testcase_result.getStatus()==ITestResult.SUCCESS) {
			
			
			System.out.println("ITestResult.FAILURE is "+ITestResult.SUCCESS );
			System.out.println("Testcase_result.getStatus() is "+Testcase_result.getStatus());
		}
		

		 driver.close();
		 driver.quit();
				
		}  

	@BeforeMethod
	@Parameters({ "browser" })

	public void open_browers(@Optional("chrome") String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to("https://phptravels.net/login");
			driver.manage().window().maximize();

		}
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.navigate().to("https://phptravels.net/login");
			driver.manage().window().maximize();

		}

		if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.navigate().to("https://phptravels.net/login");
			driver.manage().window().maximize();

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void registration() throws InterruptedException {

		driver.findElement(By.name("email")).sendKeys("fewigiv678@24rumen.com");
		driver.findElement(By.name("password")).sendKeys("54321Nn");
	
        WebElement submit_btn = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[4]/div/div[2]/div[2]/div/form/div[3]/button"));
		submit_btn.submit();


	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2")));
		String actual_result = driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div[1]/div/div[1]/div[1]/div/div/h2")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual_result,"Hi, Nariman Welcome Back");
		soft.assertAll();
	}
	
}
    








