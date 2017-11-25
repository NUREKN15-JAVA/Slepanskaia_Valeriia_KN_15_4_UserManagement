package ua.nure.kn156.slepanska;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import ua.nure.kn156.slepanska.User;

public class UserTest extends TestCase {
	private static final int AGE = 19;
	private User user;
	private Date date;

	@Override
	protected void setUp() throws Exception {

		super.setUp();
		user = new User();
		Calendar calendar = Calendar.getInstance();
		calendar.set(1998, Calendar.JANUARY, 28);
		date = calendar.getTime();
	}

	public void testGetFullName() {
		user.setFirstName("Kseniia");
		user.setLastName("Hondak");
		assertEquals("Hondak,Kseniia", user.getFullName());
	}

	public void testLastNameIsNull() {
		user.setLastName("Hondak");
		try {
			user.getFullName();
			fail("Should have thrown an exception");

		} catch (IllegalArgumentException e) {
			System.out.println("lastName is NULL");
		}

	}

	public void testFirstNameIsNull() {
		user.setFirstName("Kseniia");
		try {
			user.getFullName();
			fail("Should have thrown an exception");

		} catch (IllegalArgumentException e) {
			System.out.println("firstName is NULL");
		}

	}

	public void testGetAge() {
		user.setDateOfBirth(date);
		assertEquals(AGE, user.getAge());
	}

}
