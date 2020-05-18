package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioDetailsData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.PortfoliosCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.model.Collaborator;
import fr.ca.sa.model.Client;
import fr.ca.sa.model.Entity;
import fr.ca.sa.model.IdName;
import fr.ca.sa.nct.commons.services.json.portfolioManagement.GetPortfolioDetailsRequest;

/**
 * 
 * Routine for retrieving portfolio details (clients in portfolio)
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetPortfolioDetailsData extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetPortfolioDetailsData.class);

	private GetPortfolioDetailsRequest req;

	/**
	 * NCT Database Get Portfolio Details Data
	 * 
	 * @param userId User ID
	 * 
	 * @param req    Request
	 */
	public NCTDatabaseGetPortfolioDetailsData(int userId, GetPortfolioDetailsRequest req) {
		super(userId);
		this.req = req;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spPagingRetrievePortfDetsData ?,?,?,?,?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.req.getPageSize());
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.req.getPageIndex());

			String orderString = "ClientName ASC ";
			if (this.req.getOrderColumnName() != null && this.req.getOrderCriteria() != null) {
				orderString = this.req.getOrderColumnName() + " " + this.req.getOrderCriteria() + " ";
			}
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, orderString);

			if (this.req.getPortfolioId() != null && this.req.getPortfolioId() != -1) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.req.getPortfolioId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			}

			if (this.req.getClientTypeId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_6, this.req.getClientTypeId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_6, Types.INTEGER);
			}

			if (this.req.getClientSegmentId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_7, this.req.getClientSegmentId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_7, Types.INTEGER);
			}
			if (this.req.getClientCode() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_8, this.req.getClientCode());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_8, Types.NVARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetPortfolioDetailsDataNCTResultList detailsList = new GetPortfolioDetailsDataNCTResultList();
		try {
			while (this.getResultSet().next()) {
				Client client = new Client(this.getResultSet().getInt("ClientId"), 
											this.getResultSet().getString("ClientName"), 
											new Entity(this.getResultSet().getInt("ClientEntityId"), null, null, null),
											this.getResultSet().getInt("PortfolioId"),					
											this.getResultSet().getString("C_L"));
				client.setCode(this.getResultSet().getString("ClientCode"));
				client.setType(new IdName(0, this.getResultSet().getString("ClientType")));
				
				client.setAdvisorId(this.getResultSet().getInt("ClientAdvisorId"));
				client.setSegment(this.getResultSet().getString("ClientSegment"));
				client.setMarked(this.getResultSet().getInt("RedColor") == 1);
				client.setActive(this.getResultSet().getInt("ActiveClient") == 1);
				client.setReceiveSalaryInBank(this.getResultSet().getInt("ReceiveSalary") == 1);
				client.setContactPriority(this.getResultSet().getInt("contactPriority"));
				Timestamp dateOfLastContact = this.getResultSet().getTimestamp("DateOfLastContact");
				SimpleDateFormat formatter = new SimpleDateFormat(NCTDatabaseConstants.BACKBONE_FULL_DATETIME_FORMAT);
				if (dateOfLastContact != null) {
					client.setDateOfLastContact(formatter.format(dateOfLastContact));
				}
				
				Collaborator lastContactAdvisor = new Collaborator();
				lastContactAdvisor.setName(this.getResultSet().getString("LastContactAdvisorName"));
				
				client.setLastContactCollaborator(lastContactAdvisor);
				
				detailsList.getPortfolioClients().add(new GetPortfolioDetailsDataNCTResultItem(this.getResultSet().getInt("__RowId__"), client)); 
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIOS);
		}
		return detailsList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIOS);
	}

}
