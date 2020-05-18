package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.nct.commons.services.json.event.GetOpportunityDataReq;

/**
 * 
 * Store procedure handler for getting client's active opportunities in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetOpportunityData extends AbstractNCTDatabaseGetOpportunityData {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunityData.class);
	
	public static final int INDEX_OF_FIRST_PARAMETER = 9;
	
	/**
	 * NCT Database Get Opportunity Data
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseGetOpportunityData(int userId, GetOpportunityDataReq req) {
		super(userId, req);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 

		PreparedStatement ps = connection
				.prepareStatement("exec spPagingRetrieveOpportData ?,?,?,?,?,?,?,?,?,?,?,?,?");
		try {	
			setFirstSixParams(ps);
			GetOpportunityDataReq dataReq = null;
			if (this.req instanceof GetOpportunityDataReq) {
				dataReq = (GetOpportunityDataReq) this.req;
			}
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, (dataReq).getBranchId());
		
			if ((dataReq).getAdvisorId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_8, (dataReq).getAdvisorId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.INTEGER);
			}
			
			setLastFiveParams(ps, INDEX_OF_FIRST_PARAMETER);
	
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}
}
