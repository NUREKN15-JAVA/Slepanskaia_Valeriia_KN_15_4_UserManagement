package ua.nure.kn156.slepanska.db;

import junit.framework.TestCase;
import ua.nure.kn156.slepanska.db.DaoFactory;
import ua.nure.kn156.slepanska.db.UserDAO;

public class DaoFactoryTest extends TestCase {

	public void testGetUserDao() {
		
		try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			assertNotNull("DaoFactory instance is null",daoFactory);
			UserDAO userDao = daoFactory.getUserDao();
			assertNotNull("UserDao instance is null", userDao);
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
