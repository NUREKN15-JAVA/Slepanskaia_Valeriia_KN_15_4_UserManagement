package ua.nure.kn156.slepanska.db;

import java.util.Collection;

import ua.nure.kn156.slepanska.User;

/**
 * Interface for User class which implements DAO pattern with all CRUD opps
 * 
 * @author Valeriia Slepanska KN-15-6
 *
 */

public interface UserDAO {
	/**
	 * Add user into DB users table and get new user`s id from db
	 * 
	 * @param user
	 *            all fields of user must be non-null except id field
	 * @return copy of user from db with id auto created
	 * @throws DatabaseException
	 *             in case of any error with db
	 */
	User create(User user) throws DatabaseException;

	/**
	 * Find user in users table by user`s id
	 * 
	 * @param id
	 *            of user which must be found by method
	 * @return user of specified id.In case if there is no user with specified
	 *         id, the method return null
	 * @throws DatabaseException
	 *             in case of any error with db
	 */
	User find(Long id) throws DatabaseException;

	/**
	 * Update entries in the users table
	 * 
	 * @param entries
	 *            of user which method must update
	 * @throws DatabaseException
	 *             in case of any error with db
	 */
	void update(User user) throws DatabaseException;

	/**
	 * Delete entries from users table by user`s id
	 * 
	 * @param entries
	 *            of user which method must remove
	 * @throws DatabaseException
	 *             in case of any error with db
	 */

	void delete(User user) throws DatabaseException;

	/**
	 * Find all of users` entities in the db
	 * 
	 * @return collection of all users`entities in the db. If it`s empty, the
	 *         method return empty list
	 * @throws DatabaseException
	 *             in case of any error with db
	 */

	Collection<User> findAll() throws DatabaseException;

	/**
	 * Set of connection configuration parameters that has been defined by an
	 * administrator
	 * 
	 * @param connectionFactory
	 */
	void setConnectionFactory(ConnectionFactory connectionFactory);
}