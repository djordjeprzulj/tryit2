package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * Retrieve all agenda element statuses from database
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgendaElementStatuses extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaElementStatuses.class);

	/**
	 * NCT Database Get Agenda Element Statuses
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetAgendaElementStatuses(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetAgendaElementStatuses ?,?");
		try {
			if (this.userId != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_1, java.sql.Types.INTEGER);
			}
			if (this.langId != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.langId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_2, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		AgendaStatusItemList agendaStatuses = new AgendaStatusItemList();
		try {
			while (this.getResultSet().next()) {
				agendaStatuses.getStatusList()
						.add(new AgendaStatusItem(this.getResultSet().getInt("AgendaElementStatusId"),
								this.getResultSet().getString("AgendaElementStatusName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return agendaStatuses;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}
}
