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
public class NCTDatabaseGetBasketProjects extends AbstractUserBasketDataSourceProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetBasketProjects.class);

	/**
	 * Constructor for all fields initialization.
	 * 
	 * @param userId User ID
	 * @param basketId Basket ID
	 * @param dataSource Data source
	 */
	public NCTDatabaseGetBasketProjects(int userId, int basketId, String dataSource) {
		super(userId, basketId, dataSource);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetSalAssBasketProjects ?,?,?");
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
		GetBasketProjectResultList resultList = new GetBasketProjectResultList();
		try {
			while (this.getResultSet().next()) {
				resultList.getProjectList()
						.add(new GetBasketProjectResultItem(this.getResultSet().getInt("ProjectCategoryId"),
								this.getResultSet().getString("ProjectCategoryNameL1"),
								this.getResultSet().getString("ProjectCategoryNameL2"),
								this.getResultSet().getTimestamp("TargetDate"), this.getResultSet().getDouble("Amount"),
								this.getResultSet().getInt("CurrencyId"), this.getResultSet().getString("Comment")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
		}
		return resultList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new SalesAssistantCRUDException(ErrorConstants.ERROR_MSG_LOAD_BASKET);
	}
}
