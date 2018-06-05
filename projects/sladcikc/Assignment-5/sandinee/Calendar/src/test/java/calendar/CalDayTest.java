/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import calendar.Appt;
import calendar.CalDay;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  Appt appt1 = new Appt(13, 45, 1, 1, 2018, "Doctor Thing", "Go to Doctor", "doc@email.com" );
	  Appt appt2 = new Appt(12, 42, 2, 2, 2018, "Doctor Thing", "Go to Doctor", "doc@email.com" );
	//  System.out.print(appt1.getValid());
	  GregorianCalendar day = new GregorianCalendar();
	  day.set(2018, 2, 12);
	  CalDay calday = new CalDay(day);
	  calday.addAppt(appt1);
	  assertEquals(calday.getYear(), 2018);
	  assertTrue(calday.isValid());
	  assertTrue(appt1.getValid());
	  //add appt again to test for loop
	  calday.addAppt(appt1);
	  calday.addAppt(appt2);
	  
	  assertEquals(calday.getSizeAppts(), 3);
	  assertEquals(calday.getDay(), 12);
	  assertEquals(calday.getMonth(), 3);
	  
	  String dd = calday.toString();
	 // System.out.print(dd);
	  assertNotNull(dd);
	  
	  String fullinfo = calday.getFullInfomrationApp(calday);
	 // System.out.print(fullinfo);
	  assertNotNull(fullinfo);
	  assertNotNull(calday.getAppts());
	  assertNotNull(calday.getDay());
	  assertNotNull(calday.getMonth());
	  assertNotNull(calday.getYear());
	  assertNotNull(calday.getSizeAppts());

  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  CalDay day = new CalDay();
	  assertNull(day.iterator());
	  assertEquals(day.toString(), "");

  }
  
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
	  Appt appt4 = new Appt(0, 1, 1, 1, 2018, "Doctor Thing", "Go to Doctor", "doc@email.com" );
	  Appt appt5 = new Appt(222, 222, -212, "Doctor Thing", "Go to Doctor", "doc@email.com" );
	  Appt appt6 = new Appt(15, 15, -212, "Doctor Thing", "Go to Doctor", "doc@email.com" );
	 // System.out.print(appt4.getValid());
	  GregorianCalendar day = new GregorianCalendar();
	  day.set(2018, 2, 12);
	  CalDay calday = new CalDay(day);
	  calday.addAppt(appt5);
	  calday.addAppt(appt4);
	  assertEquals(calday.getYear(), 2018);
	  assertTrue(calday.isValid());
	  assertTrue(appt4.getValid());
	  String fullinfo = calday.getFullInfomrationApp(calday);
	  assertNotNull(fullinfo);
	 // System.out.print(fullinfo);
	  
	  
	  
	  
	  
	  
  }

}