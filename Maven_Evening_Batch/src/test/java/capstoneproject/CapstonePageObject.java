package capstoneproject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CapstonePageObject {
	
		@FindBy (xpath = "//a[text()='About']") WebElement aboutLink;
		@FindBy (xpath = "//a[text()='Terms and Conditions']") WebElement tcLink;
		@FindBy (xpath = "//a[text()='Privacy']") WebElement privacyLink;

}
