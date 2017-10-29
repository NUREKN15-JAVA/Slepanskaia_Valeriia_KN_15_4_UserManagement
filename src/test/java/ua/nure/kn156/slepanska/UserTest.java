package ua.nure.kn156.slepanska;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;
import ua.nure.kn156.slepanska.User;

/**
 * 
 * @ author Valeriia Slepanska KN-15-6
 *
 */
public class UserTest extends TestCase {

	private static final int AGE_OF_PERSON = 19;
	private static final int DAY_OF_BIRTH = 12;
	private static final int YEAR_OF_BIRTH = 1998;
	private User user;
	private Date dateOfBirth;

	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR_OF_BIRTH, Calendar.MAY, DAY_OF_BIRTH);
		dateOfBirth = calendar.getTime();
	}

	public void testGetFullName() {
		user.setFirstName("Lera");
		user.setLastName("Slepanskaia");
		assertEquals("Slepanskaia, Lera", user.getFullName());
	}

	public void testGetAge() {
		user.setDateOfBirth(dateOfBirth);
		assertEquals(AGE_OF_PERSON, user.getAge());
	}

	public void testGetFullNameThrowException() {
		user.setLastName(null);
		try {
			user.getFullName();
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Please,fill all the fields of the form");
		}
	}
}
