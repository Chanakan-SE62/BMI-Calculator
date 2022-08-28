import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SearchTestBMI {

	@Test
	void testSearchBMI() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		
		browser.get("https://www.calculator.net/bmi-calculator.html");
		browser.manage().window().setSize(new Dimension(1122, 730));
		browser.findElement(By.id("cage")).click();
		browser.findElement(By.id("cage")).clear();
		browser.findElement(By.id("cage")).sendKeys("22");
		browser.findElement(By.cssSelector(".cbcontainer:nth-child(2)")).click();
		browser.findElement(By.id("cheightmeter")).click();
		browser.findElement(By.id("cheightmeter")).clear();
		browser.findElement(By.id("cheightmeter")).sendKeys("170");
		browser.findElement(By.id("ckg")).click();
		browser.findElement(By.id("ckg")).clear();
		browser.findElement(By.id("ckg")).sendKeys("50");
		browser.findElement(By.cssSelector("td > input:nth-child(2)")).click();
		
		String check = browser.findElement(By.xpath("/html/body/div[3]/div[1]/div[4]/div[1]")).getText();
		assertEquals("BMI = 17.3 kg/m2   (Mild thinness)",check);
		
		//browser.manage().window().setSize(new Dimension(1920,1080));
		try {
			this.takeSnapShot(browser, "c:\\test001.png") ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Thread.sleep(500);
		browser.close();
	}
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}
}
