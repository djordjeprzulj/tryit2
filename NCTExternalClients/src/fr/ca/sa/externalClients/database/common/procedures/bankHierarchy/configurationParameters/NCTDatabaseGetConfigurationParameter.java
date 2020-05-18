package fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.configurationParameters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.ParametersCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankSegments.NCTDatabaseGetBankSegments;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Store procedure handler for getting bank configuration parameter with specified name
 * 
 * @author Djordje Przulj
 *
 */
public class NCTDatabaseGetConfigurationParameter extends AbstractStoreProcedureHandler {
	
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankSegments.class);
	
	private String parameterName;

	/**
	 * default constructor for NCT Database Get Configuration Parameters
	 */
	public NCTDatabaseGetConfigurationParameter() {
		super();
	}

	/**
	 * NCT Database Get Configuration Parameter
	 * 
	 * @param parameterName
	 * 			Parameter name
	 */
	public NCTDatabaseGetConfigurationParameter(String parameterName) {
		super();
		this.parameterName = parameterName;
	}
	
	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetCONFIGURATION_PARAMS ?");
		try {
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_1, this.parameterName);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetConfigurationParametersNCTResultItem retItem = new GetConfigurationParametersNCTResultItem();
		try {
			if (this.getResultSet().next()) {
				retItem.setParameterId(this.getResultSet().getInt("PARAM_ID"));
				retItem.setConfigurationTypeName(this.getResultSet().getString("BANK_CONFIGURATION_TYPE_NAME"));
				retItem.setParameterName(this.getResultSet().getString("PARAM_NAME"));
				retItem.setParameterValue(this.getResultSet().getString("PARAM_VALUE"));
				retItem.setType(this.getResultSet().getString("DATA_TYPE"));
				retItem.setMinValue(this.getResultSet().getInt("MIN_VALUE"));
				retItem.setMaxValue(this.getResultSet().getInt("MAX_VALUE"));
				retItem.setMinLength(this.getResultSet().getInt("MIN_LENGTH"));
				retItem.setMaxLength(this.getResultSet().getInt("MAX_LENGTH"));
				retItem.setDescription(this.getResultSet().getString("DESCRIPTION"));				
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_GET_CONFIGURATION_PARAMETERS);
		}
		return retItem;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new ParametersCRUDException(ErrorConstants.ERROR_MSG_GET_CONFIGURATION_PARAMETERS);
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
}
