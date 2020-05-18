package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.saveBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket.AbstractUserBasketStoreProcedureHandler;

/**
 * 
 * Store procedure for setting not interested project for specific basket
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseSetNotInterestedProjects extends AbstractUserBasketStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetNotInterestedProjects.class);
	
	private Integer projectId;

	private Integer notIntReason;
	
	private Integer opportunityId;

	/**
	 * NCT Database Set Not Interested Projects
	 * 
	 * @param userId
	 * 				User ID 
	 * 
	 * @param basketId
	 * 				Basket ID
	 * 
	 * @param projectId
	 * 				Project ID
	 * 
	 * @param notIntReason
	 * 				Not interested reason
	 */
	public NCTDatabaseSetNotInterestedProjects(int userId, Integer basketId, Integer projectId, Integer notIntReason, Integer opportunityId) {
		super(userId, basketId);
		this.projectId = projectId;
		this.notIntReason = notIntReason;
		this.opportunityId = opportunityId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetSalAssOfferNotInteresList ?,?,?,?,?");
		try {	
			setUserAndBasket(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.projectId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.notIntReason);
			if (this.opportunityId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_5, this.opportunityId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_5, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}														
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_SAVE_BASKET);
	}

}
