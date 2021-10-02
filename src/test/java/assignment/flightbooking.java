package assignment;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.TestBase;


public class flightbooking extends TestBase{
	
	
	public flightbooking() {
		
		super();
	}

	
	@BeforeMethod
	public void setup() {
		
		initialization();
		System.out.println("The title of page is "+driver.getTitle());
		
	}
	
	@Test
	public void flight_booking() throws InterruptedException {
		
		Actions action = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.findElement(By.className("closeit")).click();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div[2]/div/div[2]/label[2]/div[2]/p"));
		element.click();
		TestBase.scroll(element);
		List<WebElement> input_feild = driver.findElements(By.xpath("//div[@class='p-relative']"));
		
		//From city
		input_feild.get(2).click();
		TestBase.scrolldown();
		
		Thread.sleep(4000);
		try {
		WebElement parent =TestBase.WebElement("//div[@class='bg-white br-4 elevation-5 p-1 p-absolute mt-1 z-50 l-0']");
		List <WebElement> list= TestBase.List(parent,"//p[@class='to-ellipsis o-hidden ws-nowrap c-inherit fs-3']");
		System.out.println("The origin city is "+list.get(2).getText());
		
		list.get(2).click();
		Thread.sleep(3000);
		
		input_feild.get(4).click();	
		list.get(3).click();
		
		
		}catch(org.openqa.selenium.StaleElementReferenceException ex){
			
			input_feild.get(4).click();
			WebElement parent =TestBase.WebElement("//div[@class='bg-white br-4 elevation-5 p-1 p-absolute mt-1 z-50 l-0']");
			List <WebElement> list= TestBase.List(parent,"//p[@class='to-ellipsis o-hidden ws-nowrap c-inherit fs-3']");
			System.out.println("The destination city is "+list.get(3).getText());
			
			list.get(3).click();
			Thread.sleep(3000);
		
			List<WebElement> svg = driver.findElements(By.xpath("//button[@class='flex flex-middle flex-between t-all fs-2 "
					+ "focus:bc-secondary-500 bg-transparent "
					+ "bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']"));
			svg.get(0).click();
			
			WebElement depart_on = driver.findElement(By.xpath("//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--end DayPicker-Day--selected DayPicker-Day--today']"));
			
			action.doubleClick(depart_on).perform();
			Thread.sleep(4000);
			
			svg.get(1).click();
			
			WebElement return_on = driver.findElement(By.xpath("//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[@class='DayPicker-Day DayPicker-Day--rightEdge']"));
			action.doubleClick(return_on).perform();
			
			driver.findElement(By.xpath("//button[@class='px-7 bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer w-100p py-2 px-5 h-10 fs-4 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']")).click();
			
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}