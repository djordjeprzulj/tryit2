package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getNotIntReasons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;

/**
 * 
 * Get SA not interested reasons
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetSANotIntReasons extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetSANotIntReasons.class);

	private Integer languageId;

	/**
	 * NCT Database Get Sales Assistant Not Interested Reasons
	 * 
	 * @param languageId
	 * 				Language ID
	 */
	public NCTDatabaseGetSANotIntReasons(Integer languageId) {
		this.languageId = languageId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetProductNotIntReasons ?,?");
		try {		
			cs.setNull(NCTDatabaseConstants.SP_ARG_NR_1, Types.INTEGER);
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.languageId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}		
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SANotIntReasonResultList retValue = new SANotIntReasonResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getNotIntReasonList()
						.add(new SANotIntReasonItem(this.getResultSet().getInt("ProductNotIntReasonId"),
								this.getResultSet().getString("ProductNotIntReasonName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_NEEDS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_NEEDS);
	}

}
