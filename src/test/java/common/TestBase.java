package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
	
	static String path = System.getProperty("user.dir");
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream((path+"\\config.properties"));
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		
		
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", path+"\\Application\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		
		driver.get(prop.getProperty("url"));
		
	}
	
	public static void scroll(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static org.openqa.selenium.WebElement WebElement(String xpath) {
		
		WebElement parent = driver.findElement(By.xpath(xpath));
		
		return parent;
	}
	
	public static java.util.List<org.openqa.selenium.WebElement> List(WebElement parent, String xpath) {
		
		List <WebElement> list= parent.findElements(By.xpath(xpath));
		
		return list;
	}
	
	public static  void scrolldown() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
