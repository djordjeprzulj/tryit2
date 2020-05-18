package fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.setCodeTableCompetitor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nctManagement.procedures.codeTables.SetCodeTableNCTResultItem;

/**
 * 
 * Store procedure handler for setting competitor code table data
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabasesetCodeTableCompetitor extends AbstractUserStoreProcedureHandler {
	private static final Logger LOGGER = Logger.getLogger(NCTDatabasesetCodeTableCompetitor.class);

	private Integer id;
	private String name;
	private int active;

	/**
	 * NCT Database set Code Table Competitor
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param id
	 * 				ID
	 * 
	 * @param name
	 * 				Name
	 * 
	 * @param active
	 * 				Active
	 */
	public NCTDatabasesetCodeTableCompetitor(int userId, Integer id, String name, int active) {
		super(userId);
		this.id = id;
		this.name = name;
		this.active = active;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spSetCompetitor ?,?,?,?");
		try {
			setUser(ps);
	
			if (this.id != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.id);
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_2, Types.INTEGER);
			}
	
			ps.setString(NCTDatabaseConstants.SP_ARG_NR_3, this.name);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.active);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetCodeTableNCTResultItem retValue = null;
		try {
			while (this.getResultSet().next()) {
				retValue = new SetCodeTableNCTResultItem(this.getResultSet().getInt("CompetitorId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);

			throw new LoadingConfigurationException();
		}
		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}
}
