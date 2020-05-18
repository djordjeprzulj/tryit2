package fr.ca.sa.externalClients.database.core;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.DatabaseConnectionException;

/**
 * 
 * Proxy of datasource, for invoking store procedures on DB Connects to
 * datasource, creates and closes connection with DB
 * 
 * @author Nemanja Ignjatov
 *
 */
public class DatasourceProxy {

	private static final Logger LOGGER = Logger.getLogger(DatasourceProxy.class);

	private DataSource ds = null;
	private Connection connection = null;

	/**
	 * Finds datasource in app server
	 * 
	 * @throws DatabaseConnectionException
	 */
	public DatasourceProxy() throws DatabaseConnectionException {
		try {
			InitialContext ic = new InitialContext();
			Object obj = ic.lookup(NCTDatabaseConstants.DATASOURCE_PATH);
			if (obj instanceof DataSource) {
				ds = (DataSource) obj;	
			}
		} catch (NamingException ex) {
			LOGGER.error(ErrorConstants.ERROR_MSG_FAILED_TO_LOOKUP_DATASOURCE);
			LOGGER.error(ex);
			throw new DatabaseConnectionException(ErrorConstants.ERROR_MSG_FAILED_TO_LOOKUP_DATASOURCE);
		}
	}

	/**
	 * Connects to datasource and DB
	 * 
	 * @return Created connection to datasource and DB
	 * @throws SQLException
	 */
	protected Connection createConnection() throws SQLException {
		if (this.connection == null) {
			this.connection = ds.getConnection();
		}
		return this.connection;
	}

	/**
	 * Closes connection to DB, if any
	 * 
	 * @throws SQLException
	 */
	protected void closeConnection() throws SQLException {
		if (this.connection != null) {
			this.connection.close();
		}
	}
}
