package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSummaryOpportunityCountSum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.utilFunctions.TextUtilFunctions;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityDataCount.GetOpportunityDataCountNCTResult;
import fr.ca.sa.nct.commons.services.json.event.GetOpportunityDataReq;

/**
 * 
 * Store procedure handler for getting client's active opportunities in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetOpportunityCountSum extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunityCountSum.class);

	private GetOpportunityDataReq req;

	/**
	 * NCT Database Get Opportunity Data Count
	 * 
	 * @param userId User ID
	 * 
	 * @param req    Request
	 */
	public NCTDatabaseGetOpportunityCountSum(int userId, GetOpportunityDataReq req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spPagingRetrieveOpportCountSum ?,?,?,?,?,?");
		try {
			setUser(ps);

			if (this.req.getOpportunityCategoryIds() != null && !this.req.getOpportunityCategoryIds().isEmpty()) {
				String catIdsString = TextUtilFunctions
						.convertIntArrayToSQLString(this.req.getOpportunityCategoryIds());
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, catIdsString);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.VARCHAR);
			}
			if (this.req.getOpportunityPrioritiesIds() != null && !this.req.getOpportunityPrioritiesIds().isEmpty()) {
				String priorityIdsString = TextUtilFunctions
						.convertIntArrayToSQLString(this.req.getOpportunityPrioritiesIds());
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, priorityIdsString);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.VARCHAR);
			}
			if (this.req.getSegmentId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.req.getSegmentId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.INTEGER);
			}
			if (this.req.getContactPriority() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getContactPriority());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			}
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.req.getBranchId());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOpportunityDataCountNCTResult retValue = null;
		try {
			while (this.getResultSet().next()) {
				if (retValue == null) {
					retValue = new GetOpportunityDataCountNCTResult(this.getResultSet().getInt("RecordCount"));
				}
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES);
	}
}
