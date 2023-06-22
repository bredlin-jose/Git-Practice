import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_4 {
	@Test
	public void scriptSelenium4() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.addArguments("--incognito");
		//options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		Thread.sleep(4000);
		String window1 = driver.getWindowHandle();
		System.out.println(window1);
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(4000);
		String window2 = driver.getWindowHandle();
		System.out.println(window2);

		if ((window2.equals(window1))!=true) {
			driver.switchTo().window(window1);
		}
		
		Thread.sleep(4000);
		driver.findElement(By.name("q")).sendKeys("Bredlin");

		driver.findElement(By.name("btnK")).click();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(4000);
		driver.get("https://www.facebook.com/");
		
		Set<String> win = driver.getWindowHandles();
		System.out.println(win.toString());
		
		Thread.sleep(4000);
		driver.quit();

	}
}
