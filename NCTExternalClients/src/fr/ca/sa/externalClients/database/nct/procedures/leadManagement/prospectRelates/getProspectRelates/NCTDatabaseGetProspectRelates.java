package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.prospectRelates.getProspectRelates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LeadManagementCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetProspectRelates extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetProspectRelates.class);

	private int prospectId;

	/**
	 * NCT Database Get Prospect Relates
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 */
	public NCTDatabaseGetProspectRelates(int userId, int prospectId) {
		super(userId);
		this.prospectId = prospectId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetProspectRelates ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.prospectId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetProspectRelatesNCTResultList retValue = new GetProspectRelatesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getRelatesList().add(new GetProspectRelatesNCTResultItem(
						this.getResultSet().getInt("ClientId"), this.getResultSet().getString("ClientName"),
						this.getResultSet().getString("ClientSurname"), this.getResultSet().getInt("RelateId")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_GET_PROSPECT_DATA);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_GET_PROSPECT_DATA);
	}
}
