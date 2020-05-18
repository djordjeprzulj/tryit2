package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters.GetBankParametersNCTResultItem;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.nct.commons.NCTSystemConstants;
import fr.ca.sa.nct.commons.services.json.event.GetOpportunityDetailsRequest;

/**
 * 
 * @author Milos Topalovic
 *
 */
public class NCTDatabaseGetOpportunityDetails extends AbstractUserStoreProcedureHandler {
	
	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetOpportunityDetails.class);

	private GetOpportunityDetailsRequest req;

	/**
	 * NCT Database Get Opportunity Details
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseGetOpportunityDetails(int userId, GetOpportunityDetailsRequest req) {
		super(userId);
		this.req = req;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetOpportDetails ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getOpportunityId());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}				
		return ps;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES_DETAILS);
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOpportunityDetailsNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				
				HashMap<String, String> subcategoryNames = new HashMap<String, String>();

				setUpOpportunitySubCategoryNames(this.getResultSet(), subcategoryNames);

				retValue = new GetOpportunityDetailsNCTResultItem(this.getResultSet().getString("OptDescription"),
						this.getResultSet().getString("SPD"), this.getResultSet().getInt("Cancel"),
						this.getResultSet().getInt("Treat_OL"), this.getResultSet().getInt("Treat_QCR"),
						this.getResultSet().getString("OpportSubCatName_L1"), this.getResultSet().getString("OpportSubCatName_L2"),
						this.getResultSet().getString("OpportStartDate"), this.getResultSet().getString("OpportExpirationDate"),subcategoryNames);

			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES_DETAILS);
		}
		return retValue;
	}
	
	private void setUpOpportunitySubCategoryNames(ResultSet resultSet,
			HashMap<String, String> subcategoryNames) throws SQLException {

		for (Map.Entry<String, GetBankParametersNCTResultItem> entry : NCTSystemConstants.getLanguageMap().entrySet()) {
			if (entry.getValue().getLangOrder() == NCTDatabaseConstants.getLanguageId1()) {
				subcategoryNames.put(entry.getKey(), resultSet.getString("OpportSubCatName_L1"));
			}

			if (entry.getValue().getLangOrder() == NCTDatabaseConstants.getLanguageId2()) {
				subcategoryNames.put(entry.getKey(), resultSet.getString("OpportSubCatName_L2"));
			}
		}

	}

}
