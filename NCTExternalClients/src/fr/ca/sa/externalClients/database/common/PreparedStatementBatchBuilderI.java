package fr.ca.sa.externalClients.database.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 * Interface for defining required methods while implementing store procedure handler for batch bulk processing
 * 
 * @author Nemanja Ignjatov
 *
 */
public interface PreparedStatementBatchBuilderI extends PreparedStatementBuilderI {

	/**
	 * Set Connection Auto Commit
	 * 
	 * @param connection
	 * 				Connection
	 * 
	 * @throws SQLException
	 * 				Throws SQL Exception 
	 */
	void setConnectionAutoCommit(Connection connection) throws SQLException;
	
	/**
	 * Set Connection Auto Commit
	 * 
	 * @param statement
	 * 				Statement
	 * 
	 * @param connection
	 * 				Connection
	 * 
	 * @throws SQLException
	 * 				Throws SQL Exception
	 */
	void commitBatchBulk(PreparedStatement statement, Connection connection) throws SQLException;
	
}
