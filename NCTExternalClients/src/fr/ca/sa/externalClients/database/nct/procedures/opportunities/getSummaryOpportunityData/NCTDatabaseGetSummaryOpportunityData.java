package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getSummaryOpportunityData;

import fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityData.AbstractNCTDatabaseGetOpportunityData;
import fr.ca.sa.nct.commons.services.json.event.GetOpportunityDataReq;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.utilFunctions.TextUtilFunctions;

public class NCTDatabaseGetSummaryOpportunityData extends AbstractNCTDatabaseGetOpportunityData {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetSummaryOpportunityData.class);


	/**
	 * NCT Database Get Opportunity Data
	 * 
	 * @param userId User ID
	 * 
	 * @param req    Request
	 */
	public NCTDatabaseGetSummaryOpportunityData(int userId, GetOpportunityDataReq req) {
		super(userId, req);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {

		PreparedStatement ps = connection.prepareStatement("exec spPagingRetrieveOpportSum ?,?,?,?,?,?,?");
		try {
			
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getPageSize());
			if (this.req.getOpportunityCategoryIds() != null && !this.req.getOpportunityCategoryIds().isEmpty()) {
				String catIdsString = TextUtilFunctions
						.convertIntArrayToSQLString(this.req.getOpportunityCategoryIds());
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, catIdsString);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.VARCHAR);
			}

			if (this.req.getOpportunityPrioritiesIds() != null && !this.req.getOpportunityPrioritiesIds().isEmpty()) {
				String priorityIdsString = TextUtilFunctions
						.convertIntArrayToSQLString(this.req.getOpportunityPrioritiesIds());
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, priorityIdsString);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
			}
			if (this.req.getSegmentId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getSegmentId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			}
			if (this.req.getContactPriority() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.req.getContactPriority());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.INTEGER);
			}
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, ((GetOpportunityDataReq) this.req).getBranchId());

		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}
}
