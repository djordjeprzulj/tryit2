package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getAgreedProductStatuses;

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
 * Get SA agreed offer statuses
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetSAAgreedProductStatuses extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetSAAgreedProductStatuses.class);

	private Integer languageId;

	/**
	 * NCT Database Get Sales Assistant Agreed Product Statuses
	 * 
	 * @param languageId
	 * 				Language ID
	 */
	public NCTDatabaseGetSAAgreedProductStatuses(Integer languageId) {
		this.languageId = languageId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetSalAssAgreedOfferStatuses ?,?");
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
		SAAgreedProductStatusResultList retValue = new SAAgreedProductStatusResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getAgreedProductStatusesList()
						.add(new SAAgreedProductStatusItem(this.getResultSet().getInt("SalAssAgreedOfferStatusId"),
								this.getResultSet().getString("SalAssAgreedOfferStatusName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_AGREED_OFFER_STATUSES);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_AGREED_OFFER_STATUSES);
	}
}
