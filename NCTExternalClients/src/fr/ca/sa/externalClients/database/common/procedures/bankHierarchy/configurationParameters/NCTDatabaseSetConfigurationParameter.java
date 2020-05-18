package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationParameters;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting bank configuration parameters
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetConfigurationParameter extends AbstractUserStoreProcedureHandler {
	
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetConfigurationParameter.class);

	private int parameterId;
	private String parameterValue;

	/**
	 * NCT Database Set Configuration Parameter
	 * 
	 * @param userId
	 * @param parameterId
	 * @param parameterValue
	 */
	public NCTDatabaseSetConfigurationParameter(int userId, int parameterId, String parameterValue) {
		super(userId);
		this.parameterId = parameterId;
		this.parameterValue = parameterValue;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement cs = connection.prepareCall("exec spSetCONFIGURATION_PARAMS ?,?,?");
		try {
			setUser(cs);			
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.parameterId);
			cs.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.parameterValue);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_SET_CONFIGURATION_PARAMETERS);
	}
}
