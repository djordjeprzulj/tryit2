package fr.ca.sa.externalClients.database.nct.procedures.agenda.configuration.getAgendaElementPurpose;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserLanguageStoreProcedureHandler;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseGetAgendaElementPurpose extends AbstractUserLanguageStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaElementPurpose.class);

	/**
	 * NCT Database Get Agenda Element Purpose
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param langId
	 * 				Language ID
	 */
	public NCTDatabaseGetAgendaElementPurpose(Integer userId, Integer langId) {
		super(userId, langId);
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("exec spGetAgendaElementPurpose ?,?");
		try {
			setUserAndLanguage(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}				
		return ps;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_PURPOSE);
		
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAgendaElementPurposeResultItemList purposeList = new GetAgendaElementPurposeResultItemList();
		try {
			while (this.getResultSet().next()) {
				purposeList.getPurposeList()
						.add(new GetAgendaElementPurposeResultItem(this.getResultSet().getInt("AgendaElementPurposeId"),
								this.getResultSet().getString("AgendaElementPurposeName"))
								);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
		}

		return purposeList;
	}
	
	
	
}
