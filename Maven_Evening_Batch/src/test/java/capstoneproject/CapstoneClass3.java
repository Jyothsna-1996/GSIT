package capstoneproject;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class CapstoneClass3 {

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
	public void dataRead() throws Exception {

		FileInputStream f = new FileInputStream("C:\\Users\\jyoth\\Desktop\\CapstoneProject\\CapstoneInputData.xls");

		// Opening the ExcelSheet
		Workbook wb = Workbook.getWorkbook(f);

		// Opening the Sheet
		Sheet s = wb.getSheet("Sheet1");

		// code to launch Factorial calculator application
		System.setProperty("webdriver.chrome.driver", s.getCell(1, 18).getContents());

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		for (int i = 4; i < 11; i++) {
			for (int j = 1; j < 2; j++) {
				driver.findElement(By.id(s.getCell(1, 13).getContents())).sendKeys(s.getCell(j, i).getContents());
				driver.findElement(By.id(s.getCell(1, 14).getContents())).click();
				Thread.sleep(2000);
				String data = driver.findElement(By.id(s.getCell(1, 15).getContents())).getText();
				System.out.println(data);
				driver.navigate().refresh();
			}

		}

	}

}
