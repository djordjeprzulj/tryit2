package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getClientActiveOpportunities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Opportunity;
import fr.ca.sa.nct.commons.NCTSystemConstants;
import fr.ca.sa.nct.commons.services.json.event.GetClientActiveOpportunities;

/**
 * 
 * Store procedure handler for getting client's active opportunities in bank
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetActiveUserOpportunities extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetActiveUserOpportunities.class);

	private GetClientActiveOpportunities req;

	/**
	 * NCT Database Get Active User Opportunities
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param req
	 * 				Request
	 */
	public NCTDatabaseGetActiveUserOpportunities(int userId, GetClientActiveOpportunities req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetActiveOpportByClientId ?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getClientId());
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetClientActiveOpportunitiesNCTResultList retValue = new GetClientActiveOpportunitiesNCTResultList();
		try {
			while (this.getResultSet().next()) {
				Opportunity opportunity = new Opportunity(this.getResultSet().getInt("OpportunityId"), this.getResultSet().getInt("OpportTypeId"), null);
				opportunity.setStartDate(this.getResultSet().getString("OpportStartDate"));
				opportunity.setExpirationDate(this.getResultSet().getString("OpportExpirationDate"));
				opportunity.setTreatmentPeriod(this.getResultSet().getString("TreatmentPeriod")); 				
				retValue.getOpportunities().add(new GetClientActiveOpportunitiesNCTResultItem(
						opportunity,
						this.getResultSet().getString("OpportSubCatName_L1"),
						this.getResultSet().getString("OpportSubCatName_L2"),
						this.getResultSet().getInt("OpportStateId"),
						this.getResultSet().getString("OpportBlueprintsLink"),
						NCTSystemConstants.getOpportunityCategoriesPictures().get(this.getResultSet().getInt("OpportTypeId")),
						this.getResultSet().getInt("Cancel"), 
						this.getResultSet().getInt("Treat_OL"),
						this.getResultSet().getInt("Treat_QCR")));
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
