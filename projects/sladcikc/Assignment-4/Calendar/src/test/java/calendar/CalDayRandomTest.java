package calendar;


import org.junit.Test;


import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Random;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
	private static final long TestTimeouts = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTSs=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
    
    public static java.lang.Integer RandomSelectNull(Random random) {
    	int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 10);
		int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);

		int r = random.nextInt(50) + 0;
		if( (r & 1) == 0) {
			return null;
		}
		else {
			return recurDays[sizeArray];
		}
	}
    
    
    
    
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
    
    
    
   /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 

		 
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeouts; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 GregorianCalendar day = new GregorianCalendar();		 
				 int sDay=ValuesGenerator.getRandomIntBetween(random, -1, 32);
				 int sMonth=ValuesGenerator.getRandomIntBetween(random, -1, 13);
				 int sYear=ValuesGenerator.getRandomIntBetween(random, -2, 100);
				 day.set(sYear, sMonth, sDay);
				 CalDay calday = new CalDay(day);
				 for (int i = 0; i < NUM_TESTSs; i++) {
					 int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 13);
					 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 60);
					 int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 32);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, -1, 13);
					 int startYear=ValuesGenerator.getRandomIntBetween(random, -2, 100);
					 String title="Birthday Party";
					 String description="This is my birthday party.";
					 String emailAddress="xyz@gmail.com";
	
					 //Construct a new Appointment object with the initial data	 
					 //Construct a new Appointment object with the initial data	 
			         Appt appt = new Appt(startHour,
			                  startMinute ,
			                  startDay ,
			                  startMonth ,
			                  startYear ,
			                  title,
			                 description,
			                 emailAddress);
			         
			         calday.addAppt(appt);
				 }
		         
					
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeouts);	         
		         
		         
		         
		         
			}
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }
}

