package fr.ca.sa.externalClients.database.procedures.auth.validateUsernameSSO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.CriticalSystemErrorException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.exceptions.databaseExceptions.WrongCredentialException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Store procedure handler for checking user account in DB on SSO login
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseValidateSSOSession extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseValidateSSOSession.class);

	private String operatorId;
	private String groupListCSV;
	private Integer placeId;

	/**
	 * NCT Database Validate Username SSO
	 * 
	 * @param operatorId   operator Id
	 * 
	 * @param groupListCSV Group list CSV
	 * 
	 * @param placeId      Place ID
	 */
	public NCTDatabaseValidateSSOSession(String operatorId, String groupListCSV, Integer placeId) {
		super();
		this.operatorId = operatorId;
		this.groupListCSV = groupListCSV;
		this.placeId = placeId;
	}

	/**
	 * Build Prepared Statement
	 * 
	 * @param connection Connection
	 * 
	 * @return PreparedStatement Returns prepared statement
	 */
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spValidateUsernameSSO ?,?,?");
		try {
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_1, operatorId);

			if (this.groupListCSV != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, this.groupListCSV);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.VARCHAR);
			}

			if (this.placeId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.placeId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		StoreProcedureResult retValue = null;
		try {
			while (this.getResultSet().next()) {
				int result = this.getResultSet().getInt("UserId");
				if (result == NCTDatabaseConstants.getLoginUserNotActive()) {
					throw new WrongCredentialException(ErrorConstants.ERROR_MSG_USER_NOT_ACTIVE);
				} else if (result == NCTDatabaseConstants.getLoginUserUnknown()) {
					throw new WrongCredentialException();
				}

				retValue = new ValidateSSOSessionNCTResult(result, this.getResultSet().getString("UserName"),
						this.getResultSet().getInt("UserIdCore"), this.getResultSet().getInt("UserRoleId"));
			}
		} catch (NumberFormatException ex) {
			LOGGER.error(ex);
			throw new CriticalSystemErrorException();
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new WrongCredentialException();
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new WrongCredentialException();
	}
}
