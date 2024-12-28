package capstoneproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CapstoneClass5 {

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

	public void bugTrack() throws Exception {
		driver.findElement(By.id("number")).sendKeys("3232");
		Thread.sleep(2000);
		driver.findElement(By.id("getFactorial")).click();
		Thread.sleep(2000);
		String linkName = driver.findElement(By.id("resultDiv")).getText();
		System.out.println(linkName);
		if (linkName.contains("The factorial of 32 is: ")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

}
