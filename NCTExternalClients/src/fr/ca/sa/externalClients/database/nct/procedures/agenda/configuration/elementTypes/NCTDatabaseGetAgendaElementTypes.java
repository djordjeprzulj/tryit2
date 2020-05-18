package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.elementTypes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LoadingConfigurationException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;
import fr.ca.sa.externalClients.database.nct.procedures.agenda.AgendaConfigurationItem;
import fr.ca.sa.externalClients.database.nct.procedures.agenda.AgendaItemConfigurationList;

/**
 * 
 * Store procedure call for retrieving Agenda item configuration
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgendaElementTypes extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaElementTypes.class);


	/**
	 * NCT Database Get Agenda Element Types
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param language
	 * 				Language
	 */
	public NCTDatabaseGetAgendaElementTypes(Integer userId, Integer language) {
		super(userId, language);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetAgendaElementTypes ?,?");
		try {
			if (this.userId != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_1, this.userId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_1, java.sql.Types.INTEGER);
			}
			cs.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.langId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		AgendaItemConfigurationList agendaTypeList = new AgendaItemConfigurationList();
		try {
			while (this.getResultSet().next()) {
				agendaTypeList.getItemTypeList()
						.add(new AgendaConfigurationItem(this.getResultSet().getInt("AgendaElementTypeId"),
								this.getResultSet().getString("AgendaElementTypeName"),
								this.getResultSet().getString("AgendaElementTypeBackColor"),
								this.getResultSet().getInt("AgendaElementAllDaysFlag")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return agendaTypeList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}
