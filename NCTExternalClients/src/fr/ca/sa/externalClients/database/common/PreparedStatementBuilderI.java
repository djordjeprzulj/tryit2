package fr.ca.sa.externalClients.database.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;



/**
 * 
 * Interface for defining required methods while implementing store procedure
 * handler
 * 
 * @author Nemanja Ignjatov
 *
 */
public interface PreparedStatementBuilderI {

	/**
	 * 
	 * Build query that will be executed in DB using store procedure
	 * 
	 * @param connection
	 *            - Connection to DB through datasource
	 * @return - Query for invoking store procedure, including arguments
	 * @throws SQLException
	 */
	Statement buildPreparedStatement(Connection connection) throws SQLException;

	/**
	 * Predefined message that should shown to user if statement execution for
	 * store procedure fails
	 * 
	 * @return Error message
	 * 				Returns error message
	 * 
	 * @param ex
	 * 				Exception
	 * 
	 * @throws StatementExecutionException
	 * 				Throws Statement Execution Exception 
	 */
	void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException;
}
