package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.purpose;

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
 * Retrieve agenda purpose
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgendaPurposes extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaPurposes.class);

	private Integer agendaTypeId;

	/**
	 * NCT Database Get Agenda Purposes
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 * 
	 * @param agendaTypeId
	 * 				Agenda type ID
	 */
	public NCTDatabaseGetAgendaPurposes(Integer userId, Integer langId, Integer agendaTypeId) {
		super(userId, langId);
		this.agendaTypeId = agendaTypeId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement cs = connection.prepareStatement("exec spGetAgendaElementObjects ?,?,?");
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
			if (this.agendaTypeId != null) {
				cs.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.agendaTypeId);
			} else {
				cs.setNull(NCTDatabaseConstants.SP_ARG_NR_3, java.sql.Types.INTEGER);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			cs.close();
		}
		return cs;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		AgendaElementPurposeItemList purposes = new AgendaElementPurposeItemList();
		try {
			while (this.getResultSet().next()) {
				purposes.getPurposes()
						.add(new AgendaElementPurposeItem(this.getResultSet().getInt("AgendaElementObjectId"),
								this.getResultSet().getString("AgendaElementObjectName")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LoadingConfigurationException();
		}

		return purposes;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LoadingConfigurationException();
	}

}
