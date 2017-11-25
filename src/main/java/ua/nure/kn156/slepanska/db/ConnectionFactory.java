package ua.nure.kn156.slepanska.db;

import java.sql.Connection;

public interface ConnectionFactory {
	Connection createConnection()throws DatabaseException;

}
