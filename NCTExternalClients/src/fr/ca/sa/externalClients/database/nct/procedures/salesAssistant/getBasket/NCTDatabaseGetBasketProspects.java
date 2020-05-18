package fr.ca.sa.externalClients.database.nct.procedures.salesAssistant.getBasket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.SalesAssistantCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;

/**
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetBasketProspects extends AbstractUserBasketDataSourceProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBasketProspects.class);

	/**
	 * Constructor for all fields initialization.
	 * 
	 * @param userId User ID
	 * @param basketId Basket ID
	 * @param dataSource Data source
	 */
	public NCTDatabaseGetBasketProspects(int userId, int basketId, String dataSource) {
		super(userId, basketId, dataSource);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssBasketProspects ?,?,?");
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
		GetBasketProspectsResultList prospectList = new GetBasketProspectsResultList();
		try {
			while (this.getResultSet().next()) {
				prospectList.getProspectList()
						.add(new GetBasketProspectsResultItem(this.getResultSet().getInt("ClientId"),
								this.getResultSet().getString("Name"), this.getResultSet().getString("Surname")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
		}
		return prospectList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
	}

}
