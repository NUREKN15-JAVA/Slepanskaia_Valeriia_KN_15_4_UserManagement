package ua.nure.kn156.slepanska.db;

import junit.framework.TestCase;

public class DaoFactoryTest extends TestCase {

	public void testGetUserDao() {
		System.out.println(DaoFactory.getInstance());
		DaoFactory daoFactory = DaoFactory.getInstance();
		assertNotNull("DaoFactory instance is null", daoFactory);
		UserDAO userDao = daoFactory.getUserDao();
		assertNotNull("UserDAO instance is null", userDao);
	}
}
