package example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class script {
	private WebDriver driver;

@BeforeClass
public void beforeClass() {
	 System.setProperty("webdriver.chrome.driver", "H:\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
	 driver= new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://192.168.101.34/WebSite2");
 }
  @Test
  public void Application() {
		//Verifying the loaded page TEST CASE 1
				driver.getTitle();
				if(driver.getTitle().contains("- My ASP.NET Application")) 
					System.out.println("ASP.NET Application page is successfully loaded");
				else {
					System.out.println("Wrong page loaded");
				}
				
				//Verifying the page header TEST CASE 2
				WebElement element = driver.findElement(By.xpath("/html/body/div[2]/h1"));
				String text = element.getText();
				System.out.println("Page header: " + text);
				if(text.contains("Sample Application For Automation"))
					System.out.println("Expected Text is obtained");
				else {
					System.out.println("Expected Text is not obtained");	
					}
				
				//Entering the input data (2 entries) TEST CASE 3
				//first Data entry
				driver.findElement(By.id("txt_id")).sendKeys("1");
				driver.findElement(By.id("txt_name")).sendKeys("Krish");
				driver.findElement(By.id("txt_designation")).sendKeys("kid");
				driver.findElement(By.xpath("//input[@value='submit']")).click();
				driver.switchTo().alert().accept();
				driver.switchTo().alert().accept();
				
				// second Data entry TEST CASE 4
				driver.navigate().refresh();
				driver.findElement(By.id("txt_id")).click();
				driver.findElement(By.id("txt_name")).click();
				driver.findElement(By.id("txt_designation")).click();
				driver.findElement(By.xpath("//input[@value='submit']")).click();
				driver.switchTo().alert().accept();
				driver.switchTo().alert().accept();

			}

  @AfterClass
  public void afterClass() {
	 driver.quit();
  }

}
