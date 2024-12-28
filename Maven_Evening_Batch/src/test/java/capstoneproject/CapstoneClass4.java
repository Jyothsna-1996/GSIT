package capstoneproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CapstoneClass4 {

	WebDriver driver;
	WebDriverWait wait;

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

	public void verifyLink() {

		CapstonePageObject p = PageFactory.initElements(driver, CapstonePageObject.class);
		p.aboutLink.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		System.out.println(driver.getTitle());

		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("a"), 5));

		for (WebElement data : link) {
			String linkName = data.getText();
			System.out.println(linkName);
		}

	}

}
