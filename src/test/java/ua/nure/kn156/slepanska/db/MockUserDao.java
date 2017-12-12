package ua.nure.kn156.slepanska.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ua.nure.kn156.slepanska.User;
import ua.nure.kn156.slepanska.db.ConnectionFactory;
import ua.nure.kn156.slepanska.db.DatabaseException;
import ua.nure.kn156.slepanska.db.UserDAO;

public class MockUserDao implements UserDAO {

	private long id = 0;
	private Map<Long, User> users = new HashMap<>();
	
	
	public User create(User user) throws DatabaseException {
		Long currentId = new Long(++id);
		user.setId(currentId);
		users.put(currentId, user);
		return user;
	}

	
	public User find(Long id) throws DatabaseException {
		return (User) users.get(id);
	}

	
	public void update(User user) throws DatabaseException {
	Long currentId = user.getId();
	users.remove(currentId);
	users.put(currentId, user);

	}

	
	public void delete(User user) throws DatabaseException {
		Long currentId = user.getId();
		users.remove(currentId);

	}


	public Collection<User> findAll() throws DatabaseException {
		return users.values();
	}

	
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		// TODO Auto-generated method stub

	}


	@Override
	public Collection find(String firstName, String lastName) throws DatabaseException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
