package fr.ca.sa.externalClients.database.nct.procedures.opportunities.getOpportunityData;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.commons.utilFunctions.TextUtilFunctions;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.common.procedures.bankHierarchy.bankParameters.GetBankParametersNCTResultItem;
import fr.ca.sa.externalClients.database.core.AbstractStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.IdName;
import fr.ca.sa.model.Opportunity;
import fr.ca.sa.model.OpportunitySubcategory;
import fr.ca.sa.nct.commons.NCTSystemConstants;
import fr.ca.sa.nct.commons.services.json.event.GetOpportunityDataMyTasksReq;

/**
 * 
 * Store procedure handler for getting client's active opportunities in bank
 * 
 * @author Djordje Przulj
 *
 */
public abstract class AbstractNCTDatabaseGetOpportunityData extends AbstractStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(AbstractNCTDatabaseGetOpportunityData.class);

	protected int userId;
	protected GetOpportunityDataMyTasksReq req;

	/**
	 * NCT Database Get Opportunity Data
	 * 
	 * @param userId User ID
	 * 
	 * @param req    Request
	 */
	public AbstractNCTDatabaseGetOpportunityData(int userId, GetOpportunityDataMyTasksReq req) {
		super();
		this.userId = userId;
		this.req = req;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetOpportunityDataNCTResultList retValue = new GetOpportunityDataNCTResultList();
		try {
			while (this.getResultSet().next()) {				
				OpportunitySubcategory opportunitySubcategory = new OpportunitySubcategory(this.getResultSet().getInt("OpportSubCatId"), null, null, null);
				Opportunity opportunity = new Opportunity(this.getResultSet().getInt("OpportunityId"), this.getResultSet().getInt("OpportTypeId"), opportunitySubcategory);
				HashMap<String, String> subcategoryNames = new HashMap<String, String>();
				HashMap<String, String> statuses = new HashMap<String, String>();
				setUpOpportunitySubCategoryNamesAndStatuses(this.getResultSet(), subcategoryNames, statuses);
				opportunity.setStatusNames(statuses);
				opportunity.setSubCatNames(subcategoryNames);
				opportunity.setContactPriority(this.getResultSet().getInt("ContactPriority"));
				opportunity.setCivility(this.getResultSet().getString("Civility"));
				opportunity.setCategoryPictureUri(NCTSystemConstants.getOpportunityCategoriesPictures().get(this.getResultSet().getInt("OpportTypeId")));
				Date opportunityStartDate = this.getResultSet().getDate("OpportStartDate");
				DateFormat df = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
				if (opportunityStartDate != null) {
					opportunity.setStartDate(df.format(opportunityStartDate));
				}
				Date opportunityExpirationDate = this.getResultSet().getDate("OpportExpirationDate");
				if (opportunityExpirationDate != null) {
					opportunity.setExpirationDate(df.format(opportunityExpirationDate));
				}
				opportunity.setTreatmentPeriod(this.getResultSet().getString("TreatmentPeriod"));
				opportunity.setPriorityId(this.getResultSet().getInt("OpportPriorityId"));
				opportunity.setStatusId(this.getResultSet().getInt("OpportStatusId"));
				
				Entity entity = new Entity(this.getResultSet().getInt("EntityId"), null, null, this.getResultSet().getString("EntityName"));
				opportunity.setEntity(entity);
				
				IdName segment = new IdName(this.getResultSet().getInt("SegmentId"), this.getResultSet().getString("Segment"));
				opportunity.setSegment(segment);
				
				Client client = new Client(this.getResultSet().getInt("ClientId"), 
						this.getResultSet().getString("ClientCode"),
						new IdName(0 ,this.getResultSet().getString("TypeOfClient")),
						this.getResultSet().getString("C_L"),
						this.getResultSet().getString("FirstName"),
						this.getResultSet().getString("FamilyName"),
						this.getResultSet().getInt("ClientAdvisorId"), 
						new Entity(this.getResultSet().getInt("ClientEntityId"), null, null, null));
				client.setPortfolioId(this.getResultSet().getInt("PortfolioId"));
				opportunity.setClient(client);		
				
				Collaborator advisor = new Collaborator(this.getResultSet().getInt("AdvisorId"), null, null, null);
				advisor.setName(this.getResultSet().getString("AdvisorName"));				
				opportunity.setAdvisor(advisor);
				
				retValue.getOpportunities().add(new GetOpportunityDataNCTResultItem(this.getResultSet().getInt("__RowId__"), opportunity)); 
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES);
		}
		return retValue;
	}

	private void setUpOpportunitySubCategoryNamesAndStatuses(ResultSet resultSet,
			HashMap<String, String> subcategoryNames, HashMap<String, String> statuses) throws SQLException {

		for (Map.Entry<String, GetBankParametersNCTResultItem> entry : NCTSystemConstants.getLanguageMap().entrySet()) {
			if (entry.getValue().getLangId() == NCTSystemConstants.getLanguageOrder1Id()) {
				subcategoryNames.put(entry.getKey(), resultSet.getString("OpportSubCatName_L1"));
				statuses.put(entry.getKey(), resultSet.getString("OpportStatusName_L1"));
			}

			if (entry.getValue().getLangId() == NCTSystemConstants.getLanguageOrder2Id()) {
				subcategoryNames.put(entry.getKey(), resultSet.getString("OpportSubCatName_L2"));
				statuses.put(entry.getKey(), resultSet.getString("OpportStatusName_L2"));
			}
		}

	}

	protected void setFirstSixParams(PreparedStatement ps) throws SQLException {
		ps.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
		ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getPageSize());
		String orderString = "ClientCode ASC ";
		if (this.req.getOrderColumnName() != null && this.req.getOrderCriteria() != null) {
			orderString = this.req.getOrderColumnName() + " " + this.req.getOrderCriteria() + " ";
		}
		ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, orderString);

		if (this.req.getOpportunityCategoryIds() != null && !this.req.getOpportunityCategoryIds().isEmpty()) {
			String catIdsString = TextUtilFunctions.convertIntArrayToSQLString(this.req.getOpportunityCategoryIds());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, catIdsString);
		} else {
			ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
		}

		if (this.req.getOpportunitySubcategoryId() != null) {
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getOpportunitySubcategoryId());
		} else {
			ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
		}

		if (this.req.getOpportunityPrioritiesIds() != null && !this.req.getOpportunityPrioritiesIds().isEmpty()) {
			String priorityIdsString = TextUtilFunctions
					.convertIntArrayToSQLString(this.req.getOpportunityPrioritiesIds());
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_6, priorityIdsString);
		} else {
			ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.VARCHAR);
		}
	}


	/**
	 * 
	 * @param ps
	 * @param firstIndex index of first parameter
	 * @throws SQLException
	 */
	protected void setLastFiveParams(PreparedStatement ps, int firstIndex) throws SQLException {
		if (this.req.getSegmentId() != null) {
			ps.setInt(firstIndex++, this.req.getSegmentId());
		} else {
			ps.setNull(firstIndex++, Types.INTEGER);
		}

		if (this.req.getFirstName() != null) {
			ps.setString(firstIndex++, this.req.getFirstName());
		} else {
			ps.setNull(firstIndex++, Types.VARCHAR);
		}

		if (this.req.getFamilyName() != null) {
			ps.setString(firstIndex++, this.req.getFamilyName());
		} else {
			ps.setNull(firstIndex++, Types.VARCHAR);
		}

		if (this.req.getClientCode() != null) {
			ps.setString(firstIndex++, this.req.getClientCode());
		} else {
			ps.setNull(firstIndex++, Types.VARCHAR);
		}

		if (this.req.getContactPriority() != null) {
			ps.setInt(firstIndex, this.req.getContactPriority());
		} else {
			ps.setNull(firstIndex, Types.INTEGER);
		}
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_LOAD_OPPORTUNITIES);
	}
}
