package fr.ca.sa.externalClients.database.nct.procedures.leadManagement.prospectRelates.setProspectRelate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.LeadManagementCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;

/**
 * 
 * Store procedure handler for setting prospects relate
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseSetProspectRelate extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseSetProspectRelate.class);

	private int prospectId;

	private int clientId;

	private int relateId;

	/**
	 * NCT Database Set Prospect Relate
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param prospectId
	 * 				Prospect ID
	 * 
	 * @param clientId
	 * 				Client ID
	 * 
	 * @param relateId
	 * 				Relate ID
	 */
	public NCTDatabaseSetProspectRelate(int userId, int prospectId, int clientId, int relateId) {
		super(userId);
		this.prospectId = prospectId;
		this.clientId = clientId;
		this.relateId = relateId;
	}

	@Override
	public PreparedStatement buildPreparedStatement(Connection connection) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement("exec spSetProspectRelate ?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.prospectId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.clientId);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_4, this.relateId);
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}
		return ps;
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		SetProspectRelateNCTResultItem retValue = null;

		try {
			while (this.getResultSet().next()) {
				retValue = new SetProspectRelateNCTResultItem(this.getResultSet().getInt("RelateId"));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_SET_PROSPECT);
		}

		return retValue;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new LeadManagementCRUDException(ErrorConstants.ERROR_MSG_SET_PROSPECT);
	}

}
