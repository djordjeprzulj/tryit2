package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.messageTypes;

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
 * Retrieve all message types from database
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgendaMsgTypes extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaMsgTypes.class);

	/**
	 * NCT Database Get Agenda Message Types
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetAgendaMsgTypes(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetAgendaElementMessageTypes ?,?");
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
		AgendaElementMsgTypesItemList agendaMsgTypesList = new AgendaElementMsgTypesItemList();
		try {
			while (this.getResultSet().next()) {
				agendaMsgTypesList.getMsgTypesList()
						.add(new AgendaElementMsgTypeItem(this.getResultSet().getInt("AgendaElementMessageTypeId"),
								this.getResultSet().getString("AgendaElementMessageTypeName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return agendaMsgTypesList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}
