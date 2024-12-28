package capstoneproject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class CapstoneReusableClass {
	
	WebDriver driver;
	
	public void launchApp(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Jars\\chromedriver.exe");
	driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closeApp() {
		driver.close();
	}
	
	//create reusable method
			public static void screenshot() throws IOException {
				WebDriver driver = new ChromeDriver();
	//whatever screenshot(SS) we take will store it in File. SS of driver or application & get that SS & output type file
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//after taking SS we give file to copy to desktop 'folder from ->to' location
			Files.copy(f, new File("C:\\Users\\jyoth\\Desktop\\CapstoneProject\\"+driver.getTitle()+".png"));
			}
	
}
