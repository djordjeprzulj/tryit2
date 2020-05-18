package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getAgreedOfferTypes;

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
 * Get SA agreed offer types
 * 
 * @author Stefan Djokic
 *
 */
public class NCTDatabaseGetSAAgreedProductTypes extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetSAAgreedProductTypes.class);

	private Integer languageId;

	/**
	 * NCT Database Get Sale Assistant Agreed Product Types
	 * 
	 * @param languageId
	 * 				Language ID
	 */
	public NCTDatabaseGetSAAgreedProductTypes(Integer languageId) {
		this.languageId = languageId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetSalAssAgreedOfferTypes ?,?");
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
		SAAgreedProductTypeResultList retValue = new SAAgreedProductTypeResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getAgreedProductTypesList()
						.add(new SAAgreedProductTypeItem(this.getResultSet().getInt("SalAssAgreedOfferTypeId"),
								this.getResultSet().getString("SalAssAgreedOfferTypeName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_AGREED_OFFER_TYPES);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_AGREED_OFFER_TYPES);
	}
}
