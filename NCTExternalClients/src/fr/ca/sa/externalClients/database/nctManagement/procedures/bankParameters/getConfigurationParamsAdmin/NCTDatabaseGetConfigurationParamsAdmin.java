package fr.ca.sa.externalClients.database.nctManagement.procedures.bankParameters.getConfigurationParamsAdmin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetConfigurationParamsAdmin extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetConfigurationParamsAdmin.class);

	/**
	 * default constructor for NCT Database Get Configuration Parameters Admin
	 */
	public NCTDatabaseGetConfigurationParamsAdmin() {
		super();
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		return connection.prepareStatement("exec spGetCONFIGURATION_PARAMS_Admin");
	}


	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetConfigurationParamsAdminNCTResultList retList = new GetConfigurationParamsAdminNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getParamsList().add(new GetConfigurationParamsAdminNCTResultItem(
						this.getResultSet().getInt("PARAM_ID"),
						this.getResultSet().getString("PARAM_NAME"), this.getResultSet().getString("PARAM_VALUE"),
						this.getResultSet().getString("DATA_TYPE")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_GET_CONFIGURATION_PARAMETERS);
		}
		 return retList;
	
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_GET_CONFIGURATION_PARAMETERS);
	}
}

