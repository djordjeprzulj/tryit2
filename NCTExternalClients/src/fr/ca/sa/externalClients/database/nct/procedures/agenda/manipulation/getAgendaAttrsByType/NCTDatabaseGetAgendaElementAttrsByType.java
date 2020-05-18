package fr.ca.sa.externalClients.database.nct.procedures.agenda.manipulation.getAgendaAttrsByType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.exceptions.databaseExceptions.AgendaCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;

/**
 * 
 * Retrieve agenda element attributes based on agenda element type
 * 
 * @author Sasa Radovanovic
 *
 */
public class NCTDatabaseGetAgendaElementAttrsByType extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseGetAgendaElementAttrsByType.class);


	/**
	 * NCT Database Get Agenda Element Attributes By Type
	 * 
	 * @param userId
	 * 				User ID
	 */
	public NCTDatabaseGetAgendaElementAttrsByType(Integer userId) {
		super(userId);
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spGetAgendaElementAttrByType ?");
		try {
			setUser(ps);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		GetAgendaElementAttrsByTypeItemList attrList = new GetAgendaElementAttrsByTypeItemList();

		try {
			while (this.getResultSet().next()) {
				attrList.getElementAttrList().add(new GetAgendaElementAttrsByTypeItem(
						this.getResultSet().getInt("ELEMENT_TYPE_ID"),
						this.getResultSet().getString("ELEMENT_TYPE_NAME"), this.getResultSet().getInt("FIELD_ID"),
						this.getResultSet().getString("FIELD_NAME"), this.getResultSet().getString("FIELD_ALIAS_NAME"),
						this.getResultSet().getString("DESCRIPTION"), this.getResultSet().getInt("IsVisible"),
						this.getResultSet().getInt("IsMandatory"), this.getResultSet().getString("DefaultValue")));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
		}

		return attrList;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new AgendaCRUDException(ErrorConstants.ERROR_MSG_GET_AGENDA_INFO);
	}

}
