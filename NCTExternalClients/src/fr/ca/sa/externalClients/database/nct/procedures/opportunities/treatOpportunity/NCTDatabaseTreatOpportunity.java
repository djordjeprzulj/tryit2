package fr.ca.sa.externalClients.database.nct.procedures.opportunities.treatOpportunity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import org.jboss.logging.Logger;

import fr.ca.sa.commons.constants.NCTDatabaseConstants;
import fr.ca.sa.commons.exceptions.databaseExceptions.OpportunitiesCRUDException;
import fr.ca.sa.commons.exceptions.databaseExceptions.StatementExecutionException;
import fr.ca.sa.externalClients.database.common.StoreProcedureResult;
import fr.ca.sa.externalClients.database.core.AbstractUserStoreProcedureHandler;
import fr.ca.sa.commons.constants.ErrorConstants;
import fr.ca.sa.nct.commons.services.json.event.TreatOpportunity;

/**
 * 
 * @author Nemanja Ignjatov
 *
 */
public class NCTDatabaseTreatOpportunity extends AbstractUserStoreProcedureHandler {

	private static final Logger LOGGER = Logger.getLogger(NCTDatabaseTreatOpportunity.class);
	
	private TreatOpportunity request;

	/**
	 * NCT Database Treat Opportunity
	 * 
	 * @param userId
	 * 				User ID
	 * 
	 * @param request
	 * 				Request
	 */
	public NCTDatabaseTreatOpportunity(int userId, TreatOpportunity request) {
		super(userId);
		this.request = request;
	}

	@Override
	public Statement buildPreparedStatement(Connection connection) throws SQLException {
		CallableStatement ps = connection.prepareCall("exec spTreatOpportunity ?,?,?,?");
		try {
			setUser(ps);
			ps.setInt(NCTDatabaseConstants.SP_ARG_NR_2, this.request.getOpportunityId());
			if (this.request.getReasonId() != null) {
				ps.setInt(NCTDatabaseConstants.SP_ARG_NR_3, this.request.getReasonId());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_3, Types.INTEGER);
			}
			if (this.request.getComment() != null) {
				ps.setString(NCTDatabaseConstants.SP_ARG_NR_4, this.request.getComment());
			} else {
				ps.setNull(NCTDatabaseConstants.SP_ARG_NR_4, Types.VARCHAR);
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
			ps.close();
		}		
		return ps;
	}

	@Override
	public void throwFailedStatementExeption(SQLException ex) throws StatementExecutionException {
		throw new OpportunitiesCRUDException(ErrorConstants.ERROR_MSG_TREAT_OPPORTUNITY);
	}

	@Override
	protected StoreProcedureResult handleResultSet() throws StatementExecutionException {
		return null;
	}
}
