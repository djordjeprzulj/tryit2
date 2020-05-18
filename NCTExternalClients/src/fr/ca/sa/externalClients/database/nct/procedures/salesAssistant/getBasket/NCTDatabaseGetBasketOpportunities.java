package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters.GetBankParametersNCTResultItem;
import fr.ca.sa.model.Opportunity;
import fr.ca.sa.nct.commons.NCTSystemConstants;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetBasketOpportunities extends AbstractUserBasketDataSourceProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBasketOpportunities.class);

	/**
	 * Constructor for all fields initialization.
	 * 
	 * @param userId User ID
	 * @param basketId Basket ID
	 * @param dataSource Data source
	 */
	public NCTDatabaseGetBasketOpportunities(int userId, int basketId, String dataSource) {
		super(userId, basketId, dataSource);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssBasketOpport ?,?,?");
		try {		
			setUserBasketAndDataSource(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}							
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetBasketOpportunityResultList resultList = new GetBasketOpportunityResultList();
		try {
			while (this.getResultSet().next()) {
				HashMap<String, String> opportunityNames = new HashMap<>();

				setUpOpportunitySubCategoryNames(this.getResultSet(), opportunityNames);

				Opportunity opportunity = new Opportunity(this.getResultSet().getInt("OpportunityId"),
						this.getResultSet().getInt("OpportunityTypeId"), null);
				Timestamp tsStartDate = this.getResultSet().getTimestamp("OpportStartDate");
				SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.getBackboneOnlyDateDatetimeFormat());
				String strStartDate = formatter.format(tsStartDate);
				opportunity.setStartDate(strStartDate);
				Timestamp tsExpirationDate = this.getResultSet().getTimestamp("OpportExpirationDate");
				String strExpDate = formatter.format(tsExpirationDate);
				opportunity.setExpirationDate(strExpDate);
				opportunity.setNames(opportunityNames);
				opportunity.setTreatmentPeriod(this.getResultSet().getString("TreatmentPeriod"));
				opportunity.setStatusId(this.getResultSet().getInt("OpportStatusId"));
				opportunity.setCategoryPictureUri(NCTSystemConstants.getOpportunityCategoriesPictures().get(this.getResultSet().getInt("OpportunityTypeId")));
				resultList.getOpportunityList().add(new GetBasketOpportunityResultItem(opportunity));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
		}
		return resultList;
	}

	private void setUpOpportunitySubCategoryNames(ResultSet resultSet, HashMap<String, String> opportunityNames)
			throws SQLException {

		for (Map.Entry<String, GetBankParametersNCTResultItem> entry : NCTSystemConstants.getLanguageMap().entrySet()) {
			if (entry.getValue().getLangId() == NCTDatabaseConstants.getLanguageId1()) {
				opportunityNames.put(entry.getKey(), resultSet.getString("OpportSubCatName_L1"));
			}

			if (entry.getValue().getLangId() == NCTDatabaseConstants.getLanguageId2()) {
				opportunityNames.put(entry.getKey(), resultSet.getString("OpportSubCatName_L2"));
			}
		}
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
	}
}
