package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.competitors.setProspectCompetitors;

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
 * Store procedure handler for setting prospects competitor
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetProspectCompetitor extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetProspectCompetitor.class);

	private int prospectId;

	private int competitorId;

	/**
	 * NCT Database Set Prospect Competitor
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 * 
	 * @param competitorId
	 * 				Competitor ID
	 */
	public NCTDatabaseSetProspectCompetitor(int userId, int prospectId, int competitorId) {
		super(userId);
		this.prospectId = prospectId;
		this.competitorId = competitorId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetProspectCompetitor ?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.prospectId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.competitorId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetProspectCompetitorNCTResultItem retValue = null;

		try {
			while (this.getResultSet().next()) {
				retValue = new SetProspectCompetitorNCTResultItem(this.getResultSet().getInt("CompetitorId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_SET_PROSPECT);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_SET_PROSPECT);
	}

}
