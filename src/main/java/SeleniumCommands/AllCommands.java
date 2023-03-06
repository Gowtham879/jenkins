package SeleniumCommands;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllCommands {
	public static WebDriver driver;

	public void openBrower() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-notifications");
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://www.easemytrip.com/");
	}

	public void HRMBrower() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-notifications");
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public WebElement getWebElementUsingXapth(String xpath) {
		WebElement element = AllCommands.driver.findElement(By.xpath(xpath));
		return element;
	}

	public WebElement getWebElementUsingCssSelector(String cssSelector) {
		WebElement element = AllCommands.driver.findElement(By.cssSelector(cssSelector));
		return element;
	}

	public void click(String xpath) {
		WebElement element = this.getWebElementUsingXapth(xpath);
		if (element.isEnabled()) {
			element.click();
		}
	}

	public void enterText(String xpath, String data) {
		WebElement element = this.getWebElementUsingXapth(xpath);
		element.clear();
		if (element.isEnabled()) {
			this.click(xpath);
			element.sendKeys(data);
		}
	}

	public void delayScript(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
		}
	}

	public void windowHandle() {
		Set<String> win = driver.getWindowHandles();
		Iterator<String> it = win.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
	}

 public void explicit(String xpath) {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
}
}