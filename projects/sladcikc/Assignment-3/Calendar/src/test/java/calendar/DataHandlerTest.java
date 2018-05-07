/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  GregorianCalendar day = new GregorianCalendar();
	  day.set(2018, 2, 12);
	  GregorianCalendar day2 = new GregorianCalendar();
	  day2.set(2018, 2, 15);
	  GregorianCalendar day3 = new GregorianCalendar();
	  day3.set(2018, 2, 13);
	  CalDay d3 = new CalDay(day3);
	  
	  Appt appt1 = new Appt(13, 45, 13, 2, 2018, "Doctor Thing", "Go to Doctor", "doc@email.com" );
	  Appt appt2 = new Appt(13, 45, 13, 2, 2018, "Doctor Thing", "Go to Doctor", "doc@email.com" );
		int a[] = {3,4,5,6,7,8,9,10};
		appt2.setRecurrence(a, 2, 4, 2);
		assertTrue(appt2.isRecurring());
	  d3.addAppt(appt1);
	  d3.addAppt(appt2);
	  DataHandler dh = new DataHandler("file", true);
	  assertTrue(dh.saveAppt(appt1));
	  assertTrue(dh.deleteAppt(appt1));
	  assertTrue(dh.save());
	  dh.getApptRange(day, day2);
	  dh.getApptRange(day3, day2);
	  
	  

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  DataHandler dh = new DataHandler();
	  Appt appt1 = new Appt( 0, 0, 0, null, null, null);
	  assertTrue(dh.saveAppt(appt1));
	  assertTrue(dh.deleteAppt(appt1));
	  

  }

}