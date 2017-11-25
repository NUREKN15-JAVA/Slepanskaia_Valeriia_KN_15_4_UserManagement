package ua.nure.kn156.slepanska.web;

import java.text.DateFormat;
import java.util.Date;

import ua.nure.kn156.slepanska.User;

public class DetailsServletTest extends MockServletTestCase {
	
	protected void setUp() throws Exception {
		super.setUp();
		createServlet(DetailsServlet.class);
	}

	
	public void testDetails() {
		Date date = new Date();
		addRequestParameter("id", "1000");
		addRequestParameter("firstName", "John");
		addRequestParameter("lastName", "Doe");
		addRequestParameter("dateOfBirth",DateFormat.getDateInstance().format(date));
		addRequestParameter("okButton", "Ok");
		doPost();
	}
}