package capstoneproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CapstoneClass2 {

	WebDriver driver;

	@BeforeTest

	public void launchApp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qainterview.pythonanywhere.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@Test
	public void ts1() {
		WebElement textBox = driver.findElement(By.name("number"));
		String placeholderText = textBox.getAttribute("placeholder");
		System.out.println("placeholder text is: " + placeholderText);
		if (placeholderText.contains("Enter an integer")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}

	@Test
	public void ts2() {
		driver.findElement(By.name("number"));
		System.out.println("Application title is: " + driver.getTitle());
		if (driver.getTitle().contains("Factorial")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}

	@Test
	public void ts3() {
		driver.findElement(By.name("number"));
		System.out.println("Application title is: " + driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("https")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	@AfterTest
	public void closeApp() {
		driver.close();
	}

}
