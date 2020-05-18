package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityDataCount;

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
import fr.ca.sa.nct.commons.services.json.event.GetOpportunityDataReq;

/**
 * 
 * Store procedure handler for getting client's active opportunities in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetOpportunityDataCount extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunityDataCount.class);

	private GetOpportunityDataReq req;

	/**
	 * NCT Database Get Opportunity Data Count
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseGetOpportunityDataCount(int userId, GetOpportunityDataReq req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spPagingRetrieveOpportCount ?,?,?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
	
			if (this.req.getOpportunityCategoryIds() != null && !this.req.getOpportunityCategoryIds().isEmpty()) {
				String catIdsString = TextUtilFunctions.convertIntArrayToSQLString(this.req.getOpportunityCategoryIds());
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_2, catIdsString);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.VARCHAR);
			}
	
			if (this.req.getOpportunitySubcategoryId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getOpportunitySubcategoryId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
	
			if (this.req.getOpportunityPrioritiesIds() != null && !this.req.getOpportunityPrioritiesIds().isEmpty()) {
				String priorityIdsString = TextUtilFunctions.convertIntArrayToSQLString(this.req.getOpportunityPrioritiesIds());
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, priorityIdsString);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
			}
			
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getBranchId());
			
			if (this.req.getAdvisorId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.req.getAdvisorId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.INTEGER);
			}
			if (this.req.getSegmentId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.req.getSegmentId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.INTEGER);
			}
	
			if (this.req.getFirstName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_8, this.req.getFirstName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.VARCHAR);
			}
	
			if (this.req.getFamilyName() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_9, this.req.getFamilyName());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.VARCHAR);
			}
	
			if (this.req.getClientCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_10, this.req.getClientCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_10, Types.VARCHAR);
			}
	
			if (this.req.getContactPriority() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_11, this.req.getContactPriority());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_11, Types.INTEGER);
			}
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
