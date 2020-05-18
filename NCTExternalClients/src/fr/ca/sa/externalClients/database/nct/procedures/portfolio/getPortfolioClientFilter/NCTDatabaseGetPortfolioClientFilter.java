package fr.ca.sa.externalClients.database.nct.procedures.portfolio.getPortfolioClientFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.PortfoliosCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * @author Nemanj Ignjatov
 *
 */
public class NCTDatabaseGetPortfolioClientFilter extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetPortfolioClientFilter.class);
	
	private Integer langId;
	
	/**
	 * NCT Database Get Portfolio Client Filter
	 * 
	 * @param userId
	 * 			User ID
	 * 
	 * @param langId
	 * 			Language ID
	 */
	public NCTDatabaseGetPortfolioClientFilter(int userId, Integer langId) {
		super(userId); 
		this.langId = langId;
	}
	
	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetPortfolioClientFilter ?,?");
		try {
			setUser(ps);
	
			if (this.langId != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.langId);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}
	
	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetPortfolioClientFilterNCTResultList retValue = new GetPortfolioClientFilterNCTResultList();
		try {
			while (this.getResultSet().next()) {

				retValue.getPortfolioClientFilter()
						.add(new GetPortfolioClientFilterNCTResultItem(this.getResultSet().getInt("Id"),
								this.getResultSet().getString("Name")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIO_FILTER);
		}
		return retValue;
	}
	
	@Override
	public void throwFailedStatementExeption(SQLException ex
			) throws StatementExecutionException {
		throw new PortfoliosCRUDException(ErrorConstants.ERROR_MSG_LOAD_PORTFOLIO_FILTER);
	}
}
