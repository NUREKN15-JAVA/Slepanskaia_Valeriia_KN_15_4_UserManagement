package ua.nure.kn156.slepanska.db;

import java.util.Collection;
import java.util.Date;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import ua.nure.kn156.slepanska.User;
import ua.nure.kn156.slepanska.db.ConnectionFactory;
import ua.nure.kn156.slepanska.db.ConnectionFactoryImpl;
import ua.nure.kn156.slepanska.db.DatabaseException;
import ua.nure.kn156.slepanska.db.HsqldbUserDao;

/**
 * 
 * @author Valeriia Slepanska KN-15-6
 *
 */
public class HsqldbUserDaoTest extends DatabaseTestCase {

	/**
	 * Variable TEST_USER_ID_FROM_DB(described as final) contain a value of id
	 * of the user. Id must exist in usersDataSet.xml. Constant is used to
	 * create testcase for methods of finding by id, updatind and deleting
	 * entities from db
	 */

	private static final Long TEST_USER_ID_FROM_DB = (long) 1001;

	HsqldbUserDao dao;
	private ConnectionFactory connectionFactory;

	@Override

	protected void setUp() throws Exception {
		super.setUp();
		dao = new HsqldbUserDao(connectionFactory);
	}

	public void testCreate() {
		User user = new User();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setDateOfBirth(new Date());
		assertNull(user.getId());
		User createdUser;
		try {
			createdUser = dao.create(user);
			assertNotNull(createdUser);
			assertNotNull(createdUser.getId());
			assertEquals(user.getFullName(), createdUser.getFullName());
			assertEquals(user.getAge(), createdUser.getAge());
		} catch (DatabaseException e) {
			fail(e.toString());
		}
	}

	public void testFindUserById() {
		try {
			User finded_by_id_user = dao.find(TEST_USER_ID_FROM_DB);
			assertNotNull(finded_by_id_user);
			assertEquals(TEST_USER_ID_FROM_DB, finded_by_id_user.getId());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	public void testUpdateUser() {
		try {
			User user = dao.find(TEST_USER_ID_FROM_DB);
			user.setFirstName("Lera");
			user.setLastName("Slepanskaia");
			user.setDateOfBirth(new Date());
			dao.update(user);
			User updated_user = dao.find(TEST_USER_ID_FROM_DB);
			assertNotNull(updated_user);
			assertEquals(user.getFirstName(), updated_user.getFirstName());
			assertEquals(user.getLastName(), updated_user.getLastName());
			assertEquals(user.getAge(), updated_user.getAge());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}

	}

	public void testDeleteUser() {
		try {
			User user = dao.find(TEST_USER_ID_FROM_DB);
			assertNotNull(user);
			dao.delete(user);
			User deletedUser = dao.find(TEST_USER_ID_FROM_DB);
			assertNotNull(deletedUser);
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}

	}

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connectionFactory = new ConnectionFactoryImpl("org.hsqldb.jdbcDriver", "jdbc:hsqldb:file:db/usermanagement",
				"sa", "");
		return new DatabaseConnection(connectionFactory.createConnection());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		IDataSet dataSet = new XmlDataSet(getClass().getClassLoader().getResourceAsStream("usersDataSet.xml"));
		return dataSet;
	}

	public void testFindAll() {
		try {
			Collection collection = dao.findAll();
			assertNotNull("Collection is null", collection);
			assertEquals("Collection size", 2, collection.size());

		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
