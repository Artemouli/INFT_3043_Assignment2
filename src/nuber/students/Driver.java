package nuber.students;

import java.util.Random;
import java.lang.Thread;

public class Driver extends Person {
	
	private Passenger currentPassenger; 
	
	public Driver(String driverName, int maxSleep)
	{
		// invokes base Person class
		super(driverName, maxSleep);
	}
	
	/**
	 * Stores the provided passenger as the driver's current passenger and then
	 * sleeps the thread for between 0-maxDelay milliseconds.
	 * 
	 * @param newPassenger Passenger to collect
	 * @throws InterruptedException
	 */
	public void pickUpPassenger(Passenger newPassenger)
	{
		this.currentPassenger = newPassenger;
		
		// Sets the sleep time between 0-maxDelay
		Random rand = new Random();
		long sleepTime = rand.nextLong(this.maxSleep);
		
		
		try {
			Thread.sleep(sleepTime);
		} 
		catch (Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Sleeps the thread for the amount of time returned by the current 
	 * passenger's getTravelTime() function
	 * 
	 * @throws InterruptedException
	 */
	public void driveToDestination() {
		try {
			Thread.sleep(this.currentPassenger.getTravelTime());
		} 
		catch (Exception e){
			System.out.println(e);
		}
	}
	
}
