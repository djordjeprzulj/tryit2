package fr.ca.sa.externalClients.database.nct.procedures.opportunities.mytasks.getOpportunityData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityData.AbstractNCTDatabaseGetOpportunityData;
import fr.ca.sa.nct.commons.services.json.event.GetOpportunityDataMyTasksReq;

/**
 * 
 * Store procedure handler for getting client's active opportunities in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetOpportunityDataMyTasks extends AbstractNCTDatabaseGetOpportunityData {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunityDataMyTasks.class);	
	
	public static final int INDEX_OF_FIRST_PARAMETER = 7;
	
	/**
	 * NCT Database Get Opportunity Data
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseGetOpportunityDataMyTasks(int userId, GetOpportunityDataMyTasksReq req) {
		super(userId, req);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 

		PreparedStatement ps = connection
				.prepareStatement("exec spPagingRetrieveOpportDataMyTasks ?,?,?,?,?,?,?,?,?,?,?");
		try {
			setFirstSixParams(ps);						
			setLastFiveParams(ps, INDEX_OF_FIRST_PARAMETER);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}
}
