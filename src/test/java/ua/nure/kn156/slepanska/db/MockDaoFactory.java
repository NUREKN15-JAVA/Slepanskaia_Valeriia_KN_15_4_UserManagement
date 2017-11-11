package ua.nure.kn156.slepanska.db;

import com.mockobjects.dynamic.Mock;

import ua.nure.kn156.slepanska.db.DaoFactory;
import ua.nure.kn156.slepanska.db.UserDAO;

public class MockDaoFactory extends DaoFactory {
	
	private Mock mockUserDao;
	
	public MockDaoFactory() {
		mockUserDao =new Mock(UserDAO.class);
	}

	public Mock getMockUserDao() {
		return  mockUserDao;
	}
	
	public UserDAO getUserDao() {
		return (UserDAO) mockUserDao.proxy();
	}

}
