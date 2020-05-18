package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.PortfoliosCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.Portfolio;
import fr.ca.sa.model.PortfolioType;
import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.nct.commons.services.json.portfolioManagement.GetPortfoliosRequest;

/**
 * 
 * Store procedure handler for getting portfolios for entity and advisor
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetPortfolioData extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetPortfolioData.class);

	private GetPortfoliosRequest req;

	/**
	 * NCT Database Get Portfolio Data
	 * 
	 * @param userId User ID
	 * 
	 * @param req    Request
	 */
	public NCTDatabaseGetPortfolioData(int userId, GetPortfoliosRequest req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spPagingRetrievePortfolioData ?,?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getPageSize());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getPageIndex());

			String orderString = "Name ASC ";
			if (this.req.getOrderColumnName() != null && this.req.getOrderCriteria() != null) {
				orderString = this.req.getOrderColumnName() + " " + this.req.getOrderCriteria() + " ";
			}
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, orderString);

			if (this.req.getEntityId() != null && this.req.getEntityId() != -1) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getEntityId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			}

			if (this.req.getAdvisorId() != null && this.req.getAdvisorId() != -1) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.req.getAdvisorId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.INTEGER);
			}

			if (this.req.getPortfolioTypeId() != null && this.req.getPortfolioTypeId() != -1) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.req.getPortfolioTypeId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.INTEGER);
			}
			if (this.req.getPortfolioCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_8, this.req.getPortfolioCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.NVARCHAR);
			}
			if (this.req.getClientLead() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_9, this.req.getClientLead());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_9, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetPortfolioDataNCTResultList retValue = new GetPortfolioDataNCTResultList();
		try {
			while (this.getResultSet().next()) {

				PortfolioType portfolioType = new PortfolioType(this.getResultSet().getInt("TypeId"),
						this.getResultSet().getString("TypeName"), this.getResultSet().getString("TypeCode")); 
				Entity entity = new Entity(this.getResultSet().getInt("EntityId"), null, null, this.getResultSet().getString("EntityName"));		
				Collaborator advisor = new Collaborator(this.getResultSet().getInt("OwnerId"), this.getResultSet().getString("OwnerFirstName"),
						this.getResultSet().getString("OwnerLastName"), null); 
				
				Portfolio portfolio = new Portfolio(this.getResultSet().getInt("Id"), 
						this.getResultSet().getInt("__RowId__"),
						this.getResultSet().getString("Name"),
						this.getResultSet().getString("Code"), 
						this.getResultSet().getInt("Size"), this.getResultSet().getInt("FTESize"),
						portfolioType, entity, advisor);
				
				retValue.getPortfolios().add(new GetPortfolioDataNCTResultItem(portfolio));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIOS);
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIOS);
	}
}
