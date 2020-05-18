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
 * Store procedure handler for getting bank configuration parameters
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetConfigurationParameters extends AbstractStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBankSegments.class);

	private String name;

	/**
	 * default constructor for NCT Database Get Configuration Parameters
	 */
	public NCTDatabaseGetConfigurationParameters(String name) {
		super();
		this.name = name;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetCONFIGURATION_PARAMS ?");
		try {
			if (this.name != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_1, this.name);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_1, java.sql.Types.VARCHAR);
			}
		} catch(SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetConfigurationParametersNCTResultList retList = new GetConfigurationParametersNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retList.getParameters().add(new GetConfigurationParametersNCTResultItem(
						this.getResultSet().getInt("PARAM_ID"),
						this.getResultSet().getString("BANK_CONFIGURATION_TYPE_NAME"),
						this.getResultSet().getString("PARAM_NAME"), this.getResultSet().getString("PARAM_VALUE"),
						this.getResultSet().getString("DATA_TYPE"), this.getResultSet().getInt("MIN_VALUE"),
						this.getResultSet().getInt("MAX_VALUE"), this.getResultSet().getInt("MIN_LENGTH"),
						this.getResultSet().getInt("MAX_LENGTH"), this.getResultSet().getString("DESCRIPTION")));
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
