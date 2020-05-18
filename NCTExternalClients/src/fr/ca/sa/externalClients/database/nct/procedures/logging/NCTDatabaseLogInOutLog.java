package fr.ca.sa.externalClients.database.nct.procedures.logging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.WrongCredentialException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure for logging log off
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseLogInOutLog extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseLogInOutLog.class);

	private Integer type;

	/**
	 * NCT Database Log In/Out Log
	 * 
	 * @param type
	 * 				Type
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseLogInOutLog(Integer type, Integer userId) {
		super(userId);
		this.type = type;
	}

	/**
	 * Build Prepared Statement
	 * 
	 * @param connection
	 * 				Connection
	 * 
	 * @return PreparedStatement
	 * 				Returns prepared statement
	 */
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetTransactLogin ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.type);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.userId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new WrongCredentialException();
	}
}
