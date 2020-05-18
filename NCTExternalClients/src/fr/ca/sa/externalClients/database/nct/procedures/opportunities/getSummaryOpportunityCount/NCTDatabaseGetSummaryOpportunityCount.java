package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSummaryOpportunityCount;

import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.services.json.event.GetOpportunityDataReq;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.utilFunctions.TextUtilFunctions;

public class NCTDatabaseGetSummaryOpportunityCount extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetSummaryOpportunityCount.class);
	private GetOpportunityDataReq req;

	/**
	 * NCT Database Get Opportunity Data
	 * 
	 * @param userId User ID
	 * 
	 * @param req    Request
	 */
	public NCTDatabaseGetSummaryOpportunityCount(int userId, GetOpportunityDataReq req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {

		PreparedStatement ps = connection.prepareStatement("exec spGetOpportSum ?,?,?,?,?,?");
		try {

			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
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
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, ((GetOpportunityDataReq) this.req).getBranchId());

		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();

	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetSummaryOpportunityCountResultList retValue = new GetSummaryOpportunityCountResultList();
		try {
			while (this.getResultSet().next()) {
				retValue.getResultList()
						.add(new GetSummaryOpportunityCountResultItem(this.getResultSet().getInt("OpportTypeId"),
								this.getResultSet().getInt("OpportSubCatId"), this.getResultSet().getInt("EntityId"),
								this.getResultSet().getInt("OppSum")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}
		return retValue;
	}
}
