/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

	@Test(timeout = 4000)
	public void testCreateAppt() throws Throwable {
		Appt appt1 = new Appt(13, 45, 1, -1, 2018, "Doctor Thing", "Go to Doctor", "doc@email.com" );
		String string0 = appt1.toString();
		String email = appt1.getEmailAddress();

		assertEquals("doc@email.com", email);
		assertEquals("\t-1/1/2018 at 1:45pm ,Doctor Thing, Go to Doctor\n", string0);
		assertFalse(appt1.isRecurring());
		assertTrue(appt1.isOn(1, -1, 2018));
		appt1.setValid();
		assertFalse(appt1.getValid());
		
	}
	
	@Test(timeout = 4000)
	public void testRecurring() throws Throwable{
		Appt appt2 = new Appt(11, 59, 2, 2, 2020, "Lunch Time", "Eat your Lunch", "");
		int a[] = {3,4,5,6,7,8,9,10};
		appt2.setRecurrence(a, 2, 4, 2);
		assertTrue(appt2.isRecurring());
		assertNotNull(appt2.getRecurBy());


		
	}
	@Test(timeout = 4000)
	public void test3() throws Throwable{
		Appt appt3 = new Appt(1, 1, 1, 1, 1, null, null, null);
		appt3.getXmlElement();
		assertTrue(appt3.hasTimeSet());
	}
	@Test(timeout = 4000)
	public void test4() throws Throwable{
		Appt appt4 = new Appt(-1, 1, -1, null, null, null);
		appt4.setValid();
		assertFalse(appt4.getValid());
		//tests invalid minute
		Appt appt5 = new Appt(10, 60, 1, 1, 1, null, null, null);
		appt5.setValid();
		assertFalse(appt5.getValid());
		//test invalid year
		Appt appt6 = new Appt(3, 4, 3, 1, -1, null, null, null);
		appt6.setValid();
		assertFalse(appt6.getValid());
		
		//test invalid month date
		Appt appt7 = new Appt(3, 4, 12, -1, 12, null, null, null);
		appt7.setValid();
		assertFalse(appt7.getValid());
		
		
		//test valid
		Appt appt8 = new Appt(9, 15, 15, 3, 2020, null, null, null);
		appt8.setValid();
		assertTrue(appt8.getValid());

	}
}