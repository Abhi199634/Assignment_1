package assignment;

import org.testng.annotations.Test;

import common.TestBase;
import methods.HomepageMethods;


public class flightbooking extends TestBase{
	
	
	public flightbooking() {
		
		super();
	}
	
	@Test
	public void flight_booking() throws InterruptedException {
		
			HomepageMethods.flightDetails();
			
			HomepageMethods.flightlistingpage();
			
			HomepageMethods.userDetails();
		}
}