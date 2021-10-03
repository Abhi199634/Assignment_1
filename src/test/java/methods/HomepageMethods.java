package methods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import assignment.getData;
import common.TestBase;

public class HomepageMethods  extends TestBase  {
	
	
	public HomepageMethods() {
		
		super();
	}

	public static void flightDetails() throws InterruptedException {
		
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
			
			WebElement depart_on = driver.findElement(By.xpath("//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--end DayPicker-Day--rightEdge DayPicker-Day--selected DayPicker-Day--today']"));
			
			action.doubleClick(depart_on).perform();
			Thread.sleep(4000);
			
			svg.get(1).click();
			
			List<WebElement> return_on = driver.findElements(By.xpath("//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[@class='DayPicker-Day DayPicker-Day--rightEdge']"));
			action.doubleClick(return_on.get(7)).perform();
			
		}
			
			driver.findElement(By.xpath("//button[@class='px-7 bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer w-100p py-2 px-5 h-10 fs-4 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']")).click();
			
			Thread.sleep(5000);
			System.out.println("The title of the page after enterting the booking details are "+ driver.getTitle());
			
			System.out.println("The url of the page after enterting the booking details are "+ driver.getCurrentUrl());
	}
	
	public static void flightlistingpage() throws InterruptedException {
		
		WebElement on_board_flight = driver.findElement(By.xpath("//div[@data-test-attrib='onward-view']"));
		List<WebElement> on_board_flight_list = on_board_flight.findElements(By.xpath("//div[@class='rt-tuple-container__details ms-grid-row-2']"));
		System.out.println("The total onborad flight showed are "+ on_board_flight_list.size());
		
		WebElement return_flight = driver.findElement(By.xpath("//div[@data-test-attrib='return-view']"));
		List<WebElement> return_flight_list = return_flight.findElements(By.xpath("//div[@class='rt-tuple-container__details ms-grid-row-2']"));
		System.out.println("The total return  flight showed are "+ return_flight_list.size());
		
		TestBase.scrolldown();
		
		on_board_flight_list.get(1).click();
		return_flight_list.get(1).click();
		
		Thread.sleep(4000);
		
		TestBase.ScrolltoTop();
		
		String price = driver.findElement(By.xpath("//span[@class='c-neutral-900 mx-4  fw-700 flex flex-right fs-7']")).getText();
		
		System.out.println("The total price is "+ price);
		
		System.out.println("now clicking the book button after selecting the flight");
		driver.findElement(By.xpath("//button[@class='bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer py-1 px-3 h-8 fs-3 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']")).click();
	}
	
	public static void userDetails() throws InterruptedException {
		
		Thread.sleep(5000);
		
		getData gt = new getData();
		
		String parent_window=driver.getWindowHandle();
		
		System.out.println("The window handle of parent is "+parent_window);
		
		TestBase.windowhandles(parent_window);
		
		System.out.println("The url of the page after switching to child window is "+ driver.getCurrentUrl());
		
		TestBase.ScrolltoEnd(2);
		
		Thread.sleep(4000);
		
		ArrayList<String > ar = gt.get_data();
		
		List<WebElement> parent = driver.findElements(By.xpath("//div[@class='d-inline-block']"));
			
		parent.get(0).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='px-7 mr-2 bg-primary-500 hover:bg-primary-600 c-white bc-transparent"
				+ " c-pointer py-2 px-5 h-10 fs-4 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border'")).click();
			
		driver.findElement(By.xpath("//div[@class='p-relative']//input[@class='field bw-1 bs-solid w-100p p-2 box-border br-4 fs-2 c-neutral-900 h-9 fs-3 bc-neutral-100 c-neutral-900 focus:bc-secondary-500' "
				+ "and @type='text' and @placeholder='Mobile number']")).sendKeys(ar.get(0));
		
		System.out.println("Mobile number Entered");
		
		driver.findElement(By.xpath("//div[@class='p-relative']//input[@class='field bw-1 bs-solid w-100p p-2 box-border br-4 fs-2 c-neutral-900 h-9 fs-3 bc-neutral-100 c-neutral-900 focus:bc-secondary-500' "
				+ "and @type='text' and @placeholder='Email address']")).sendKeys(ar.get(1));
		
		System.out.println("Email ID  Entered");
		
		parent.get(1).click();
		
		System.out.println("Continue button clicked");
			
		Thread.sleep(4000);
		
	}
}
