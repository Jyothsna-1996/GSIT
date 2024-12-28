package capstoneproject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import automation_testing.BaseClass;

public class CapstoneClass1 {

	WebDriver driver;

	@BeforeMethod

	public void launchApp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qainterview.pythonanywhere.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void closeApp() {
		driver.close();
	}

	@Test
	public void ts1() throws Exception {
		boolean textboxDisplay = driver.findElement(By.id("number")).isDisplayed();
		boolean calculatebtnDisplay = driver.findElement(By.id("getFactorial")).isDisplayed();
		boolean aboutlinkDispaly = driver.findElement(By.xpath("//a[text()='About']")).isDisplayed();
		boolean tandclinkDispaly = driver.findElement(By.xpath("//a[text()='Terms and Conditions']")).isDisplayed();
		boolean privacylinkDispaly = driver.findElement(By.xpath("//a[text()='Privacy']")).isDisplayed();
		if (textboxDisplay == true) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		if (calculatebtnDisplay == true) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		System.out.println(aboutlinkDispaly);
		System.out.println(tandclinkDispaly);
		System.out.println(privacylinkDispaly);
	}

	@Test
	public void ts2() throws Exception {
		boolean textboxEnabled = driver.findElement(By.id("number")).isEnabled();
		boolean calculatebtnEnabled = driver.findElement(By.id("getFactorial")).isEnabled();
		boolean aboutlinkEnabled = driver.findElement(By.xpath("//a[text()='About']")).isEnabled();
		boolean tandclinkEnabled = driver.findElement(By.xpath("//a[text()='Terms and Conditions']")).isEnabled();
		boolean privacylinkEnabled = driver.findElement(By.xpath("//a[text()='Privacy']")).isEnabled();

		// Applying Soft Assertion
		SoftAssert obj1 = new SoftAssert();
		obj1.assertEquals(textboxEnabled, true);// (actual, expected result) ->type:it should display
		obj1.assertEquals(calculatebtnEnabled, true);
		obj1.assertEquals(aboutlinkEnabled, true);
		obj1.assertEquals(tandclinkEnabled, true);
		obj1.assertEquals(privacylinkEnabled, true);
		System.out.println("Application title is: " + driver.getTitle());
		obj1.assertAll(); // close all the soft assert

	}

	@Test
	public void ts3() {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("number")).click();
		driver.findElement(By.id("getFactorial")).click();
		driver.findElement(By.xpath("//a[text()='About']")).click();
		System.out.println("Application title is: " + driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Terms and Conditions']")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//a[text()='Privacy']")).click();
		driver.navigate().back();

	}

}
